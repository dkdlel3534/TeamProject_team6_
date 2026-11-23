import java.util.HashMap;

/**
 * 대출 데이터베이스 클래스
 *
 * @author (2025320070 복창희)
 * @version (2026.11.23)
 */
public class LoanDB
{
    private HashMap<Integer, Loan> loanMap = new HashMap<>();

    /**
     * 대출 객체 저장 메소드
     *
     * @param bookID 도서 등록번호
     * @param loan 대출 객체
     */
    public void save(int bookID, Loan loan)
    {
        loanMap.put(bookID, loan);
    }

    /**
     * 도서 등록번호를 이용한 Loan 객체 검색 메소드
     *
     * @param bookID 도서 등록번호
     * @return Loan 대출 객체
     */
    public Loan getLoan(int bookID)
    {
        return loanMap.get(bookID);
    }

    /**
     * Loan 객체 삭제 메소드
     *
     * @param loan 삭제할 대출 객체
     */
    public void delete(Loan loan)
    {
        loanMap.values().remove(loan);
    }
}
