package br.edu.saojudas.pi.service;

import br.edu.saojudas.pi.dao.ClienteDao;
import br.edu.saojudas.pi.pacote.Cliente;

public class ClienteService {

	public ClienteDao dao = new ClienteDao();

	public Cliente carregar(int id){

		return dao.carregarCliente(id);
	}

	public int criarCliente(Cliente cli) {
		return dao.cadastroCliente(cli);
	}
}
