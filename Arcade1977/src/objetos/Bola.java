package objetos;

import principal.ArcadeFramework;

public class Bola {
    public int x_pos;
    public int y_pos;
    public int x_vel;
    public int y_vel;
    public int diametro;
    public int x_aceleracao;
    public int y_aceleracao;


    
    public Bola (int x_vel, int y_vel, int x_aceleracao, int y_aceleracao){
        this.x_pos = ArcadeFramework.largura/2;
        this.y_pos = ArcadeFramework.altura/2;
        this.x_vel = x_vel;
        this.y_vel = y_vel;
        this.x_aceleracao = x_aceleracao;
        this.y_aceleracao = y_aceleracao;
        this.diametro = 15;
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
        x_vel = -x_vel;
    }

    public void revVelocidadeY(){
        y_vel = -y_vel;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }
    
    


}
