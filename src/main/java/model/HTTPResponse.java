package model;

import config.serverConfig;
import util.ContentMapper;
import util.StatusMapper;
import util.constants.Types;

import java.util.Date;

public class HTTPResponse {
    private String server;
    private String date;
    private SingleRouteModel route;
    private Types.CONTENT_TYPE content;
    private Types.RESPONSE_STATUS status;

    public HTTPResponse() { }

    public String getStatus() {
        return new StatusMapper().getStatus(status);
    }
    public void setStatus(Types.RESPONSE_STATUS gStatus) {
        status=gStatus;
    }

    public String getContentType() {
        return new ContentMapper().getContent(content);
    }
    public void setContent(Types.CONTENT_TYPE gContent) {
        content=gContent;
    }

    public void setRoute(SingleRouteModel gRoute){ route = gRoute; }

    public String getServer() {
        return server;
    }
    public void setServer(String gServer) { server = gServer; }

    public String getDate() { return date; }
    public void setDate (String gDate) { date = gDate; }

    public HTTPResponse(SingleRouteModel gRoute) {
        this.server = serverConfig.SERVERNAME;
        this.date = "Date: " + new Date();
        this.route = gRoute;
        this.content = Types.CONTENT_TYPE.HTML;
        this.status = Types.RESPONSE_STATUS.OK;
    }

    public HTTPResponse(Types.RESPONSE_STATUS gStatus, Types.CONTENT_TYPE gContent, SingleRouteModel gRoute) {
        this.status = gStatus;
        this.content = gContent;
        this.content = gContent;
        this.server = serverConfig.SERVERNAME;
        this.date = "Date: " + new Date();
        this.route = gRoute;
    }

    public void handle(HTTPRequest request){ route.handle(request, this);}
    public Integer getHandleDataLength(){ return route.getHandleDataLength();}
    public byte[] getHandleData (){ return route.getHandleData();}
}

