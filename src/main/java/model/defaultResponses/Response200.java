package model.defaultResponses;

import config.serverConfig;
import model.HTTPResponse;
import model.defaultRoutes.*;
import util.constants.Types;

import java.util.Date;

public class Response200 extends HTTPResponse {
    public Response200(){
        setContent(Types.CONTENT_TYPE.TEXT);
        setStatus(Types.RESPONSE_STATUS.OK);
        setDate(new Date().toString());
        setServer(serverConfig.SERVERNAME);
        setRoute(new Route200());
    }
}
