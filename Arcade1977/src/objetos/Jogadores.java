package objetos;

import principal.Framework;

/**
 *
 * @author estel
 */
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
    public Jogadores(String j, int tamanho, int y) {
        velocidade = 10;
        altura = tamanho;
        largura = 10;   
        

        if(j.equals("esquerda")){
            x_pos = 260;     
            y_pos = y;
            
        }
        if(j.equals("direita")){
            x_pos = 520;
            y_pos = y;
        }
    }

//    public void moveCima(){
//        if(y_pos > 0)
//            y_pos -= velocidade;
//    }
//
//    public void moveBaixo(){
//        if(y_pos < (Framework.altura - altura))
//            y_pos += velocidade;
//    }

    public void move(){
        if(y_pos <= 0 || y_pos >= 520)
            velocidade = - velocidade;
        
        y_pos += velocidade;
    }
}
