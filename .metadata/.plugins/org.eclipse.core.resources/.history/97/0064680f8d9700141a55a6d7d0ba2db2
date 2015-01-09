package edu.java2.exercise.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HWorldServer {

//    public static void main(String[] args) {
//	
//    }
    
    public void execute() {
	HWorldImpl imple = new HWorldImpl();
	try {
	    Registry registry = LocateRegistry.getRegistry(52352);
	    System.out.println(registry);
	    HWorldInterface stub = (HWorldInterface) UnicastRemoteObject.exportObject(imple, 0);
	    System.out.println("impl instantiated");
	    registry.rebind("rmi:Hworld", stub);
	    System.out.println("stub bound" + stub);
	} catch (RemoteException e) {
	    System.err.println("exception thrown");
	    e.printStackTrace();
	    System.exit( 1 );
	}
    }

}
