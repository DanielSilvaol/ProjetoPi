package br.edu.saojudas.pi.service;

import br.edu.saojudas.pi.pacote.PalavraChave;
import br.edu.saojudas.pi.pacote.Resposta;

import java.util.ArrayList;

import br.edu.saojudas.pi.dao.RespostaDao;

public class PerguntaService {
	

	public ArrayList<String> quebraResposta(String pergunta) {
		String [] vet;
		vet= pergunta.split(" ");
		ArrayList<String> listPergunta = new ArrayList<String>();
		
		for(int i = 0; i<vet.length; i++) {
			listPergunta.add(vet[i]);
		}

		
		return listPergunta;
	}

}

/*
 * ChatBDao br.edu.saojudas.pi.dao = new ChatBDao();
 * 
 * 
 * public PalavraChave obterPalavraChave(PalavraChave palavraChave1) {
 * 
 * // pl = palavraChave1.getPalavra().split(" "); //// ArrayList<PalavraChave>
 * palavraChave = new ArrayList<PalavraChave>(); //// ArrayList
 * <RespostaService> respostasPossiveis =
 * RespostaService.obterRespostasPossiveis (palavraChave); ////
 * while(palavraChave1.split(" ") != null) //// palavraChave.add(palavraChave1);
 * // // return br.edu.saojudas.pi.dao.chamarPalavra(palavraChave1); return null; }
 * 
 * }
 */

