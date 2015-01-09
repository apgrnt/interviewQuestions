package edu.uweo.java2.rmi_list.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.List;

public class RMIListServer implements Runnable, RMIFilteredList {
    
    private int port;
    private String regHost;
    public static void main(String[] args){
	RMIListServer server = new RMIListServer("localhost", 52742);
	Thread thr = new Thread(server);
	thr.start();
    }

    public RMIListServer() {
	port = 1099;
	regHost = "localhost";
    }
    
    public RMIListServer(String regHost, int report) {
	this.port = report;
	this.regHost = regHost;
    }
    
    @Override
    public void run() {
	try {
	    RMIListServer filterEngine = new RMIListServer();
	    Registry registry = LocateRegistry.getRegistry("localhost", port);
	    System.out.println(registry);
	    RMIFilteredList stub = (RMIFilteredList) UnicastRemoteObject.exportObject(filterEngine, 0);
	    System.out.println("filterEngine instantiated");
	    registry.rebind("rmi:rmilist", stub);
	    System.out.println("stub bound" + stub);
	} catch (RemoteException e) {
	    System.err.println("exception thrown");
	    e.printStackTrace();
	    System.exit( 1 );
	}
    }

    @Override
    public <T extends Comparable<?>> List<T> getList(Collection<T> input,
	    ListFilter<T> filter) throws RemoteException {
	List<T> cleanedList = null;
	return cleanedList;
    }
}
