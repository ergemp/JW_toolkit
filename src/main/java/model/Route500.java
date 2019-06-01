package model;

import util.constants.ContentTypes;

public class Route500 extends SingleRouteModel {
    public Route500() {
        setResponseContentType(ContentTypes.CONTENT.HTML);
        setResponseFile("500.html");
        setRequestPath("*");
    }
}
