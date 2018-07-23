package first;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.*;
import java.util.Scanner;

public class secondExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite id:");
        String id = sc.nextLine();

        Connection connection = null;
        try {//1.sukurti connectiona'a
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs1", "root", "");
        } catch (SQLException e) {
            System.out.println("Ivyko klaida" + e);
        }
        if (connection != null) {
            System.out.println("Prisijungeme");
            try {
                Statement st = connection.createStatement();
                ResultSet resultSet = st.executeQuery("SELECT * FROM  students where laukai_ID = " + id );
                resultSet.next();

                System.out.println(resultSet.getString("name"));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        }
    }