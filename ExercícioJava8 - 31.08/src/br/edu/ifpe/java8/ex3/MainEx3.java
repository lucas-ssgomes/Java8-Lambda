package br.edu.ifpe.java8.ex3;

public class MainEx3 {

	public static void main(String[] args) {
		
		RelatorioAlunos3.gerar(TipoRelatorio3.MEDIA_GERAL);
		RelatorioAlunos3.gerar(TipoRelatorio3.ALUNOS_ACIMA_MEDIA);
		RelatorioAlunos3.gerar(TipoRelatorio3.ALUNOS_ABAIXO_MEDIA);
		
	}
}
