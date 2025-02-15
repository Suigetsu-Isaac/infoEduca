package drafeon;

import java.util.ArrayList;
import java.util.Random;

public class IaDoInimigo {
    private Random r=new Random();
    private String mensagem;
    
    public IaDoInimigo(Personagem agente){
        String acao = escolheAcao(agente);
        
        if (acao.equals("cortelaminar")){
            Personagem alvo = escolheAlvo(CampoDeBatalha.getAliados());
            this.mensagem =  Habilidades.corteLaminar(agente,alvo);
           
            
        }else if (acao.equalsIgnoreCase("recuperacao")){
            Personagem alvo = escolheAlvo(CampoDeBatalha.getInimigos());
            this.mensagem =  Habilidades.recuperacao(agente, alvo);
           
        } else if (acao.equalsIgnoreCase("cortebrutal")){
            Personagem alvo = escolheAlvo(CampoDeBatalha.getAliados());
            this.mensagem =  Habilidades.ataqueBrutal(agente, alvo);
          
        }
            else if (acao.equalsIgnoreCase("boladefogo")){
                
                this.mensagem =  Habilidades.bolaDeFogo(agente, CampoDeBatalha.getAliados());
                
            }
            else if (acao.equalsIgnoreCase("boladefogodraconica")){
                this.mensagem = Habilidades.bolaDeFogoDraconica(agente, CampoDeBatalha.getAliados());
            }
            else if (acao.equalsIgnoreCase("drenarataque")){
                Personagem alvo = escolheAlvo(CampoDeBatalha.getAliados());
                this.mensagem =  Habilidades.drenarAtaque(agente, alvo);
             
            }
            else if (acao.equalsIgnoreCase("fortificar")){
                Personagem alvo = escolheAlvo(CampoDeBatalha.getInimigos());
                this.mensagem = Habilidades.fortificar(agente, alvo);
               
            }
        
        else {
            this.mensagem = "error";
        }
   }    

    public Personagem escolheAlvo(ArrayList<Personagem> alvos){
        int i=r.nextInt(alvos.size());
        return  alvos.get(i); 
    }

    //método que recebe o arraylist de habilidades da classe personagem() 
    //e retorna uma de suas habilidades aleatória:
    public String escolheAcao(Personagem agente){
        ArrayList<String> habilidades;
        habilidades = agente.getHabilidades();
        int i= r.nextInt(habilidades.size());
        
        return habilidades.get(i);
    }
    public String getMensagem(){
        return this.mensagem;
    }
}