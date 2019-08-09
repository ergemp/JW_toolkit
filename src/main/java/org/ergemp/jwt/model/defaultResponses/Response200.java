package org.ergemp.jwt.model.defaultResponses;

import org.ergemp.jwt.config.serverConfig;
import org.ergemp.jwt.model.HTTPResponse;
import org.ergemp.jwt.model.defaultRoutes.Route200;
import org.ergemp.jwt.util.constants.Types;
import model.defaultRoutes.*;

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
