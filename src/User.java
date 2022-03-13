import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class User extends Person implements Serializable {
    private int numOfReadBooks;
    private int numOfBoughtBooks;

    // setters and getters
    public int getNumOfReadBooks() {

        return numOfReadBooks;
    }

    public void setNumOfReadBooks(int numOfReadBooks) {
        this.numOfReadBooks = numOfReadBooks;
    }

    public int getNumOfBoughtBooks() {
        return numOfBoughtBooks;
    }

    public void setNumOfBoughtBooks(int numOfBoughtBooks) {
        this.numOfBoughtBooks = numOfBoughtBooks;
    }
    //------------------------------------

}
