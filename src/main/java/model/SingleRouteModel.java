package model;

import model.handlers.AbstractHandler;
import model.handlers.InterfaceHandler;
import model.handlers.SimpleHandler;

public class SingleRouteModel {
    private String requestPath;
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
            else if (simpleResponseClass != null) {
                setHandleData(simpleResponseClass.handle(request, response));
                setHandleDataLength(getHandleData().length);
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
    public void setInterfaceResponseClass(InterfaceHandler responseClass) { this.interfaceResponseClass = responseClass; }

    public AbstractHandler getAbstractResponseClass() {
        return abstractResponseClass;
    }
    public void setAbstractResponseClass(AbstractHandler responseClass) { this.abstractResponseClass = responseClass; }

    public SimpleHandler getSimpleResponseClass() {
        return simpleResponseClass;
    }
    public void setSimpleResponseClass(SimpleHandler responseClass) { this.simpleResponseClass = responseClass; }

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
