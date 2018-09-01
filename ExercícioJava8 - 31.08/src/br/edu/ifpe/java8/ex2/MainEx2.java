package br.edu.ifpe.java8.ex2;

public class MainEx2 {

	public static void main(String[] args) {
		
		RelatorioAlunos2.gerar(TipoRelatorio2.NOME); //1
		RelatorioAlunos2.gerar(TipoRelatorio2.NOME_MATRICULA); //2
		RelatorioAlunos2.gerar(TipoRelatorio2.NOME_MATRICULA_MEDIA); //3
		RelatorioAlunos2.gerar(TipoRelatorio2.NOME_MEDIA); //4
		RelatorioAlunos2.gerar(TipoRelatorio2.MATRICULA_MEDIA); //5
		
	}
}
