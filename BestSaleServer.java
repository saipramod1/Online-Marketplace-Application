
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 * Java RMI BestSale Server 
 */
public class BestSaleServer {
	
		// TODO Auto-generated constructor stub
	
	/*
	 * RMI Functionality has been removed from BestSaleServer and implemented in ServerImpl class.
	 */
	/**
	 * Main Method
	 * 
	 * This method is responsible for starting the BestSale server
	 * and binding it to the Java RMI lookup.
	 * @param args
	 */
	public static void main(String args[]){
		// Java RMI Security Manager
		System.setSecurityManager(new SecurityManager());
		
		try {
			System.out.println("Creating a Server!");
			
			// Location of Server
			String name = "//in-csci-rrpc01.cs.iupui.edu/BestSaleServer";
			
			System.out.println("Server: Binding it to name: " + name);
			
			BestSale assignment = (BestSale) Proxy.newProxyInstance(BestSale.class.getClassLoader(),
	                new Class<?>[] {BestSale.class},
	                new AuthorizationInvocationHandler(new ServerImpl()));
						
			// Binds the Server to the RMI Service.
			Naming.rebind(name, assignment);
			
			System.out.println("Server Ready!");
		} catch (Exception e){
			System.out.println("Server Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}