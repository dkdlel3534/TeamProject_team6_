import java.time.LocalDate;

/**
 * 반납 객체를 생성하는 클래스
 *
 * @author (2025320070 복창희)
 * @version (2026.11.23)
 */
public class Return
{
    private Loan loan;
    private LocalDate returnDate;
    private boolean resultOverdue;

    /**
     * Return 클래스의 객체 생성자
     *
     * @param loan 대출 객체
     * @param returnDate 실제 반납일
     * @param resultOverdue 연체 여부
     */
    public Return(Loan loan, LocalDate returnDate, boolean resultOverdue)
    {
        this.loan = loan;
        this.returnDate = returnDate;
        this.resultOverdue = resultOverdue;
    }

    /**
     * 화면 출력 메소드
     */
    public void display()
    {
        loan.display();

        System.out.println("실제 반납일: " + returnDate);
        System.out.println("연체 여부: " + resultOverdue);
    }
}