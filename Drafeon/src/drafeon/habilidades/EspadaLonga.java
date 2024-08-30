package drafeon.habilidades;

import drafeon.Personagem;

public class EspadaLonga {
    
    private String cortelaminaraNome = "Corte Lâminar";
    private String cortelaminaraDescricao = "Desfere um poderoso ataque cortante em um alvo, causando " + ATK + "de dano. Custo: 1 de ataque";
    
    public EspadaLonga(){
    
    }
    
    public String cortelaminar(Personagem alvo, int ATK){
        String mensagem = "algo deu errado";
        if (alvo.getDEF() >= 1) {
            alvo.setDEF(alvo.getDEF() - ATK);
            if (alvo.getDEF() < 0) {
                alvo.setHP(alvo.getHP() - 1);
                alvo.setDEF(0);
                mensagem = alvo.getNome() + " é acertado, recebendo " + 1 + " de dano ao seu HP";
            }
            mensagem = alvo.getNome() + " bloqueia gastando " + ATK + " de defesa";
        } else if (alvo.getDEF() <= 0) {
            alvo.setHP(alvo.getHP() - 1);
            System.out.println(alvo.getNome() + " é acertado, recebendo " + 1 + " de dano \n");
        }
    return mensagem;
    }
    }
