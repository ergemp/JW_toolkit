package util;

import util.constants.Types;

import java.util.HashMap;
import java.util.Map;

public class MethodMapper {
    private Map<String, Types.REQUEST_METHOD> map;

    public MethodMapper(){
        map = new HashMap<>();
        map.put("GET", Types.REQUEST_METHOD.GET);
        map.put("POST", Types.REQUEST_METHOD.POST);
        map.put("HEAD", Types.REQUEST_METHOD.HEAD);
        map.put("PUT", Types.REQUEST_METHOD.PUT);
    }

    public Types.REQUEST_METHOD getMehod(String gMethod){
        Types.REQUEST_METHOD retVal = map.getOrDefault(gMethod, Types.REQUEST_METHOD.GET);
        return retVal;
    }
}
