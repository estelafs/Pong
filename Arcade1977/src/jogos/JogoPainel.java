package jogos;

import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import javax.swing.*;
//import javax.swing.Timer;
import objetos.*;
import principal.ArcadeFramework;


public abstract class JogoPainel extends JPanel implements ActionListener,KeyListener {
    protected Bola bola;
    protected Raquete r_esq;
    protected  Raquete r_dir;
    protected Timer timer;
    protected int DELAY = 10;
        
    protected boolean chaves[]; //Vetor pra acompanhar movimento
    protected int esq_cima = 0;
    protected int esq_baixo = 1;
    protected int dir_cima = 2;
    protected int dir_baixo = 3;
    
    public JogoPainel(int Rtamanho, int Bx_vel, int By_vel, int Bx_aceleracao, int By_aceleracao) {
        setBackground(Color.BLACK);
        bola = new Bola(Bx_vel, By_vel,Bx_aceleracao, By_aceleracao);
        r_esq = new Raquete("esquerda", Rtamanho);
        r_dir = new Raquete("direita", Rtamanho);
        
        addKeyListener(this);
        setFocusable(true);
        timer = new Timer(DELAY, this);
        timer.start();
        setDoubleBuffered(true);
        chaves = new boolean[]{false, false, false, false};
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        bola.movimento();
        cechaColisao();
        if (chaves[esq_cima]) r_esq.moveCima();
        if (chaves[esq_baixo]) r_esq.moveBaixo();
        if (chaves[dir_cima]) r_dir.moveCima();
        if (chaves[dir_baixo]) r_dir.moveBaixo();
        repaint();
    }

    protected void cechaColisao() {
        if (bola.getX_pos() < (r_esq.getX_pos() + r_esq.getLargura())) {
            if ((bola.getY_pos() > r_esq.getY_pos()) && (bola.getY_pos() < (r_esq.getY_pos() + r_esq.getAltura()))) {
                bola.revVelocidadeX();
            } else {
                bola.setX_pos(ArcadeFramework.largura / 2);
                bola.setY_pos(ArcadeFramework.altura / 2);
            }
        }
        if (bola.getX_pos() > (r_dir.getX_pos() - r_dir.getLargura())) {
            if ((bola.getY_pos() > r_dir.getY_pos()) && (bola.getY_pos() < (r_dir.getY_pos() + r_dir.getAltura()))) {
                bola.revVelocidadeX();
            } else {
                bola.setX_pos(ArcadeFramework.largura / 2);
                bola.setY_pos(ArcadeFramework.altura / 2);
            }

        } else if (bola.getY_pos() < 0 || bola.getY_pos() > ArcadeFramework.altura) {
            bola.revVelocidadeY();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenhaBola(g);
        desenhaRaquete(g);

    }

    protected void desenhaRaquete(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(r_esq.getX_pos(), r_esq.getY_pos(), r_esq.getLargura(), r_esq.getAltura());
        g.fillRect(r_dir.getX_pos(), r_dir.getY_pos(), r_dir.getLargura(), r_dir.getAltura());
        Toolkit.getDefaultToolkit().sync();
    }

    protected void desenhaBola(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(bola.getX_pos(), bola.getY_pos(), bola.getDiametro(), bola.getDiametro());
         Toolkit.getDefaultToolkit().sync();
    }

    //@Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    //@Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            chaves[dir_cima] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            chaves[dir_baixo] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            chaves[esq_cima] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            chaves[esq_baixo] = true;
        }

    }

    //@Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            chaves[dir_cima] = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            chaves[dir_baixo] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            chaves[esq_cima] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            chaves[esq_baixo] = false;
        }
    }
    
}
