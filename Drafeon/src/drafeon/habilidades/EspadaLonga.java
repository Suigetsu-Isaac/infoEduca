package drafeon.habilidades;

import drafeon.Personagem;

public class EspadaLonga {

    private String cortelaminaraNome;
    private String cortelaminaraDescricao;

    public String getCortelaminaraNome() {
        return cortelaminaraNome;
    }

    public void setCortelaminaraNome(String cortelaminaraNome) {
        this.cortelaminaraNome = cortelaminaraNome;
    }

    public String getCortelaminaraDescricao() {
        return cortelaminaraDescricao;
    }

    public void setCortelaminaraDescricao(String cortelaminaraDescricao) {
        this.cortelaminaraDescricao = cortelaminaraDescricao;
    }

    public String cortelaminar(Personagem alvo) {
        String mensagem = "algo deu errado";
        if (alvo.getDEF() >= 1) {
            alvo.setDEF(alvo.getDEF() - 2);
            mensagem = alvo.getNome() + " bloqueia gastando " + 2 + " de defesa";
            if (alvo.getDEF() < 0) {
                alvo.setHP(alvo.getHP() - 1);
                alvo.setDEF(0);
                mensagem = alvo.getNome() + " é acertado, recebendo " + 1 + " de dano ao seu HP";
            }
        } else if (alvo.getDEF() <= 0) {
            alvo.setHP(alvo.getHP() - 1);
            mensagem = alvo.getNome() + " é acertado, recebendo " + 2 + " de dano";
        }
        return mensagem;
    }

    public String corteLaminarDesc(int ATK) {
        cortelaminaraDescricao = "Desfere um poderoso ataque cortante em um alvo, causando " + ATK + "de dano. Custo: 1 de ataque";
        return cortelaminaraDescricao;
    }
}
