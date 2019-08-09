package org.ergemp.jwt.example;

        import org.ergemp.jwt.actor.RoutesFactory;
        import org.ergemp.jwt.model.HTTPServer;
        import org.ergemp.jwt.model.Routes;
        import org.ergemp.jwt.model.handlers.SimpleHandler;

public class JavaHTTPServer {
    public static void main(String[] args) {
        //generate Routes
        RoutesFactory routesFactory = new RoutesFactory();
        Routes routes = routesFactory.getPredefinedRoutes();

        routes.addRoute("/handler" , new CustomAbstractHandler());
        routes.addRoute("/index" , new SimpleHandler("index.html" ));

        HTTPServer httpServer = new HTTPServer(routes);
        httpServer.start();
    }
}