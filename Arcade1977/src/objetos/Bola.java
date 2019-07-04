package objetos;

import principal.Arcade1977;
import java.util.Random;

public class Bola {
    public int x_pos;
    public int y_pos;
    public int x_vel;
    public int y_vel;
    public int diametro;
    public int aceleracao;

    public Bola (int x_vel, int y_vel, int aceleracao){
        this.x_pos = Arcade1977.largura/2;
        this.y_pos = Arcade1977.altura/2;
        this.x_vel = x_vel;
        this.y_vel = y_vel;
        this.aceleracao = aceleracao;
        this.diametro = 20;
    }
    
    public void movimento(){
        x_pos += x_vel;
        y_pos += y_vel;       
    }
    
    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public int getDiametro() {
        return diametro;
    }

    public void revVelocidadeX(){
        acelera();
        x_vel = -x_vel; 
    }

    public void revVelocidadeY(){
        acelera();
        y_vel = -y_vel;
    }
    
    public void acelera(){
        Random aleatorio = new Random();
        int probabilidade = aleatorio.nextInt(10);
        if (y_vel<=8 && x_vel<8 && aceleracao == 1 && probabilidade == 0){
            if (y_vel > 0)
                y_vel +=1;
            else if (y_vel<0)
                y_vel -= 1;
            if (x_vel > 0)
                x_vel +=1;
            else if (x_vel<0)
                x_vel -= 1;
        }
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }
    
}
