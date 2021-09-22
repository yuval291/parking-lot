package ParkingLot;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApiClient implements ImageToTextInterface{
    private String key;

    public ApiClient(String Key) {
        this.key = Key;
    }

    public String GetImageText(String URL) {
        String licensePlate = "";
        try {
            HttpClient client = HttpClient.newHttpClient();

            URI uri = new URIBuilder("https://api.ocr.space/parse/imageurl").addParameter("apikey", key)
                    .addParameter("url",URL).build();

            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

            JSONObject t = new JSONObject(response.body());
            JSONArray arr = t.getJSONArray("ParsedResults");
            JSONObject obj = arr.getJSONObject(0);
            String str = obj.getString("ParsedText");

            System.out.println("First Item Text: " + str);
            licensePlate = myTrim(str);
            System.out.println("licensePlate==" + licensePlate);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return licensePlate;
    }

    private String myTrim(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]+", "");
        return str.trim();
    }

}