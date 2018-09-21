package br.ifpe.presentation;

import java.util.List;
import java.util.stream.Collectors;

import br.ifpe.entities.Account;
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
		imprimirNomesClientes();
		System.out.println("");
	}
	
	/**
	 * 1. Imprima na tela o nome e e-mail de todos os clientes (sem repetição), usando o seguinte formato:
	 * Victor Lira - vl@cin.ufpe.br
	 */
	public static void imprimirNomesClientes() {
		service
			.listClients()
			.stream()
			.map(cliente -> cliente.getName() +" - "+cliente.getEmail())
			.distinct()
			.forEach(System.out::println);
	}
	
	/**
	 * 2. Imprima na tela o nome do cliente e a média do saldo de suas contas, ex:
	 * Victor Lira - 352
	 */
	public static void imprimirMediaSaldos() {
		service
			.listAccounts()
			.stream()
			//.map(cliente -> cliente.getName())
			.filter(conta -> conta.getCliente().getName() == cliente)
			.distinct()
			.collect(Collectors.summarizingDouble(conta -> Account.class))
			;
	}
	
	/**
	 * 3. Considerando que só existem os países "Brazil" e "United States", 
	 * imprima na tela qual deles possui o cliente mais rico, ou seja,
	 * com o maior saldo somando todas as suas contas.
	 */
	public static void imprimirPaisClienteMaisRico() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 4. Imprime na tela o saldo médio das contas da agência
	 * @param agency
	 */
	public static void imprimirSaldoMedio(int agency) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 5. Imprime na tela o nome de todos os clientes que possuem conta poupança (tipo SAVING)
	 */
	public static void imprimirClientesComPoupanca() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 6.
	 * @param agency
	 * @return Retorna uma lista de Strings com o "estado" de todos os clientes da agência
	 */
	public static List<String> getEstadoClientes(int agency) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 7.
	 * @param country
	 * @return Retorna uma lista de inteiros com os números das contas daquele país
	 */
	public static int[] getNumerosContas(String country) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 8.
	 * Retorna o somatório dos saldos das contas do cliente em questão 
	 * @param clientEmail
	 * @return
	 */
	public static double getMaiorSaldo(String clientEmail) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 9.
	 * Realiza uma operação de saque na conta de acordo com os parâmetros recebidos
	 * @param agency
	 * @param number
	 * @param value
	 */
	public static void sacar(int agency, int number, double value) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 10. Realiza um deposito para todos os clientes do país em questão	
	 * @param country
	 * @param value
	 */
	public static void depositar(String country, double value) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 11. Realiza uma transferência entre duas contas de uma agência.
	 * @param agency - agência das duas contas
	 * @param numberSource - conta a ser debitado o dinheiro
	 * @param numberTarget - conta a ser creditado o dinheiro
	 * @param value - valor da transferência
	 */
	public static void transferir(int agency, int numberSource, int numberTarget, double value) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 12.
	 * @param clients
	 * @return Retorna uma lista com todas as contas conjuntas (JOINT) dos clientes
	 */
	public static List<Account> getContasConjuntas(List<Client> clients) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 13.
	 * @param state
	 * @return Retorna uma lista com o somatório dos saldos de todas as contas do estado 
	 */
	public static double getSomaContasEstado(String state) {
		throw new UnsupportedOperationException();	
	}
	
	/**
	 * 14.
	 * @return Retorna um array com os e-mails de todos os clientes que possuem contas conjuntas
	 */
	public static String[] getEmailsClientesContasConjuntas() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 15.
	 * @param number
	 * @return Retorna se o número é primo ou não
	 */
	public static boolean isPrimo(int number) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 16.
	 * @param number
	 * @return Retorna o fatorial do número
	 */
	public static int getFatorial(int number) {
		throw new UnsupportedOperationException();
	}
}
