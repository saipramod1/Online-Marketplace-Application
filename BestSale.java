/**
 * RMI Interface for BestSale Server/Client
 */

import java.rmi.*;
import java.util.List;

public interface BestSale extends Remote {
	public String Register(String userName,String pwd) throws RemoteException;
	public int Login(String choose,String userName,String pwd) throws RemoteException;
	public String ReturnValidate(int n) throws RemoteException;
	public String browseItems(String itemName) throws RemoteException;
	//@RequiresRole("admin")
	//String addAdmin(Session session,String name) throws RemoteException;
	@RequiresRole("admin")
	String addItems(Session session,String name, int price, int quantity) throws RemoteException;
	@RequiresRole("admin")
	String updateItems(Session session,String name, int price, int quantity) throws RemoteException;
	@RequiresRole("admin")
	String removeItems(Session session,String name) throws RemoteException;
	@RequiresRole("customer")
	public String addToCart(Session session, String name, String userName) throws RemoteException;
	//@RequiresRole("customer")
	//public String viewCart() throws RemoteException;
	public Session sessionLogin(String userType) throws RemoteException;
}
