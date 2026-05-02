import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {
        String json = getJsonFromApi(urlString);
        try {
            JSONParser parser = new JSONParser();
            Object parsed = parser.parse(json);
            String found = findAttribute(parsed, attributeName);
            if (found == null) {
                throw new IllegalArgumentException("Attribute not found: " + attributeName);
            }
            return found;
        } catch (org.json.simple.parser.ParseException e) {
            throw new IOException("Failed to parse JSON response", e);
        }
    }

    private String getJsonFromApi(String apiUrl) throws IOException {
        URL url;
        try {
            url = new URL(apiUrl);
        } catch (Exception e) {
            throw new IOException("Invalid URL: " + apiUrl, e);
        }

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(10_000);
        con.setReadTimeout(10_000);

        try {
            int status = con.getResponseCode();
            InputStream stream = (status >= 200 && status < 300) ? con.getInputStream() : con.getErrorStream();
            String body = readStream(stream);
            if (!(status >= 200 && status < 300)) {
                throw new IOException("HTTP error code: " + status + " response: " + body);
            }
            return body;
        } finally {
            con.disconnect();
        }
    }

    private String readStream(InputStream in) throws IOException {
        if (in == null) return "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }
    }


    private String findAttribute(Object node, String attributeName) {
        if (node instanceof JSONObject) {
            JSONObject obj = (JSONObject) node;
            if (obj.containsKey(attributeName)) {
                Object value = obj.get(attributeName);
                return valueToString(value);
            }
            for (Object key : obj.keySet()) {
                Object child = obj.get(key);
                String found = findAttribute(child, attributeName);
                if (found != null) return found;
            }
        } else if (node instanceof JSONArray) {
            JSONArray array = (JSONArray) node;
            for (Object element : array) {
                String found = findAttribute(element, attributeName);
                if (found != null) return found;
            }
        }
        return null;
    }

    private String valueToString(Object value) {
        if (value == null) return null;
        return value.toString();
    }
}
