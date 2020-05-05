package org.ergemp.jwt.example.fileServer;

import org.ergemp.jwt.config.serverConfig;
import org.ergemp.jwt.model.HTTPRequest;
import org.ergemp.jwt.model.HTTPResponse;
import org.ergemp.jwt.model.handlers.InterfaceHandler;

import java.io.File;
import java.util.Date;
import java.util.Map;

public class ListFiles implements InterfaceHandler {
    @Override
    public byte[] handle(HTTPRequest request, HTTPResponse response) {

        String sVal = "";
        String rFileName = "";

        Map<String, String> params = request.getParams();
        if (!params.containsKey("fileName")) {
            rFileName = serverConfig.DOCROOT;
        }
        else{
            rFileName = params.get("fileName");
        }

        File rootFile = new File(rFileName);

        try {
            sVal += "<html><body>" ;
            sVal += "<table border='1' width='60%'>";
            sVal += "<caption>File Browser</caption> ";

            sVal += "<tr><th></th><th>Last Modified</th><th>File Name</th></tr>" ;
            //display folders first
            for (File file :rootFile.listFiles() ) {
                if (file.isFile()) {
                    //sVal += "<a href='getFileContent?fileName=" + file.getPath() + "'>"+  file.getPath() + "</a><br/>";
                }
                else if (file.isDirectory()){
                    sVal += "<tr><td>Folder</td><td>" + new Date(file.lastModified())  + "</td><td><a href='listFiles?fileName=" + file.getPath() + "'>"+  file.getPath() + "</a></td></tr>";
                }
            }

            //display files
            for (File file :rootFile.listFiles() ) {
                if (file.isFile()) {
                    sVal += "<tr><td>File</td><td>" + new Date(file.lastModified())  + "</td><td><a href='getFileContent?fileName=" + file.getPath() + "'>"+  file.getPath() + "</a></td></tr>";
                }
                else if (file.isDirectory()){
                    //sVal += "<a href='listFiles?fileName=" + file.getPath() + "'>"+  file.getPath() + "</a><br/>";
                }
            }
            sVal += "</table>";
            sVal += "</body></html>" ;


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return sVal.getBytes();
        }
    }
}
