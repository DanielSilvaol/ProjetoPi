package br.edu.saojudas.pi.service;

import br.edu.saojudas.pi.dao.ChatBDao;
import br.edu.saojudas.pi.pacote.Conversa;

public class ConversaService {

    ChatBDao dao = new ChatBDao();

    public int AdicionarConversa(Conversa cv){
        return dao.AdicionaConversa(cv);
    }

}
