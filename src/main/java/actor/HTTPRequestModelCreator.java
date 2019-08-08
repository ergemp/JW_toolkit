package actor;

import model.HTTPRequest;
import util.MethodMapper;
import util.constants.Types;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class HTTPRequestModelCreator {
    HTTPRequest model = new HTTPRequest();
    List<String> clientRequestHeaderArr = new ArrayList();

    public HTTPRequest createRequest(BufferedReader gIn, BufferedInputStream gDataIn) {
        this.prepareDataAsList(gIn);
        //this.createRequestHeader();
        return this.model;
    }

    public void prepareDataAsList(BufferedReader gIn) {

        Boolean isContent = false;
        try {
            String line = null;
            while ((line = gIn.readLine()) != null ) {
                if (line.trim().equalsIgnoreCase("")) {
                    break;
                }
                clientRequestHeaderArr.add(line);
            }

            createRequestHeader();

            if (model.getMethod() != null) {

                //20190808: ergemp: I think, we shouldnt control the body loader on request type
                /*
                if (!(model.getMethod().equals(Types.METHOD.GET) ||
                      model.getMethod().equals(Types.METHOD.HEAD) ||
                      model.getMethod().equals(Types.METHOD.DELETE))) {
                */
                StringBuilder payload = new StringBuilder();
                while (gIn.ready()) {
                    payload.append((char) gIn.read());
                }
                model.setContent(payload.toString());
                //}
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {

        }
    }

    public  void createRequestHeader(){
        try {
            if (clientRequestHeaderArr != null) {
                clientRequestHeaderArr.forEach(each -> {

                    if (each.split(":").length >= 2) {
                        model.addHeader(each.split(":")[0].toLowerCase().trim(), each.split(":")[1].toLowerCase().trim());
                        switch (each.split(":")[0].toLowerCase().trim()) {
                            case "host":
                                model.setHost(each.split(":")[1].toLowerCase().trim());
                                break;
                            case "connection":
                                model.setConnection(each.split(":")[1].toLowerCase().trim());
                                break;
                            case "cache-control":
                                model.setCacheControl(each.split(":")[1].toLowerCase().trim());
                                break;
                            case "upgrade-insecure-requests":
                                model.setUpgradeInsecureRequests(each.split(":")[1].toLowerCase().trim());
                                break;
                            case "user-agent":
                                model.setUserAgent(each.split(":")[1].toLowerCase().trim());
                                break;
                            case "accept":
                                model.setAccept(each.split(":")[1].toLowerCase().trim());
                                break;
                            case "accept-encoding":
                                model.setAcceptEncoding(each.split(":")[1].toLowerCase().trim());
                                break;
                            case "accept-language":
                                model.setAcceptLanguage(each.split(":")[1].toLowerCase().trim());
                                break;
                            default:
                                break;
                        }
                    }
                    else {
                        model.setMethod(new MethodMapper().getMehod(each.split(" ")[0]));
                        model.setPath(each.split(" ")[1]);
                        if (!model.getPath().trim().equalsIgnoreCase("prefetch")) {
                            model.setHttpVersion(each.split(" ")[2]);
                        }
                    }
                });
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally{
            if (config.serverConfig.DEBUG){
                if (model.getMethod() != null) {
                    System.out.println(" - Thread ID: " + Thread.currentThread().getId() + " - Request Raw: " + clientRequestHeaderArr.toString());
                    System.out.print(" - Request Method: " + model.getMethod());
                    System.out.print(" - Request Path: " + model.getPath());
                    System.out.print(" - Request Host: " + model.getHost());
                    System.out.print(" - Request HTTP Version: " + model.getHttpVersion() + "");
                    System.out.print(" - Request Content: " + model.getContent() + "\n");
                }
            }
        }
    }
}
