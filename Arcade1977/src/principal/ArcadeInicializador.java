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
    
    protected int  altura = 600;
    protected int largura = 800;
    
    public ArcadeInicializador(String modo, String tipo, String dificuldade,String velocidade){
        this.dificuldade_jogo = dificuldade;
        this.tipo_jogo = tipo;
        this.velocidade_jogo = velocidade;
        
//        setDificuldade();
//        setVelocidade();
//        iniciaModo();
        
        
        
        
        
        JFrame janela  = new JFrame("A R C A D E   1 9 7 7");
        janela.setSize(largura,altura);
        
//        if(modo.equals("Jogo"))
//            Jogo novo = new Jogo(tipo, dificuldade, velocidade);
//        
//        else if(modo.equals("Treino"))
//            Treino novo = new Treino(tipo, dificuldade, velocidade);
//        
        JogoPainel novo = new FutebolPainel(95, 4, 4, 0, 0);
        janela.add(novo);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

    
    }

    public void setDificuldade(){
            switch (tipo_jogo){
            case "Dificil":
                this.dificuldade_int = 15;
                break;
            case "Medio":
                this.dificuldade_int = 95;
                break;
            case "Facil":
                this.dificuldade_int = 150;
                break;                     
        }
    }

    public void setVelocidade(){
        switch (velocidade_jogo) {
            case "Baixa":
                this.dificuldade_int = 4;
                break;
            case "Media":
                this.dificuldade_int = 6;
                break;
            case "Alta":
                this.dificuldade_int = 8;
                break;
            case "Crescente":
                this.dificuldade_int = 8; //// O QUE POR AQUI
                break;
        }
    }
//    
//    public void iniciaModo(){
//        switch(modo_jogo){
//            case "Jogo":
//                ModoJogo novo = new ModoJogo(tipo_jogo,dificuldade_int,velocidade_int);
//                
//                break;
//            case "Treino":
//                Treino novo1 = new Treino(tipo_jogo,dificuldade_int,velocidade_int);
//                break;
//        }
//    }
    
    
    




}
