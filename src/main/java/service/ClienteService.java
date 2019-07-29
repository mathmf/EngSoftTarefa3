package service;

import java.util.ArrayList;
import java.util.List;

import clienteweb.User;

public class ClienteService {

	private static List<User> lista = new ArrayList<User>();
	
	public List<User> getTodos(){
		return lista;
	}
	
	public void addUsuario(User user) {
		lista.add(user);
	}
	
	public void delUsuario(int indice) {
		lista.remove(indice);
	}
}
