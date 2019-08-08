package model.defaultRoutes;

import model.SingleRouteModel;
import model.handlers.SimpleHandler;

public class Route404 extends SingleRouteModel {
    public Route404() {
        setSimpleResponseClass(new SimpleHandler("404.html")); ;
        setRequestPath("*");
    }
}
