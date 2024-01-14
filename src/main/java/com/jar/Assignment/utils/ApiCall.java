package com.jar.Assignment.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCall {

    public static double getApiData() {
        double inrRate = 0;
        try {

            String apiUrl = "https://api.fxratesapi.com/latest";

            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.toString());

            JsonNode ratesNode = jsonNode.path("rates");
             inrRate = ratesNode.path("INR").asDouble();

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return inrRate;
    }
}
