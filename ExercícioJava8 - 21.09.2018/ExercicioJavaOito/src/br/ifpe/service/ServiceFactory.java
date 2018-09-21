package br.ifpe.service;

public class ServiceFactory {

	public static BankService getService() {
		return new BankServiceImpl();
	}
}
