package org.ergemp.jwt.model.handlers;

import org.ergemp.jwt.config.serverConfig;
import org.ergemp.jwt.model.HTTPRequest;
import org.ergemp.jwt.util.ReadFileData;
import org.ergemp.jwt.model.HTTPResponse;

import java.io.File;

public class SimpleHandler implements InterfaceHandler {

    private String responseFileName;

    public String getResponseFileName() {
        return responseFileName;
    }
    public void setResponseFileName(String gResponseFileName) {
        responseFileName=gResponseFileName ;
    }

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
        catch(Exception ex) {
            retVal = 0;
        }
        finally {
            return retVal;
        }
    }

    public byte[] getFileData(){

        byte[] retVal = null;

        try {
            if (responseFileName != null) {
                retVal = ReadFileData.read(new File(serverConfig.RESOURCES, this.getResponseFileName()), getFileSize());
            }
            else {
                retVal = "no data".getBytes();
            }
        }
        catch(Exception ex) {

        }
        finally {
            return retVal;
        }
    }

}