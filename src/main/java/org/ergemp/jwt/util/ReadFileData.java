package org.ergemp.jwt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileData {
    public static byte[] read(File file, int fileLength) throws IOException {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[fileLength];

        try {
            fileIn = new FileInputStream(file);
            fileIn.read(fileData);
        } finally {
            if (fileIn != null)
                fileIn.close();
        }
        return fileData;
    }
}
