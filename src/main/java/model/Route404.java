package model;

import util.constants.ContentTypes;

public class Route404 extends SingleRouteModel {
    public Route404() {
        setResponseContentType(ContentTypes.CONTENT.HTML);
        setResponseFile("404.html");
        setRequestPath("*");
    }
}
