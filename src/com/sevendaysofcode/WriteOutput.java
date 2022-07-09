package com.sevendaysofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public abstract class WriteOutput {

    public static void write(Object data, String filename) {
        String directoryName = "output";
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }

        try (PrintStream ps = new PrintStream(directoryName + "/" + filename)) {
            ps.print(data);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
