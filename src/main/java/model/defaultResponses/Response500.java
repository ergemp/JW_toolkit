package model.defaultResponses;

import config.serverConfig;
import model.HTTPResponse;
import model.defaultRoutes.*;
import util.constants.Types;

import java.util.Date;

public class Response500 extends HTTPResponse {
    public Response500(){
        setContent(Types.CONTENT_TYPE.TEXT);
        setStatus(Types.RESPONSE_STATUS.INTERNAL_ERROR);
        setDate(new Date().toString());
        setServer(serverConfig.SERVERNAME);
        setRoute(new Route500());
    }
}
