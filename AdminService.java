package Main.AdminService;
import java.util.Scanner;

public class AdminService {

    public boolean login() {

        try (Scanner sc = new Scanner(System.in)) {
			System.out.println("================================");
			System.out.println("     ADMIN LOGIN SYSTEM");
			System.out.println("================================");

			System.out.print("Enter Username: ");
			String username = sc.nextLine();

			System.out.print("Enter Password: ");
			String password = sc.nextLine();

			if (username.equals("admin") && password.equals("admin123")) {

			    System.out.println("\nLogin Successful!\n");
			    return true;

			} else {

			    System.out.println("\nInvalid Username or Password!");
			    return false;
			}
		}
    }
}
