package CurrencyWithApi;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class GetRateAction {

    private static final String URL = "https://api.exchangeratesapi.io/latest?base=%s&symbols=%s";

    public Rate getCurrentRate(String base, String symbols) throws IOException {
        //czasem trzeba wpisac, zeby przegladarka dzialala poprawnie
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

        URL url = new URL(String.format(URL, base, symbols));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.addRequestProperty("User-Agent", "Mozilla/5.0");
        Gson gson = new Gson();
        String response = readResponse(con);
        Rate rate = gson.fromJson(response, Rate.class);
        System.out.println("Deserialize: ");
        System.out.println(rate);
        con.disconnect();
        return rate;
    }

    private String readResponse(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader((InputStream) con.getContent()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content);
        return content.toString();
    }

}