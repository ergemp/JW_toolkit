package org.ergemp.jwt.model.handlers;

import org.ergemp.jwt.model.HTTPRequest;
import org.ergemp.jwt.model.HTTPResponse;

public interface InterfaceHandler {
    public byte[] handle(HTTPRequest request, HTTPResponse response);
}
