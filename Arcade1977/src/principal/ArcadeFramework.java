package principal;

import jogos.*;
import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 
import javax.swing.border.EmptyBorder;

public class ArcadeFramework extends JFrame {
    public static int largura = 800;
    public static int altura = 600;
  
    private JPanel contentPane;
    

    public ArcadeFramework() {
        JFrame janela = new JFrame("A R C A D E   1 9 7 7");    
        janela.setVisible(true);
        janela.setBackground(Color.MAGENTA);
        janela.setForeground(Color.BLUE);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 153, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] opcoesmodo = {"Jogo","Treino"};
        JComboBox comboBox = new JComboBox(opcoesmodo);
        comboBox.setSelectedIndex(-1);
        comboBox.setBackground(new Color(255, 255, 255));
        comboBox.setBounds(226, 59, 121, 27);
        contentPane.add(comboBox);

        JLabel lblModoDeJogo = new JLabel("Modo de Jogo");
        lblModoDeJogo.setBounds(104, 59, 97, 27);
        contentPane.add(lblModoDeJogo);

        JLabel lblTipoDeJogo = new JLabel("Tipo de Jogo");
        lblTipoDeJogo.setBounds(104, 103, 84, 14);
        contentPane.add(lblTipoDeJogo);

        String[] opcoestipo = {"Futebol", "Tenis", "Paredao"};
        JComboBox comboBox_1 = new JComboBox(opcoestipo);
        comboBox_1.setBackground(new Color(255, 255, 255));
        comboBox_1.setBounds(226, 97, 121, 27);
        comboBox_1.setSelectedIndex(-1);
        contentPane.add(comboBox_1);

        JLabel lblDificuldade = new JLabel("Dificuldade");
        lblDificuldade.setBounds(104, 142, 74, 14);
        contentPane.add(lblDificuldade);

        String[] opcoesdif = {"Facil", "Medio", "Dificil"};
        JComboBox comboBox_2 = new JComboBox(opcoesdif);
        comboBox_2.setBackground(new Color(255, 255, 255));
        comboBox_2.setBounds(226, 136, 121, 27);
        comboBox_2.setSelectedIndex(-1);
        contentPane.add(comboBox_2);

        JLabel lblVelocidade = new JLabel("Velocidade");
        lblVelocidade.setBounds(104, 180, 74, 14);
        contentPane.add(lblVelocidade);

        String[] opcoesvel = {"Baixa", "Media", "Alta","Crescente"};
        JComboBox comboBox_3 = new JComboBox(opcoesvel);
        comboBox_3.setBackground(new Color(255, 255, 255));
        comboBox_3.setBounds(226, 174, 121, 27);
        comboBox_3.setSelectedIndex(-1);
        contentPane.add(comboBox_3);

        JLabel lblBemvindoAoArcade = new JLabel("Bem-vindo ao Arcade 1977!");
        lblBemvindoAoArcade.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblBemvindoAoArcade.setBounds(126, 11, 202, 27);
        contentPane.add(lblBemvindoAoArcade);

        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setForeground(new Color(255, 255, 255));
        btnIniciar.setBackground(new Color(153, 0, 204));
        btnIniciar.setBounds(169, 227, 89, 23);
        contentPane.add(btnIniciar);

        btnIniciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                String modo = comboBox.getSelectedItem().toString();
                String tipo = comboBox_1.getSelectedItem().toString();
                String dificuldade = comboBox_2.getSelectedItem().toString();
                String velocidade = comboBox_3.getSelectedItem().toString();
                janela.dispose();
                ArcadeInicializador novoJogo = new ArcadeInicializador(modo, tipo,  dificuldade, velocidade);
            }
        });  

        janela.add(contentPane);
}

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            //@Override
            public void run() {
                ArcadeFramework janela = new ArcadeFramework();
                
                
                
            }
        });
    }
}
