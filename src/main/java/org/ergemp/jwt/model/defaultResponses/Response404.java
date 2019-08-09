package org.ergemp.jwt.model.defaultResponses;

import org.ergemp.jwt.config.serverConfig;
import org.ergemp.jwt.model.HTTPResponse;
import org.ergemp.jwt.model.defaultRoutes.Route404;
import org.ergemp.jwt.util.constants.Types;

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
