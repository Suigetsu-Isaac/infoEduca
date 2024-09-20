package drafeon;

import java.util.ArrayList;
import java.util.Collections;

public class Iniciativa {
    private static ArrayList<Personagem> ordem = new ArrayList<>(); 
    private static int indiceAtual;

    public Iniciativa() {
      
        Iniciativa.ordem.addAll(CampoDeBatalha.getAliados());
        Iniciativa.ordem.addAll(CampoDeBatalha.getInimigos());
        Collections.shuffle(Iniciativa.ordem); // Embaralha a lista para uma ordem aleatória
        Iniciativa.indiceAtual = 0;
    }

    public static ArrayList<Personagem> getOrdem(){
        return ordem;
    }
    public static void setOrdem(){
        Iniciativa.ordem.addAll(CampoDeBatalha.getAliados());
        Iniciativa.ordem.addAll(CampoDeBatalha.getInimigos());
        Collections.shuffle(Iniciativa.ordem); // Embaralha a lista para uma ordem aleatória
        Iniciativa.indiceAtual = 0;
    }

    public static void removePersonagem(Personagem personagem){

        Iniciativa.getOrdem().remove(personagem);
    }


    public static Personagem getAtual() {
        return ordem.get(indiceAtual);
    }

    public static Personagem proximo() {
        indiceAtual = (indiceAtual + 1) % ordem.size();
        return ordem.get(indiceAtual);
    }

    public static void mostrarOrdem() {
        System.out.println("Ordem de iniciativa:");
        for (Personagem p : ordem) {
            System.out.println(p.getNome());
        }
    }
}
