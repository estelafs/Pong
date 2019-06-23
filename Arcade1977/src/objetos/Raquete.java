
package objetos;

import principal.Framework;

/**
 *
 * @author estel
 */
public class Raquete {
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
    
    /*A string r diz se é a raqueta da esquerda ou a da direita */
    public Raquete(String r) {
        velocidade = 10;
        altura = 150;
        largura = 10;
        y_pos = (Framework.altura / 2) - (altura / 2); //no centro

        if(r.equals("esquerda")){
            x_pos = 10;
        }
        if(r.equals("direita")){
            x_pos = Framework.largura - 25;
        }
    }

    public void moveCima(){
        if(y_pos > 0)
            y_pos -= velocidade;
    }

    public void moveBaixo(){
        if(y_pos < (Framework.altura - altura))
            y_pos += velocidade;
    }
}
