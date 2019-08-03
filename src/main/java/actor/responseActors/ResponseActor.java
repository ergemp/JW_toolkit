package actor.responseActors;

import config.serverConfig;
import model.HTTPRequest;
import model.HTTPResponse;
import model.defaultResponses.Response501;

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
                    writeHeader(out, response);
                    writeData(dataOut,response);
                    break;
                case HEAD:
                    writeHeader(out, response);
                    break;
                case POST:
                    writeHeader(out, response);
                    writeData(dataOut,response);
                    break;
                case PUT:
                    writeHeader(out, new Response501());
                    break;
                default:
                    writeHeader(out, new Response501());
                    break;
            }
        }
        catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverConfig.DEBUG){
                //System.out.println("");
                System.out.print(" - Response File Lenth: " + response.getHandleDataLength());
                System.out.print(" - Response Status: " + response.getStatus() + "\n" );
            }
        }
    }

    public static void writeHeader(PrintWriter out, HTTPResponse response) {
        out.println(response.getStatus());
        out.println(response.getServer());
        out.println(response.getDate());
        out.println(response.getContentType());
        out.println("Content-length: " + response.getHandleDataLength());
        out.println(); // blank line between headers and content, very important !
        out.flush(); // flush character output stream buffer

    }

    public static void writeData(BufferedOutputStream dataOut, HTTPResponse response) throws Exception {
            dataOut.write(response.getHandleData(), 0, response.getHandleDataLength());
            dataOut.flush();
    }
}
