package br.edu.saojudas.pi.pacote;

/**
 * Created by daniel on 14/04/18.
 */
public class Conversa {

    public String pergunta;

    public String resposta;
    public int id;


    public Conversa() {

    }

    public Conversa(int id,String pergunta, String resposta) {
        this.id = id;
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public String getPergunta() {

        return pergunta;
    }

    public void setPergunta(String pergunta){

        this.pergunta = pergunta;
    }

    public int getId() {

        return id;
    }
    public void setId(int id){

        this.id = id;
    }

    public String getResposta() {

        return resposta;
    }

    public void setResposta(String resposta) {

        this.resposta = resposta;
    }
}