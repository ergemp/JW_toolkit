package org.ergemp.jwt.example.fileServer;

import org.ergemp.jwt.model.HTTPRequest;
import org.ergemp.jwt.model.HTTPResponse;
import org.ergemp.jwt.model.handlers.InterfaceHandler;

import java.io.File;
import java.util.Map;

public class ListFiles implements InterfaceHandler {
    @Override
    public byte[] handle(HTTPRequest request, HTTPResponse response) {

        String sVal = "";

        Map<String, String> params = request.getParams();
        String rFileName = params.get("fileName");

        File rootFile = new File(rFileName);

        try {
            for (File file :rootFile.listFiles() ) {
                if (file.isFile()) {
                    sVal += "<a href='getFileContent?fileName=" + file.getPath() + "'>"+  file.getPath() + "</a><br/>";
                }
                else if (file.isDirectory()){
                    sVal += "<a href='listFiles?fileName=" + file.getPath() + "'>"+  file.getPath() + "</a><br/>";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return sVal.getBytes();
        }
    }
}
