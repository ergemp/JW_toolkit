package util.constants;

public class Types {
    public static enum CONTENT { HTML, JSON, TEXT };
    public static enum METHOD { GET, HEAD, POST, PUT };
    public static enum STATUS { OK, INTERNAL_ERROR, NOT_FOUND, NOT_IMPLEMENTED, CREATED };
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
