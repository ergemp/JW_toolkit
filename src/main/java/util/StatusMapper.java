package util;

import util.constants.Types;

import java.util.HashMap;
import java.util.Map;

public class StatusMapper {
    private Map<Types.RESPONSE_STATUS, String> map;

    public StatusMapper(){
        map = new HashMap<>();
        map.put(Types.RESPONSE_STATUS.OK, "HTTP/1.1 200 OK");
        map.put(Types.RESPONSE_STATUS.INTERNAL_ERROR, "HTTP/1.1 500 Internal Server Error");
        map.put(Types.RESPONSE_STATUS.NOT_FOUND, "HTTP/1.1 404 File Not Found");
        map.put(Types.RESPONSE_STATUS.NOT_IMPLEMENTED, "HTTP/1.1 501 Not Implemented");
    }

    public String getStatus(Types.RESPONSE_STATUS gStatus){
        String retVal = map.getOrDefault(gStatus, "HTTP/1.1 200 OK");
        return retVal;
    }
}
