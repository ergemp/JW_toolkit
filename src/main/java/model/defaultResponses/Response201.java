package model.defaultResponses;

import config.serverConfig;
import model.HTTPResponse;
import model.defaultRoutes.*;
import util.constants.Types;

import java.util.Date;

public class Response201 extends HTTPResponse {
    public Response201(){
        setContent(Types.CONTENT_TYPE.TEXT);
        setStatus(Types.RESPONSE_STATUS.CREATED);
        setDate(new Date().toString());
        setServer(serverConfig.SERVERNAME);
        setRoute(new Route201());
    }
}
