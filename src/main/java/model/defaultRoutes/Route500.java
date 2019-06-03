package model.defaultRoutes;

import model.SingleRouteModel;

public class Route500 extends SingleRouteModel {
    public Route500() {
        setResponseFile("500.html");
        setRequestPath("*");
    }
}
