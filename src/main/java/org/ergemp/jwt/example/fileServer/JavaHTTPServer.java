package org.ergemp.jwt.example.fileServer;

import org.ergemp.jwt.actor.RoutesFactory;
import org.ergemp.jwt.example.CustomAbstractHandler;
import org.ergemp.jwt.model.HTTPServer;
import org.ergemp.jwt.model.Routes;
import org.ergemp.jwt.model.handlers.SimpleHandler;

public class JavaHTTPServer {
    public static void main(String[] args) {
        //generate Routes
        RoutesFactory routesFactory = new RoutesFactory();
        Routes routes = routesFactory.getPredefinedRoutes();

        routes.addRoute("/getFileContent" , new GetFileContent());
        routes.addRoute("/listFiles" , new ListFiles());
        routes.addRoute("/" , new ListFiles());

        HTTPServer httpServer = new HTTPServer(routes);
        httpServer.start();
    }
}