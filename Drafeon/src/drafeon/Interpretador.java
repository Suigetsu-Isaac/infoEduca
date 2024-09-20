package drafeon;

import java.util.ArrayList;

public class Interpretador {
    String mensagem = "000";
    // Método que processa a string
    public Interpretador(String input, ArrayList<Personagem> aliados, ArrayList<Personagem> inimigos) {
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
if (palavra2.equalsIgnoreCase("boladefogo")){
    this.mensagem = chamaBoladefogo(palavra1, palavra2, aliados, inimigos);
}
            //chama todos os métodos chamados por três palavras
        } else if (quantidadeDePalavras == 3) {
            if (palavra2.equalsIgnoreCase("cortelaminar")) {
                this.mensagem = chamaCorteLaminar(palavra1, palavra3, palavra2, aliados, inimigos);
            
            }else if (palavra2.equalsIgnoreCase("recuperacao")) {
                this.mensagem = chamaRecuperacao(palavra1, palavra3, palavra2, aliados, inimigos);
            

        } else {
            this.mensagem = "deu ruim";
        }
    }
    }

    public String retornaMensagem(){
        return this.mensagem;
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

//Método para acionar o corte laminar
    public String chamaCorteLaminar(String agent, String target, String skill, ArrayList<Personagem> aliados, ArrayList<Personagem> inimigos) {
        Object agente;
        Object alvo;
        agente = verificarPersonagem(agent, aliados);
        alvo = verificarPersonagem(target, inimigos); 
        try {
            boolean verificador = verificaHabilidade((Personagem)agente, skill);
            if(verificador == true){
                    String ataque = Habilidades.cortelaminar((Personagem)agente, (Personagem)alvo); 
                     
                return ataque;
            }else{
                return "comando inválido, tente novamente";
            }
        }catch(Exception e){
            return "deu erro tente novamente";
        }
    }

//Método para acionar recupera ação
public String chamaRecuperacao(String agent, String target, String skill, ArrayList<Personagem> aliados, ArrayList<Personagem> inimigos) {
        Object agente;
        Object alvo;
        agente = verificarPersonagem(agent, aliados);
        alvo = verificarPersonagem(agent, inimigos);
        try {
            boolean verificador = verificaHabilidade((Personagem)agente, skill);
            if(verificador == true){
                    String ataque = Habilidades.recuperacao((Personagem)agente, (Personagem)alvo); 
                     
                return ataque;
            }else{
                return "comando inválido, tente novamente";
            }
        }catch(Exception e){
            return "deu erro tente novamente";
        }
    }

    public String chamaBoladefogo(String agent, String skill, ArrayList<Personagem> aliados, ArrayList<Personagem> inimigos) {
        Object agente;
        
        agente = verificarPersonagem(agent, aliados);
        
        try {
            boolean verificador = verificaHabilidade((Personagem)agente, skill);
            if(verificador == true){
                    String ataque = Habilidades.boladefogo((Personagem)agente, inimigos); 
                     
                return ataque;
            }else{
                return "comando inválido, tente novamente";
            }
        }catch(Exception e){
            return "deu erro tente novamente";
        }
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
        return "cortelaminar:  \n boladefogo: \n recuperacao: \n Ajuda ou help: Lista todos os comandos \n Sair ou retornar: SRetorna ao menu inicial \n";
    
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
