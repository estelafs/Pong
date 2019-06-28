package objetos;

import principal.ArcadeFramework;

public class Jogadores {
    private int altura;
    private int largura;
    private int x_pos;
    private int y_pos;
    private int velocidade;
    
    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }
    
    /*A string r diz se é o jogador da esquerda ou o da direita */
    public Jogadores(String j, int y) {
        velocidade = 3;
        altura = 50;
        largura = 20;         

        if(j.equals("esquerda")){
            x_pos = 260;     
            y_pos = y;  
        }
        if(j.equals("direita")){
            x_pos = 520;
            y_pos = y;
        }
    }

    public void move(){
        y_pos += velocidade;
    }

    public void inverte_velocidade(){
        velocidade = -velocidade;
    }
}
