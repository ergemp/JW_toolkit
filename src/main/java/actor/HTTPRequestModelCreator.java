package actor;

import model.HTTPRequest;
import util.MethodMapper;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class HTTPRequestModelCreator {

    public HTTPRequest createRequestHeader(BufferedReader gIn) {

        HTTPRequestModelCreator creator = new HTTPRequestModelCreator();
        HTTPRequest model = new HTTPRequest();

        try {
            String line = "";
            List<String> clientRequestArr = new ArrayList();

            while ((line = gIn.readLine()) != null) {
                if (line.trim().equalsIgnoreCase("")) {
                    break;
                }
                else {
                    clientRequestArr.add(line);
                }
            }

            model = creator.createRequestHeader(clientRequestArr);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally{
            return model;
        }
    }

    public HTTPRequest createRequestHeader(List<String> gRequest){
        HTTPRequest model = new HTTPRequest();
        try {
            if (gRequest != null) {
                gRequest.forEach(each -> {
                    switch (each.split(":" )[0].toLowerCase().trim()){
                        case "host" :
                            model.setHost(each.split(":" )[1].toLowerCase().trim());
                            break;
                        case "connection":
                            model.setConnection(each.split(":" )[1].toLowerCase().trim());
                            break;
                        case "cache-control":
                            model.setCacheControl(each.split(":" )[1].toLowerCase().trim());
                            break;
                        case "upgrade-insecure-requests":
                            model.setUpgradeInsecureRequests(each.split(":" )[1].toLowerCase().trim());
                            break;
                        case "user-agent":
                            model.setUserAgent(each.split(":" )[1].toLowerCase().trim());
                            break;
                        case "accept":
                            model.setAccept(each.split(":" )[1].toLowerCase().trim());
                            break;
                        case "accept-encoding":
                            model.setAcceptEncoding(each.split(":" )[1].toLowerCase().trim());
                            break;
                        case "accept-language":
                            model.setAcceptLanguage(each.split(":" )[1].toLowerCase().trim());
                            break;
                        default :
                            model.setMethod(new MethodMapper().getMehod(each.split(" ")[0]));
                            model.setPath(each.split(" ")[1]);
                            if (!model.getPath().trim().equalsIgnoreCase("prefetch" )) {
                                model.setHttpVersion(each.split(" ")[2]);
                            }
                            break;
                    }
                });
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally{
            if (config.serverConfig.DEBUG){
                System.out.print(" - Request Method: " +  model.getMethod());
                System.out.print(" - Request Path: " +  model.getPath());
                System.out.print(" - Request Host: " +  model.getHost());
                System.out.print(" - Request HTTP Version: " +  model.getHttpVersion() + "\n" );
            }
            return model;
        }
    }
}
