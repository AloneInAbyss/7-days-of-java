package com.sevendaysofcode;

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

        System.out.println(resp);

    }
}
