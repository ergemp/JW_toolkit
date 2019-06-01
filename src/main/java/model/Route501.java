package model;

import util.constants.ContentTypes;

public class Route501 extends SingleRouteModel {
    public Route501() {
        setResponseContentType(ContentTypes.CONTENT.HTML);
        setResponseFile("501.html");
        setRequestPath("*");
    }
}
