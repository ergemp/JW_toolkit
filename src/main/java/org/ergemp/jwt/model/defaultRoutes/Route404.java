package org.ergemp.jwt.model.defaultRoutes;

import org.ergemp.jwt.model.SingleRouteModel;
import org.ergemp.jwt.model.handlers.SimpleHandler;

public class Route404 extends SingleRouteModel {
    public Route404() {
        setSimpleResponseClass(new SimpleHandler("404.html")); ;
        setRequestPath("*");
    }
}
