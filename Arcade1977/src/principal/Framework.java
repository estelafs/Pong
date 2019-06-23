/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;
import jogos.*;
import javax.swing.*;

/**
 *
 * @author estel
 */
public class Framework {
    static final public int altura = 600;
    static final public int largura = 800;
        private FutebolPanel panel;


    private Framework()
    {
    JFrame janela = new JFrame("A R C A D E   1 9 7 7");
    janela.setSize(largura, altura);
    janela.setVisible(true);
    panel = new FutebolPanel(25, 4, 4, 10, 0, 0);
    janela.add(panel);
    janela.setResizable(false);
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    janela.setVisible(true);

    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            //@Override
            public void run() {
                new Framework();
            }
        });
    }
}
