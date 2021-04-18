package quotes;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class quotesRead {

    public Quotes[] quotes;

    public quotesRead(String theFile){
        this.quotes = readQuote(theFile);
    }

    //Read and return quotes
    private Quotes[] readQuote(String theFile){
        Gson gson = new Gson();
        try {
            JsonReader reader = new JsonReader(new FileReader(theFile));
            quotes = gson.fromJson(reader, Quotes[].class);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        return quotes;
    }

    //Generate random quote
    public String getRandomQuote(){
        int index = new Random().nextInt(quotes.length);
        StringBuilder result = new StringBuilder();
        result.append(quotes[index].getText());
        result.append("\n- Author: " + quotes[index].getAuthor());

        return result.toString();
    }

    public Quotes[] getQuotes() {
        return quotes;
    }




}
