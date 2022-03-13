import java.io.*;
import java.util.ArrayList;

public class Admin extends  Person implements Serializable {


    public  void addBook(ArrayList<BookIO> list){
        BookIO newBook = new BookIO();
        newBook.readBookInfo();
        list.add(newBook);
    }

    public void diplayUsers(ArrayList<UserIO> usersList){
        for(UserIO usr : usersList)
            usr.displayUsersInfo();
    }

    public  void saveBooksInFile(ArrayList<BookIO> bookList) throws IOException {
        FileOutputStream fo = new FileOutputStream("booksDB.bin");
        ObjectOutputStream obs = new ObjectOutputStream(fo);
        obs.writeObject(bookList);
        obs.close();
        fo.close();
    }

    public  ArrayList<BookIO> loadBooksDB() throws IOException, ClassNotFoundException {
        FileInputStream fo = new FileInputStream("booksDB.bin");
        ObjectInputStream obi = new ObjectInputStream(fo);
        ArrayList<BookIO> bookList = (ArrayList<BookIO>)obi.readObject();
        fo.close();
        obi.close();
        return bookList;
    }

    public ArrayList<Admin> setAdmin() throws IOException, ClassNotFoundException {
        ArrayList<Admin> adminsList = new ArrayList<>();
        Admin admin1 = new Admin();
        admin1.setFullName("Mohamad Khalid");
        admin1.setUserName("medo");
        admin1.setPassword("1");
        adminsList.add(admin1);
        saveAdminsInFile(adminsList);
        return adminsList;
    }

    public  void saveAdminsInFile(ArrayList<Admin> adminsList) throws IOException {
        FileOutputStream fo = new FileOutputStream("adminsDB.bin");
        ObjectOutputStream obs = new ObjectOutputStream(fo);
        obs.writeObject(adminsList);
        obs.close();
        fo.close();
    }

    public  ArrayList<Admin> loadAdminsDB() throws IOException, ClassNotFoundException {
        FileInputStream fo = new FileInputStream("adminsDB.bin");
        ObjectInputStream obi = new ObjectInputStream(fo);
        ArrayList<Admin> adminsList = (ArrayList<Admin>)obi.readObject();
        obi.close();
        //fo.close();
        return adminsList;
    }

    public boolean checkIfAdmin(ArrayList<Admin> list , String username , String password) {
        boolean yesAdmin = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserName().equals(username) && list.get(i).getPassword().equals(password)) {
                yesAdmin = true;
                break;
            }
        }
        return yesAdmin;
    }

}
