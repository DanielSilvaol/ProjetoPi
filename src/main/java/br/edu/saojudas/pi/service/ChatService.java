package br.edu.saojudas.pi.service;


import br.edu.saojudas.pi.pacote.Conversa;
import br.edu.saojudas.pi.pacote.PalavraChave;
import br.edu.saojudas.pi.pacote.Resposta;

import java.util.ArrayList;
import java.util.List;


public class ChatService {

	public PalavraChaveService palavraChaveService = new PalavraChaveService();

	public RespostaService respostaService = new RespostaService();

	public Resposta buscaResposta(String pergunta) {

		
		ArrayList<PalavraChave> palavraChaves =  palavraChaveService.encontraPalavrasChavesPorPergunta(pergunta);
		
		
		return respostaService.buscaRespostaApropriada(palavraChaves);
	}

	public Resposta SimBotaoo(String pergunta){
		ArrayList<PalavraChave> palavraChaves =  palavraChaveService.encontraPalavrasChavesPorPergunta(pergunta);

		return respostaService.SimBotao(palavraChaves);
	}

}