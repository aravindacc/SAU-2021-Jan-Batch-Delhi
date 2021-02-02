package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.Client;
public class ClientService implements ClientServiceIn
{
private static Map<Integer,Client> clients = new HashMap<Integer,Client>();
	
	@Override
	public boolean addClient(Client p) {
		if(clients.get(p.getId()) != null) return false;
		clients.put(p.getId(), p);
		return true;
	}

	@Override
	public boolean deleteClient(int id) {
		if(clients.get(id) == null) return false;
		clients.remove(id);
		return true;
	}

	@Override
	public Client getClient(int id) {
		return clients.get(id);
	}

	@Override
	public Client[] getAllClient() {
		Set<Integer> ids = clients.keySet();
		Client[] p = new Client[ids.size()];
		int i=0;
		for(Integer id : ids){
			p[i] = clients.get(id);
			i++;
		}
		return p;
	}

}
