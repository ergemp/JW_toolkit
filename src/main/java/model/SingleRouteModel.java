package model;

import config.serverConfig;
import util.ReadFileData;
import java.io.File;

public class SingleRouteModel {
    private String requestPath;
    private String responseFile;
    private Handler responseClass;

    private byte[] handleData;
    private Integer handleDataLength;

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
            if (responseFile != null) {
                retVal = ReadFileData.read(new File(serverConfig.RESOURCES, this.getResponseFile()), getFileSize());
            }
            else {
                retVal = "no data".getBytes();
            }
        }
        catch(Exception ex){

        }
        finally{
            return retVal;
        }
    }

    public void handle(HTTPRequest request){
        try{
            if (responseClass != null) {
                setHandleData(responseClass.handle(request));
                setHandleDataLength(getHandleData().length);
            }
            else if (responseFile != null) {
                File tmpFile = new File(serverConfig.RESOURCES, this.getResponseFile());
                setHandleDataLength((int) tmpFile.length());
                setHandleData(ReadFileData.read(tmpFile, getHandleDataLength()));
            }
            else {
                setHandleData("no data".getBytes());
                setHandleDataLength(0);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
        }
    }

    public Handler getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(Handler responseClass) {
        this.responseClass = responseClass;
    }

    public byte[] getHandleData() {
        return handleData;
    }

    public void setHandleData(byte[] handleData) {
        this.handleData = handleData;
    }

    public Integer getHandleDataLength() {
        return handleDataLength;
    }

    public void setHandleDataLength(Integer handleDataLength) {
        this.handleDataLength = handleDataLength;
    }
}
