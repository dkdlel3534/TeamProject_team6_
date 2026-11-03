
/**
 * 도서관관리시스템 클래스
 *
 * @author (2025320070 복창희)
 * @version (2026.11.03)
 */
public class NewLibMS
{
    private BookDB bookDB;
    private UserDB userDB;
    private LoanDB loanDB;

    /**
     * 책을 빌리는 작업을 수행하는 메소드
     *
     * @param  bookID(등록번호), stID(학번)
     */
    public void borrowBook(String bookID, String stID)
    {
        BookDB bookDB = new BookDB();
        UserDB userDB = new UserDB();
        LoanDB loanDB = new LoanDB();

        Book book = bookDB.search(bookID);
        User user = userDB.search(bookID);

        if (book != null && user != null){
            book.display();
            user.display();
        }
        else{
            System.out.println("책 또는 이용자를 찾을 수 없습니다!");
            return;
        }

        boolean resultBook = book.check();
        boolean resultUser= user.check();
        if(resultBook == false && resultUser == false){
            System.out.println("책 대출불가능! & 이용자 대출불가능!");
        }
        else if ((resultBook == true) && (resultUser == false)){
            System.out.println("책 대출가능! & 이용자 대출불가능!");
            return;
        }
        else if ((resultBook == false) && (resultUser == true)){
            System.out.println("책 대출불가능! & 이용자 대출가능!");
            return;
        }
        else{
            Loan loan = new Loan(user, book);
            loan.display();
            loanDB.save(loan);
        }
    }
    
    /**
     * 새 책을 등록하는 메소드
     *
     * @param  bookID(등록번호), title(제목), author(작가)
     * 
     */
    public void registerNewBook(String bookID, String title, String author)
    {
        BookDB bookDB = new BookDB();

        boolean resultBook = bookDB.check(bookID);

        if (resultBook == true) {
            System.out.println("이미 등록된 책입니다!");
            return;
        }

        else{

            Book book = new Book(title, author, bookID);

            bookDB.save(book);

            book.display();
        }
    }
}