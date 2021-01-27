package service;

import model.Client;

public interface ClientServiceIn 
{

    boolean addClient(Client p);
	
	boolean deleteClient(int id);
	
	Client getClient(int id);
	
	Client[] getAllClient();
}
