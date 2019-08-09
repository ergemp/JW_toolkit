package org.ergemp.jwt.model.defaultResponses;

import org.ergemp.jwt.config.serverConfig;
import org.ergemp.jwt.model.HTTPResponse;
import org.ergemp.jwt.model.defaultRoutes.Route501;
import org.ergemp.jwt.util.constants.Types;

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
