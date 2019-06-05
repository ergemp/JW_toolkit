import model.HTTPRequest;
import model.HTTPResponse;
import util.constants.Types;

public class customHandler implements model.Handler {
    @Override
    public byte[] handle(HTTPRequest request, HTTPResponse response) {
        String retStr = "handler worked" ;
        byte[] retVal = null;
        if (request.getContent() != null) {
            retVal = request.getContent().getBytes();
        }
        else {
            retVal = "".getBytes();
        }
        response.setStatus(Types.STATUS.OK);
        return retVal;
    }
}
