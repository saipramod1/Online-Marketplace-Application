import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ServerImpl extends UnicastRemoteObject implements BestSale{
	/**
	 * ServerImpl class extends UnicastRemoteObject and also implements BestSale
	 */
	private static final long serialVersionUID = -3104953025020562043L;
	BestSale bestSale;
	String itemPrice;
	String removeItem;
	Connection conn = null;
	String string;
	String itemName;
	String updateName;
	int updatePrice;
	int updateQuantity;
	int quantityOfnewItem;
	String addedItem;
	int newItemPrice;
	String userName;
	String pwd;
	String email;
	int option;
	int flag;
	Statement stmt = null;
	Statement stmt1 = null;
	Statement stmt2 = null;
	
	Scanner sc = new Scanner(System.in);
	/**
	 * BestSale Server Constructor
	 * @param s
	 * @throws RemoteException
	 * @throws ClassNotFoundException 
	 */
	protected ServerImpl() throws RemoteException, ClassNotFoundException {
		
		String hostname = "localhost:3306"; 
		String dbName = "saipyeru_db";
		String url = "jdbc:mysql://" + hostname + "/" + dbName; 
		String username = "saipyeru"; 
		String password = "saipyeru";
		System.out.println("Connecting to the database..."); 
		 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, username, password);
		    System.out.println("Database connected!"); 
		    
		    } catch (SQLException e) {     
		    	e.printStackTrace();
		    	//	throw new IllegalStateException("Cannot connect the database!",e);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		
		//super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Register Method
	 * @param userName, pwd, email
	 * Allows the client to register to access the products
	 * @throws RemoteException
	 */
	
	public synchronized String Register(String userName, String pwd) throws RemoteException {
		this.userName = userName;
		this.pwd = pwd;
			
		try{
		stmt = conn.createStatement();
		stmt.executeUpdate("INSERT INTO Register(username, password) VALUES ('"+userName+"', '"+pwd+"')");
		 
		System.out.println("Registered Successfully");
		
		}catch (Exception e){
		e.printStackTrace();
	}
		return "Registered Successfully  ";
	}
	/*
	 * (non-Javadoc)
	 * @see BestSale#Login(java.lang.String, java.lang.String, java.lang.String)
	 * @param userName, pwd
	 */
	public synchronized int Login(String choose,String userName,String pwd){
		this.userName=userName;
		this.pwd=pwd;
		if(choose.equalsIgnoreCase("Admin")){
		try{
			
		stmt = conn.createStatement();
		stmt.executeQuery("SELECT name, password from Admin WHERE name = '"+userName+"' and password = '"+pwd+"'");
		ResultSet rs = stmt.getResultSet();
		while(rs.next()){
			String adminUserName = rs.getString("name");
			String adminPwd = rs.getString("password");
			if(userName.equals(adminUserName)&& pwd.equals(adminPwd)){
				System.out.println("Admin Login Successful");
				flag = 1;
				
			}	
			else{
				System.out.println("Invalid Admin Credentials");
				flag = 0;
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}	
		else if(choose.equalsIgnoreCase("customer")){
			
		try{
			
			stmt = conn.createStatement();
			stmt.executeQuery("SELECT username, password from Register WHERE username = '"+userName+"' and password = '"+pwd+"'");
			ResultSet rs1 = stmt.getResultSet();
			while(rs1.next()){
				String customerUserName = rs1.getString("username");
				String customerPwd = rs1.getString("password");
		if(userName.equals(customerUserName)&& pwd.equals(customerPwd)){
			System.out.print("Customer Login Successful");
			flag = 2;
		}
		else{
			System.out.println("Invalid Login Credentials");
			flag=0;
		
			}
		}
		} catch(Exception e){
			e.printStackTrace();
		}
		}
			return flag;
	}
	/*
	 * @param n
	 * (non-Javadoc)
	 * @see BestSale#ReturnValidate(int)
	 */
	public synchronized String ReturnValidate(int n){
		if(flag == 1){
			return "Admin Login Successful  ";
		}else if(flag == 2){
			return "Login Successful  ";
		}else{
			return "Invalid Credentials";
		}
		
	}
	/*
	 * (non-Javadoc)
	 * @see BestSale#browseItems(java.lang.String)
	 */
	public synchronized String browseItems(String itemName){
		this.itemName = itemName;
		try{			
			stmt = conn.createStatement();
			stmt.executeQuery("SELECT * FROM Items WHERE itemName = '"+itemName+"'");
			ResultSet rs = stmt.getResultSet();
			while(rs.next()){
				String item = rs.getString("ItemName");
		
				String itemPrice = rs.getString("Price");
				String itemQuantity = rs.getString("quantity");
		
				if(itemName.equals(item)){
				System.out.println(itemName+"  ----->   "+itemPrice+"  ----->  "+itemQuantity);
				return item+ "  ---->  " +itemPrice+ "  the #of items in inventory are ---->  "+itemQuantity;
			}
				else{
					return "Item not found";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
	}
	
		return "";
	
	}
	/*
	 * (non-Javadoc)
	 * @see BestSale#sessionLogin(java.lang.String)
	 */
	public synchronized Session sessionLogin(String userType) throws RemoteException {
		// TODO Auto-generated method stub
		Session session = new Session(userType);
		return session;
	}
	/*
	 * (non-Javadoc)
	 * @see BestSale#addItems(Session, java.lang.String, int)
	 */
	public synchronized String addItems(Session session, String itemName, int itemPrice, int quantity) throws RemoteException {
		// TODO Auto-generated method stub
		this.quantityOfnewItem = quantity;
		this.addedItem = itemName;
		this.newItemPrice = itemPrice;
		try{			
			stmt = conn.createStatement();
	
			stmt.executeUpdate("INSERT INTO Items(ItemName, Price, quantity) VALUES ('"+addedItem+"',"+newItemPrice+","+quantityOfnewItem+")");
		System.out.println("Item added to database");
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Item added to database";
	}
			
	/*
	 * (non-Javadoc)
	 * @see BestSale#updateItems(Session, java.lang.String, int)
	 */
	public synchronized String updateItems(Session session,String name, int price, int quantity){
		this.updateName = name;
		this.updatePrice = price;
		this.updateQuantity = quantity;
		
		try{			
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE Items SET ItemName = '"+updateName+"', Price = "+updatePrice+", quantity = "+updateQuantity+" WHERE ItemName = '"+updateName+"'");
		}catch(Exception e){
			e.printStackTrace();
		
		}
			return "Item Updated in the Inventory";
	}
	/*
	 * (non-Javadoc)
	 * @see BestSale#removeItems(Session, java.lang.String)
	 */
	public synchronized String removeItems(Session session,String name){
		this.removeItem = name;
		System.out.println("In server"+removeItem);
		try{			
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM Items WHERE ItemName = '"+removeItem+"'");
			System.out.println("Item deleted from database");
			return "The item has been removed from inventory";
		}catch(Exception e){
			//e.printStackTrace();
			System.out.println("Item not available in inventory");
			return "Item not available in inventory";
		}
	}
	/*
	 * non-Javadoc)
	 * @see BestSale#addToCart(Session, java.lang.String)
	 */
	public synchronized String addToCart(Session session, String itemName, String userName){
		try{			
			stmt = conn.createStatement();
			stmt1 = conn.createStatement();
			stmt2 = conn.createStatement();
			stmt.executeQuery("SELECT ItemName,quantity,Price FROM Items WHERE ItemName = '"+itemName+"'");
			ResultSet rs = stmt.getResultSet();
			while(rs.next()){
				String item = rs.getString("ItemName");
				int quantity = rs.getInt("quantity");
				int price = rs.getInt("Price");
				if(quantity > 0){
				stmt1.executeUpdate("INSERT INTO Cart (ItemName, Price, Username) VALUES ('"+item+"',"+price+",'"+userName+"')");
				stmt2.executeUpdate("Update Items SET quantity = quantity-1 WHERE ItemName = '"+itemName+"'");
				System.out.println("Item added to Cart");
				return "Item Added to Cart";
				
				}
				else{
					System.out.println("Item out of stock");
					return "Item out of stock";
				}
			}return "";
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		
	}
}
