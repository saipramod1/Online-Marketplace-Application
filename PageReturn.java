/*
 * extends AbstractClass class
 */
public class PageReturn extends AbstractClass{
	/*
	 * (non-Javadoc)
	 * @see AbstractClass#returnPage(java.lang.String)
	 */
	@Override
	AbstractFactory returnPage(String page) {
		// TODO Auto-generated method stub
		//Instance for AdminView
		AdminView adminView=new AdminView();
		//Instance for BestSaleView
		BestSaleView bestSaleView=new BestSaleView();
		/*
		 * Checks the request and return the page
		 */
		if(page.equalsIgnoreCase("Admin")){
			return new AdminDispatcher(adminView);
		}
		else {
			return new ClientDispatcher(bestSaleView);
		}
	}
	
}
