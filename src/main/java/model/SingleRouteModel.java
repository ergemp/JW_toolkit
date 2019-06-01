package model;

import config.serverConfig;
import util.ReadFileData;
import util.constants.ContentTypes;

import java.io.File;

public class SingleRouteModel {
    private String requestPath;
    private String responseFile;
    private ContentTypes.CONTENT responseContentType; //supported MIME Types

    public String getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public String getResponseFile() {
        return responseFile;
    }

    public void setResponseFile(String responseFile) {
        this.responseFile = responseFile;
    }

    public ContentTypes.CONTENT getResponseContentType() {
        return responseContentType;
    }

    public void setResponseContentType(ContentTypes.CONTENT responseContentType) {
        this.responseContentType = responseContentType;
    }

    public Integer getFileSize(){
        Integer retVal = 0;
        try {
            File file = new File(serverConfig.RESOURCES, responseFile);
            retVal = (int) file.length();
        }
        catch(Exception ex){

        }
        finally {
            return retVal;
        }
    }

    public byte[] getFileData(){
        byte[] retVal = null;
        try{
            retVal = ReadFileData.read(new File(serverConfig.RESOURCES,this.getResponseFile()), getFileSize());
        }
        catch(Exception ex){

        }
        finally{
            return retVal;
        }
    }
}
