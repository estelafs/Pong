package principal;

import jogos.*;
import javax.swing.*;

public class ArcadeInicializador {
    protected String modo_jogo;
    protected String tipo_jogo;
    protected String dificuldade_jogo;
    protected String velocidade_jogo;

    protected int dificuldade_int;
    protected int velocidade_int;
    protected int aceleracao;
    
    protected int  altura = 600;
    protected int largura = 800;
    
    public ArcadeInicializador(String modo, String tipo, String dificuldade,String velocidade){
        this.modo_jogo = modo;
        this.dificuldade_jogo = dificuldade;
        this.tipo_jogo = tipo;
        this.velocidade_jogo = velocidade;

        setDificuldade();
        setVelocidade();

        JFrame janela = new JFrame("A R C A D E   1 9 7 7");
        janela.setSize(largura, altura);

        JogoPainel novo = iniciaModo();
        janela.add(novo);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }

    public void setDificuldade(){
            switch (dificuldade_jogo){
            case "Dificil":
                this.dificuldade_int = 40;
                break;
            case "Medio":
                this.dificuldade_int = 100;
                break;
            case "Facil":
                this.dificuldade_int = 150;
                break;                     
        }
    }

    public void setVelocidade(){
        switch (velocidade_jogo) {
            case "Baixa":
                this.velocidade_int = 2;
                break;
            case "Media":
                this.velocidade_int = 4;
                break;
            case "Alta":
                this.velocidade_int = 6;
                break;
            case "Crescente":
                this.velocidade_int = 2;
                this.aceleracao = 1;
                break;
        }
    }
//    
    public JogoPainel iniciaModo() {
        // Definindo o tipo de jogo e criando-o
        switch (tipo_jogo) {
            case "Futebol":
                JogoPainel novo = new FutebolPainel(modo_jogo, dificuldade_int, velocidade_int, velocidade_int, aceleracao);
                return novo;
            case "Tenis":
                JogoPainel novo2 = new TenisPainel(modo_jogo, dificuldade_int, velocidade_int, velocidade_int, aceleracao);
                return novo2;
            case "Paredao":
                JogoPainel novo3 = new ParedaoPainel(modo_jogo, dificuldade_int, velocidade_int, velocidade_int, aceleracao);
                return novo3;                    
        }
        return null;
    }
}
