package edu.uweo.java2.rmi_list.registry;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class registryCreater {

    public static void main(String[] args) throws InterruptedException {
//	if (System.getSecurityManager() == null){
//	  System.setProperty("java.sercurity.policy", "/Users/apgrnt/WorkSpace/RMIserver.policy");
//	    System.setSecurityManager(new SecurityManager());
//	    System.out.println("security manager created");
//	}
	
	    try {
		Registry regi = LocateRegistry.createRegistry(52742);
		System.out.println(regi);
	    } catch (RemoteException e) {
		e.printStackTrace();
		System.exit(1);
	    }
	    while(true){
		Thread.sleep(500);
	    }
	}
}
