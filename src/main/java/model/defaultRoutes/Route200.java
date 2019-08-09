package model.defaultRoutes;

import model.SingleRouteModel;
import model.handlers.SimpleHandler;

public class Route200 extends SingleRouteModel {
    public Route200() {
        setSimpleResponseClass(new SimpleHandler("200.html")); ;
        setRequestPath("*");
    }
}
