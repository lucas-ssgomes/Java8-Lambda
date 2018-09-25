package br.ifpe.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import br.ifpe.entities.Account;
import br.ifpe.entities.AccountEnum;
import br.ifpe.entities.Address;
import br.ifpe.entities.Client;

public class LoadEntities {

	public static final List<Account> ACCOUNTS;
	public static final List<Client> CLIENTS;
	public static final List<Address> ADDRESSES;
	
	static {
		ACCOUNTS = new ArrayList<>();
		CLIENTS = new ArrayList<>();
		ADDRESSES = new ArrayList<Address>();

		createDummyAddresses();
		createDummyClients();
		createDummyAccounts();
	}

	private static void createDummyAddresses() {
		IntStream.range(0, 10).forEach(LoadEntities::createDummyAddress);
	}

	private static void createDummyAddress(int index) {
		String country = index % 2 == 0 ? "Brazil" : "United States";
		Address address = new Address("Street " + index, index, "Complement " + index, "State " + index, country);
		ADDRESSES.add(address);
	}
	
	private static void createDummyClients() {
		IntStream.range(0, 50).forEach(LoadEntities::createDummyClient);
	}
	
	private static void createDummyClient(int index) {
		int addressPosition = index % (ADDRESSES.size() - 1);
		Client client = new Client("Client named " + index, "client" + index + "@bank.com", ADDRESSES.get(addressPosition));
		
		CLIENTS.add(client);
	}
	
	private static void createDummyAccounts() {
		IntStream.range(0, 200).forEach(LoadEntities::createDummyAccount);;
	}
	
	private static void createDummyAccount(int index) {
		int addressClient = index % (CLIENTS.size() - 1);
		Client client = CLIENTS.get(addressClient);
		
		int randomBalance = ThreadLocalRandom.current().nextInt(1, 10000);
		
		Account account = new Account(index, index * 3, randomBalance, client, AccountEnum.randomType());
		
		client.getAccounts().add(account);
		
		ACCOUNTS.add(account);
	}
}
