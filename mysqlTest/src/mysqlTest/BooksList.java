//package mysqlTest;
//
//import java.sql.*;
//
//public class BooksList {
//    public static void main(String[] args) {
//        try {
//               Class.forName("com.mysql.jdbc.Driver");
//               Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=root&password=root");
//               Statement st = con.createStatement();
//               ResultSet rs = st.executeQuery("select * from books");
//
//               while(rs.next()) {
//                   System.out.println( rs.getString("title"));
//               }
//               st.close();
//               rs.close();
//               con.close();
//       } catch (Exception ex) {
//               ex.printStackTrace();
//       }
//   }
//
//}
