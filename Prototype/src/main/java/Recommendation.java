import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Recommendation clone() throws CloneNotSupportedException {
        Recommendation clonedRecommendation = (Recommendation) super.clone();
        clonedRecommendation.books = new ArrayList<>();
        for (Book book : this.books) {
            clonedRecommendation.books.add((Book) book.clone());
        }
        return clonedRecommendation;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "targetAudience='" + targetAudience + ' ' +
                ", books=" + books +
                '}';
    }
}
