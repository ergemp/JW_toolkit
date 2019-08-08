package model;

import config.serverConfig;
import model.defaultRoutes.Route404;
import model.handlers.AbstractHandler;
import model.handlers.InterfaceHandler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Routes {
    private List<SingleRouteModel> routes = new ArrayList<SingleRouteModel>();

    public void addRoute(SingleRouteModel route){
        this.routes.add(route);
    }

    public void addRoute(String path, InterfaceHandler gHandler){
        SingleRouteModel route = new SingleRouteModel();
        route.setRequestPath(path);
        route.setInterfaceResponseClass(gHandler);
        this.routes.add(route);
    }

    public void addRoute(String path, AbstractHandler gHandler){
        SingleRouteModel route = new SingleRouteModel();
        route.setRequestPath(path);
        route.setAbstractResponseClass(gHandler);
        this.routes.add(route);
    }

    public Boolean containsPath(String path){
        Boolean exists = false;
        try {
            exists = routes.contains(path);

            Iterator it = routes.iterator();
            while (it.hasNext()){

                SingleRouteModel route = (SingleRouteModel)it.next();
                if (route.getRequestPath().trim().equalsIgnoreCase(path))
                {
                    exists = true;
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            return exists;
        }
    }

    public SingleRouteModel getRoute(String path) {
        SingleRouteModel retRoute = null;
        try {
            if (containsPath(path)){
                Iterator it = routes.iterator();
                while (it.hasNext()){
                    SingleRouteModel route = (SingleRouteModel)it.next();
                    if (route.getRequestPath().equalsIgnoreCase(path)) {
                        retRoute = route;
                    }
                }
            }
            else {
                //return default route for 404
                Route404 route404 = new Route404();
                retRoute = route404;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            if (retRoute == null){
                retRoute = new Route404();
            }

            if (serverConfig.DEBUG){
                System.out.print(" - Selected Route -> ");
                System.out.print(" - Route Request Path: "  + retRoute.getRequestPath() );
            }

            return retRoute;
        }
    }
}
