import java.util.Scanner;
abstract class AppUser {
    private String name ;
    private String email;

    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }

    public void login (){
      System.out.println("Login completed");
    }
   public  abstract void displayRole();
}
interface UserOperations {
    void register();
    void logout();

    default void showWelcome(){
       System.out.println("Welcome to Smart Access Management App");
    }
    static void  appInfo(){
      System.out.println(" Welcome to Smart Access Management App\n" +
              "----------------------------------------\n" +
              "Role Based Access Control System\n" +
              "Console Version : v1.0");
    }
}
class  AdminUser extends AppUser implements UserOperations {


    public void register() {
        System.out.println("Regsitration completed");
    }

    public void displayRole() {
        System.out.println("- Can manage users\n" +
                "- Can view reports\n" +
                "- Full access");
    }

    public void logout() {
        System.out.println("logout sucessfully");
    }

}
class NormalUser extends AppUser implements UserOperations{

     @Override
    public void register() {
        System.out.println("Regsitration completed");
    }

     @Override
     public void login(){
         System.out.println("Login completed");
     }
    public  void displayRole(){
        System.out.println("- Can login\n" +
                "- Can update profile\n" +
                "- Limited access");
     }
       public  void logout(){
         System.out.println("logout sucessfully");
     }
 }
public class MyProject {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        UserOperations.appInfo();

        System.out.println("\nEnter 1 For Admin Register");
        System.out.println("Enter 2 For User Login");

        int num = sc.nextInt();
        sc.nextLine(); // clear buffer

        AppUser user;              // Abstract reference
        UserOperations operations; // Interface reference

        if(num == 1){

        user = new AdminUser();
        operations = (UserOperations) user;

        operations.showWelcome();

        System.out.println("Enter your name:");
        user.setName(sc.nextLine());

        System.out.println("Enter your email:");
        user.setEmail(sc.nextLine());

        operations.register();
        user.displayRole();

        }
        else if(num == 2){

        user = new NormalUser();
        operations = (UserOperations) user;

        operations.showWelcome();
        user.login();
        user.displayRole();

        }
        else{
        System.out.println("Invalid option");
        }

        sc.close();
        }
}


