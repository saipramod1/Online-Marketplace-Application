/*
 * ClientDispatcher implements interface Abstractfactory
 */
public class ClientDispatcher implements AbstractFactory {
	private BestSaleView bestSaleView;

	public ClientDispatcher(BestSaleView BestSaleView) {
		bestSaleView = new BestSaleView();
	    
	}
/*
 * @param request
 * (non-Javadoc)
 * @see AbstractFactory#dispatchRequest(java.lang.String)
 */
	public void dispatchRequest(String request) {
		// TODO Auto-generated method stub
		if(request.equalsIgnoreCase("Customer")){
			BestSaleView.showView();
		}
	}
}