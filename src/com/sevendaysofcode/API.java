package com.sevendaysofcode;

public abstract class API {

    public static void validateKey(String key) throws Exception {
        if (!key.startsWith("API_KEY=")) {
            throw new Exception("Missing API_KEY argument");
        }

        if (key.split("=").length != 2) {
            throw new Exception("Invalid API_KEY format");
        }
    }

}
