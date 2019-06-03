package util;

import util.constants.Types;

import java.util.HashMap;
import java.util.Map;

public class ContentMapper {
    private Map<Types.CONTENT, String> map;

    public ContentMapper(){
        map = new HashMap<>();
        map.put(Types.CONTENT.HTML, "Content-type: text/html");
        map.put(Types.CONTENT.JSON, "Content-type: text/json");
        map.put(Types.CONTENT.TEXT, "Content-type: plain/text");
    }

    public String getContent(Types.CONTENT gContent){
        return map.getOrDefault(gContent, "Content-type: text/html");
    }
}
