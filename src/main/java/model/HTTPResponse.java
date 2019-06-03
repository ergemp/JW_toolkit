package model;

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

    public String getContentType() {
        return new ContentMapper().getContent(content);
    }

    public String getServer() {
        return server;
    }

    public String getDate() {
        return date;
    }


    public HTTPResponse(SingleRouteModel gRoute) {
        this.server = "Server: Simple Java Web Server 1.0";
        this.date = "Date: " + new Date();
        this.route = gRoute;
        this.content = Types.CONTENT.HTML;
        this.status = Types.STATUS.OK;
    }

    public HTTPResponse(Types.STATUS gStatus, Types.CONTENT gContent, SingleRouteModel gRoute) {
        this.status = gStatus;
        this.content = gContent;
        this.server = "Server: Simple Java Web Server 1.0";
        this.date = "Date: " + new Date();
        this.route = gRoute;
    }

    public Integer getFileSize(){
        return route.getFileSize();
    }

    public byte[] getFileData(){
        return route.getFileData();
    }

    public String getFileName() { return route.getResponseFile(); }
}

