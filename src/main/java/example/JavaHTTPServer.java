package example;

import actor.RoutesFactory;
import model.HTTPServer;
import model.Routes;

public class JavaHTTPServer {
    public static void main(String[] args) {
        //generate Routes
        RoutesFactory routesFactory = new RoutesFactory();
        Routes routes = routesFactory.getPredefinedRoutes();

        routes.addRoute("/handler" , new CustomInterfaceHandler());

        HTTPServer httpServer = new HTTPServer(routes);
        httpServer.start();
    }
}