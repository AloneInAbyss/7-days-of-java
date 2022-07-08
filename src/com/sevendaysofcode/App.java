package com.sevendaysofcode;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new Exception("Missing API_KEY argument");
        }

        API.validateKey(args[0]);

        System.out.println("--------------------------------");
        System.out.println("        7 Days of Code          ");
        System.out.println("--------------------------------");
    }
}
