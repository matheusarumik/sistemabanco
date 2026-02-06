package service;

import com.google.gson.Gson;
import model.CurrencyResponse;

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

            String json = response.body();
            Gson gson = new Gson();

            CurrencyResponse data = gson.fromJson(json, CurrencyResponse.class);

            return Double.parseDouble(data.USDBRL.bid);

        } catch (Exception e) {
            System.out.println("API error: " + e.getMessage());

            return 5.0;
        }
    }
}