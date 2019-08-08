package model.defaultResponses;

import config.serverConfig;
import model.HTTPResponse;
import model.defaultRoutes.Route501;
import util.constants.Types;

import java.util.Date;

public class Response501 extends HTTPResponse {
    public Response501(){
        setContent(Types.CONTENT_TYPE.TEXT);
        setStatus(Types.RESPONSE_STATUS.NOT_IMPLEMENTED);
        setDate(new Date().toString());
        setServer(serverConfig.SERVERNAME);
        setRoute(new Route501());
    }
}
