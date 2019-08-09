package org.ergemp.jwt.model.handlers;

import org.ergemp.jwt.model.HTTPRequest;
import org.ergemp.jwt.model.HTTPResponse;
import org.ergemp.jwt.util.constants.Types;

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
        response.setStatus(Types.RESPONSE_STATUS.NOT_IMPLEMENTED);
        return "not implemented".getBytes();
    }

    public byte[] handleHEAD(HTTPRequest request, HTTPResponse response){
        response.setStatus(Types.RESPONSE_STATUS.NOT_IMPLEMENTED);
        return "not implemented".getBytes();
    }

    public byte[] handlePOST(HTTPRequest request, HTTPResponse response){
        response.setStatus(Types.RESPONSE_STATUS.NOT_IMPLEMENTED);
        return "not implemented".getBytes();
    }

    public byte[] handlePUT(HTTPRequest request, HTTPResponse response){
        response.setStatus(Types.RESPONSE_STATUS.NOT_IMPLEMENTED);
        return "not implemented".getBytes();
    }

    public byte[] handleDELETE(HTTPRequest request, HTTPResponse response){
        response.setStatus(Types.RESPONSE_STATUS.NOT_IMPLEMENTED);
        return "not implemented".getBytes();
    }

    public byte[] handlePATCH(HTTPRequest request, HTTPResponse response){
        response.setStatus(Types.RESPONSE_STATUS.NOT_IMPLEMENTED);
        return "not implemented".getBytes();
    }
}
