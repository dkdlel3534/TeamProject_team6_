import java.util.HashMap;

/**
 * 이용자 데이터베이스 클래스
 *
 * @author (2025320070 복창희)
 * @version (2026.11.26)
 */
public class UserDB
{
    private HashMap<String, User> userMap = new HashMap<>();

    /**
     * 이용자 학번 검색 메소드
     *
     * @param stID 이용자 학번
     * @return User 검색된 이용자 객체
     */
    public User search(String stID)
    {
        return userMap.get(stID);
    }

    /**
     * 이용자 학번 검사 메소드
     *
     * @param stID 이용자 학번
     * @return 등록 여부 (true: 등록됨, false: 미등록)
     */
    public boolean check(String stID)
    {
        return userMap.containsKey(stID);
    }

    /**
     * 이용자 객체 저장 메소드
     *
     * @param user 저장할 이용자 객체
     */
    public void save(User user)
    {
        userMap.put(user.stID, user);
    }
}
