package quotes;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Random;

public class quotesRead {

    public Quotes[] quotes;


    public quotesRead(String theFile) throws FileNotFoundException {
        this.quotes = readQuotes(theFile);
    }



    public Quotes[] readQuotes(String theFile) throws FileNotFoundException{
        Gson gson = new Gson();
        Reader reader = new FileReader(theFile);
        quotes = gson.fromJson(reader, Quotes[].class);

        
        return quotes;
    }

    public String getRandomQuote(){
        int index = new Random().nextInt(quotes.length);
        StringBuilder result = new StringBuilder();
        result.append(quotes[index].getText());
        result.append("\n- " + quotes[index].getAuthor());

        return result.toString();
    }


}
