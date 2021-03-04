package data;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class URLCreator {

    public static boolean sendPostRequest(double longitude, double latitute, String name, String address) throws IOException, InterruptedException {
        //setting up the connection
        String MARKERS_ADDRESS = "https://4e49f597b226.ngrok.io/markers";
        URL url = new URL(MARKERS_ADDRESS);
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection) con;
        http.setRequestMethod("POST");
        http.setDoOutput(true);

        //setting up and convert values which will be send
        Map<String, String> arguments = new HashMap<>();
        arguments.put("longitude", Double.toString(longitude));
        arguments.put("latitute", Double.toString(latitute));
        arguments.put("name", name);
        arguments.put("address", address);
        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String, String> entry: arguments.entrySet()) {
            sj.add(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8) + "=" + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }
        byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        //sending data
        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        boolean connect = true;
        while(connect) {
            try {
                http.connect();
                connect = false;
            } catch (BindException e) {
                Thread.sleep(1000);
            }
        }

        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        if(http.getResponseCode() == 400) {
            System.out.println("Something went wrong. ");
            http.disconnect();
            return false;
        }
        http.disconnect();
        return true;
    }

}
