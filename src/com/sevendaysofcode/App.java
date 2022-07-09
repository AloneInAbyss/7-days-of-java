package com.sevendaysofcode;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            throw new Exception("Missing API_KEY argument");
        }

        final String key = API.validateKey(args[0]);

        System.out.println("--------------------------------");
        System.out.println("        7 Days of Code          ");
        System.out.println("--------------------------------");

        final String url = "https://imdb-api.com/en/API/Top250Movies/" + key;

        final String resp = API.connect(url);

        final String[] movies = DataParser.getData(resp);
        final List<String> titles = DataParser.getAttribute(movies, "title");
        final List<String> images = DataParser.getAttribute(movies, "image");

        WriteOutput.write(resp, "response.json");
        WriteOutput.write(titles, "titles.txt");
        WriteOutput.write(images, "images.txt");

    }
}
