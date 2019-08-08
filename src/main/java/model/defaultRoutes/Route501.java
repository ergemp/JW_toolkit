package model.defaultRoutes;

import model.SingleRouteModel;
import model.handlers.SimpleHandler;

public class Route501 extends SingleRouteModel {
    public Route501() {
        setSimpleResponseClass(new SimpleHandler("501.html")); ;
        setRequestPath("*");
    }
}
