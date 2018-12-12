import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
/**
 * BestSale View
 */

/*
 * @param option, request, userName1, pwd1, email
 */
public class BestSaleView {
	String option;
	String option3;
	String addToCartUser;
	String option1;
	String addToCartOption;
	String addItemsOption;
	String updateOption;
	String removeOption;
	int updateQuantity;
	String deletedItem;
	String browseItem;
	int request;
	String itemName;
	int quantity;
	static String userName1;
	static String pwd1;
	String updateName;
	static String email;
	String browseName;
	int updatePrice;
	int price;
	String addItemName;
	BestSaleView view;
	Scanner sc=new Scanner(System.in);
	/**
	 * RegistrationDisplay Method
	 * @param userName, pwd, email
	 * Allows the client to register to access the products
	 * @throws RemoteException
	 */
	public void RegistrationDisplay() {
		System.out.println("Welcome to Registration Page");
		
		System.out.println("Do you want to Register??  --  yes/no");
		option3 = sc.next();
		if(option3.equalsIgnoreCase("yes")){
		System.out.println("Enter the username");
		userName1=sc.next();
		System.out.println("Enter the password");
		pwd1=sc.next();
		}
		else 
			System.out.println("Leaving Registration Page");
	}
	/**
	 * LoginAuthentication Method
	 * @param userName, pwd, option
	 * Allows the client to register to access the products
	 * @throws RemoteException
	 */
	public void LoginAuthentication(){
		//System.out.println("From the View");
		System.out.println("Admin / Customer");
		option = sc.next();
		if(option.equalsIgnoreCase("Admin")){
		
		System.out.println("Welcome to Admin Page");
		System.out.println("Admin username: ");
		userName1=sc.next();
		System.out.println("Admin password: ");
		pwd1=sc.next();
		}
		else if(option.equalsIgnoreCase("Customer")){
			
			System.out.println("Welcome to Customer Page");
			System.out.println("Enter your username: ");
			userName1=sc.next();
			System.out.println("Enter your password: ");
			pwd1=sc.next();
		}
		else{ 
			System.out.println("Invalid Entry");
			System.exit(0);
		}
	}
	/*
	 * addItems method for Admin
	 * @param name, price
	 */
	public String addItems(){
		System.out.println("Do you want to add items to DB?? --  yes/no");
		addItemsOption = sc.next();
		if(addItemsOption.equals("yes")){
		System.out.println("Enter the item name which is to be added");
		addItemName = sc.next();
		System.out.println("Enter the price of " +addItemName);
		price = sc.nextInt();
		System.out.println("Enter the quantity of " +addItemName);
		quantity = sc.nextInt();
		return "Item added to DB";
		}else{
			return "No item is added";
		}
	}
	/*
	 * browseItems method
	 * @param browse, name
	 * Allows admin and customer to see the items available in inventory
	 */
	public void browseItems(){ 
		System.out.println("Do you want to browse the items");
		System.out.println("Yes or No");
		browseItem = sc.next();
		if(browseItem.equalsIgnoreCase("yes")){
			System.out.println("Welcome to Products Page ");
			System.out.println("Enter the name of Product you want to browse");
			browseName = sc.next();
		}
		else{
			System.out.println("You are leaving the Products Page");
		}
	}
	/*
	 * addToCart method
	 * @param option2, itemName
	 * Allows client to add the items to his cart if available.
	 */
	public void addToCart() {
		System.out.println("Do you want to buy any product-- Yes/No");
		addToCartOption = sc.next();
		addToCartUser = view.userName1;
		if(addToCartOption.equalsIgnoreCase("yes")){
			System.out.println("Enter the name of the item you wish to purchase");
			itemName = sc.next();
		}else if(addToCartOption.equalsIgnoreCase("no"))
			{
				System.out.println("Leaving the Cart Page");
			}
		}
	/*
	 * updateItem method
	 * @param option2, updateName, updatePrice
	 * Allows admin to update the details of the product
	 */
	public void updateItem(){
		System.out.println("Do you want to update any item? -- Yes/No");
		updateOption = sc.next();
		if(updateOption.equalsIgnoreCase("yes")){
			System.out.println("Enter the name of the item you want to update!!");
			updateName = sc.next();
			System.out.println("Enter the new price of the product");
			updatePrice = sc.nextInt();
			System.out.println("Enter the quantity of the item");
			updateQuantity = sc.nextInt();
		}else if(updateOption.equalsIgnoreCase("no")){
			System.out.println("Leaving the updateItems Page");
		}
	}
	/*
	 * removeItem method
	 * @param option2, deletedItem
	 * Allows admin to delete the items from inventory.
	 */
	public void removeItems(){
		System.out.println("Do you want to delete any item?");
		removeOption = sc.next();
		if(removeOption.equalsIgnoreCase("yes")){
			System.out.println("Enter the name of item you want to delete");
			deletedItem = sc.next();
		}
	}
	public static void showView(){
		System.out.println("In Customer Page ");
	}
}