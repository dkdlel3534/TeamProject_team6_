
/**
 * 책 객체를 생성하는 클래스
 *
 * @author (2025320070 복창희)
 * @version (2026.11.23)
 */
public class Book
{
    private String title;
    private String author;
    public int bookID;
    public Loan loan;

    /**
     * Book 클래스의 객체 생성자
     *
     * @param bookID 도서 등록번호
     * @param title 도서 제목
     * @param author 도서 작가
     */
    public Book(int bookID, String title, String author)
    {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.loan = null;
    }

    /**
     * 화면 출력 메소드
     */
    public void display()
    {
        System.out.println("도서 등록번호: " + bookID);
        System.out.println("도서 제목: " + title);
        System.out.println("도서 작가: " + author);
    }

    /**
     * 대출가능한 책인지 여부를 체크하는 메소드
     *
     * @return 대출가능 여부 (true: 가능, false: 불가능)
     */
    public boolean check()
    {
        return loan == null;
    }

    /**
     * 대출 객체와 책의 연결을 해제하는 메소드
     *
     * @param loan 연결을 해제할 대출 객체
     */
    public void disconnect(Loan loan)
    {
        if (this.loan == loan) {
            this.loan = null;
        }
    }
}
