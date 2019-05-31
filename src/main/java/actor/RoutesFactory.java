package actor;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Routes;

public class RoutesFactory {
    public Routes getRoutes(){

        Routes routes = new Routes();
        try {
            routes.addRoute("/" , "index.html", "text/html"  );
            routes.addRoute("/about" , "about.html", "text/html" );
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            return routes;
        }

    }
}
