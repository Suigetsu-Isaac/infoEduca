package drafeon;

import java.util.ArrayList;
import java.util.Random;


public class IaDoInimigo {
    private Random r=new Random();
    private String mensagem;
    public IaDoInimigo(Personagem agente){
        String acao = escolheAcao(agente);
        
        if (acao.equals("corteLaminar")){
            Personagem alvo = escolheAlvo(CampoDeBatalha.getAliados());
            this.mensagem =  Habilidades.corteLaminar(agente,alvo);
           
            
        }else if (acao.equals("recuperacao")){
            Personagem alvo = escolheAlvo(CampoDeBatalha.getInimigos());
            this.mensagem =  Habilidades.recuperacao(agente, alvo);
           
        } else if (acao.equals("corteBrutal")){
            Personagem alvo = escolheAlvo(CampoDeBatalha.getAliados());
            this.mensagem =  Habilidades.ataqueBrutal(agente, alvo);
          
        }
            else if (acao.equals("boladefogo")){
                
                this.mensagem =  Habilidades.bolaDeFogo(agente, CampoDeBatalha.getAliados());
                
            }
            else if (acao.equals("drenarataque")){
                Personagem alvo = escolheAlvo(CampoDeBatalha.getAliados());
                this.mensagem =  Habilidades.drenarAtaque(agente, alvo);
             
            }
            else if (acao.equals("fortificar")){
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
    public  static void  main(String args[]){
        // Criando 8 personagens
        Personagem p1 = new Personagem("Guerreiro", 100, 50, 30);
        Personagem p2 = new Personagem("Arqueiro", 80, 40, 25);
        Personagem p3 = new Personagem("Mago", 70, 30, 35);
        
        Personagem p4 = new Personagem("Assassino", 90, 45, 40);
        Personagem p5 = new Personagem("Clérigo", 85, 35, 15);
        Personagem p6 = new Personagem("Bárbaro", 110, 55, 25);
        
        
        CampoDeBatalha campo = new CampoDeBatalha(p1, p2, p3, p4, p5, p6);

        p1.adicionarHabilidade("cortelaminar");
        p1.adicionarHabilidade("recuperacao");
        p1.adicionarHabilidade("boladefogo");
        
        IaDoInimigo ia = new IaDoInimigo(p1);
        
         
        
    }
}