package example;

import model.HTTPRequest;
import model.HTTPResponse;

public class CustomAbstractHandler extends model.handlers.AbstractHandler {
    @Override
    public byte[] handleGET(HTTPRequest request, HTTPResponse response) {
        //return super.handleGET(request, response);
        return "GET Request handle".getBytes();
    }
}
