package br.edu.saojudas.pi.controller;

import br.edu.saojudas.pi.pacote.ChatB;
import br.edu.saojudas.pi.pacote.Conversa;
import br.edu.saojudas.pi.pacote.Resposta;
import br.edu.saojudas.pi.service.ChatService;
import br.edu.saojudas.pi.service.ConversaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ChatBController
 */
@WebServlet("/chatBController.do")
public class ChatBController extends HttpServlet {

    public static final String CHAT = "chat";
    public static final String RESPOSTA_NAO_ENCONTRADA = "Desculpe, mas não tenho a resposta para sua pergunta! Você pode reformular a sua pergunta?";
    public static final String ATT_PERG = "pergunta";
    public ChatService chatService = new ChatService();

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ChatB chat = (ChatB) session.getAttribute(CHAT);
        String pergunta = request.getParameter(ATT_PERG);
        String pAcao = request.getParameter("acao");

        //Instanciando e adicionando id
        ConversaService service = new ConversaService();
        Conversa cv = new Conversa();


        Resposta resposta = chatService.buscaResposta(pergunta);


    String aux = cv.getPergunta();

    if (pAcao.equals("Enviar")) {
        //Adicionando ao Banco a Conversa
        cv.setPergunta(pergunta);
        cv.setResposta(resposta.getValor());
        int id = service.AdicionarConversa(cv);
        cv.setId(id);
        if (resposta == null) {

            chat.addConversa(id, pergunta, RESPOSTA_NAO_ENCONTRADA);
        } else {
            chat.addConversa(id, pergunta, resposta.getValor());

        }
    } else if (pAcao.equals("Sim")) {
        //Adicionando ao Banco a Conversa

        cv.setPergunta(aux);
        cv.setResposta(resposta.getValor());
        int id = service.AdicionarConversa(cv);
        cv.setId(id);

        resposta = chatService.SimBotaoo(aux);
        chat.addConversa(id, aux, resposta.getValor());



}
        session.setAttribute(CHAT, chat);

        RequestDispatcher view = request.getRequestDispatcher("chat.jsp");
        view.forward(request, response);
    }


//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        ChatB chat = (ChatB) session.getAttribute("chat");
//
//        String pNome = request.getParameter("nome");
//        String pEmail = request.getParameter("email");
//
//        String pMenssagem = request.getParameter("");
//        String pNomeMsg = request.getParameter("nome");
//        String pPergunta = request.getParameter("txtMsg");
//
//
//        //instanciar o javabean
//        Cliente cli = new Cliente();
//        cli.setNome(pNome);
//        cli.setEmail(pEmail);
//        ChatService cs = new ChatService();
//        cs.criarCliente(cli);
//        cli = cs.carregar(cli.getId());
//
//        response.setContentType("text/html;charset=UTF-8");
//
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
//            out.println("id: " + cli.getId() + "<br>");
//            out.println("nome: " + cli.getNome() + "<br>");
//            out.println("email: " + cli.getEmail() + "<br>");
//            out.println("</body></html>");
//
//            Menssagem msg = new Menssagem();
//            msg.setMenssagem(pMenssagem);
//            msg.setNome(cli.getNome());
//            cs.addMenssagem(msg);
//            cli = cs.carregar(msg.getId());
//
//
//            chat.setPergunta(pPergunta);
//            int id = 0;
//
//
//            //Display Chat Room
//            out.println("<html>  <head> <body bgcolor=\"#6495ED\"> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <title>Chat Room</title>  </head>");
//            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <center>");
//            out.println("<h2>Ol� ");
//            out.println(cli.getNome());
//            out.println("<br> Bem-Vindo");
//            out.println("</h2><br><hr>");
//            out.println("  <body>");
//            out.println("      <form name=\"CadastraClienteController.do\" action=\"CadastraClienteController.do\">");
//            out.println("Menssagem: <input type=\"text\" name=\"txtMsg\" value=\"\" /><input type=\"submit\" value=\"Enviar\" name=\"cmdSend\"/>");
//            out.println("<br>  <br>");
//            out.println("Conversa:");
//            out.println("<br><br>");
//            out.println("<textarea  readonly=\"readonly\"   name=\"txtMessage\" rows=\"20\" cols=\"60\">");
//
//            if (request.getParameter("txtMsg") != null) {
//
//                try {
//                    Connection conn = ConnectionFactory.obtemConexao();
//                    Statement st = conn.createStatement();
//
//                    pNomeMsg = cli.getNome();
//
//                    int x = 1;
//
//                    String sql = "insert into pergunta values ('" + id + "','" + pPergunta + "')";
//                    st.executeUpdate(sql);
//
//                    String status = "feliz";
//                    String sql2 = "insert into atendimento values ('" + id + "','" + status + "','" + x + "','" + x + "','" + id + "')";
//                    st.executeUpdate(sql2);
//
//
//                    st.execute("commit");
//
//
//                } catch (Exception ex1) {
//                    System.err.println(ex1.getMessage());
//                    String messages = "Erro.";
//                    out.println(messages);
//                }
//            }
//            try {
//                Connection conn = ConnectionFactory.obtemConexao();
//                Statement st = conn.createStatement();
//
//                ResultSet rs = st.executeQuery(" select cliente.Nome_Cliente, pergunta.pergunta from cliente join pergunta on cliente.id_cliente = pergunta.id_pergunta");
//
//                // Print all retrieved messages
//                while (rs.next()) {
//                    String messages = rs.getString(1) + " >> " + rs.getString(2);
//
//                    out.println(messages);
//                }
//
//                conn.close();
//            } catch (Exception ex1) {
//                System.err.println(ex1.getMessage());
//            }
//
//
//            out.println("</textarea>");
//            out.println("<hr>");
//            out.println("</form>");
//            out.println("</body>");
//            out.println("</html>");
//
//
//        }
//
//    }

    String username, tempName;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        //Session
//
//        session = request.getSession();
//
//        if (chat.getPergunta() != null) {
//            tempName = chat.getPergunta();
//        }
//
//        doPost(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
