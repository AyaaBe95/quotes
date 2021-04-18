package quotes;

public class quotesFromApi {

    private String quoteText;
    //author
    private String quoteAuthor;

    public quotesFromApi(String quoteText, String quoteAuthor) {
        this.quoteAuthor=quoteAuthor;
        this.quoteAuthor=quoteAuthor;


    }

    public String getQuoteText() {
        return quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }


    //to string
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(quoteText);
        result.append("\n- " + quoteAuthor);

        return result.toString();
    }


}