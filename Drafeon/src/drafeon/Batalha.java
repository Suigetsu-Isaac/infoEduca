package drafeon;

import java.util.ArrayList;

public class Batalha {
    private CampoDeBatalha campo;
    private Iniciativa iniciativa;

    public Batalha(CampoDeBatalha campo) {
        this.campo = campo;
        this.iniciativa = new Iniciativa(campo.getAliados(), campo.getInimigos());

        //instancia a classe campo de batalha (grupo de 3 aliádos e 3 inimigos)
        //instancia a classe iniciativa (ordem dos turnos)
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
        Personagem p1 = new Personagem("Guerreiro", 3, 50, 30);
        Personagem p2 = new Personagem("Arqueiro", 2, 40, 25);
        Personagem p3 = new Personagem("Mago", 2, 30, 35);
        Personagem p4 = new Personagem("Cavaleiro", 3, 60, 20);
        Personagem p5 = new Personagem("Assassino", 3, 45, 40);
        Personagem p6 = new Personagem("Clérigo", 3, 35, 15);
        

        // Adicionando 3 personagens aos aliados
        campo.inserirAliado(p1);
        campo.inserirAliado(p2);
        campo.inserirAliado(p3);
        
        // Adicionando 3 personagens aos inimigos
        campo.inserirInimigo(p4);
        campo.inserirInimigo(p5);
        campo.inserirInimigo(p6);
        
        // Iniciando a batalha
        Batalha batalha = new Batalha(campo);
        batalha.iniciar();
    }
}
