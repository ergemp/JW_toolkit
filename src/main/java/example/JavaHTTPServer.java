package example;

        import actor.RoutesFactory;
        import model.HTTPServer;
        import model.Routes;
        import model.handlers.SimpleHandler;

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