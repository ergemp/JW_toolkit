package org.ergemp.jwt.util;

import org.ergemp.jwt.util.constants.Types;

import java.util.HashMap;
import java.util.Map;

public class MethodMapper {
    private Map<String, Types.REQUEST_METHOD> map;

    public MethodMapper(){
        map = new HashMap<>();
        map.put("GET", Types.REQUEST_METHOD.GET);
        map.put("HEAD", Types.REQUEST_METHOD.HEAD);
        map.put("POST", Types.REQUEST_METHOD.POST);
        map.put("PUT", Types.REQUEST_METHOD.PUT);
        map.put("DELETE", Types.REQUEST_METHOD.DELETE);
        map.put("PATCH", Types.REQUEST_METHOD.PATCH);
    }

    public Types.REQUEST_METHOD getMehod(String gMethod){
        Types.REQUEST_METHOD retVal = map.getOrDefault(gMethod, Types.REQUEST_METHOD.GET);
        return retVal;
    }
}
