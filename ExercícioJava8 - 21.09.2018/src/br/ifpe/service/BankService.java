package br.ifpe.service;

import java.util.List;

import br.ifpe.entities.Account;
import br.ifpe.entities.Client;

public interface BankService {
	public List<Account> listAccounts();
	public List<Client> listClients();
}
