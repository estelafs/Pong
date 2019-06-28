package jogos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import objetos.*;
import principal.*;

public class FutebolPainel extends JogoPainel {
//    private Bola bola;
    private Jogadores e1; private Jogadores e2; private Jogadores e3;
    private Jogadores d1; private Jogadores d2; private Jogadores d3;
//    private Raquete r_esq;
//    private Raquete r_dir;
//    private Timer timer;
//    private int DELAY = 10;
//
//    private boolean chaves[]; //Vetor pra acompanhar movimento
//    private int esq_cima = 0;
//    private int esq_baixo = 1;
//    private int dir_cima = 2;
//    private int dir_baixo = 3;
    
    public FutebolPainel(int Rtamanho, int Bx_vel, int By_vel, int Bx_aceleracao, int By_aceleracao) {
        super(Rtamanho, Bx_vel, By_vel, Bx_aceleracao, By_aceleracao);
        
        r_esq.x_pos += 25;
        r_dir.x_pos -= 25;

        e1 = new Jogadores("esquerda", 5);
        e2 = new Jogadores("esquerda", 200);
        e3 = new Jogadores("esquerda", 395);

        d1 = new Jogadores("direita", 105);
        d2 = new Jogadores("direita", 300);
        d3 = new Jogadores("direita", 495);
    }
    
    
//    public FutebolPainel(int Rtamanho, int Bx_vel, int By_vel, int Bx_aceleracao, int By_aceleracao){
////        setBackground(Color.BLACK);
////        bola = new Bola(Bx_vel, By_vel, Bx_aceleracao, By_aceleracao);
////        
////        r_esq = new Raquete("esquerda", Rtamanho);
////        r_dir = new Raquete("direita", Rtamanho);
//        r_esq.x_pos += 25;
//        r_dir.x_pos -=25;
//        
//        e1 = new Jogadores("esquerda", 5);
//        e2 = new Jogadores("esquerda", 200);
//        e3 = new Jogadores("esquerda", 395);
//           
//        d1 = new Jogadores("direita", 105);
//        d2 = new Jogadores("direita", 300);
//        d3 = new Jogadores("direita", 495);
//
//        addKeyListener(this);
//        setFocusable(true);
//        timer = new Timer(DELAY,this);
//        timer.start();
//        setDoubleBuffered(true);
//        chaves = new boolean[]{false,false,false,false};
//    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        bola.movimento();
        chechaColisao();
        if(chaves[esq_cima]) r_esq.moveCima();
        if(chaves[esq_baixo]) r_esq.moveBaixo();
        if(chaves[dir_cima]) r_dir.moveCima();
        if(chaves[dir_baixo]) r_dir.moveBaixo();
        
        e1.move();
        e2.move();
        e3.move();

        d1.move();
        d2.move();
        d3.move();

        if (e1.getY_pos() >= 150) {
            e1.inverte_velocidade();
            e2.inverte_velocidade();
            e3.inverte_velocidade();
        }
        if (e1.getY_pos() <= 4) {
            e1.inverte_velocidade();
            e2.inverte_velocidade();
            e3.inverte_velocidade();
        }

        if (d1.getY_pos() >= 150) {
            d1.inverte_velocidade();
            d2.inverte_velocidade();
            d3.inverte_velocidade();
        }
        if (d1.getY_pos() <= 4) {
            d1.inverte_velocidade();
            d2.inverte_velocidade();
            d3.inverte_velocidade();
        }

        repaint();
    }

    public void chechaColisao() {
        if(bola.getX_pos() < (r_esq.getX_pos() + r_esq.getLargura())) {
            if((bola.getY_pos() > r_esq.getY_pos()) && (bola.getY_pos() < (r_esq.getY_pos() + r_esq.getAltura())))
                bola.revVelocidadeX();
            else {
                if ((bola.getX_pos() <= (ArcadeFramework.largura - 25) && (bola.getY_pos() >= 10 && bola.getY_pos() <= 200))
                        || (bola.getX_pos() <= (ArcadeFramework.largura - 25) && (bola.getY_pos() >= 401 && bola.getY_pos() <= 600))
                        || (bola.getX_pos() <= 10 && (bola.getY_pos() >= 10 && bola.getY_pos() <= 200))
                        || (bola.getX_pos() <= 10 && (bola.getY_pos() >= 410 && bola.getY_pos() <= 600))) {

                    bola.revVelocidadeX();
                } else {
                    bola.setX_pos(ArcadeFramework.largura / 2);
                    bola.setY_pos(ArcadeFramework.altura / 2);
                }
            }
        }
        if(bola.getX_pos() > (r_dir.getX_pos() - r_dir.getLargura())){
            if((bola.getY_pos() > r_dir.getY_pos()) && (bola.getY_pos() < (r_dir.getY_pos() + r_dir.getAltura())))
                bola.revVelocidadeX();
            else {
                if ((bola.getX_pos() <= (ArcadeFramework.largura - 25) && (bola.getY_pos() >= 10 && bola.getY_pos() <= 200))
                        || (bola.getX_pos() <= (ArcadeFramework.largura - 25) && (bola.getY_pos() >= 401 && bola.getY_pos() <= 600))
                        || (bola.getX_pos() <= 10 && (bola.getY_pos() >= 10 && bola.getY_pos() <= 200))
                        || (bola.getX_pos() <= 10 && (bola.getY_pos() >= 410 && bola.getY_pos() <= 600))) {
                    bola.revVelocidadeX();
                } else {
                    bola.setX_pos(ArcadeFramework.largura / 2);
                    bola.setY_pos(ArcadeFramework.altura / 2);
                }
            }
        }
                
        //Trata da colisão com os jogadores
        if (bola.getX_pos() > e1.getX_pos() && bola.getX_pos() < e1.getX_pos() + e1.getLargura()) {  
            if (bola.getY_pos() > e1.getY_pos() && bola.getY_pos() < e1.getY_pos() + e1.getAltura()) 
                bola.revVelocidadeX();
        }        
        
        
        if (bola.getX_pos() > e2.getX_pos() && bola.getX_pos() < e2.getX_pos() + e2.getLargura()) {  
            if (bola.getY_pos() > e2.getY_pos() && bola.getY_pos() < e2.getY_pos() + e2.getAltura()) 
                bola.revVelocidadeX();
        }
        
        if (bola.getX_pos() > e3.getX_pos() && bola.getX_pos() < e3.getX_pos() + e3.getLargura()) {  
            if (bola.getY_pos() > e3.getY_pos() && bola.getY_pos() < e3.getY_pos() + e3.getAltura()) 
                bola.revVelocidadeX();
        }
        
        if(bola.getX_pos() > d1.getX_pos() && bola.getX_pos() < d1.getX_pos() + d1.getLargura()){ 
            if(bola.getY_pos() > d1.getY_pos() && bola.getY_pos() < d1.getY_pos() + d1.getAltura())
                bola.revVelocidadeX();
        }
        
        if(bola.getX_pos() > d2.getX_pos() && bola.getX_pos() <= d2.getX_pos() + d2.getLargura()){ 
            if(bola.getY_pos() > d2.getY_pos() && bola.getY_pos() <= d2.getY_pos() + d2.getAltura())
                bola.revVelocidadeX();
        }
        
        if(bola.getX_pos() > d3.getX_pos() && bola.getX_pos() < d3.getX_pos() + d3.getLargura()){ 
            if(bola.getY_pos() > d3.getY_pos() && bola.getY_pos() < d3.getY_pos() + d3.getAltura())
                bola.revVelocidadeX();
        }
//---------------------------------------------------------------
        if(bola.getY_pos()<0 || bola.getY_pos()>ArcadeFramework.altura - 35){
            bola.revVelocidadeY();
        }

    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        desenhaBola(g);
//        desenhaRaquete(g);
        desenhaJogadores(g); 
        desenhaLimites(g);
  
        timer.start();
    }

//    public void desenhaRaquete(Graphics g) {
//        g.setColor(Color.WHITE);
//        g.fillRect(r_esq.getX_pos(),r_esq.getY_pos(),r_esq.getLargura(),r_esq.getAltura());
//        g.fillRect(r_dir.getX_pos(),r_dir.getY_pos(),r_dir.getLargura(),r_dir.getAltura());
//        Toolkit.getDefaultToolkit().sync();
//    }

//    public void desenhaBola(Graphics g) {
//        g.setColor(Color.WHITE);
//        g.fillOval(bola.getX_pos(),bola.getY_pos(),bola.getDiametro(),bola.getDiametro());
//        Toolkit.getDefaultToolkit().sync();
//    }

    public void desenhaJogadores(Graphics g) {
        g.setColor(Color.WHITE);
        
        g.fillRect(e1.getX_pos(),e1.getY_pos(),e1.getLargura(),e1.getAltura());
        g.fillRect(e2.getX_pos(),e2.getY_pos(),e2.getLargura(),e2.getAltura());
        g.fillRect(e3.getX_pos(),e3.getY_pos(),e3.getLargura(),e3.getAltura());
        g.fillRect(d1.getX_pos(),d1.getY_pos(),d1.getLargura(),d1.getAltura());
        g.fillRect(d2.getX_pos(),d2.getY_pos(),d2.getLargura(),d2.getAltura());
        g.fillRect(d3.getX_pos(),d3.getY_pos(),d3.getLargura(),d3.getAltura());
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    public void desenhaLimites(Graphics g) {
        g.setColor(Color.WHITE);

        //Limites da esquerda
        g.fillRect(10, 2, 10, 200);
        g.fillRect(10, 410, 10, 200);

        //Limites da direita
        g.fillRect(ArcadeFramework.largura - 25, 2, 10, 200);
        g.fillRect(ArcadeFramework.largura - 25, 410, 10, 200);

        Toolkit.getDefaultToolkit().sync();
    }
        
        
//    //@Override
//    public void keyTyped(KeyEvent keyEvent) {
//
//    }
//
//    //@Override
//    public void keyPressed(KeyEvent e) {
//        /*
//        Controls for right paddle are the up and down arrow keys.
//        Controls for left paddle are the w and s keys.
//
//        Used the keys array to implement simultaneous movement of paddles.
//        Movement code is shifted to the actionPerformed method.
//        For eg. if keys[RIGHT_UP] = true,the action performed method will move
//        the right paddle up.
//         */
//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//            chaves[dir_cima] = true;
//
//        }
//        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            chaves[dir_baixo] = true;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_W) {
//            chaves[esq_cima] = true;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_S) {
//            chaves[esq_baixo] = true;
//        }
//
//    }
//
//    //@Override
//    public void keyReleased(KeyEvent e) {
//        if (e.getKeyCode() == KeyEvent.VK_UP) {
//            chaves[dir_cima] = false;
//
//        }
//        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//            chaves[dir_baixo] = false;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_W) {
//            chaves[esq_cima] = false;
//        }
//        if (e.getKeyCode() == KeyEvent.VK_S) {
//            chaves[esq_baixo] = false;
//        }
//    }
    
}
