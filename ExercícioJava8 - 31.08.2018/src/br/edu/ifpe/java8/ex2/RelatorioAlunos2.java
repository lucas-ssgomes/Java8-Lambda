package br.edu.ifpe.java8.ex2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import br.edu.ifpe.java8.entidades.Aluno;

/**
 * Esta classe � respons�vel pela leitura de todos os alunos de um arquivo de entrada (alunos.txt)
 *  e gerar um relat�rio 5 Op��es de relat�rios est�o dispon�veis: 
 *  
 * 		1 - Com o nome de todos os alunos;
 *		2 - Com o nome e a matr�cula de todos os alunos;
 *		3 - Com o nome, a matr�cula e a m�dia de todos os alunos;
 *		4 - Com o nome e a m�dia de todos os alunos;
 *		5 - Com o a matr�cula e a m�dia de todos os alunos;
 *
 * O problema do c�digo abaixo (entre outros) � que ele viola o princ�pio OPEN-CLOSED de OO, 
 * que diz que o entidades devem estar aberta para extens�es, por�m fechadas para mudan�as.
 * 
 * Logo, o seu trabalho � basicamente, utilizando programa��o funcional, modificar o mecanismo 
 * de gera��o de relat�rios para evitar ifs e switchs ao longo do m�todo abaixo.
 * 
 * @author Victor Lira
 *
 */
public class RelatorioAlunos2 {

	private static final String SEPARADOR = "#";
	
	private static final Map<TipoRelatorio2, Function<Aluno, String>> ACAO;
	static {
		ACAO = new HashMap<>();
		ACAO.put(TipoRelatorio2.NOME, aluno -> aluno.getNome());
		ACAO.put(TipoRelatorio2.NOME_MATRICULA, aluno -> aluno.getNome() + SEPARADOR + aluno.getMatricula());
		ACAO.put(TipoRelatorio2.NOME_MATRICULA_MEDIA, aluno -> aluno.getNome() + SEPARADOR 
				+ aluno.getMatricula() + SEPARADOR + aluno.getMedia());
		ACAO.put(TipoRelatorio2.NOME_MEDIA, aluno -> aluno.getNome() + SEPARADOR + aluno.getMedia());
		ACAO.put(TipoRelatorio2.MATRICULA_MEDIA, aluno -> aluno.getMatricula() + SEPARADOR + aluno.getMedia());
	}

	public static void gerar(TipoRelatorio2 opcao) {
		File arquivoEntrada = new File("alunos.txt");
		File arquivoSaida = new File("relatorio.txt");

		Scanner leitor = null;
		PrintWriter escritor = null;

		try {
			leitor = new Scanner(arquivoEntrada);
			escritor = new PrintWriter(arquivoSaida);

			while (leitor.hasNextLine()) {
				String linha = leitor.nextLine();

				String[] valores = linha.split(SEPARADOR);

				Aluno aluno = new Aluno();
				aluno.setNome(valores[0]);
				aluno.setMatricula(valores[1]);
				aluno.setMedia(Double.parseDouble(valores[2]));
			}
		} catch (IOException e) {
			/* DO NOTHING */
		} finally {
			if (leitor != null) {
				leitor.close();
			}
			if (escritor != null) {
				escritor.close();
			}
		}
	}
}
