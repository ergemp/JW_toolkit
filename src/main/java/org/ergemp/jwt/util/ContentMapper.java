package org.ergemp.jwt.util;

import org.ergemp.jwt.util.constants.Types;

import java.util.HashMap;
import java.util.Map;

public class ContentMapper {
    private Map<Types.CONTENT_TYPE, String> map;

    public ContentMapper(){
        map = new HashMap<>();
        map.put(Types.CONTENT_TYPE.HTML, "Content-type: text/html");
        map.put(Types.CONTENT_TYPE.JSON, "Content-type: text/json");
        map.put(Types.CONTENT_TYPE.TEXT, "Content-type: plain/text");
    }

    public String getContent(Types.CONTENT_TYPE gContent){
        return map.getOrDefault(gContent, "Content-type: text/html");
    }
}
