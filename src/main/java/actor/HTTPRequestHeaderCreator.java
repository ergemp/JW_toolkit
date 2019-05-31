package actor;

import model.HTTPRequestHeaderModel;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HTTPRequestHeaderCreator {

    public HTTPRequestHeaderModel createRequestHeader(BufferedReader gIn) {

        HTTPRequestHeaderCreator creator = new HTTPRequestHeaderCreator();
        HTTPRequestHeaderModel model = new HTTPRequestHeaderModel();

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

    public  HTTPRequestHeaderModel createRequestHeader(List<String> gRequest){
        HTTPRequestHeaderModel model = new HTTPRequestHeaderModel();
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
                            model.setMethod(each.split(" ")[0]);
                            model.setPath(each.split(" ")[1]);
                            model.setHttpVersion(each.split(" ")[2]);
                            break;
                    }
                });
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally{
            return model;
        }
    }
}
