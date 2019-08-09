package org.ergemp.jwt.model.defaultRoutes;

import org.ergemp.jwt.model.SingleRouteModel;
import org.ergemp.jwt.model.handlers.SimpleHandler;

public class Route201 extends SingleRouteModel {
    public Route201() {
        setSimpleResponseClass(new SimpleHandler("201.html")); ;
        setRequestPath("*");
    }
}
