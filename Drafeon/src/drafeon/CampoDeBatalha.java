package drafeon;

import java.util.ArrayList;

public class CampoDeBatalha {
    private ArrayList<Personagem> aliados;
    private ArrayList<Personagem> inimigos;

    public CampoDeBatalha() {
        this.aliados = new ArrayList<>(4);
        this.inimigos = new ArrayList<>(4);
    }

    public void inserirAliado(Personagem personagem) {
        if (aliados.size() < 4) {
            aliados.add(personagem);
            System.out.println(personagem.getNome() + " foi adicionado aos aliados.");
        } else {
            System.out.println("O grupo de aliados está cheio. Não é possível adicionar mais personagens.");
        }
    }

    public void inserirInimigo(Personagem personagem) {
        if (inimigos.size() < 4) {
            inimigos.add(personagem);
            System.out.println(personagem.getNome() + " foi adicionado aos inimigos.");
        } else {
            System.out.println("O grupo de inimigos está cheio. Não é possível adicionar mais personagens.");
        }
    }

    public ArrayList<Personagem> getAliados() {
        return aliados;
    }

    public ArrayList<Personagem> getInimigos() {
        return inimigos;
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
