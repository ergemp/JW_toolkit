package org.ergemp.jwt.model;

import org.ergemp.jwt.util.constants.Types;

import java.util.HashMap;
import java.util.Map;

public class HTTPRequest {
    private Types.REQUEST_METHOD method ;
    private String path ;
    private String httpVersion ;
    private String host;
    private String connection;
    private String cacheControl;
    private String userAgent;
    private String accept;
    private String acceptEncoding;
    private String acceptLanguage;
    private String content;
    private Map<String, String> allHeaders = new HashMap<>();
    private Map<String, String> params = new HashMap<>();

    public void addHeader(String gKey, String gValue){
        allHeaders.put(gKey, gValue);
    }

    public Map<String, String> getHeader(String gKey, String gValue){
        return allHeaders;
    }

    public Types.REQUEST_METHOD getMethod() {
        return method;
    }

    public void setMethod(Types.REQUEST_METHOD method) {
        this.method = method;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public String toString(){
        return
            method + ", " +
            host + ", " +
            connection + ", " +
            cacheControl + ", " +
            userAgent + ", " +
            accept + ", " +
            acceptEncoding + ", " +
            acceptLanguage;
    }

    public void setParams(String gParams) {
        for (String param : gParams.split("&")) {
            try {
                params.put(param.split("=")[0], param.split("=")[1]);
            }
            catch(Exception ex){
            }
        }
    }

    public Map<String,String> getParams() {
        return params;
    }

    public void setPath(String path) {
        if (path.indexOf("?") > 0) {
            this.path = path.substring(0,path.indexOf("?"));
            setParams(path.substring(path.indexOf("?") + 1));
        }
        else {
            this.path = path;
        }
    }

    public String getPath() {
        return path;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
