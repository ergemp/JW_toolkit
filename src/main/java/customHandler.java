import model.HTTPRequest;

public class customHandler implements model.Handler {
    @Override
    public byte[] handle(HTTPRequest request) {
        String retStr = "handler worked" ;
        byte[] retVal = retStr.getBytes();
        return retVal;
    }
}
