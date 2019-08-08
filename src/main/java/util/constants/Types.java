package util.constants;

public class Types {
    public static enum CONTENT_TYPE { HTML, JSON, TEXT };
    public static enum REQUEST_METHOD { GET, HEAD, POST, PUT, DELETE, PATCH };
    public static enum RESPONSE_STATUS { OK, INTERNAL_ERROR, NOT_FOUND, NOT_IMPLEMENTED, CREATED };
    /*
     *
     * OK - 200
     * INTERNAL_ERROR - 500
     * NOT_FOUND - 404
     * NOT_IMPLEMENTED - 501
     * CREATED - 201
     *
     * */
}
