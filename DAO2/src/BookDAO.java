import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book k) {
        books.add(k);
    };

    public List<Book> getAll() {
        return books;
    };
}
