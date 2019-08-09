package model.defaultRoutes;

import model.SingleRouteModel;
import model.handlers.SimpleHandler;

public class Route201 extends SingleRouteModel {
    public Route201() {
        setSimpleResponseClass(new SimpleHandler("201.html")); ;
        setRequestPath("*");
    }
}
