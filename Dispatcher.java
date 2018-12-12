/*
 * Class created for AbstractFactory Pattern
 */

public class Dispatcher {
	/*
	 * method returnPage call from AbstractClass
	 * @param page
	 */
	public static AbstractClass returnPage(String page){
		
		if(page.equalsIgnoreCase("Admin")||page.equalsIgnoreCase("Customer")){
			return new PageReturn();
		}
		return null;
	}
}
