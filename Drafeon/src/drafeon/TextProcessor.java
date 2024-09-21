import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextProcessor {
    private JTextField inputField;
    private JLabel displayLabel;
    private JButton actionButton;

    public TextProcessor() {
        // Configurações da janela
        JFrame frame = new JFrame("Processador de Texto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Campo de entrada de texto
        inputField = new JTextField(20);

        // Label para exibir o resultado
        displayLabel = new JLabel("Digite algo no campo acima e clique no botão.");

        // Botão para processar a entrada
        actionButton = new JButton("Executar");
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processInput();
            }
        });

        // Painel principal
        JPanel panel = new JPanel();
        panel.add(inputField);
        panel.add(actionButton);
        panel.add(displayLabel);

        // Adiciona o painel ao frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // Método para processar o texto inserido
    private void processInput() {
        String input = inputField.getText().toLowerCase();  // Converte o texto para minúsculo para facilitar comparações

        switch (input) {
            case "ajuda":
                displayLabel.setText("Tela de Ajuda: Aqui estão as instruções...");
                break;
            case "guerreiro ataca mago":
                displayLabel.setText("Guerreiro ataca o Mago! O Mago perde 10 pontos de vida.");
                break;
            default:
                displayLabel.setText("Comando não reconhecido. Tente novamente.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextProcessor::new);
    }
}