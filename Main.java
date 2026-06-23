package Main.java;

import Main.AdminService.AdminService;
import UI.java.UI;

public class Main {

    public static void main(String[] args) {

        AdminService admin = new AdminService();

        if (admin.login()) {

            System.out.println("Welcome to Smart Student Management System");

        } else {

            System.out.println("Access Denied");

        }
        if (admin.login()) {

            UI ui = new UI();
            ui.start();

        } else {

            System.out.println("Access Denied");
        }
        

    }
}

  
