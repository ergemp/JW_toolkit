package org.ergemp.jwt.example;

import org.ergemp.jwt.model.handlers.InterfaceHandler;
import org.ergemp.jwt.util.constants.Types;
import org.ergemp.jwt.model.HTTPRequest;
import org.ergemp.jwt.model.HTTPResponse;

public class CustomInterfaceHandler implements InterfaceHandler {

    @Override
    public byte[] handle(HTTPRequest request, HTTPResponse response) {
        //String retStr = "handler worked" ;

        byte[] retVal = null;
        if (request.getContent() != null) {
            retVal = request.getContent().getBytes();
        }
        else {
            retVal = "".getBytes();
        }

        response.setStatus(Types.RESPONSE_STATUS.OK);
        return retVal;
    }
}
