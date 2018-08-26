
public class Main {
	
	public static void main(String[] args) {				
	
			FuncaoSoma funcaoSoma = (n1, n2) -> n1 + n2;
			System.out.println(funcaoSoma.somar(15, 10));
			System.out.println(funcaoSoma.somar(187, 18));
			
			
			FuncaoFatorial funcaoFatorial = n1 -> {
				if (n1 < 0) {
					throw new IllegalArgumentException("numero > 0");	
				}
				
				int resultado = 1;
				
				for (int i = 1; i <= n1; i++) {
					resultado *= i;
				}
				return resultado;
			};
			System.out.println(funcaoFatorial.fatorial(5));
			System.out.println(funcaoFatorial.fatorial(7));
			
			
			FuncaoIsPrimo funcaoIsPrimo = n1 -> {
				int divisiveis = 0;
				
				for (int i = 1; i <= n1; i++) {
					if (n1 % i == 0) {
						divisiveis++;
					}
				}
				
				return divisiveis == 2;
			};
			System.out.println(funcaoIsPrimo.isPrimo(13));
			System.out.println(funcaoIsPrimo.isPrimo(14));
			
			
			FuncaoInteiroValido funcaoInteiroValido = texto -> {
				return texto.matches("-?\\d+");
			};
			System.out.println(funcaoInteiroValido.isInteiroValido("157"));
			System.out.println(funcaoInteiroValido.isInteiroValido("15a7"));
			
			
			FuncaoCalcularMedia funcaoCalcularMedia = vetor -> {
				if (vetor.length == 0) {
					throw new IllegalArgumentException("vetor.length == 0");
				}
				
				double soma = 0;
				
				for (double valor : vetor) {
					soma += valor;
				}
				
				return soma / vetor.length;
			};
			double[] array01 = { 1, 10, 6.5, 189.5 };
			System.out.println(funcaoCalcularMedia.calcularMedia(array01));
			
			double[] array02 = { 10, 58.9, 6.5, 18 };
			System.out.println(funcaoCalcularMedia.calcularMedia(array02));
			
			
			FuncaoImprimirMaiorNumero funcaoImprimirMaiorNumero = vetor -> {
				if (vetor.length == 0) {
					throw new IllegalArgumentException("vetor.length == 0");
				}
				
				double maiorNumero = vetor[0];
				
				for (int i = 1; i < vetor.length; i++) {
					if (vetor[i] > maiorNumero) {
						maiorNumero = vetor[i];
					}
				}
				
				System.out.println("Maior número = " + maiorNumero);
			};
			funcaoImprimirMaiorNumero.imprimirMaiorNumero(array01);
			funcaoImprimirMaiorNumero.imprimirMaiorNumero(array02);
	}
}
