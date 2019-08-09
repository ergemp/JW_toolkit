package org.ergemp.jwt.actor.responseActors;

import org.ergemp.jwt.config.serverConfig;
import org.ergemp.jwt.model.HTTPRequest;
import org.ergemp.jwt.util.constants.Types;
import org.ergemp.jwt.model.HTTPResponse;

import java.io.*;

public class ResponseActor {
    public static void act(PrintWriter out, BufferedOutputStream dataOut, HTTPResponse response, HTTPRequest request) {
        try {
            response.handle(request);

            if (request.getMethod() == Types.REQUEST_METHOD.HEAD) {
                writeHeader(out, response);
            }
            else {
                writeHeader(out, response);
                writeData(dataOut, response);
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
        }
        finally {
            if (serverConfig.DEBUG){
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