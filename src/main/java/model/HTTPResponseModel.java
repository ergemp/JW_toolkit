package model;

import config.serverConfig;
import util.ReadFileData;
import util.constants.StatusTypes;

import java.io.File;
import java.util.Date;

public class HTTPResponseModel {
    private String status ;
    private String server;
    private String date;
    private String contentType;

    private SingleRouteModel route;

    public String getStatus() {
        return status;
    }

    public String getServer() {
        return server;
    }

    public String getDate() {
        return date;
    }

    public String getContentType() {
        return contentType;
    }


    public HTTPResponseModel(StatusTypes.STATUS gStatus, SingleRouteModel gRoute) {
        switch(gStatus) {
            case OK:
                this.status = "HTTP/1.1 200 OK" ;
                this.route = gRoute;
                break;
            case INTERNAL_ERROR:
                this.status = "HTTP/1.1 500 Internal Server Error" ;
                this.route = gRoute ;
                break;
            case NOT_FOUND:
                this.status = "HTTP/1.1 404 File Not Found";
                this.route = gRoute ;
                break;
            case NOT_IMPLEMENTED:
                this.status = "HTTP/1.1 501 Not Implemented" ;
                this.route = gRoute ;
                break;
        }
        this.server = "Server: Simple Java Web Server 1.0";
        this.date = "Date: " + new Date();
        this.route = gRoute;
        switch(this.route.getResponseContentType()) {
            case HTML:
                this.contentType = "Content-type: text/html" ;
                break;
            case JSON:
                this.contentType = "Content-type: text/json" ;
                break;
            case TEXT:
                this.contentType = "Content-type: plain/text" ;
                break;
        }
    }

    public Integer getFileSize(){
        return route.getFileSize();
    }

    public byte[] getFileData(){
        return route.getFileData();
    }
}

