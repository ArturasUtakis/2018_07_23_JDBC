package first;


import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        Connection connection = null;
        try {//1.sukurti connectiona'a
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs1", "root","" );
        } catch (SQLException e) {
                System.out.println("Ivyko klaida" + e);
            }
            if(connection !=null){
                System.out.println("Prisijungeme");
                try {//2. sukurtas statment
                    Statement st = connection.createStatement();
                    //3. executinti
                    ResultSet resultSet = st.executeQuery("SELECT * from students");

                    while (resultSet.next()){
                        System.out.println(resultSet.getString("name") +" "+  resultSet.getString("surname") +" "+ resultSet.getString("phone") +" "+ resultSet.getString("email") );
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
