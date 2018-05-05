package br.edu.saojudas.pi;

import br.edu.saojudas.pi.pacote.ChatB;
import br.edu.saojudas.pi.pacote.Cliente;
import br.edu.saojudas.pi.service.ChatService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChatTest {


	Cliente cli;
	ChatB chat, copia;
	ChatService cs = new ChatService();
	static int id = 0 ;
		// TODO Auto-generated method stub
	@Test
	public void test01Criar() {
		System.out.println("criar");
		
		System.out.println(id);
		cli = new Cliente();
        cli.setNome("João das Couves");
        cli.setEmail("1160606161");
//        cs.criarCliente(cli);
//        id = cs.criarCliente(cli);

	}
	@Test
	public void test00CriarAtendente() {
		System.out.println("carregar");
		
	//	at = new Atendente(id,"das","dsda","sda","ad","ads","ads","dsad");
//		cs.criarAtendente(at);
//		id = cs.criarAtendente(at);
	
	}
	
@Test
	public void Carregar() {
//		cli = new Cliente(41,"João das Couves","1160606161");
        
//		cli = cs.carregar(41);
		System.out.println(cli);
		
	}
	

}
