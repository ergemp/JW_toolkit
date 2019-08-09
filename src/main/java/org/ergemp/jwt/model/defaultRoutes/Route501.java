package org.ergemp.jwt.model.defaultRoutes;

import org.ergemp.jwt.model.SingleRouteModel;
import org.ergemp.jwt.model.handlers.SimpleHandler;

public class Route501 extends SingleRouteModel {
    public Route501() {
        setSimpleResponseClass(new SimpleHandler("501.html")); ;
        setRequestPath("*");
    }
}
