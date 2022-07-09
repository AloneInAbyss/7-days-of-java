package com.sevendaysofcode;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            throw new Exception("Missing API_KEY argument");
        }

        System.out.println("--------------------------------");
        System.out.println("        7 Days of Code          ");
        System.out.println("--------------------------------");

        final String key = API.validateKey(args[0]);
        final String[] movies = API.getTopMovies(key);

        final List<String> titles = DataParser.getAttribute(movies, "title");
        final List<String> images = DataParser.getAttribute(movies, "image");

        WriteOutput.write(Arrays.toString(movies), "movies.txt");
        WriteOutput.write(titles, "titles.txt");
        WriteOutput.write(images, "images.txt");

    }
}
