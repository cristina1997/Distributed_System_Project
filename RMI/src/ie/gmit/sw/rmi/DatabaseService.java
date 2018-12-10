package ie.gmit.sw.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.Model.Order;

public interface DatabaseService extends Remote {

	/********************************************************************/
	/************************** Read Interface **************************/ 
	/********************************************************************/
	public ArrayList<Order> read() throws RemoteException, SQLException;
	
	/********************************************************************/
	/************************* Create Interface *************************/ 
	/********************************************************************/
	public void create(Order order) throws RemoteException, SQLException;
	
	/********************************************************************/
	/************************* Update Interface *************************/ 
	/********************************************************************/
	public void update(Order order) throws RemoteException, SQLException;
	
	/********************************************************************/
	/************************* Delete Interface *************************/ 
	/********************************************************************/
	public void delete(Order order) throws RemoteException, SQLException;

}
