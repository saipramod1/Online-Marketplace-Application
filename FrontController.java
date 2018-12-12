/*
 *FrontController
 *@param abstractFactory, abstractFactory2, flag, f;ag1 
 */
public class FrontController {
	
	AbstractFactory abstractFactory;
	AbstractFactory abstractFactory2;
	int flag;
	int flag1;
	AdminView adminView = new AdminView();
	BestSaleView bestSaleView = new BestSaleView();
	/*
	 * Constructor
	 * @param newabstractFactory
	 * 
	 */
	public FrontController(){
		
		this.abstractFactory = abstractFactory;
		this.abstractFactory2 = abstractFactory;
	
	}
	/*
	 * DispatchRequest method
	 * @param option
	 * Call for Dispatcher
	 */
	public void DispatchRequest(String option){
		System.out.println("The Page Requested is : " +option);
		Dispatcher dispatcher = new Dispatcher();
		dispatcher.returnPage(option);
		//Page Call through Abstract Pattern
		/*AbstractClass abstractClass = Dispatcher.returnPage(option);
		AbstractFactory absFactory = abstractClass.returnPage(option);
		absFactory.dispatchRequest(option);	*/
	}
}