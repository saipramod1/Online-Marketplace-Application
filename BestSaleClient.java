
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * BestSale Client
 * @param userName1, pwd1, email, flag, request, bestSale
 */
/* 
 * Functionality has been isolated from BestSaleClient.
 */
public class BestSaleClient {
	BestSale bestSale;
	static String userName1;
	static String pwd1;
	static String email;
	static int flag;
	static int request;
	/*
	 * main method()
	 */
	public static void main(String args[]) throws RemoteException{
		// Java RMI Security Manager
		System.setSecurityManager(new SecurityManager());
		// Try-Catch is necessary for remote exceptions.
		Session session = null; 
		String name = "//in-csci-rrpc01.cs.iupui.edu/BestSaleServer";
		BestSale bestSale = null;
		
		try {
			/*
			 * This is our host name where our RMI server is running. We
			 * can also specify the port here.
			 */
			//We are going to attempt to locate the BestSale server.
			bestSale = (BestSale) Naming.lookup(name);
		}
		catch(Exception e)
		{
			System.out.println("Exception :"+e.getMessage());
		}
		//Instance for  Registration class 
		Registration  register = new Registration(bestSale);
		try
		{
		//Command Pattern Implementation
		//Instance for Invoker Class
			Invoker invoker = new Invoker();
			invoker.addToList(register);
			invoker.inTheList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			
			
			//Instance for FrontController Class
			FrontController frontController = new FrontController();
			
			//Call for Dispatcher
			
			frontController.DispatchRequest(register.choose);
			
			AbstractClass abstractClass = Dispatcher.returnPage(register.choose);
			AbstractFactory absFactory = abstractClass.returnPage(register.choose);
			absFactory.dispatchRequest(register.choose);	
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}