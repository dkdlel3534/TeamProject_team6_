import java.util.ArrayList;

/**
 * 반납 데이터베이스 클래스
 *
 * @author (2025320070 복창희)
 * @version (2026.11.26)
 */
public class ReturnDB
{
    private ArrayList<Return> returnList = new ArrayList<>();

    /**
     * 반납 객체 저장 메소드
     *
     * @param returned (반납 객체)
     */
    public void save(Return returned)
    {
        returnList.add(returned);
    }
}