package org.ergemp.jwt.model.defaultRoutes;

import org.ergemp.jwt.model.SingleRouteModel;
import org.ergemp.jwt.model.handlers.SimpleHandler;

public class Route500 extends SingleRouteModel {
    public Route500() {
        setSimpleResponseClass(new SimpleHandler("500.html")); ;
        setRequestPath("*");
    }
}
