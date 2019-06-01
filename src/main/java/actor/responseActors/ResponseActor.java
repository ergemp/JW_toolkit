package actor.responseActors;

import model.HTTPResponseModel;
import model.Route500;
import util.constants.StatusTypes;

import java.io.*;

public class ResponseActor {
    public static void act(BufferedReader in, PrintWriter out, BufferedOutputStream dataOut, HTTPResponseModel response) {

        try {
            // we send HTTP Headers with data to client
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
        }
        catch(FileNotFoundException fnfe){

        }
        catch (IOException ioe){

        }
        finally {

        }
    }
}
