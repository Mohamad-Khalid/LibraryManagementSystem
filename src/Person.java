import java.io.Serializable;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Person implements Serializable {

    private String userName;
    private String password;
    private String fullName;

    // setters and getters

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //-------------
    public void showBooks(ArrayList<BookIO> list){
        for(BookIO book : list)
            book.displayBookInfo();
    }


    public int searchForBook(ArrayList<BookIO> list){
        int found = -1;
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the name you of the book you want");
        String wanted = input.nextLine();
        for(int i=0 ; i<list.size();i++){
            if(list.get(i).book.getBookName().equals(wanted)){
                found = i;
                break;
            }
        }
        return found;
    }


}
