package org.ergemp.jwt.example.fileServer;

import org.ergemp.jwt.model.HTTPRequest;
import org.ergemp.jwt.model.HTTPResponse;
import org.ergemp.jwt.model.handlers.InterfaceHandler;
import org.ergemp.jwt.util.GetFileSize;
import org.ergemp.jwt.util.ReadFileData;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class GetFileContent implements InterfaceHandler {
    @Override
    public byte[] handle(HTTPRequest request, HTTPResponse response) {

        //return request.getPath().substring( request.getPath().indexOf("?")).getBytes();
        //return "hoop".getBytes();

        byte[] retVal = null;

        Map<String, String> params = request.getParams();
        String rFileName = params.get("fileName");

        try {
            File file = new File(rFileName);

            if (file.isFile()) {
                retVal = ReadFileData.read(file, GetFileSize.get(rFileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return retVal;
        }
    }
}
