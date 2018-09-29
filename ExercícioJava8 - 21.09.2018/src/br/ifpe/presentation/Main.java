package br.ifpe.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.ifpe.entities.Account;
import br.ifpe.entities.AccountEnum;
import br.ifpe.entities.Client;
import br.ifpe.service.BankService;
import br.ifpe.service.ServiceFactory;

/**
 * OBSERVAÇÕES: 
 * NÃO é permitido o uso de nenhuma estrutura de repetição (for, while, do-while).
 * Tente, ao máximo, evitar o uso das estruturas if, else if, else e switch-case
 * 
 * @author Victor Lira
 *
 */
public class Main {

	private static BankService service = ServiceFactory.getService();

	public static void main(String[] args) {
		//TO test here

	}

	/**
	 * 1. Imprima na tela o nome e e-mail de todos os clientes (sem repetição), usando o seguinte formato:
	 * Victor Lira - vl@cin.ufpe.br
	 */
	public static void imprimirNomesClientes() {
		service
		.listClients()
		.stream()
		.map(cliente -> cliente.getName() +" - "+ cliente.getEmail())
		.distinct()
		.forEach(System.out::println);
	}

	/**
	 * 2. Imprima na tela o nome do cliente e a média do saldo de suas contas, ex:
	 * Victor Lira - 352
	 */
	public static void imprimirMediaSaldos() {
		service
		.listClients()
		.stream()
		.forEach(cliente -> {
			double media = 
					service
					.listAccounts()
					.stream()
					.filter(conta -> conta.getClient().getName().equals(cliente.getName()))
					.mapToDouble(conta -> conta.getBalance())
					.average()
					.getAsDouble();
			
			System.out.println(cliente.getName() + " - " + media);
		});
	}

	/**
	 * 3. Considerando que só existem os países "Brazil" e "United States", 
	 * imprima na tela qual deles possui o cliente mais rico, ou seja,
	 * com o maior saldo somando todas as suas contas.
	 */
	public static void imprimirPaisClienteMaisRico() {
		double sumClientBrazil = 
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getClient().getAddress().getCountry().equals("Brazil"))
				.mapToDouble(conta -> conta.getBalance())
				.sum();
		double sumClienteUSA = 
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getClient().getAddress().getCountry().equals("United States"))
				.mapToDouble(conta -> conta.getBalance())
				.sum();

		System.out.println(Double.compare(sumClientBrazil, sumClienteUSA));

	}

	/**
	 * 4. Imprime na tela o saldo médio das contas da agência
	 * @param agency
	 */
	public static void imprimirSaldoMedio(int agency) {	
		double average = 
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getAgency() == agency)
				.mapToDouble(conta -> conta.getBalance())
				.average()
				.getAsDouble();
		System.out.println(average);

	}

	/**
	 * 5. Imprime na tela o nome de todos os clientes que possuem conta poupança (tipo SAVING)
	 */
	public static void imprimirClientesComPoupanca() {
		service
		.listAccounts()
		.stream()
		.filter(conta -> conta.getType().equals("SAVING"))
		.map(conta -> conta.getClient())
		.distinct()
		.forEach(System.out::println);
	}

	/**
	 * 6.
	 * @param agency
	 * @return Retorna uma lista de Strings com o "estado" de todos os clientes da agência
	 */
	public static List<String> getEstadoClientes(int agency) {
		List<String> stateOfAllClients = 
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getAgency() == agency)
				.map(conta -> conta.getClient().getAddress().getState())
				.collect(Collectors.toList());
		return (List<String>) stateOfAllClients;
	}

	/**
	 * 7.
	 * @param country
	 * @return Retorna uma lista de inteiros com os números das contas daquele país
	 */
	public static int[] getNumerosContas(String country) {
		int [] countryNumbers =
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getClient().getAddress().getCountry().equals(country))
				.mapToInt(conta -> conta.getNumber()).toArray();
		return (int[]) countryNumbers;
	}

	/**
	 * 8.
	 * Retorna o somatório dos saldos das contas do cliente em questão 
	 * @param clientEmail
	 * @return
	 */
	public static double getMaiorSaldo(String clientEmail) {
		double sumBalance =
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getClient().getEmail().equals(clientEmail))
				.mapToDouble(conta -> conta.getBalance())
				.sum();
		return sumBalance;
	}

	/**
	 * 9.
	 * Realiza uma operação de saque na conta de acordo com os parâmetros recebidos
	 * @param agency
	 * @param number
	 * @param value
	 */
	public static void sacar(int agency, int number, double value) {
		service
		.listAccounts()
		.stream()
		.filter(conta -> conta.getAgency( )== agency &&
						conta.getNumber() == number)
		.map(conta -> conta.getBalance() - value);
	}

	/**
	 * 10. Realiza um deposito para todos os clientes do país em questão	
	 * @param country
	 * @param value
	 */
	public static void depositar(String country, double value) {
		service
		.listAccounts()
		.stream()
		.filter(conta -> conta.getClient().getAddress().getCountry().equals(country))
		.map(conta -> conta.getBalance() + value);
	}

	/**
	 * 11. Realiza uma transferência entre duas contas de uma agência.
	 * @param agency - agência das duas contas
	 * @param numberSource - conta a ser debitado o dinheiro
	 * @param numberTarget - conta a ser creditado o dinheiro
	 * @param value - valor da transferência
	 */
	public static void transferir(int agency, int numberSource, int numberTarget, double value) {
		service
		.listAccounts()
		.stream()
		.filter(conta -> conta.getAgency() == agency &&
						conta.getNumber() == numberSource)
		.map(conta -> conta.getBalance() - value);
		service
		.listAccounts()
		.stream()
		.filter(conta -> conta.getAgency() == agency &&
						conta.getNumber() == numberTarget)
		.map(conta -> conta.getBalance() + value);
	}

	/**
	 * 12.
	 * @param clients
	 * @return Retorna uma lista com todas as contas conjuntas (JOINT) dos clientes
	 */
	public static List<Account> getContasConjuntas(List<Client> clients) {
		List<Account> jointAccounts = new ArrayList<Account>();
		service
		.listAccounts()
		.stream()
		.filter(conta -> conta.getClient().equals(clients))
		.map(conta -> conta.getType().equals("JOINT"))
		.collect(Collectors.toList());
		return jointAccounts;
	}

	/**
	 * 13.
	 * @param state
	 * @return Retorna uma lista com o somatório dos saldos de todas as contas do estado 
	 */
	public static double getSomaContasEstado(String state) {
		double sumAccountState =
				service
				.listAccounts()
				.stream()
				.filter(conta -> conta.getClient().getAddress().getState().equals(state))
				.mapToDouble(conta -> conta.getBalance())
				.sum();
		return sumAccountState;
	}

	/**
	 * 14.
	 * @return Retorna um array com os e-mails de todos os clientes que possuem contas conjuntas
	 */
	public static String[] getEmailsClientesContasConjuntas() {
		List<String> emailsAllClientsJoinAccounts =
				service
				.listClients()
				.stream()
				.filter(cliente -> cliente.getAccounts().equals(AccountEnum.JOINT))
				.map(cliente -> cliente.getEmail())
				.collect(Collectors.toList());
		return (String []) emailsAllClientsJoinAccounts.toArray();
				
	}

	/**
	 * 15.
	 * @param number
	 * @return Retorna se o número é primo ou não
	 */
	public static boolean isPrimo(int number) {
		return IntStream
				.rangeClosed(2, (number/2))
				.noneMatch(i -> number % i==0);
	}

	/**
	 * 16.
	 * @param number
	 * @return Retorna o fatorial do número
	 */
	public static int getFatorial(int number) {
		int factorial =
				IntStream.rangeClosed(1, number)
				.reduce(1, (x,y) -> x*y);
		return factorial;
	}
}
