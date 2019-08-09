package model.defaultResponses;

import config.serverConfig;
import model.HTTPResponse;
import model.defaultRoutes.*;
import util.constants.Types;

import java.util.Date;

public class Response404 extends HTTPResponse {
    public Response404(){
        setContent(Types.CONTENT_TYPE.TEXT);
        setStatus(Types.RESPONSE_STATUS.NOT_FOUND);
        setDate(new Date().toString());
        setServer(serverConfig.SERVERNAME);
        setRoute(new Route404());
    }
}
