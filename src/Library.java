import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {


    public static void welcome(){
        System.out.println("\n\t\t************************************************");
        System.out.println("\t\t*******  Welcome to you in our Library   *******");
        System.out.println("\t\t************************************************\n");
    }
    public static void sayGoodBy(){
        System.out.println("Do your best, Good by ");
    }


    public static void main(String [] args) throws IOException, ClassNotFoundException {
        // Are you admin? 1 2
        // if admin ... login --> what do you want ? add book , show books ,search ,display users --> logout
        // else
            // login or sign up ?
            // if sign up goto menu
            // if login ... what do you want ?  (menu) show , search , buy --> logout

        welcome();
        Admin admin = new Admin();
        UserIO usr = new UserIO();
        BookIO book = new BookIO();
        SignUpLogIn visit = new SignUpLogIn();
        Scanner input = new Scanner(System.in);

        // Load database
        ArrayList<Admin> adminList = admin.setAdmin();
        ArrayList<BookIO> bookList = admin.loadBooksDB();
        ArrayList<UserIO> userList = usr.loadUsersDB();

        // Start the console from here
        System.out.println("Press : \n1 - if you are admin\n2 - if you are user\n0 - to Exit");
        int choice = input.nextInt();
        if(choice ==1 ){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your username ");
            String adminName = sc.nextLine();
            System.out.println("Enter your password");
            String adminPassword = sc.nextLine();
            boolean okAdmin = admin.checkIfAdmin(adminList,adminName,adminPassword);
            if(okAdmin){
                // 5 options
                int adminTask = 1;
                do{
                    System.out.println("\nPress :\n1 - to add book");
                    System.out.println("2 - to show books");
                    System.out.println("3 - to search for book");
                    System.out.println("4 - to display users");
                    System.out.println("0 - to Exit");
                    int adminOption = input.nextInt();
                    if(adminOption==1){
                        admin.addBook(bookList);
                    }
                    if(adminOption==2){
                        admin.showBooks(bookList);
                    }
                    if(adminOption==3){
                        int found = admin.searchForBook(bookList);
                        if(found!=-1)
                            System.out.println("found");
                        else
                            System.out.println("Not found");
                    }
                    if(adminOption==4){
                        admin.diplayUsers(userList);
                    }
                    if (adminOption==0){
                        adminTask=0;
                    }

                }while (adminTask > 0 );

                // after the admin finishes his work
                // save the data into in the file
                admin.saveBooksInFile(bookList);
                sayGoodBy();

            }
            else{
                System.out.println("You Are Not Admin");
                System.out.println("to login or signup press 2");
                System.out.println("to Exit press 0;");
                choice = input.nextInt();
            }

        }
        if(choice==2){
            // login or singup
            System.out.println("1 - to login\n2 - to signup");
            int userOption = input.nextInt();
            if(userOption==1){
               boolean logedIn =  visit.login(userList);
               if(!logedIn)
                   userOption=2;
            }
            if(userOption==2){
                System.out.println("Let's Sign up ");
                visit.signUp(userList);
            }
            // save user data in the file (database)
            usr.saveUserInFile(userList);

            // if login ... what do you want ?  (menu) show , search , buy --> logout
            int userChoose = 0 ;
            do{
                System.out.println("Press :\n1 - to show books\n2 - to search for book\n3 - to buy a book\n0 - to exit");
                userChoose = input.nextInt();
                if(userChoose==1){
                    usr.user.showBooks(bookList);
                }
                if(userChoose==2){
                    int found = usr.user.searchForBook(bookList);
                    if(found!=-1)
                        System.out.println("found");
                    else
                        System.out.println("Not found");
                }
                if(userChoose==3){
                    usr.buyBook(bookList );
                }
            }while (userChoose>0);
            // save info for the user
            usr.saveUserInFile(userList);
            admin.saveBooksInFile(bookList);
            sayGoodBy();
        }
        if(choice == 0){
            sayGoodBy();
        }

    }
}
