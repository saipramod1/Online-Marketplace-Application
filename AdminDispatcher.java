/*
 * Dispatcher for Admin
 */
/*
 * Ryan: How is this demonstrating the Abstract Factory pattern?
 * 
 * Fix:                 AbstractFactory(Interface)
 *                       |                     |
 *                       |                     |
 *     AdminDispatcher---|                     |---ClientDispatcher
 *       (Factory Method)                          (Factory Method)
 */
public class AdminDispatcher implements AbstractFactory {
	// Concrete Views...
	
	AdminView adminView;

	/**
	 * AdminDispatcher Constructor
	 */
	
	public AdminDispatcher(AdminView adminView) {
	    adminView = new AdminView();
	}
	/*
	 * @param request
	 * (non-Javadoc)
	 * @see AbstractFactory#dispatchRequest(java.lang.String)
	 */
	public void dispatchRequest(String request) {
		// TODO Auto-generated method stub
		if(request.equalsIgnoreCase("Admin")){
			AdminView.showView();
		}
	}
}