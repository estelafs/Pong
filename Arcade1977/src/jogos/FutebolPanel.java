package jogos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import objetos.*;
import principal.*;

public class FutebolPanel extends JPanel implements ActionListener, KeyListener {
    private Bola b;
    private Jogadores e1; private Jogadores e2; private Jogadores e3;
    private Jogadores d1; private Jogadores d2; private Jogadores d3;
    private Raquete r_esq;
    private Raquete r_dir;
    private Timer timer;
    private int DELAY = 10;

    private boolean chaves[]; //Vetor pra acompanhar movimento
    private int esq_cima = 0;
    private int esq_baixo = 1;
    private int dir_cima = 2;
    private int dir_baixo = 3;
    
    public FutebolPanel(int Jtamanho, int Bx_vel, int By_vel, int Bdiametro, int Bx_aceleracao, int By_aceleracao){
        setBackground(Color.BLACK);
        b = new Bola(Bx_vel, By_vel, Bdiametro, Bx_aceleracao, By_aceleracao);
        
        r_esq = new Raquete("esquerda");
        r_dir = new Raquete("direita");
        
        e1 = new Jogadores("esquerda", Jtamanho, 5);
        e2 = new Jogadores("esquerda", Jtamanho, 200);
        e3 = new Jogadores("esquerda", Jtamanho, 395);
           
        d1 = new Jogadores("direita", Jtamanho, 105);
        d2 = new Jogadores("direita", Jtamanho, 300);
        d3 = new Jogadores("direita", Jtamanho, 495);

        addKeyListener(this);
        setFocusable(true);
        timer = new Timer(DELAY,this);
        timer.start();
        setDoubleBuffered(true);
        chaves = new boolean[]{false,false,false,false};
    }
/*
Moving the code for moving paddles into actionPerformed make
the paddle movement super smooth.
 */
    //@Override
    public void actionPerformed(ActionEvent e) {
        b.movimento();
        checkCollision();
        if(chaves[esq_cima]) r_esq.moveCima();
        if(chaves[esq_baixo]) r_esq.moveBaixo();
        if(chaves[dir_cima]) r_esq.moveCima();
        if(chaves[dir_baixo]) r_dir.moveBaixo();
        
        e1.move(); e2.move(); e3.move(); d1.move(); d2.move(); d3.move();

        repaint();
    }

    public void checkCollision() {
        if(b.getX_pos() < (r_esq.getX_pos() + r_esq.getLargura())) {
            if((b.getY_pos() > r_esq.getY_pos()) && (b.getY_pos() < (r_esq.getY_pos() + r_esq.getAltura())))
                b.revVelocidadeX();
            else {
                b.setX_pos(Framework.largura / 2);
                b.setY_pos(Framework.altura / 2);
            }
        }
        if(b.getX_pos() > (r_dir.getX_pos() - r_dir.getLargura())){
            if((b.getY_pos() > r_dir.getY_pos()) && (b.getY_pos() < (r_dir.getY_pos() + r_dir.getAltura())))
                b.revVelocidadeX();
            else {
                b.setX_pos(Framework.largura / 2);
                b.setY_pos(Framework.altura / 2);
            }

        }
        else if(b.getY_pos()<0 || b.getY_pos()>Framework.altura){
            b.revVelocidadeY();
        }

    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenhaBola(g);
        desenhaRaquete(g);
        desenhaJogadores(g);
        timer.start();
    }

    public void desenhaRaquete(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(r_esq.getX_pos(),r_esq.getY_pos(),r_esq.getLargura(),r_esq.getAltura());
        g.fillRect(r_dir.getX_pos(),r_dir.getY_pos(),r_dir.getLargura(),r_dir.getAltura());
        Toolkit.getDefaultToolkit().sync();
    }

    public void desenhaBola(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(b.getX_pos(),b.getY_pos(),b.getDiametro(),b.getDiametro());
        Toolkit.getDefaultToolkit().sync();
    }

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
    
    //@Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    //@Override
    public void keyPressed(KeyEvent e) {
        /*
        Raquete da direira é controlada Controls for right paddle are the up and down arrow keys.
        Controls for left paddle are the w and s keys.

        Used the keys array to implement simultaneous movement of paddles.
        Movement code is shifted to the actionPerformed method.
        For eg. if keys[RIGHT_UP] = true,the action performed method will move
        the right paddle up.
         */
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            chaves[dir_cima] = true;

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            chaves[dir_baixo] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            chaves[esq_cima] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            chaves[esq_baixo] = true;
        }

    }

    //@Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            chaves[dir_cima] = false;

        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            chaves[dir_baixo] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            chaves[esq_cima] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            chaves[esq_baixo] = false;
        }
    }

}
