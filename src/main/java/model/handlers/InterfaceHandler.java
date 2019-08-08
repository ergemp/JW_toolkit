package model.handlers;

import model.HTTPRequest;
import model.HTTPResponse;
import util.constants.Types;

public interface InterfaceHandler {
    public byte[] handle(HTTPRequest request, HTTPResponse response);
}
