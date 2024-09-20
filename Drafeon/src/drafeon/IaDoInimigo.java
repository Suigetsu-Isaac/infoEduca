package drafeon;

import java.util.ArrayList;
import java.util.Random;


public class IaDoInimigo {
    private Random r=new Random();
    public IaDoInimigo(Personagem agente, CampoDeBatalha campo){
        String acao = escolheAcao(agente);
        
        if (acao.equals("cortelaminar")){
            Personagem alvo = escolheAlvo(campo.getAliados());
            String v = Habilidades.cortelaminar(agente,alvo);
            System.out.println(v);
            
        }else if (acao.equals("recuperacao")){
            Personagem alvo = escolheAlvo(campo.getInimigos());
            String v = Habilidades.recuperacao(agente, alvo);
            System.out.println(v);
        }else {
            System.err.println("error");
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
    
    public  static void  main(String args[]){
        
        CampoDeBatalha campo = new CampoDeBatalha();

        // Criando 8 personagens
        Personagem p1 = new Personagem("Guerreiro", 100, 50, 30);
        Personagem p2 = new Personagem("Arqueiro", 80, 40, 25);
        Personagem p3 = new Personagem("Mago", 70, 30, 35);
        
        Personagem p5 = new Personagem("Assassino", 90, 45, 40);
        Personagem p6 = new Personagem("Clérigo", 85, 35, 15);
        Personagem p7 = new Personagem("Bárbaro", 110, 55, 25);
        

        // Adicionando 4 personagens aos aliados
        campo.inserirAliado(p1);
        campo.inserirAliado(p2);
        campo.inserirAliado(p3);
 
  

        // Adicionando 4 personagens aos inimigos
        campo.inserirInimigo(p5);
        campo.inserirInimigo(p6);
        campo.inserirInimigo(p7);


        // Mostrando os nomes dos personagens no campo de batalha
        campo.mostrarAliados();
        campo.mostrarInimigos();

        p1.adicionarHabilidade("cortelaminar");
        p1.adicionarHabilidade("recuperacao");
        
        IaDoInimigo ia = new IaDoInimigo(p1, campo);
        
         
        
    }
}