package br.ifpe.service;

import java.util.List;

import br.ifpe.entities.Account;
import br.ifpe.entities.Client;
import br.ifpe.helper.LoadEntities;

public class BankServiceImpl implements BankService {

	protected BankServiceImpl() { }
	
	@Override
	public List<Account> listAccounts() {
		return LoadEntities.ACCOUNTS;
	}

	@Override
	public List<Client> listClients() {
		return LoadEntities.CLIENTS;
	}
	
}
