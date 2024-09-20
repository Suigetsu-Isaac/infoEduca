package drafeon;
import java.util.ArrayList;
public class Habilidades {

    //nomes e descrições de todas as habilidades:
    private String cortelaminarNome = "cortelaminar";
    private String cortelaminaraDescricao;
    
    public String getCortelaminarNome() {
        return cortelaminarNome;
    }

    public void setCortelaminarNome(String cortelaminaraNome) {
        this.cortelaminarNome = cortelaminaraNome;
    }

    public String getCortelaminaraDescricao() {
        return cortelaminaraDescricao;
    }

    public void setCortelaminaraDescricao(String cortelaminaraDescricao) {
        this.cortelaminaraDescricao = cortelaminaraDescricao;
    }


    public static String recuperacao(Personagem agente, Personagem alvo){

        if (agente.getDEF() < 1) {
            return "você não tem defesa o suficiente pode ativar essa habilidade";
        }
        agente.setDEF(agente.getDEF() - 1);
        String mensagem = "algo deu errado";

        alvo.setHP(alvo.getHP() + 2);
        if(alvo.getHP()>3) {alvo.setHP(3);}

        mensagem = "A vida de: "+alvo.getNome()+ " foi recuperada em 2 ao custo de 1 de defesa";

        return mensagem;
    }

    public static String fortificar(Personagem agente, Personagem alvo){

        if (agente.getDEF() < 1 || agente.getATK() < 1) {
            return "Você não tem a defesa ou o ataque necessario para ativar essa habilidade";
        }

        agente.setDEF(agente.getDEF() - 1);
        agente.setATK(agente.getATK() -1);
        String mensagem = "algo deu errado";

        alvo.setHP(alvo.getATK() + 2);
        if(alvo.getATK()>3) {alvo.setATK(3);}

        mensagem = "O ataque de: "+alvo.getNome()+ " foi recuperada em 2 ao custo de 1 de defesa e 1 de ataque";

        return mensagem;
    }

    public static String boladefogo(Personagem agente, ArrayList<Personagem> alvo){

        if (agente.getATK() < 2){
            return "você não tem ataque o suficiente para ativar essa habilidade";
        }
        agente.setATK(agente.getATK() - 2);
        String mensagem = "";
        for (Personagem p : alvo){
            if (p.getDEF() >= 1) {
            p.setDEF(p.getDEF() - 1);
            mensagem += p.getNome() + " bloqueia gastando " + 1 + " de defesa \n";
           
        } else if (p.getDEF() <= 0) {
            p.setHP(p.getHP() - 1);
            mensagem += p.getNome() + " é acertado, recebendo " + 1 + " de dano\n";
        }
            
        }

        return mensagem;
    }     

    public static String cortelaminar(Personagem agente, Personagem alvo) {
        //reduzir o atk do agente em 1 como custo.
        if (agente.getATK() < 1) {
            return "Você não tem ataque o suficiente para ativar essa habilidade";
        }
        agente.setATK(agente.getATK() - 1);
        String mensagem = "algo deu errado";
        if (alvo.getDEF() >= 1) {
            alvo.setDEF(alvo.getDEF() - 2);
            mensagem = alvo.getNome() + " bloqueia gastando " + 2 + " de defesa";
            if (alvo.getDEF() < 0) {
                alvo.setHP(alvo.getHP() - 1);
                alvo.setDEF(0);
                mensagem = alvo.getNome() + " é acertado, recebendo " + 1 + " de dano ao seu HP";
            }
        } else if (alvo.getDEF() <= 0) {
            alvo.setHP(alvo.getHP() - 1);
            mensagem = alvo.getNome() + " é acertado, recebendo " + 2 + " de dano";
        }
        return mensagem;
    }

        public static String ataquebrutal(Personagem agente, Personagem alvo) {
        //reduzir o atk do agente em 1 como custo.
        if (agente.getATK() < 2 || agente.getDEF() < 1) {
            return "Você não tem ataque ou defesa o suficiente para ativar essa habilidade";
        }
        agente.setATK(agente.getATK() - 2);
        agente.setDEF(agente.getDEF() - 1);
        String mensagem = "algo deu errado";
        
        if (alvo.getDEF() >= 1) {
            alvo.setDEF(alvo.getDEF() - 2);
            mensagem = alvo.getNome() + " bloqueia gastando " + 2 + " de defesa";
            if (alvo.getDEF() < 0) {
                alvo.setHP(alvo.getHP() - 1);
                alvo.setDEF(0);
                mensagem = alvo.getNome() + " é acertado, recebendo " + 1 + " de dano ao seu HP";
            }
        } else if (alvo.getDEF() <= 0) {
            alvo.setHP(alvo.getHP() - 1);
            mensagem = alvo.getNome() + " é acertado, recebendo " + 2 + " de dano";
        }
        return mensagem;
    }


    public String recuperarDescricao(){
        return "Cura um aliado, recuperando 2 de vida. Custo: 1 de defesa";
    
    }
    public String corteLaminarDesc() {
        return "Desfere um poderoso ataque cortante em um alvo, causando 2 de dano. Custo: 1 de ataque";
    
    }
    public String boladefogoDesc(){
        return "Conjura uma enorme bola flamejante, causando 1 de dano em todos os inimigos. Custo: 2 de ataque";
    }

    public String fortificarDesc(){
        return "Aumenta o atk de um aliado em 2. Custo: 1 de ataque e 1 de defesa";
    
    }
    
    public String ataqueBrutalDesc(){
        return "Desfere um poderoso ataque, causando 3 de dano em um alvo. Custo: 2 de ataque e 1 de defesa";
    
    }
    
    public String drenarAtaqueDesc(){
        return "Drena a habilidade o poder de um alvo, removendo 1 ATK dele e recuperando 1 de ATK para si. Custo: 2 de defesa";
    
    }
    
    //public String reviverDesc(){
    //    return "Levanta um aliado caído no campo de batalha, aumentando seu HP em 1. Custo: 2 de ataque";
    
    //}
    
}