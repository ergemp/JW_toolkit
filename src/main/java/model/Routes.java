package model;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Routes {
    private List<SingleRouteModel> routes = new ArrayList<SingleRouteModel>();

    public void addRoute(SingleRouteModel route){
        this.routes.add(route);
    }

    public void addRoute(String path, String file, String contentType){
        SingleRouteModel route = new SingleRouteModel();
        route.setRequestPath(path);
        route.setResponseFile(file);
        route.setResponseContentType(contentType);

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

            }
        }
        catch(Exception ex){
            ex.printStackTrace();

        }
        finally {
            if (retRoute == null){
                retRoute = new SingleRouteModel();

                retRoute.setRequestPath("404");
                retRoute.setResponseFile("404.html");
                retRoute.setResponseContentType("text/html");
            }
            return retRoute;
        }
    }
}
