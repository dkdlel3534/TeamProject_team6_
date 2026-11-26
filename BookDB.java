import java.util.TreeSet;
import java.util.Comparator;

/**
 * 책 데이터베이스 클래스
 *
 * @author (2025320070 복창희)
 * @version (2026.11.23)
 */
public class BookDB
{
    private TreeSet<Book> bookSet = new TreeSet<>(Comparator.comparingInt(book -> book.bookID));

    /**
     * 책 등록번호 검색 메소드
     *
     * @param bookID 도서 등록번호
     * @return Book 검색된 도서 객체
     */
    public Book search(int bookID)
    {
        for (Book book : bookSet) {
            if (book.bookID == bookID) {
                return book;
            }
        }

        return null;
    }

    /**
     * 책 등록번호 검사 메소드
     *
     * @param bookID 도서 등록번호
     * @return 등록 여부 (true: 등록됨, false: 미등록)
     */
    public boolean check(int bookID)
    {
        return search(bookID) != null;
    }

    /**
     * 책 객체 저장 메소드
     *
     * @param book 저장할 책 객체
     */
    public void save(Book book)
    {
        bookSet.add(book);
    }
}
