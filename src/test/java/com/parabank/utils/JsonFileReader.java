package com.parabank.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReader {
    public static Object[][] getJsonData(String sectionName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(new File("src/test/resources/testdata/ParabankData.json"));
        JsonNode dataNode = rootNode.get(sectionName);

        List<Object[]> dataList = new ArrayList<>();

        for (JsonNode node : dataNode) {
            // Converts each JSON object into a list of its values
            List<String> row = new ArrayList<>();
            node.fields().forEachRemaining(entry -> row.add(entry.getValue().asText()));
            dataList.add(row.toArray());
        }

        return dataList.toArray(new Object[0][0]);
    }
}