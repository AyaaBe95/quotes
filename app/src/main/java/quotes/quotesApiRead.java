package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class quotesApiRead {

    private static final String FILE = "app/src/main/resources/recentquotes.json";

    public static void getUrlQuote(String quoteUrl) throws IOException {
        try {
            URL url = new URL(quoteUrl);
            String content;
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");
            con.getResponseCode();
            if(con.getResponseCode() == 200 ){
                try {
                    Gson gson = new Gson();
                    BufferedReader reader = getBufferedReader(con);
                    content = getContent(reader);
                    quotesFromApi randomQuote = gson.fromJson(content, quotesFromApi.class);
                    System.out.println(randomQuote.getQuoteText() + "\n- Author: " + randomQuote.getQuoteAuthor());
                    write(randomQuote);
                    reader.close();

                }catch (IOException e){
                    System.out.println("exception: IOException inside buffer "+ e);


                }
            }else{
                getFileQuote();
            }


        } catch (MalformedURLException e) {
            System.out.println("exception: MalformedURLException " + e);
//            getFileQuote();
//            return;
        }catch (IOException e){
            System.out.println("exception: IOException " + e);
//            getFileQuote();
//            return;
        }
    }

    public  static void write(quotesFromApi t) throws IOException {
        Gson gson = new Gson();
        String gsonParsing = gson.toJson(t);
        BufferedWriter writer = new BufferedWriter(new FileWriter("app/src/main/resources/recentquotes.json", true));
        writer.newLine();
        writer.write(gsonParsing);
        writer.close();
    }

    private static BufferedReader getBufferedReader(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        return new BufferedReader(inputStreamReader);
    }

    private  static String getContent(BufferedReader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        String currentLine = reader.readLine();
        while(currentLine != null){
            builder.append(currentLine);
            currentLine = reader.readLine();
        }
        return builder.toString();
    }

    public static void getFileQuote() throws IOException {
        quotesRead qReader = new quotesRead(FILE);
        System.out.println("From JSON File: ");
        System.out.println(qReader.getRandomQuote());
    }



    }








