import java.time.LocalDate;

/**
 * 대출 객체를 생성하는 클래스
 *
 * @author (2025320070 복창희)
 * @version (2026.11.23)
 */
public class Loan
{
    private LocalDate loanDate;
    private LocalDate returnDue;
    private User user;
    private Book book;

    /**
     * Loan 클래스의 객체 생성자
     *
     * @param user 대출 이용자
     * @param book 대출 도서
     */
    public Loan(User user, Book book)
    {
        this.user = user;
        this.book = book;

        user.loan = this;
        book.loan = this;

        this.loanDate = LocalDate.now();
        this.returnDue = loanDate.plusDays(14);
    }

    /**
     * 화면 출력 메소드
     */
    public void display()
    {
        System.out.println("대출일: " + loanDate);
        System.out.println("반납예정일: " + returnDue);
    }

    /**
     * 반납일을 기준으로 연체 여부를 검사하는 메소드
     *
     * @param returnDate 실제 반납일
     * @return 연체 여부 (true: 연체, false: 정상 반납)
     */
    public boolean checkOverdue(LocalDate returnDate)
    {
        return returnDate.isAfter(returnDue);
    }

    /**
     * 이용자 및 도서와의 참조 연결을 해제하는 메소드
     */
    public void disconnect()
    {
        user.loan = null;
        book.loan = null;

        user = null;
        book = null;
    }
}
