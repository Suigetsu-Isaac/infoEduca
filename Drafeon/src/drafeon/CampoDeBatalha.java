package drafeon;


import java.util.ArrayList;

public class CampoDeBatalha {
    private static ArrayList<Personagem> aliados = new ArrayList<Personagem>();
    private static ArrayList<Personagem> inimigos = new ArrayList<Personagem>();

    public CampoDeBatalha(Personagem aliado1, Personagem aliado2, Personagem aliado3, Personagem inimigo1, Personagem inimigo2, Personagem inimigo3) {
            
            CampoDeBatalha.inserirAliado(aliado1);
            CampoDeBatalha.inserirAliado(aliado2);
            CampoDeBatalha.inserirAliado(aliado3);
            CampoDeBatalha.inserirInimigo(inimigo1);
            CampoDeBatalha.inserirInimigo(inimigo2);
            CampoDeBatalha.inserirInimigo(inimigo3);

    }

    public static void removePersonagem(Personagem personagem){

        if (personagem.getEhInimigo() == false){
            CampoDeBatalha.getAliados().remove(personagem);
        }
        else{
            CampoDeBatalha.getInimigos().remove(personagem);
        }
    }

    public static void inserirAliado(Personagem personagem) {
        //if (aliados.size() < 4) {
         //  
        //} else {
          //  System.out.println("O grupo de aliados está cheio. Não é possível adicionar mais personagens.");
        //}
         aliados.add(personagem);
            System.out.println(personagem.getNome() + " foi adicionado aos aliados.");
    }

    public static void inserirInimigo(Personagem personagem) {
        
        
        //if (inimigos.size() < 4) {
        //    
        //} else {
        //    System.out.println("O grupo de inimigos está cheio. Não é possível adicionar mais personagens.");
        //}
        inimigos.add(personagem);
        System.out.println(personagem.getNome() + " foi adicionado aos inimigos.");
    }

    public static ArrayList<Personagem> getAliados() {
        return CampoDeBatalha.aliados;
    }

    public static ArrayList<Personagem> getInimigos() {
        return CampoDeBatalha.inimigos;
    }

    public void mostrarAliados() {
        System.out.println("Aliados:");
        for (int i = 0; i < aliados.size(); i++) {
            System.out.println("Posição " + (i + 1) + ": " + aliados.get(i).getNome());
        }
    }

    public void mostrarInimigos() {
        System.out.println("Inimigos:");
        for (int i = 0; i < inimigos.size(); i++) {
            System.out.println("Posição " + (i + 1) + ": " + inimigos.get(i).getNome());
        }
    }
}
