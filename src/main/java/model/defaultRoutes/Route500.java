package model.defaultRoutes;

import model.SingleRouteModel;
import model.handlers.SimpleHandler;

public class Route500 extends SingleRouteModel {
    public Route500() {
        setSimpleResponseClass(new SimpleHandler("500.html")); ;
        setRequestPath("*");
    }
}
