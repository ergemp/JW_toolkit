package model;

import util.constants.Types;

public interface Handler {
    public byte[] handle(HTTPRequest request, HTTPResponse response);
}
