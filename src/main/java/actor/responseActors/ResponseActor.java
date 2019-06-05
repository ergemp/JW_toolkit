package actor.responseActors;

import config.serverConfig;
import model.HTTPRequest;
import model.HTTPResponse;
import java.io.*;
import java.util.Date;

public class ResponseActor {
    public static void act(PrintWriter out, BufferedOutputStream dataOut, HTTPResponse response, HTTPRequest request) {
        try {
            // we send HTTP Headers with data to client
            byte[] fileData = null;
            Integer fileSize = null;

            response.handle(request);

            switch (request.getMethod()){
                case GET:
                    out.println(response.getStatus());
                    out.println(response.getServer());
                    out.println(response.getDate());
                    out.println(response.getContentType());
                    out.println("Content-length: " + response.getHandleDataLegth());
                    out.println(); // blank line between headers and content, very important !
                    out.flush(); // flush character output stream buffer
                    // file
                    dataOut.write(response.getHandleData(), 0, response.getHandleDataLegth());
                    dataOut.flush();
                    break;
                case HEAD:
                    out.println(response.getStatus());
                    out.println(response.getServer());
                    out.println(response.getDate());
                    out.println(response.getContentType());
                    out.println("Content-length: " + response.getHandleDataLegth());
                    out.println(); // blank line between headers and content, very important !
                    out.flush(); // flush character output stream buffer
                    break;
                case POST:
                    out.println(response.getStatus());
                    out.println(response.getServer());
                    out.println(response.getDate());
                    out.println(response.getContentType());
                    out.println("Content-length: " + response.getHandleDataLegth());
                    out.println(); // blank line between headers and content, very important !
                    out.flush(); // flush character output stream buffer
                    // file
                    dataOut.write(response.getHandleData(), 0, response.getHandleDataLegth());
                    dataOut.flush();
                    break;
                case PUT:
                    out.println("HTTP/1.1 501 Not Implemented");
                    out.println("Server: Simple Java Web Server 1.0");
                    out.println("Date: " + new Date());
                    out.println("Content-type: plain/text");
                    out.println("Content-length: " + "0");
                    out.println(); // blank line between headers and content, very important !
                    out.flush(); // flush character output stream buffer
                    break;
                default:
                    out.println("HTTP/1.1 501 Not Implemented");
                    out.println("Server: Simple Java Web Server 1.0");
                    out.println("Date: " + new Date());
                    out.println("Content-type: plain/text");
                    out.println("Content-length: " + "0");
                    out.println(); // blank line between headers and content, very important !
                    out.flush(); // flush character output stream buffer
                    break;
            }
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            if (serverConfig.DEBUG){
                //System.out.println("");
                System.out.print(" - Response File Lenth: " + response.getHandleDataLegth());
                System.out.print(" - Response Status: " + response.getStatus() + "\n" );
            }
        }
    }
}
