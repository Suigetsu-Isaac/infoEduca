package drafeon;

import java.util.ArrayList;
import java.util.Scanner;

public class Personagem {
    private String nome;
    private int HP;
    private int DEF;
    private int ATK;  
    private int totalHP;
    private int totalDEF;
    private int TotalATK;
    
    public Personagem(String nome, int HP, int DEF, int ATK){
        this.nome = nome;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.totalHP = HP;
        this.TotalATK = ATK;
        this.totalDEF = DEF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }
    
    public void atacar(ArrayList<Personagem> personagens) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um personagem para atacar:");
        for (int i = 0; i < personagens.size(); i++) {
            System.out.println((i + 1) + ". " + personagens.get(i).getNome());
        }

        int escolha = scanner.nextInt() - 1;
        Personagem alvo = personagens.get(escolha);

        if (alvo.DEF >= 1) {
            alvo.setDEF(alvo.getDEF() - ATK);
            System.out.println(alvo.getNome() + " bloqueia gastando " + ATK + " de defesa \n");
            if (alvo.getDEF() < 0) {
                alvo.setHP(alvo.getHP() - 1);
                alvo.setDEF(0);
                System.out.println(alvo.getNome() + " é acertado, recebendo " + 1 + " de dano \n");
            }
        } else if (alvo.DEF <= 0) {
            alvo.setHP(alvo.getHP() - 1);
            System.out.println(alvo.getNome() + " é acertado, recebendo " + 1 + " de dano \n");
        }
    }
    
    public void mostrarStatus() {
        System.out.println(nome + ": HP - " + HP + ", Defesa - " + DEF + ", Ataque - " + ATK + "\n");
    }
}
