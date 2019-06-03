package actor;

import model.Routes;

public class RoutesFactory {
    public Routes getRoutes(){

        Routes routes = new Routes();
        try {
            routes.addRoute("/" , "index.html");
            routes.addRoute("/about" , "about.html");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            return routes;
        }
    }
}
