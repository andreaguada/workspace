//package mysqlTest;
//
//import java.sql.*;
//
//public class FirstExample { 
//	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
//	   static final String DB_URL = "jdbc:mysql://localhost/ecommercestore";
//
//	   //  Database credentials
//	   static final String USER = "user";
//	   static final String PASS = "root";
//	   
//	   public static void main(String[] args) {
//	   Connection conn = null;
//	   Statement stmt = null;
//	   try{
//	      //STEP 2: Register JDBC driver
//	      Class.forName("com.mysql.jdbc.Driver");
//
//	      //STEP 3: Open a connection
//	      System.out.println("Connecting to database...");
//	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//	      //STEP 4: Execute a query
//	      System.out.println("Creating statement...");
//	      stmt = conn.createStatement();
//	      String sql;
//	      sql = "SELECT productCode, productName, productCategory, productPrice, productQty FROM storeProduct";
//	      ResultSet rs = stmt.executeQuery(sql);
//
//	      //STEP 5: Extract data from result set
//	      while(rs.next()){
//	         //Retrieve by column name
//	         String productCode  = rs.getString("productCode");
//	         String productName = rs.getString("productName");
//	         String productCategory = rs.getString("productCategory");
//	         float productPrice = rs.getFloat("productPrice");
//	         int productQty = rs.getInt("productQty");
//
//	         //Display values
//	         System.out.print("ID: " + productCode);
//	         System.out.print(", Age: " + productName);
//	         System.out.print(", First: " + productCategory);
//	         System.out.println(", Last: " + productPrice);
//	         System.out.println(", Last: " + productQty);
//	      }
//	      //STEP 6: Clean-up environment
//	      rs.close();
//	      stmt.close();
//	      conn.close();
//	   }catch(SQLException se){
//	      //Handle errors for JDBC
//	      se.printStackTrace();
//	   }catch(Exception e){
//	      //Handle errors for Class.forName
//	      e.printStackTrace();
//	   }finally{
//	      //finally block used to close resources
//	      try{
//	         if(stmt!=null)
//	            stmt.close();
//	      }catch(SQLException se2){
//	      }// nothing we can do
//	      try{
//	         if(conn!=null)
//	            conn.close();
//	      }catch(SQLException se){
//	         se.printStackTrace();
//	      }//end finally try
//	   }//end try
//	   System.out.println("Goodbye!");
//	}
//
//}
