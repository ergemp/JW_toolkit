package actor.responseActors;

import config.serverConfig;
import model.HTTPRequest;
import model.HTTPResponse;

import java.io.*;

public class ResponseActor {
    public static void act(PrintWriter out, BufferedOutputStream dataOut, HTTPResponse response, HTTPRequest request) {

        try {
            // we send HTTP Headers with data to client

            switch (request.getMethod()){
                case GET:
                    out.println(response.getStatus());
                    out.println(response.getServer());
                    out.println(response.getDate());
                    out.println(response.getContentType());

                    out.println("Content-length: " + response.getFileSize());
                    out.println(); // blank line between headers and content, very important !
                    out.flush(); // flush character output stream buffer

                    // file
                    dataOut.write(response.getFileData(), 0, response.getFileSize());
                    dataOut.flush();
                    break;
                case HEAD:
                    out.println(response.getStatus());
                    out.println(response.getServer());
                    out.println(response.getDate());
                    out.println(response.getContentType());

                    out.println("Content-length: " + response.getFileSize());
                    out.println(); // blank line between headers and content, very important !
                    out.flush(); // flush character output stream buffer
                    break;
                case POST:

                    break;
                case PUT:

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
                System.out.println("");
                System.out.print(" - Response File: " + response.getFileName());
                System.out.print(" - Response Status: " + response.getStatus() + "\n" );
            }
        }
    }
}
