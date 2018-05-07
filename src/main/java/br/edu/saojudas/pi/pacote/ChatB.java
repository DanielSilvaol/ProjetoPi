package br.edu.saojudas.pi.pacote;

import java.util.ArrayList;
import java.util.List;

public class ChatB {

	public List<Conversa> conversas;

	public ChatB() {

		conversas = new ArrayList<>();
	}

	public void addConversa(int id,String pergunta, String resposta) {

		conversas.add(new Conversa(id,pergunta, resposta));
	}
	public List<Conversa> Pergunta(){

		return conversas;
	}
	public List<Conversa> getConversas() {

		return new ArrayList<>(conversas);
	}

}