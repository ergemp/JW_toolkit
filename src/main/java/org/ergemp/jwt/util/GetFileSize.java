package org.ergemp.jwt.util;

import org.ergemp.jwt.config.serverConfig;

import java.io.File;

public class GetFileSize {
    public static Integer get(String gFileName){
        Integer retVal = 0;
        try {
            File file = new File(gFileName);
            retVal = (int) file.length();
        }
        catch(Exception ex) {
            retVal = 0;
        }
        finally {
            return retVal;
        }
    }
}
