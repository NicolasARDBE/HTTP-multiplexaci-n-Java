package org.example;

import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHttp1Client {

    public static void main(String[] args) {
        String urlString = "http://localhost:8080/test"; // URL del servidor
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Código de respuesta: " + responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
