package wtf.Wh3L1nuxXaa.library;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPConnection {
    public static int sendRequest(int availableTaps, int count, long timestamp, String token) throws IOException {
        URL url = new URL("https://api.hamsterkombatgame.io/clicker/tap");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", token);
        connection.setDoOutput(true);
        String jsonInputString = String.format("{\"availableTaps\": %d, \"count\": %d, \"timestamp\": %d}", availableTaps, count, timestamp);
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        int responseCode = connection.getResponseCode();
        return responseCode;
    }
}
