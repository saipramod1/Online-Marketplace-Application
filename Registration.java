import java.rmi.RemoteException;

/*
 * Registration implements CommandInterface
 * @param userName1, pwd1, email, choose, declare, value, declare1, bestSale, name, price, value, adminFunction, session 
 */
public class Registration implements CommandInterface{
	BestSale bestSale;
	BestSaleView view = new BestSaleView();
	String userName1;
	String itemName;
	String pwd1;
	String email;
	String choose;
	int declare;
	int quantity;
	static String declare1;
	String name;
	String addItemsValue;
	int price;
	int value;
	String adminFunction;
	Session session;
	String browse;
	
	/*
	 * Constructor
	 * @param newBestSale
	 */
	public Registration(BestSale bestSale){
		this.bestSale = bestSale;
	}
	/*
	 * (non-Javadoc)
	 * @see CommandInterface#execute()
	 */
	public void execute() {
		// TODO Auto-generated method stub
		
		try {
			//calling Register method from BestSale
			view.RegistrationDisplay();
			if(view.option3.equals("yes")){
			userName1=view.userName1;
			pwd1=view.pwd1;
			email=view.email;
			declare1 = bestSale.Register(userName1, pwd1);
			System.out.println(declare1);
		}
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		//calling LoginAuthentication
		
			try {
			view.LoginAuthentication();
			this.userName1 = view.userName1;
			this.pwd1 = view.pwd1;
			this.choose = view.option;
			//calling Login method from BestSale
			 declare = bestSale.Login(choose,userName1, pwd1);
			
			System.out.println(bestSale.ReturnValidate(declare));
			
			if( declare == 0 )
			{
				System.exit(0);
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//calling browseItems method from BestSale
		try{
			view.browseItems();
			if(view.browseItem.equals("yes")){
			this.name = view.browseName;
			//bestSale.browseItems(name);
			System.out.println(bestSale.browseItems(name));
			
			}
		}catch (Exception e){
			
		}
		
		try{
			//calling addToCart method from BestSale
			
			view.addToCart();
			if(view.addToCartOption.equalsIgnoreCase("yes")){
			if(view.option.equalsIgnoreCase("customer")){
		
			
			session = bestSale.sessionLogin(choose);
			String cart = bestSale.addToCart(session, view.itemName, view.addToCartUser);
			System.out.println(cart);
			} else {
				System.out.println("Admin cannot perform this operation");
				session = bestSale.sessionLogin(choose);
				String cart = bestSale.addToCart(session, view.itemName, view.addToCartUser);
			}
			}
		}catch (Exception e){
		//e.printStackTrace();
			System.out.println(e.getMessage());
	
		}
		//Calling addItems method from BestSaleView
		
		try {
			view.addItems();
			if(view.addItemsOption.equalsIgnoreCase("yes")){
			if(view.option.equalsIgnoreCase("admin")){
			//System.out.println("inside view of addItems");
			
			session = bestSale.sessionLogin(choose);
			addItemsValue = bestSale.addItems(session, view.addItemName, view.price, view.quantity);
			System.out.println(addItemsValue);
			}
			else {
				System.out.println("Customer cannot perform this operation");
				//calling addItems method from BestSale
				session = bestSale.sessionLogin(view.option);
				addItemsValue = bestSale.addItems(session, name, price,quantity);
			}
		} 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try{
			//calling updateItem method from BestSale
			view.updateItem();
			if(view.updateOption.equalsIgnoreCase("yes")){
			if(view.option.equalsIgnoreCase("admin")){
				session = bestSale.sessionLogin(choose);
				String updateItems = bestSale.updateItems(session,view.updateName, view.updatePrice, view.updateQuantity);
				System.out.println(updateItems);
			}else {
				System.out.println("Customer cannot perform this operation");
				//calling updateItem method from BestSale
				session = bestSale.sessionLogin(view.option);
				String updateItems = bestSale.updateItems(session,view.updateName, view.updatePrice, view.updateQuantity);
			}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try{
			//calling removeItems method from BestSale
			view.removeItems();
			if(view.removeOption.equalsIgnoreCase("yes")){
			if(view.option.equalsIgnoreCase("admin")){
				session = bestSale.sessionLogin(choose);
				System.out.println("In Registration"+view.deletedItem);
				String removeItem = bestSale.removeItems(session, view.deletedItem);
				System.out.println(removeItem);
			}else {
				System.out.println("Customer cannot perform this operation");
				//calling removeItems method from BestSale
				//session = bestSale.sessionLogin(view.option);
				//String removeItem = bestSale.removeItems(session, view.deletedItem);
			}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
}