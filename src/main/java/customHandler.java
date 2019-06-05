import model.HTTPRequest;

public class customHandler implements model.Handler {
    @Override
    public byte[] handle(HTTPRequest request) {
        String retStr = "handler worked" ;
        byte[] retVal = null;
        if (request.getContent() != null) {
            retVal = request.getContent().getBytes();
        }
        else {
            retVal = "".getBytes();
        }
        return retVal;
    }
}
