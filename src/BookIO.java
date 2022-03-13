import java.io.Serializable;
import java.util.Scanner;

public class BookIO implements Serializable {
    public Book book ;
    public BookIO(){
        book = new Book();
    }

    // fill book fields
    public void readBookInfo(){
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the book name ");
        String name = input.nextLine();
        book.setBookName(name);
        System.out.println("Enter the book author ");
        name = input.nextLine();
        book.setBookAuthor(name);
        System.out.println("Enter the book publisher ");
        name = input.nextLine();
        book.setBookPublisher(name);
        System.out.println("Enter the book id ");
        int id  = sc.nextInt();
        book.setBookId(id);
        System.out.println("Enter the book edition ");
        int edition  = sc.nextInt();
        book.setBookEdition(edition);
        System.out.println("Enter the book price ");
        double price  = sc.nextDouble();
        book.setBookPrice(price);
    }

    // Display book info
    public void displayBookInfo(){
        System.out.println("###########################");
        System.out.println("Book Name : " + book.getBookName());
        System.out.println("Book Author : " + book.getBookAuthor());
        System.out.println("Book Publisher : " + book.getBookPublisher());
        System.out.println("Book ID : " + book.getBookId());
        System.out.println("Book Edition " + book.getBookEdition());
        System.out.println("Book price " + book.getBookPrice());
    }

}
