package org.ergemp.jwt.example.fileServer;

import org.ergemp.jwt.config.serverConfig;
import org.ergemp.jwt.model.HTTPRequest;
import org.ergemp.jwt.model.HTTPResponse;
import org.ergemp.jwt.model.handlers.InterfaceHandler;

import java.io.File;

public class FileServer implements InterfaceHandler {
    @Override
    public byte[] handle(HTTPRequest request, HTTPResponse response) {

        String docRoot = serverConfig.DOCROOT;
        byte[] retVal = null;
        String sVal = "";

        sVal = request.getPath();

        File rootFile = new File (serverConfig.DOCROOT);


        for (File file :rootFile.listFiles() ){
            if (file.isFile()) {
                sVal += "<a href='getFileContent?fileName=" + file.getPath() + "'>"+  file.getPath() + "</a><br/>";
            }
            else if (file.isDirectory()){
                sVal += file.getPath() + "<br/>";
            }
        }

        //return new byte[0];
        return sVal.getBytes();
    }
}
