package util;

import util.constants.Types;

import java.util.HashMap;
import java.util.Map;

public class MethodMapper {
    private Map<String, Types.METHOD> map;

    public MethodMapper(){
        map = new HashMap<>();
        map.put("GET", Types.METHOD.GET);
        map.put("POST", Types.METHOD.POST);
        map.put("HEAD", Types.METHOD.HEAD);
        map.put("PUT", Types.METHOD.PUT);
    }

    public Types.METHOD getMehod(String gMethod){
        Types.METHOD retVal = map.getOrDefault(gMethod, Types.METHOD.GET);
        return retVal;
    }
}
