package br.edu.ifpe.java8.ex1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

import br.edu.ifpe.java8.entidades.Aluno;

/**
 * Esta classe é responsável pela leitura de todos os alunos de um arquivo de entrada (alunos.txt)
 *  e gerar um relatório.
 *  
 * 4 Opções de relatórios estão disponíveis: 
 * 		1 - Com o nome de todos os alunos;
 *		2 - Apenas com os nomes dos alunos aprovados;
 *		3 - Apenas com os nomes dos alunos que foram para a final;
 *		4 - Apenas com os nomes dos alunos que foram reprovados
 *
 * O problema do código abaixo (entre outros) é que ele viola o princípio OPEN-CLOSED de OO, 
 * que diz que o entidades devem estar aberta para extensões, porém fechadas para mudanças.
 * 
 * Logo, o seu trabalho é basicamente, utilizando programação funcional, modificar o mecanismo 
 * de geração de relatórios para evitar ifs e switchs ao longo do método abaixo.
 * 
 * @author Victor Lira
 *
 */
public class RelatorioAlunos1 {
	
	private static final String SEPARADOR = "#";

	private static final double MEDIA_APROVACAO = 6;
	private static final double MEDIA_MINIMA_FINAL = 2;
	
	private static final Map<TipoRelatorio1, Predicate<Aluno>> PREDICADOS;
	
	static {
		PREDICADOS = new HashMap<>();
		PREDICADOS.put(TipoRelatorio1.TODOS, aluno -> true);
		PREDICADOS.put(TipoRelatorio1.APENAS_APROVADOS, aluno -> aluno.getMedia() > 6);
		PREDICADOS.put(TipoRelatorio1.APENAS_FINAL, aluno -> 
		aluno.getMedia() < 6 && aluno.getMedia() > 2);
		PREDICADOS.put(TipoRelatorio1.APENAS_REPROVADOS_DIRETO, aluno -> aluno.getMedia() < 2);
	}
	
	public static void gerar(TipoRelatorio1 opcao) {
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
