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
    private Types.CONTENT content;
    private Types.STATUS status;

    public String getStatus() {
        return new StatusMapper().getStatus(status);
    }
    public void setStatus(Types.STATUS gStatus) {
        status=gStatus;
    }

    public String getContentType() {
        return new ContentMapper().getContent(content);
    }
    public void setContent(Types.CONTENT gContent) {
        content=gContent;
    }

    public String getServer() {
        return server;
    }

    public String getDate() {
        return date;
    }

    public HTTPResponse(SingleRouteModel gRoute) {
        this.server = serverConfig.SERVERNAME;
        this.date = "Date: " + new Date();
        this.route = gRoute;
        this.content = Types.CONTENT.HTML;
        this.status = Types.STATUS.OK;
    }

    public HTTPResponse(Types.STATUS gStatus, Types.CONTENT gContent, SingleRouteModel gRoute) {
        this.status = gStatus;
        this.content = gContent;
        this.content = gContent;
        this.server = serverConfig.SERVERNAME;
        this.date = "Date: " + new Date();
        this.route = gRoute;
    }

    public void handle(HTTPRequest request){ route.handle(request, this);}
    public Integer getHandleDataLegth(){ return route.getHandleDataLength();}
    public byte[] getHandleData (){ return route.getHandleData();}

    public String getFileName() { return route.getResponseFile(); }
    public String getHandlerClassName() { return route.getResponseClass().getClass().getName(); }
}

