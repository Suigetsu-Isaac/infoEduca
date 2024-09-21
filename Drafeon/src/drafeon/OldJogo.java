package drafeon;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import java.util.ArrayList;
import java.util.*;

public class Jogo extends JFrame {

    private JPanel painelPrincipal;
    private JPanel painelCreditos;
    private JPanel painelJogo;
    private CardLayout cardLayout;
    private JLabel textoCreditos;
    private JLabel textoJogo;
    private JTextField inputJogo;
    private JButton botaoJogo;
    private boolean batalhaEmAndamento = true;
    private boolean ataqueRealizado = false;
    public Jogo() {
         // Carregar e registrar a fonte personalizada
        carregarFontePersonalizada();

        // Configurações da janela
        setTitle("JOGO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(400, 350);
        // Usando CardLayout para gerenciar múltiplas telas
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Criando o painel principal
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());

        // Configurações de estilo
        painelPrincipal.setBackground(Color.BLACK);

        // Adicionando o título
        JLabel titulo = new JLabel("Título do Jogo", SwingConstants.CENTER);
        titulo.setFont(obterFonte("VCR_OSD_MONO_1.001", Font.BOLD, 24)); // Aplica a fonte personalizada
        titulo.setForeground(Color.WHITE);
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        // Criando os botões
        JButton botaoIniciar = criarBotao("Iniciar Jogo");
        JButton botaoCreditos = criarBotao("Créditos");
        JButton botaoSair = criarBotao("Sair");
        this.botaoJogo = criarBotao("Enviar");
        // Adicionando os botões ao painel em orientação vertical
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 1, 10, 10)); // Grade com 3 linhas e espaçamento de 10px
        painelBotoes.setBackground(Color.BLACK);
        painelBotoes.add(botaoIniciar);
        painelBotoes.add(botaoCreditos);
        painelBotoes.add(botaoSair);

        // Criando um painel para centralizar os botões horizontalmente
        JPanel painelCentral = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelCentral.setBackground(Color.BLACK);
        painelCentral.add(painelBotoes);

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);

        // Adicionando ações aos botões
        botaoIniciar.addActionListener(e -> iniciarJogo());
        botaoCreditos.addActionListener(e -> iniciarAnimacaoCreditos());
        botaoSair.addActionListener(e -> System.exit(0));

        // Criando o painel de créditos
        painelCreditos = new JPanel();
        painelCreditos.setLayout(new BorderLayout());
        painelCreditos.setBackground(Color.BLACK);

        // Adicionando o texto de créditos
        textoCreditos = new JLabel("", SwingConstants.CENTER);
        textoCreditos.setFont(obterFonte("VCR_OSD_MONO_1.001", Font.BOLD, 16)); // Aplica a fonte personalizada inicialmente
        textoCreditos.setForeground(Color.WHITE);
        painelCreditos.add(textoCreditos, BorderLayout.CENTER);
        
        inputJogo = new JTextField(ALLBITS);
        
        painelJogo = new JPanel();
        painelJogo.setLayout(new BorderLayout());
        painelJogo.setBackground(Color.BLACK);
        
        textoJogo = new JLabel("", SwingConstants.CENTER);
        textoJogo.setFont(obterFonte("VCR_OSD_MONO_1.001", Font.BOLD, 16)); // Aplica a fonte personalizada inicialmente
        textoJogo.setForeground(Color.WHITE);
        painelJogo.add(textoJogo, BorderLayout.CENTER);
        JPanel div = new JPanel();
        div.setLayout(new FlowLayout());
        div.add(inputJogo);
        div.add(botaoJogo);
        painelJogo.add(div,BorderLayout.SOUTH);
        
        // Adicionando Painéis ao CardLayout
        add(painelPrincipal, "Principal");
        add(painelCreditos, "Creditos");
        add(painelJogo,"Jogo");
        // Tornando a janela visível
        setVisible(true);

        // Iniciar a animação de créditos ao iniciar o jogo
        iniciarAnimacaoCreditos();
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.setPreferredSize(new Dimension(200, 40));
        botao.setFont(obterFonte("VCR_OSD_MONO_1.001", Font.BOLD, 16)); // Aplica a fonte personalizada
        botao.setForeground(Color.WHITE);
        botao.setBackground(new Color(70, 70, 70)); // Cor de fundo que se destaca do preto e do branco
        botao.setFocusPainted(false);
        return botao;
    }

    private void iniciarAnimacaoCreditos() {
        cardLayout.show(getContentPane(), "Creditos");

        // Primeiro texto
        textoCreditos.setFont(obterFonte("VCR_OSD_MONO_1.001", Font.BOLD, 16)); // Aplica a fonte personalizada inicialmente
       
        textoCreditos.setText("<html><div style='margin: 0 auto; display:block;'><p style='text-align:center; '>Este jogo foi desenvolvido para a disciplina de Informática na Educação do curso de Sistemas para Internet do IF Sertão Campus Salgueiro.</p></div></html>");

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Thread.sleep(100); // Espera 3 segundos
                for (int i = 0; i <= 100; i++) {
                    final float alpha = i / 100f;
                    SwingUtilities.invokeLater(() -> painelCreditos.setForeground(new Color(0, 0, 0, alpha)));
                    Thread.sleep(20);
                }
                textoCreditos.setText("<html><p style='text-align:center; margin: 0 auto;'>Desenvolvido por Helder Manoel Sobreira Dos Santos, Walla Nascimento de Sousa, Daniel Antônio Da Silva e Isaac Antonio Alves Souza</p></html>");
                for (int i = 0; i <= 100; i++) {
                    final float alpha = i / 100f;
                    SwingUtilities.invokeLater(() -> painelCreditos.setForeground(new Color(0, 0, 0, alpha)));
                    Thread.sleep(20);
                }
                Thread.sleep(100); // Espera mais 3 segundos
                for (int i = 0; i <= 100; i++) {
                    final float alpha = i / 100f;
                    SwingUtilities.invokeLater(() -> painelCreditos.setForeground(new Color(0, 0, 0, alpha)));
                    Thread.sleep(20);
                }
                textoCreditos.setFont(obterFonte("VCR_OSD_MONO_1.001", Font.PLAIN, 5)); // Aplica a fonte personalizada inicialmente
       
                textoCreditos.setText("<html><pre>                                                                                     \n" +
"                                              MMMMMMMMMMMM    mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            MMMMMMMMMMMMMMMM  mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            MMMMMMMMMMMMMMMM  mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            MMMMMMMMMMMMMMMM  mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            MMMMMMMMMMMMMMMM  mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            MMMMMMMMMMMMMMMM  mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                              MMMMMMMMMMMM    mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                                ..MMMM--                                                                                    \n" +
"                                                                                                                                            \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            ..------------      --------------                                                              \n" +
"                                                                                                                                            \n" +
"                                            mmmmmmmmmmmmmmmm  --mmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmmmm                                          \n" +
"                                            mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmm    mmmmmmmmmmmmmm--                                          \n" +
"                                                                                                                                            \n" +
"                                            mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm  mmmmmmmmmmmmmmmm                                                              \n" +
"                                            mmmmmmmmmmmmmmmm    mmmmmmmmmmmmmm"
                        + "</pre></html>");
                for (int i = 0; i <= 100; i++) {
                    final float alpha = i / 100f;
                    SwingUtilities.invokeLater(() -> painelCreditos.setForeground(new Color(0, 0, 0, alpha)));
                    Thread.sleep(20);
                }
                Thread.sleep(100); // Espera mais 3 segundos
                return null;
            }

            @Override
            protected void done() {
                mostrarTelaPrincipal();
            }
        }.execute();
    }

    protected void mostrarTelaPrincipal() {
        cardLayout.show(getContentPane(), "Principal");
    }
    

    // tela da batalha-----------------------------------------------------------------------------------------------------
        private void iniciarJogo(){ 
        cardLayout.show(getContentPane(), "Jogo");
         SwingWorker<Void, String> batalhaWorker = new SwingWorker<Void, String>() {

            @Override
            protected Void doInBackground() throws Exception {
                boolean fimDeJogo = false;
                while (!fimDeJogo) { 
                    
                    

                }


                while (batalhaEmAndamento) {
                    
                    

                    // Verifica se a batalha terminou
                    if (verificarTodosMortos(CampoDeBatalha.getInimigos())) {
                        publish(formatarResultado("Aliados"));
                        batalhaEmAndamento = false;
                        break; // Sai do loop de batalha
                    } else if (verificarTodosMortos(CampoDeBatalha.getAliados())) {
                        publish(formatarResultado("Inimigos"));
                        batalhaEmAndamento = false;
                        break; // Sai do loop de batalha
                    }

                    Personagem atual = Iniciativa.getAtual();  // Pega o personagem atual

                    if (atual.getHP() > 0) {  // Só age se o personagem estiver vivo
                        // Filtra os alvos para exibir apenas personagens vivos
                        ArrayList<Personagem> alvosVivos = obterAlvosVivos(
                            CampoDeBatalha.getAliados().contains(atual) ? CampoDeBatalha.getInimigos() : CampoDeBatalha.getAliados()
                        );

                        // Mostra os personagens vivos disponíveis para ataque
                        publish(atual.mostrarPersonagens(alvosVivos));

                        // Aguardando até que o ataque seja realizado
                        synchronized (this) {
                            while (!this.ataqueRealizado) {
                                wait();  // Pausa o loop até o ataque ser realizado
                            }
                        }

                        // Após o ataque, mostra o status de todos os personagens para debug
                        mostrarStatusTodosPersonagens();  // Exibe o status de todos os personagens no console

                        // Após o ataque, avança para o próximo personagem
                        this.ataqueRealizado = false;
                        Iniciativa.proximo();
                    } else {
                        // Se o personagem atual estiver morto, pula para o próximo
                        Iniciativa.proximo();
                    }

                    Thread.sleep(500);  // Adiciona um pequeno atraso para evitar loops rápidos demais
                }

                return null;
            }

            @Override
            protected void process(List<String> chunks) {
                for (String texto : chunks) {
                    textoJogo.setText(texto);  // Atualiza a interface gráfica
                }
            }

            @Override
            protected void done() {
                // Mensagem de batalha finalizada
                String mensagemFinalizacao = "Batalha finalizada!";

                // Adiciona a lista de sobreviventes após a mensagem de finalização
                String sobreviventes = mostrarSobreviventes();
                
                // Exibe a mensagem de finalização e os sobreviventes
                textoJogo.setText("<html><body>" + mensagemFinalizacao + sobreviventes + "</body></html>");
                
                
            }
        };
            // Configura o botão de ataque para realizar a ação
        botaoJogo.addActionListener(e -> {
            Personagem atual = Iniciativa.getAtual();  // Pega o personagem atual
            ArrayList<Personagem> alvosVivos = obterAlvosVivos(
                CampoDeBatalha.getAliados().contains(atual) ? CampoDeBatalha.getInimigos() : CampoDeBatalha.getAliados()
            );

            // Realiza o ataque
           

            // Notifica a thread que o ataque foi realizado
            synchronized (batalhaWorker) {
                ataqueRealizado = true;
                batalhaWorker.notify();  // Continua o loop da batalha
            }
        });
    }

    


    // Método para verificar se todos os personagens de um time estão mortos
    private boolean verificarTodosMortos(ArrayList<Personagem> personagens) {
        for (Personagem personagem : personagens) {
            if (personagem.getHP() > 0) {
                return false;  // Se ao menos um personagem está vivo, retorna falso
            }
        }
        return true;  // Se todos estão mortos, retorna verdadeiro
    }

    // Método para formatar o resultado final da batalha
    private String formatarResultado(String vencedor) {
        String resultado = "<p>O time vencedor é: " + vencedor + "</p>";
        resultado += mostrarSobreviventes();
        return "<html><body>" + resultado + "</body></html>";
    }

    // Método para mostrar sobreviventes
    private String mostrarSobreviventes() {
        StringBuilder sobreviventes = new StringBuilder("<p>Personagens sobreviventes:</p>");

        for (Personagem aliado : CampoDeBatalha.getAliados()) {
            if (aliado.getHP() > 0) {
                sobreviventes.append("<p>Aliado: ").append(aliado.getNome()).append("</p>");
            }
        }

        for (Personagem inimigo : CampoDeBatalha.getInimigos()) {
            if (inimigo.getHP() > 0) {
                sobreviventes.append("<p>Inimigo: ").append(inimigo.getNome()).append("</p>");
            }
        }

        return sobreviventes.toString();
    }

    // Método para mostrar o status de todos os personagens (debug)
    private void mostrarStatusTodosPersonagens() {
        System.out.println("Status dos Aliados:");
        for (Personagem aliado : CampoDeBatalha.getAliados()) {
            aliado.mostrarStatus();  // Chama o método mostrarStatus() de cada aliado
        }

        System.out.println("Status dos Inimigos:");
        for (Personagem inimigo : CampoDeBatalha.getInimigos()) {
            inimigo.mostrarStatus();  // Chama o método mostrarStatus() de cada inimigo
        }
    }

    // Método para obter os alvos vivos
    private ArrayList<Personagem> obterAlvosVivos(ArrayList<Personagem> personagens) {
        ArrayList<Personagem> alvosVivos = new ArrayList<>();

        for (Personagem personagem : personagens) {
            if (personagem.getHP() > 0) {  // Verifica se o personagem ainda está vivo
                alvosVivos.add(personagem);
            }
        }

        return alvosVivos;  // Retorna apenas os personagens vivos
    }
    private Font obterFonte(String nomeFonte, int estilo, int tamanho) {
        try {
            // Tenta carregar a fonte personalizada
            InputStream fonteStream = getClass().getClassLoader().getResourceAsStream("resources/" + nomeFonte + ".ttf");
            if (fonteStream == null) {
                throw new IOException("Fonte não encontrada");
            }
            Font fonte = Font.createFont(Font.TRUETYPE_FONT, fonteStream);
            return fonte.deriveFont(estilo, tamanho);
        } catch (Exception e) {
            e.printStackTrace();
            // Caso a fonte não possa ser carregada, usa a fonte padrão
            return new Font("Sans Serif", estilo, tamanho);
        }
    }

    private void carregarFontePersonalizada() {
        try {
            InputStream fonteStream = getClass().getClassLoader().getResourceAsStream("resources/VCR_OSD_MONO_1.001.ttf");
            if (fonteStream == null) {
                throw new IOException("Fonte não encontrada");
            }
            Font fonte = Font.createFont(Font.TRUETYPE_FONT, fonteStream);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fonte.deriveFont(16f)); // Registra a fonte com um tamanho padrão
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
           
        
        new Jogo();
    }
}
