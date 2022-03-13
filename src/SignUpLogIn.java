import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class SignUpLogIn implements Serializable {


    public  boolean signUp(ArrayList<UserIO> usersList) throws IOException {
        UserIO someUser = new UserIO();
        someUser.readUserInfo();// username, password, full name
        // search for username
        boolean ok = true;
        for(int i=0 ;i<usersList.size();i++){
            if(someUser.user.getUserName().equals(usersList.get(i).user.getUserName())){
                ok = false;

            }
        }
        if(ok == true){
            System.out.println("Signed up successfully");
            usersList.add(someUser);
            someUser.saveUserInFile(usersList);
        }else{
            System.out.println("This username already exists");
        }

        return ok;
    }

    public  boolean login(ArrayList<UserIO> allUsers){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter username");
        String userName = sc.nextLine();
        System.out.println("enter password");
        String password = sc.nextLine();
        boolean ok = false;
        for(int i=0 ;i<allUsers.size();i++){
            if(allUsers.get(i).user.getUserName().equals(userName) && allUsers.get(i).user.getPassword().equals(password))
                ok = true;
        }
        if(ok==true){
            System.out.println("logged in successfully");
        }
        else
            System.out.println("you don't have account");
        return  ok;
    }

}
