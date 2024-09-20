package drafeon;

import java.util.ArrayList;

public class Batalha {
    private Iniciativa iniciativa;

    public void geraCampoDeBatalha(boolean ehFase1){
        //guerreiro: HP - 3, ATK: 2, DEF: 3 (CorteLaminar, AtaqueBrutal)
        //Mago: HP - 1, ATK: 3, DEF: 2 (BolaDeFogo, DrenarAtaque, Fortificar)
        //Cleriga: Hp - 2, ATK: 1, DEF: 3 (Fortificar, Recuperacao, corteLaminar)
        Personagem aliado1 = new Personagem("Guerreiro",3,3,3);
        Personagem aliado2 = new Personagem("Mago",1,3,2);
        Personagem aliado3 = new Personagem("Cleriga",2,1,3);

        aliado1.adicionarHabilidade("cortelaminar");
        aliado1.adicionarHabilidade("ataquebrutal");
      
        aliado2.adicionarHabilidade("boladefogo");
        aliado2.adicionarHabilidade("drenarataque");
        aliado2.adicionarHabilidade("fortificar");
        
        aliado3.adicionarHabilidade("fortificar");
        aliado3.adicionarHabilidade("recuperacao");
        aliado3.adicionarHabilidade("corteLaminar");
        
        CampoDeBatalha.inserirAliado(aliado1);
        CampoDeBatalha.inserirAliado(aliado2);
        CampoDeBatalha.inserirAliado(aliado3);

        geraInimigos(ehFase1);
    }
    
    public void geraInimigos(boolean ehFase1){
        Personagem inimigo1,inimigo2,inimigo3;
        if (ehFase1 ){
        inimigo1 = new Personagem("cavaleironegro",5,5,5);
        inimigo2 = new Personagem("feiticeiro",3,5,2);
        inimigo3 = new Personagem("necromante",3,5,4);
        
        inimigo1.adicionarHabilidade("drenarataque");
        inimigo1.adicionarHabilidade("ataquebrutal");
        inimigo1.adicionarHabilidade("corteLaminar");

        inimigo2.adicionarHabilidade("boladefogo");
        inimigo2.adicionarHabilidade("drenarataque");
        
        inimigo3.adicionarHabilidade("recuperacao");
        inimigo3.adicionarHabilidade("fortificar");
        inimigo3.adicionarHabilidade("drenarataque");
        }
        else {
        inimigo1 = new Personagem("cavaleironegro",3,3,3);
        inimigo2 = new Personagem("feiticeiro",3,3,2);
        inimigo3 = new Personagem("necromante",3,1,3);

        inimigo1.adicionarHabilidade("");
        inimigo2.adicionarHabilidade("");
        inimigo3.adicionarHabilidade("");
        }
        CampoDeBatalha.inserirInimigo(inimigo1);
        CampoDeBatalha.inserirInimigo(inimigo2);
        CampoDeBatalha.inserirInimigo(inimigo3);
    }

    public Iniciativa geraIniciativa(){
        return null;
    }
}

