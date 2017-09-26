//package database;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import cart.Cart;
//import cart.CartEntry;
//import maps.Category;
//import product.Product;
//import store.Store;
//import store.StoreEntry;
//
//public class DatabaseMethods {
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost/e-commerce";
//	static final String USER = "user";
//	static final String PASS = "root";
//
//	public void dbConnection() {
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			stmt = conn.createStatement();
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null)
//					conn.close();
//			} catch (SQLException se) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//	}
//
//	public void dbPopulateStore(Store store) {
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			stmt = conn.createStatement();
//			String sql1 = "SELECT * FROM product, store_entry WHERE product.product_id = store_entry.store_entry_id";
//			ResultSet rst;
//			rst = stmt.executeQuery(sql1);
//			while (rst.next()) {
//				Product product = new Product();
//				StoreEntry storeEntry = new StoreEntry();
//				product.setProductCode(rst.getString("product_code"));
//				product.setName(rst.getString("product_name"));
//				product.setCategory(Category.valueOf(rst.getString("product_category")));
//				product.setPrice(rst.getFloat("product_price"));
//				storeEntry.setProduct(product);
//				storeEntry.setQuantityForProduct(rst.getInt("quantity_for_product"));
//				store.getStoreEntries().add(storeEntry);
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null)
//					conn.close();
//			} catch (SQLException se) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//	}
//
//	public void dbInsertProduct(Store store, StoreEntry storeEntry) {
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			stmt = conn.createStatement();
//			String sql = "INSERT INTO product VALUES (product_id, " + storeEntry.getProduct().getProductCode() + ","
//					+ storeEntry.getProduct().getName() + ", " + storeEntry.getProduct().getPrice() + ", '"
//					+ storeEntry.getProduct().getCategory().toString() + "')";
//			stmt.executeUpdate(sql);
//			sql = "INSERT INTO store_entry VALUES (last_insert_id(), " + storeEntry.getQuantityForProduct() + ")";
//			stmt.executeUpdate(sql);
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null)
//					conn.close();
//			} catch (SQLException se) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//	}
//	
//	public void dbInsertIntoStore(StoreEntry storeEntry) {
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			stmt = conn.createStatement();
//			String sql = "INSERT INTO store VALUES (cart_entry_id, " + cartEntry.getQuantityOfProduct() + ","
//					+ cartEntry.getSubPrice() + "); SELECT product_code, product_name FROM product WHERE idproduct_id = " 
//					+ cartEntry.getProduct().getProductCode() + ";";
//			stmt.executeUpdate(sql);
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null)
//					conn.close();
//			} catch (SQLException se) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//	}
//
//	public void dbInsertProductIntoCart(CartEntry cartEntry) {
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			stmt = conn.createStatement();
//			String sql = "INSERT INTO cart_entry VALUES (cart_entry_id, " + cartEntry.getQuantityOfProduct() + ","
//					+ cartEntry.getSubPrice() + "); SELECT product_code, product_name FROM product WHERE idproduct_id = " 
//					+ cartEntry.getProduct().getProductCode() + ";";
//			stmt.executeUpdate(sql);
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null)
//					conn.close();
//			} catch (SQLException se) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//	}
//
//	public void dbUpdateProductIntoCart(CartEntry cartEntry) {
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			stmt = conn.createStatement();
//			String sql = "UPDATE cart_entry SET sub_price=" + cartEntry.getSubPrice() + ", quantity_of_product="
//					+ cartEntry.getQuantityOfProduct() + " WHERE cart_entry_id = product.product_id"
//					+ cartEntry.getProduct().getProductCode();
//			stmt.executeUpdate(sql);
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null)
//					conn.close();
//			} catch (SQLException se) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//	}
//
//	public void dbCartPriceInitialization(Cart cart) {
////		Cart cart = new Cart();
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			stmt = conn.createStatement();
//			String sql = "INSERT INTO cart VALUES (cart_id, amount=0, total_price=0)";
//			stmt.executeUpdate(sql);
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null)
//					conn.close();
//			} catch (SQLException se) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//	}
//
//	public void dbCartPrice(Cart cart) {
//		Connection conn = null;
//		Statement stmt = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			stmt = conn.createStatement();
//			String sql = "UPDATE cart SET amount=" + cart.getAmount() + ", total_price= " + cart.getTotalPrice();
//			stmt.executeUpdate(sql);
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (stmt != null)
//					conn.close();
//			} catch (SQLException se) {
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//	}
//
//}
