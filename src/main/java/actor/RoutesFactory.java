package actor;

import model.Routes;
import model.handlers.SimpleHandler;

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
