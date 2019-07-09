package com.study.lombok.cleanup;

import lombok.Cleanup;

import java.io.*;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        @Cleanup
        OutputStream outStream = new FileOutputStream(new File("text.txt"));
        @Cleanup
        InputStream inStream = new FileInputStream(new File("text2.txt"));
        byte[] b = new byte[65536];
        while (true) {
            int r = inStream.read(b);
            if (r == -1) break;
            outStream.write(b, 0, r);
        }

    }
}
