import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UserIO implements Serializable {
    public User user;

    public UserIO(){
        user = new User();
    }

    public void readUserInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username ");
        String uname = input.nextLine();
        user.setUserName(uname);
        System.out.println("Enter your password ");
        String password = input.nextLine();
        user.setPassword(password);
        System.out.println("Enter your full name ");
        String name = input.nextLine();
        user.setFullName(name);
    }

    public void displayUsersInfo(){
        System.out.println("###################");
        System.out.println("User Name : " + user.getUserName());
        System.out.println("Full Name : " + user.getFullName());
    }

    public void saveUserInFile(ArrayList<UserIO> list) throws IOException {
        FileOutputStream fo = new FileOutputStream("usersDB.bin");
        ObjectOutputStream ob = new ObjectOutputStream(fo);
        ob.writeObject(list);
        ob.close();
    }
    public ArrayList<UserIO> loadUsersDB() throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream("usersDB.bin");
        ObjectInputStream obi = new ObjectInputStream(fi);
        ArrayList<UserIO> users = (ArrayList<UserIO>) obi.readObject();
        return users;
    }

    public void buyBook(ArrayList<BookIO> bookList){
        Scanner input = new Scanner(System.in);
        int bookFound = user.searchForBook(bookList);
        if(bookFound!=-1){
            double cash ;
            double bookPrice = bookList.get(bookFound).book.getBookPrice();
            System.out.println("The book price = " + bookPrice);
            System.out.println("Enter your cash ");
            cash = input.nextDouble();
            if(cash>= bookPrice){
                System.out.println("Done Successfully");
                bookList.remove(bookFound);
            }
            else{
                System.out.println("The cash is not enough");
            }
        }
        else{
            System.out.println("The book is not available");
        }
    }


}
