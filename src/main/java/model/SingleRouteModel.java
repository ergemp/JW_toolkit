package model;

import config.serverConfig;
import model.handlers.AbstractHandler;
import model.handlers.InterfaceHandler;
import model.handlers.SimpleHandler;
import util.ReadFileData;
import java.io.File;

public class SingleRouteModel {
    private String requestPath;
    private String responseFile;
    private InterfaceHandler interfaceResponseClass;
    private AbstractHandler abstractResponseClass;
    private SimpleHandler simpleResponseClass;

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

    public void handle(HTTPRequest request, HTTPResponse response){
        try{
            if (interfaceResponseClass != null) {
                setHandleData(interfaceResponseClass.handle(request, response));
                setHandleDataLength(getHandleData().length);
            }
            else if (abstractResponseClass != null) {
                setHandleData(abstractResponseClass.handle(request, response));
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

    public InterfaceHandler getInterfaceResponseClass() {
        return interfaceResponseClass;
    }
    public void setInterfaceResponseClass(InterfaceHandler responseClass) {
        this.interfaceResponseClass = responseClass;
    }

    public AbstractHandler getAbstractResponseClass() {
        return abstractResponseClass;
    }
    public void setAbstractResponseClass(AbstractHandler responseClass) { this.abstractResponseClass = responseClass; }

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
