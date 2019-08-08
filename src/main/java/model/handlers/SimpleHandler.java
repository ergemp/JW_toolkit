package model.handlers;

import config.serverConfig;
import model.HTTPRequest;
import model.HTTPResponse;
import util.ReadFileData;

import java.io.File;

public class SimpleHandler implements InterfaceHandler{

    String responseFileName;

    public SimpleHandler(String gFile){
        this.responseFileName = gFile;
    }

    @Override
    public byte[] handle(HTTPRequest request, HTTPResponse response) {
        byte[] retVal = null;

        try {
            if (responseFileName != null) {
                retVal = ReadFileData.read(new File(serverConfig.RESOURCES, this.responseFileName), getFileSize());
            }
            else {
                retVal = "Response File Read Error".getBytes();
            }
        }
        catch(Exception ex){
            retVal = "Response File Read Error".getBytes();
        }
        finally{
            return retVal;
        }
    }

    private Integer getFileSize(){
        Integer retVal = 0;
        try {
            File file = new File(serverConfig.RESOURCES, responseFileName);
            retVal = (int) file.length();
        }
        catch(Exception ex){
            retVal = 0;
        }
        finally {
            return retVal;
        }
    }
}