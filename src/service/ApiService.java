package service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    public double getDollarRate() {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://economia.awesomeapi.com.br/last/USD-BRL"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Answer API: " + response.body());

            return 5.0;
        } catch (Exception e) {
            System.out.println("Error API: " + e.getMessage());
            return 0;
        }
    }
}