package model.handlers;

import model.HTTPRequest;
import model.HTTPResponse;

public abstract class AbstractHandler {

    public byte[] handle(HTTPRequest request, HTTPResponse response){
        switch (request.getMethod()){
            case GET:
                return handleGET(request,response);
            case HEAD:
                return handleHEAD(request,response);
            case POST:
                return handlePOST(request,response);
            case PUT:
                return handlePUT(request,response);
            case DELETE:
                return handleDELETE(request,response);
            case PATCH:
                return handlePATCH(request,response);
            default:
                return "unrecognized request, should be one of: {GET, HEAD, POST, PUT, DELETE, PATCH}".getBytes();
        }
    };

    public byte[] handleGET(HTTPRequest request, HTTPResponse response){
        return "not handled".getBytes();
    };

    public byte[] handleHEAD(HTTPRequest request, HTTPResponse response){
        return "not handled".getBytes();
    };

    public byte[] handlePOST(HTTPRequest request, HTTPResponse response){
        return "not handled".getBytes();
    };

    public byte[] handlePUT(HTTPRequest request, HTTPResponse response){
        return "not handled".getBytes();
    };

    public byte[] handleDELETE(HTTPRequest request, HTTPResponse response){
        return "not handled".getBytes();
    };

    public byte[] handlePATCH(HTTPRequest request, HTTPResponse response){
        return "not handled".getBytes();
    };


}
