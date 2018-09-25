package br.ifpe.entities;

public class Account {

	private int agency;
	private int number;
	private double balance;
	private Client client;
	private AccountEnum type;

	public Account(int agency, int number, double balance, Client client, AccountEnum type) {
		this.agency = agency;
		this.number = number;
		this.balance = balance;
		this.client = client;
		this.type = type;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public AccountEnum getType() {
		return type;
	}

	public void setType(AccountEnum type) {
		this.type = type;
	}
}
