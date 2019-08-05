import model.HTTPRequest;
import model.HTTPResponse;
import util.constants.Types;

import java.io.File;

public class customHandler implements model.Handler {
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

        if (request.getMethod() == Types.METHOD.PUT) {
            response.setStatus(Types.STATUS.NOT_IMPLEMENTED);
        }
        else {
            response.setStatus(Types.STATUS.OK);
        }
        return retVal;
    }
}
