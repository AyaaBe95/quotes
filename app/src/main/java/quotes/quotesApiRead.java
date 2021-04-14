package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class quotesApiRead {

    public Quotes[] quotes;


    public static String getJsonFromAPI(URL url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int status = connection.getResponseCode();
        String content = "";
        if(status == 200) {
            BufferedReader reader = getBufferedReader(connection);
            content = getContent(reader);
            reader.close();
        } else{
            System.out.println("Error in the API. we will show quote from the file");
            String FILE = "app/src/main/resources/recentquot1es.json";
            quotesRead qReader = new quotesRead(FILE);
            System.out.println(qReader.getRandomQuote());

        }

        connection.disconnect();

        return content;
    }

    private static String getContent(BufferedReader reader) throws IOException {    //String vs StringBuilder
        StringBuilder builder = new StringBuilder();
        String currentLine = reader.readLine();

        while(currentLine != null){
            builder.append(currentLine);
            currentLine = reader.readLine();
        }
        return builder.toString();
    }

    private static BufferedReader getBufferedReader(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return new BufferedReader(inputStreamReader);
    }


    static quotesFromApi getquotesApiReadAsObject(String jsonData) {
        Gson gson = new Gson();
        quotesFromApi QuotesfromApi = gson.fromJson(jsonData, quotesFromApi.class);
        return QuotesfromApi;
    }



   

}
