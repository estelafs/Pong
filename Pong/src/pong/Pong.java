/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.*;

/**
 *
 * @author estel
 */
public class Pong {
    static final int  ALTURA = 600;
    static final int LARGURA = 800;
    
    private Pong()
    {
    JFrame janela = new JFrame("P I N G   P O N G");
    janela.setSize(LARGURA, ALTURA);
    janela.setVisible(true);
    
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
