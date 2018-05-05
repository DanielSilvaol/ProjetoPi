package br.edu.saojudas.pi.service;

import br.edu.saojudas.pi.dao.PalavraChaveDao;
import br.edu.saojudas.pi.pacote.Conversa;
import br.edu.saojudas.pi.pacote.PalavraChave;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 15/04/18.
 */
public class PalavraChaveService {

	public PalavraChaveDao dao = new PalavraChaveDao();
	PerguntaService per = new PerguntaService();
	public ArrayList<PalavraChave> encontraPalavrasChavesPorPergunta(String pergunta) {
		ArrayList<String> perguntaResp = per.quebraResposta(pergunta);
		ArrayList<PalavraChave> palavraChaves = dao.buscaTodasPalavraChaves();
		ArrayList<PalavraChave> palavrasNaPergunta = new ArrayList<>();
		
		for (PalavraChave palavraChave : palavraChaves) {
			if (perguntaResp.contains(palavraChave.getPalavra())) {
				palavrasNaPergunta.add(palavraChave);

			}
			
		
		}
		return palavrasNaPergunta;
	}

}