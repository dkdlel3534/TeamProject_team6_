import java.util.ArrayList;

/**
 * 이용자 객체를 생성하는 클래스
 *
 * @author (2025320070 복창희)
 * @version (2026.11.26)
 */
public class User
{
    String stID;
    private String name;
    ArrayList<Loan> loanList;

    /**
     * User 클래스의 객체 생성자
     *
     * @param stID 이용자 학번
     * @param name 이용자 이름
     */
    public User(String stID, String name)
    {
        this.stID = stID;
        this.name = name;
        this.loanList = new ArrayList<>();
    }

    /**
     * 화면 출력 메소드
     */
    public void display()
    {
        System.out.println("학번: " + stID);
        System.out.println("이름: " + name);
    }

    /**
     * 대출가능한 이용자인지 여부를 체크하는 메소드
     *
     * @return 대출가능 여부 (true: 가능, false: 불가능)
     */
    public boolean check()
    {
        return loanList.size() < 3;
    }

    /**
     * 이용자 학번을 반환하는 메소드
     *
     * @return 이용자 학번
     */
    public String getStID()
    {
        return stID;
    }

    /**
     * 대출 객체와 이용자의 연결을 해제하는 메소드
     *
     * @param loan 연결을 해제할 대출 객체
     */
    public void disconnect(Loan loan)
    {
        loanList.remove(loan);
    }
}
