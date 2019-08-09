package org.ergemp.jwt.actor;

import org.ergemp.jwt.model.Routes;
import org.ergemp.jwt.model.handlers.SimpleHandler;

public class RoutesFactory {
    public Routes getPredefinedRoutes(){

        Routes routes = new Routes();
        try {
            routes.addRoute("/" , new SimpleHandler("index.html" ));
            routes.addRoute("/about" , new SimpleHandler("about.html"));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            return routes;
        }
    }
}
