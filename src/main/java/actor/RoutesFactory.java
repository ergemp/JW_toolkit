package actor;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Routes;
import util.constants.ContentTypes;

public class RoutesFactory {
    public Routes getRoutes(){

        Routes routes = new Routes();
        try {
            routes.addRoute("/" , "index.html", ContentTypes.CONTENT.HTML  );
            routes.addRoute("/about" , "about.html", ContentTypes.CONTENT.HTML );
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        finally {
            return routes;
        }
    }
}
