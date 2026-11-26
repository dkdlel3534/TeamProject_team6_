import java.time.LocalDate;

/**
 * 반납 객체를 생성하는 클래스
 *
 * @author (2025320070 복창희)
 * @version (2026.11.26)
 */
public class Return
{
    private String stID;
    private int bookID;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean resultOverdue;

    /**
     * Return 클래스의 객체 생성자
     *
     * @param stID 이용자 학번
     * @param bookID 도서 등록번호
     * @param loanDate 대출일
     * @param returnDate 실제 반납일
     * @param resultOverdue 연체 여부
     */
    public Return(String stID, int bookID, LocalDate loanDate,
    LocalDate returnDate, boolean resultOverdue)
    {
        this.stID = stID;
        this.bookID = bookID;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.resultOverdue = resultOverdue;
    }

    /**
     * 화면 출력 메소드
     */
    public void display()
    {
        System.out.println("학번: " + stID);
        System.out.println("도서 등록번호: " + bookID);
        System.out.println("대출일: " + loanDate);
        System.out.println("실제 반납일: " + returnDate);
        System.out.println("연체 여부: " + resultOverdue);
    }
}
