package model.defaultRoutes;

import model.SingleRouteModel;

public class Route404 extends SingleRouteModel {
    public Route404() {
        setResponseFile("404.html");
        setRequestPath("*");
    }
}
