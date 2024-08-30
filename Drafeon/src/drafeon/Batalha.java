package drafeon;

import java.util.ArrayList;

public class Batalha {
    private CampoDeBatalha campo;
    private Iniciativa iniciativa;

    public Batalha(CampoDeBatalha campo) {
        this.campo = campo;
        this.iniciativa = new Iniciativa(campo.getAliados(), campo.getInimigos());
    }

    public void iniciar() {
        boolean batalhaEmAndamento = true;

        while (batalhaEmAndamento) {
            Personagem atual = iniciativa.proximo();

            if (atual.getHP() > 0) {
                ArrayList<Personagem> alvos = campo.getAliados().contains(atual) ? campo.getInimigos() : campo.getAliados();
                boolean todosAlvosMortos = true;

                for (Personagem alvo : alvos) {
                    if (alvo.getHP() > 0) {
                        todosAlvosMortos = false;
                        break;
                    }
                }

                if (todosAlvosMortos) {
                    batalhaEmAndamento = false;
                    String vencedor = campo.getAliados().contains(atual) ? "Aliados" : "Inimigos";
                    System.out.println("O time vencedor é: " + vencedor);
                    mostrarSobreviventes();
                } else {
                    atual.atacar(alvos);
                }
            }
        }
    }

    private void mostrarSobreviventes() {
        System.out.println("Personagens sobreviventes:");

        for (Personagem aliado : campo.getAliados()) {
            if (aliado.getHP() > 0) {
                System.out.println("Aliado: " + aliado.getNome());
            }
        }

        for (Personagem inimigo : campo.getInimigos()) {
            if (inimigo.getHP() > 0) {
                System.out.println("Inimigo: " + inimigo.getNome());
            }
        }
    }

    public static void main(String[] args) {
        CampoDeBatalha campo = new CampoDeBatalha();

        // Criando 8 personagens
        Personagem p1 = new Personagem("Guerreiro", 100, 50, 30);
        Personagem p2 = new Personagem("Arqueiro", 80, 40, 25);
        Personagem p3 = new Personagem("Mago", 70, 30, 35);
        Personagem p4 = new Personagem("Cavaleiro", 120, 60, 20);
        Personagem p5 = new Personagem("Assassino", 90, 45, 40);
        Personagem p6 = new Personagem("Clérigo", 85, 35, 15);
        Personagem p7 = new Personagem("Bárbaro", 110, 55, 25);
        Personagem p8 = new Personagem("Paladino", 95, 50, 30);

        // Adicionando 4 personagens aos aliados
        campo.inserirAliado(p1);
        campo.inserirAliado(p2);
        campo.inserirAliado(p3);
        campo.inserirAliado(p4);

        // Adicionando 4 personagens aos inimigos
        campo.inserirInimigo(p5);
        campo.inserirInimigo(p6);
        campo.inserirInimigo(p7);
        campo.inserirInimigo(p8);

        // Iniciando a batalha
        Batalha batalha = new Batalha(campo);
        batalha.iniciar();
    }
}
