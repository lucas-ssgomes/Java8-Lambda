package br.ifpe.entities;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private String name;
	private String email;
	private Address address;
	private List<Account> accounts;
	
	public Client() {
		this.accounts = new ArrayList<>();
	}
	
	public Client(String name, String email, Address address) {
		this();
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
