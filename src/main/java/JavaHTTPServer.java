import actor.HTTPRequestHeaderCreator;
import actor.RoutesFactory;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import config.serverConfig;
import model.HTTPRequestHeaderModel;
import model.Routes;
import model.SingleRouteModel;
import util.readFileData;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class JavaHTTPServer implements Runnable {

    static final File WEB_ROOT = new File("resources");
    static final String DEFAULT_FILE = "index.html";
    static final String FILE_NOT_FOUND = "404.html";
    static final String METHOD_NOT_SUPPORTED = "not_supported.html";
    // port to listen connection
    static final int PORT = 8080;

    // verbose mode
    static final boolean verbose = true;

    // Client Connection via Socket Class
    private Socket connect;

    public JavaHTTPServer(Socket c) {
        connect = c;
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverConnect = new ServerSocket(PORT);
            System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");

            // we listen until user halts server execution
            while (true) {
                JavaHTTPServer myServer = new JavaHTTPServer(serverConnect.accept());

                if (verbose) {
                    System.out.println("Connecton opened. (" + new Date() + ")");
                }

                // create dedicated thread to manage the client connection
                Thread thread = new Thread(myServer);
                thread.start();
            }

        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }

    public void run() {
        // we manage our particular client connection
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedOutputStream dataOut = null;
        HTTPRequestHeaderModel headerModel = null;

        try {
            // we read characters from the client via input stream on the socket
            in = new BufferedReader(new InputStreamReader(connect.getInputStream()));

            // we get character output stream to client (for headers)
            out = new PrintWriter(connect.getOutputStream());

            // get binary output stream to client (for requested data)
            dataOut = new BufferedOutputStream(connect.getOutputStream());

            HTTPRequestHeaderCreator headerCreator = new HTTPRequestHeaderCreator();
            headerModel = headerCreator.createRequestHeader(in);


            // we support only GET and HEAD methods, we check
            if (headerModel == null){
                return;
            }
            else if (headerModel.getMethod() == null) {
                return;
            }

            if (!headerModel.getMethod().equals("GET")  &&  !headerModel.getMethod().equals("HEAD")) {
                if (verbose) {
                    System.out.println("501 Not Implemented : " + headerModel.getMethod() + " method.");
                }

                // we return the not supported file to the client
                File file = new File(WEB_ROOT, METHOD_NOT_SUPPORTED);
                int fileLength = (int) file.length();
                String contentMimeType = "text/html";
                //read content to return to client
                byte[] fileData = readFileData.read(file, fileLength);

                // we send HTTP Headers with data to client
                out.println("HTTP/1.1 501 Not Implemented");
                out.println("Server: Java HTTP Server from SSaurel : 1.0");
                out.println("Date: " + new Date());
                out.println("Content-type: " + contentMimeType);
                out.println("Content-length: " + fileLength);
                out.println(); // blank line between headers and content, very important !
                out.flush(); // flush character output stream buffer
                // file
                dataOut.write(fileData, 0, fileLength);
                dataOut.flush();

            } else {
                // GET or HEAD method

                RoutesFactory routesFactory = new RoutesFactory();
                Routes routes = routesFactory.getRoutes();
                SingleRouteModel route = null;

                if (routes.containsPath(headerModel.getPath())){
                    route = routes.getRoute(headerModel.getPath());
                }

                System.out.println(route.getResponseFile());

                File file = new File(serverConfig.RESOURCES, route.getResponseFile());
                byte[] fileData = readFileData.read(file, (int)file.length());

                if (headerModel.getMethod().equalsIgnoreCase("GET")) { // GET method so we return content

                    // send HTTP Headers
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Java HTTP Server from SSaurel : 1.0");
                    out.println("Date: " + new Date());
                    out.println("Content-type: " + route.getResponseContentType());
                    out.println("Content-length: " + (int)file.length());
                    out.println(); // blank line between headers and content, very important !
                    out.flush(); // flush character output stream buffer

                    dataOut.write(fileData, 0, (int)file.length());
                    dataOut.flush();
                }

                if (verbose) {
                    System.out.println("File " + route.getResponseFile() + " of type " + route.getResponseContentType() + " returned");
                }
            }

        } catch (FileNotFoundException fnfe) {
            try {
                fileNotFound(out, dataOut, "");
            } catch (IOException ioe) {
                System.err.println("Error with file not found exception : " + ioe.getMessage());
            }

        } catch (IOException ioe) {
            System.out.println("Server error : " + ioe.toString());
        } finally {
            try {
                in.close();
                out.close();
                dataOut.close();
                connect.close(); // we close socket connection
            } catch (Exception e) {
                System.err.println("Error closing stream : " + e.getMessage());
            }

            if (verbose) {
                System.out.println("Connection closed.\n");
            }
        }


    }

    private void fileNotFound(PrintWriter out, OutputStream dataOut, String fileRequested) throws IOException {
        File file = new File(WEB_ROOT, FILE_NOT_FOUND);
        int fileLength = (int) file.length();
        String content = "text/html";
        byte[] fileData = readFileData.read(file, fileLength);

        out.println("HTTP/1.1 404 File Not Found");
        out.println("Server: Java HTTP Server from SSaurel : 1.0");
        out.println("Date: " + new Date());
        out.println("Content-type: " + content);
        out.println("Content-length: " + fileLength);
        out.println(); // blank line between headers and content, very important !
        out.flush(); // flush character output stream buffer

        dataOut.write(fileData, 0, fileLength);
        dataOut.flush();

        if (verbose) {
            System.out.println("File " + fileRequested + " not found");
        }
    }

}