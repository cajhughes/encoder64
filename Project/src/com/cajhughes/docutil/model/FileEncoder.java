package com.cajhughes.docutil.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

public class FileEncoder {
    public static String getBase64Encoding(File file) {
        String encoded = "<Failed to encode>";
        try {
            Path path = file.toPath();
            byte[] data = Files.readAllBytes(path);
            Base64.Encoder encoder = Base64.getEncoder();
            encoded = encoder.encodeToString(data);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return encoded;
    }
}