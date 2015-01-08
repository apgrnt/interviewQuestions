package edu.java2.exercise.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HWorldInterface extends Remote {
    String getComment() throws RemoteException;
}
