package example;

import model.HTTPRequest;
import model.HTTPResponse;
import model.handlers.InterfaceHandler;
import util.constants.Types;

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
