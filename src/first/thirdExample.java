package first;

import java.sql.*;
import java.util.Scanner;

public class thirdExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite id:");
        String id = sc.nextLine();
        System.out.println("Iveskite pavarde: ");
        String surname = sc.nextLine();
        System.out.println("Iveskite numeri: ");
        String phone = sc.nextLine();
        System.out.println("Iveskite email: ");
        String email = sc.nextLine();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs1", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection!=null){
            try {
                Statement st = connection.createStatement();
                st.executeUpdate("update students set surname = '"+surname+"', phone = '"+phone+"',email = '"+email+"' where laukai_id = " + id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
