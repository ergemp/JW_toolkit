package model;

import actor.HTTPRequestModelCreator;
import actor.responseActors.ResponseActor;
import config.serverConfig;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HTTPServer implements Runnable {
    private Socket connect;
    private Routes routes;

    public HTTPServer(Routes gRoutes){
        routes = gRoutes;
    }

    public HTTPServer(Socket gSocket){
        connect = gSocket;
    }

    public void start() {
        try {
            ServerSocket serverConnect = new ServerSocket(serverConfig.PORT);
            if (serverConfig.DEBUG) {
                System.out.println("Server Starting on Port: " + serverConfig.PORT + "; PID: " + Thread.currentThread().getId());
            }

            // we listen until user halts server execution
            while (true) {
                connect = serverConnect.accept();

                HTTPServer myServer = new HTTPServer(connect);
                myServer.routes = this.routes;

                System.out.println(" - Connecton opened. (" + new Date() + ")");

                // create dedicated thread to manage the client connection
                Thread thread = new Thread(myServer);
                thread.start();
            }
        }
        catch(IOException ioe){
            System.err.println(" - Server Connection error : " + ioe.getMessage());
        }
        finally{

        }
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedOutputStream dataOut = null;
        BufferedInputStream dataIn = null;
        HTTPRequest request = null;

        try {
            if (serverConfig.DEBUG){
                System.out.println(" - Request Handler Thread Started: " + Thread.currentThread().getId());
            }
            // read characters from the client via input stream on the socket
            in = new BufferedReader(new InputStreamReader(connect.getInputStream()));

            // read characters from the client via input stream on the socket
            dataIn = new BufferedInputStream(connect.getInputStream());

            // get character output stream to client (for headers)
            out = new PrintWriter(connect.getOutputStream());

            // binary output stream to client (for requested data)
            dataOut = new BufferedOutputStream(connect.getOutputStream());

            //create the requestModel
            HTTPRequestModelCreator requestCreator = new HTTPRequestModelCreator();
            request = requestCreator.createRequest(in, dataIn);

            if (request == null){
                return;
            }
            else if (request.getMethod() == null) {
                return;
            }

            //select the requested Route from the Routes
            SingleRouteModel route = routes.getRoute(request.getPath());

            HTTPResponse response = new HTTPResponse(route);
            ResponseActor.act(out, dataOut, response, request);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                dataOut.close();

                //close socket connection
                if (!connect.isClosed()) {
                    connect.close();
                }
            } catch (Exception e) {
                System.err.println(" - Error closing stream : " + e.getMessage());
            }
            if (serverConfig.DEBUG) {
                System.out.println(" - Connection closed: "  + Thread.currentThread().getId() + "\n");
            }
        }
    }
}
