package org.ergemp.jwt.model.defaultRoutes;

import org.ergemp.jwt.model.SingleRouteModel;
import org.ergemp.jwt.model.handlers.SimpleHandler;

public class Route200 extends SingleRouteModel {
    public Route200() {
        setSimpleResponseClass(new SimpleHandler("200.html")); ;
        setRequestPath("*");
    }
}
