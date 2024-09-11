package drafeon;

import java.util.ArrayList;

public class Interpretador {

    // Método que processa a string
    public Interpretador(String input) {
        String palavra1 = "";
        String palavra2 = "";
        String palavra3 = "";
        int quantidadeDePalavras = 0;
        Personagem objPersonagem;

        //verificar quantos espaos vazios tem no input para definir quantidade de palavras através de um if
        // Remove espaços em excesso e divide a string por espaços e vírgulas
        String[] palavras = input.split("[,\\s]+");

//ABAIXO VERIFICAR QUANTIDADE DE PALAVRES
        // Exibir o número de palavras
        quantidadeDePalavras = palavras.length;
        System.out.println("Número de palavras: " + quantidadeDePalavras);

        // Armazena as palavras em variáveis
        if (quantidadeDePalavras == 1) {
            palavra1 = palavras.length > 0 ? palavras[0] : "";
        } else if (quantidadeDePalavras == 2) {
            palavra1 = palavras.length > 0 ? palavras[0] : "";
            palavra2 = palavras.length > 1 ? palavras[1] : "";
        } else if (3 == quantidadeDePalavras) {
            palavra1 = palavras.length > 0 ? palavras[0] : "";
            palavra2 = palavras.length > 1 ? palavras[1] : "";
            palavra3 = palavras.length > 2 ? palavras[2] : "";
        } else {
            //retorna mensagem de erro
        }

        //designa ação baseada no comando passado pelo jogador
        if (quantidadeDePalavras == 1) {
            //chama todos os métodos chamados por uma palavra
            if (palavra1 == "ajuda" || palavra1 == "help") {
                ajuda();
            }

        } else if (quantidadeDePalavras == 2) {

            //chama todos os métodos chamados por duas palavras
        } else if (quantidadeDePalavras == 3) {
            if (palavra1 == "listar") {
                //Object resposta = verificarPersonagem(palavra2,);
                //if ("" == ""){

                //}
                //return listarHabilidades(personagem da palavra2);
            }

            //chama todos os métodos chamados por uma palavra
        } else {
            //mensagem de erro
        }
    }

    //Método que verifica se o alvo é válido o e retorna:
    public Object verificarPersonagem(String alvo, ArrayList<Personagem> personagens) {
        //tri catchs que verificam se um alvo é válido
        for (Personagem personagem : personagens) {
            if (personagem.getNome().equalsIgnoreCase(alvo)) {
                return personagem;//.getNome();

            }

        }
        return "ERROR";
    }
   //tirar essa negócio de estático 
   public static Personagem buscarPersonagemPorNome(CampoDeBatalha campoDeBatalha, String nome) {
        // Verificar nos aliados
        for (Personagem aliado : campoDeBatalha.getAliados()) {
            if (aliado.getNome().equalsIgnoreCase(nome)) {
                return aliado;
            }
        }
        
        // Verificar nos inimigos
        for (Personagem inimigo : campoDeBatalha.getInimigos()) {
            if (inimigo.getNome().equalsIgnoreCase(nome)) {
                return inimigo;
            }
        }
        
        // Se não encontrar nenhum personagem com o nome especificado
        return null;
    }

    public String listarHabilidades(Personagem agente) {
        String mensagem;
        mensagem = "habilidade 1: " + agente.retornaHabilidade(0) + "\nhabilidade 2: " + agente.retornaHabilidade(1) + "\nhabilidade 3: " + agente.retornaHabilidade(2);

        return mensagem;
    }

    public String chamacortelaminar(String alvo, String agente, String acao) {
        

        //verifica se
        return "foi deu certo";
    }

    public String verificarAcao(String acao) {
        if (true) {

        }
        return "ERROR!";
    }

    public boolean verificaHabilidade(Personagem agente, String habilidadeDesejada) {
    ArrayList<String> habilidades = agente.getHabilidades();

    for (String habilidade : habilidades) {
        if (habilidade.equalsIgnoreCase(habilidadeDesejada)) {
            return true;
        }
    }
        return false; // Se chegou até aqui, a habilidade não foi encontrada
    }


    //a seguir, método chamados por uma só palavra:
    public String ajuda() {
        return "texto de ajuda";
    }

    public String sair() {
        //cria janela de confirmação na tela
        //alterna para a tela do menu inicial
        return "Saindo";
    }

    public String verStatus() {
        return "adicionar retorno";
    }

}
