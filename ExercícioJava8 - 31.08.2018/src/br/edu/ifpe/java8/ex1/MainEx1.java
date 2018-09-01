package br.edu.ifpe.java8.ex1;

public class MainEx1 {

	public static void main(String[] args) {
				
		RelatorioAlunos1.gerar(TipoRelatorio1.TODOS);
		
		RelatorioAlunos1.gerar(TipoRelatorio1.APENAS_APROVADOS);
		
		RelatorioAlunos1.gerar(TipoRelatorio1.APENAS_FINAL);
		
		RelatorioAlunos1.gerar(TipoRelatorio1.APENAS_REPROVADOS_DIRETO);
	}
}
