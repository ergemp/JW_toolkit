package org.ergemp.jwt.example;

import org.ergemp.jwt.model.HTTPRequest;
import org.ergemp.jwt.model.HTTPResponse;
import org.ergemp.jwt.model.handlers.AbstractHandler;

public class CustomAbstractHandler extends AbstractHandler {
    @Override
    public byte[] handleGET(HTTPRequest request, HTTPResponse response) {
        //return super.handleGET(request, response);
        return "GET Request handle".getBytes();
    }
}
