package org.ergemp.jwt.model.defaultResponses;

import org.ergemp.jwt.config.serverConfig;
import org.ergemp.jwt.model.HTTPResponse;
import org.ergemp.jwt.model.defaultRoutes.Route201;
import org.ergemp.jwt.util.constants.Types;

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
