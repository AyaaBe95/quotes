package quotes;

import java.util.List;
import java.util.Objects;

public class Quotes {

    private List<String> tags;
    //author
    private String author;
    //likes
    private  String likes;
    //text
    private String text;

    public Quotes( List<String> tags, String author, String likes, String text) {
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quotes quotes = (Quotes) o;
        return author.equals(quotes.author) && text.equals(quotes.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, text);
    }
}
