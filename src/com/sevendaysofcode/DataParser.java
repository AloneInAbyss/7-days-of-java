package com.sevendaysofcode;

import java.util.ArrayList;
import java.util.List;

public abstract class DataParser {

    public static String[] getData(String json) {
        int start = json.indexOf("[");
        int end = json.indexOf("]");

        String dataArray = json.substring(start + 1, end - 1);
        dataArray = dataArray.replace("{", "");
        return dataArray.split("},");
    }

    public static List<String> getAttribute(String[] data, String attribute) {
        List<String> attributeList = new ArrayList<String>();

        for (String dataInfo : data) {
            String[] dataInfoArray = dataInfo.split(",");

            for (String info : dataInfoArray) {
                if (info.contains(attribute)) {
                    String attributeData = info.substring(info.indexOf(":") + 1);
                    String attributeDataParsed = attributeData.replace("\"", "");
                    attributeList.add(attributeDataParsed);
                }
            }
        }

        return attributeList;
    }

}
