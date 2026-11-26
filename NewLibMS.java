import java.time.LocalDate;

/**
 * 도서관관리시스템 클래스
 *
 * @author (2025320070 복창희)
 * @version (2026.11.26)
 */
public class NewLibMS
{
    private String name;
    private BookDB bookDB;
    private UserDB userDB;
    private LoanDB loanDB;
    private ReturnDB returnDB;

    /**
     * 책을 빌리는 작업을 수행하는 메소드
     *
     * @param bookID 도서 등록번호
     * @param stID 이용자 학번
     */
    public void borrowBook(int bookID, String stID)
    {
        Book book = bookDB.search(bookID);
        User user = userDB.search(stID);

        if (book != null && user != null){
            book.display();
            user.display();
        }
        else{
            System.out.println("책 또는 이용자를 찾을 수 없습니다!");
            return;
        }

        boolean resultBook = book.check();
        boolean resultUser = user.check();

        if(resultBook == false && resultUser == true){
            System.out.println("책 대출불가능! & 이용자 대출가능!");
            return;
        }
        else if ((resultBook == true) && (resultUser == false)){
            System.out.println("책 대출가능! & 이용자 대출불가능!");
            return;
        }
        else if ((resultBook == false) && (resultUser == false)){
            System.out.println("책 대출불가능! & 이용자 대출불가능!");
            return;
        }
        else{
            Loan loan = new Loan(user, book);
            loan.display();
            loanDB.save(bookID, loan);
        }
    }

    /**
     * 새 책을 등록하는 메소드
     *
     * @param bookID 도서 등록번호
     * @param title 도서 제목
     * @param author 도서 작가
     */
    public void registerNewBook(int bookID, String title, String author)
    {
        boolean resultBookID = bookDB.check(bookID);

        if (resultBookID == true) {
            System.out.println("이미 등록된 책입니다!");
            return;
        }
        else{
            Book book = new Book(bookID, title, author);

            bookDB.save(book);

            book.display();
        }
    }

    /**
     * 새 이용자를 등록하는 메소드
     *
     * @param stID 이용자 학번
     * @param name 이용자 이름
     */
    public void registerNewBorrower(String stID, String name)
    {
        boolean resultStID = userDB.check(stID);

        if (resultStID == true) {
            System.out.println("이미 등록된 이용자입니다!");
            return;
        }
        else{
            User user = new User(stID, name);

            userDB.save(user);

            user.display();
        }
    }

    public void returnBook(int bookID)
    {
        Book book = bookDB.search(bookID);

        if (book == null) {
            System.out.println("등록되지 않은 도서입니다.");
            return;
        }

        book.display();

        boolean resultBook = book.check();

        if (resultBook) {
            System.out.println("현재 대출 중인 도서가 아닙니다.");
            return;
        }

        Loan loan = loanDB.getLoan(bookID);

        if (loan == null) {
            System.out.println("대출 정보를 찾을 수 없습니다.");
            return;
        }

        LocalDate returnDate = LocalDate.now();
        LocalDate loanDate = loan.getLoanDate();
        boolean resultOverdue = loan.checkOverdue(returnDate);

        User user = loan.user;
        String stID = user.getStID();

        Return returned = new Return(stID, bookID, loanDate, returnDate, resultOverdue);

        returned.display();

        returnDB.save(returned);

        book.disconnect(loan);
        user.disconnect(loan);
        loan.disconnect(book);
        loan.disconnect(user);

        loanDB.delete(loan);

        System.out.println("도서 반납이 완료되었습니다.");
    }
}
