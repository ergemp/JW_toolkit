package model;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;

public interface Handler {
    public byte[] handle(HTTPRequest request);
}
