import java.io.Serializable;

public class Book implements Serializable {
    private String bookName;
    private String bookAuthor;
    private String bookPublisher;
    private int bookId;
    private int bookEdition;
    private double bookPrice;



    // -----Setters & Getters
    // To put conditions
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int id) {
        if(id > 0 ){
            this.bookId = id;
        }
        else {
            System.out.println("Invalid ID");
        }
    }

    public int getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(int edition) {
        if(edition>=1){
            this.bookEdition = edition;
        }
        else {
            System.out.println("Invalid Edition");
        }
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double price) {
        this.bookPrice = price;
    }

    //---------------------------------------

}
