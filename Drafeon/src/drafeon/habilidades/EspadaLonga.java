package drafeon.habilidades;

import java.util.ArrayList;
import drafeon.Personagem;

public class EspadaLonga {
    private int HP;
    private int ATK;
    private int DEF;
    private ArrayList<Personagem> alvos;

    public EspadaLonga(int HP, int ATK, int DEF) {
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.alvos = new ArrayList<>(8); // Inicializa o ArrayList com capacidade para 8 personagens
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public ArrayList<Personagem> getAlvos() {
        return alvos;
    }

    public void adicionarAlvo(Personagem personagem) {
        if (alvos.size() < 8) {
            alvos.add(personagem);
            System.out.println(personagem.getNome() + " foi adicionado à Espada Longa.");
        } else {
            System.out.println("A Espada Longa já possui 8 alvos. Não é possível adicionar mais.");
        }
    }
    public void corte(){
        
    }
}
