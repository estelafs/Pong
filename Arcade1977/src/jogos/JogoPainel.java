package jogos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import objetos.*;
import principal.ArcadeFramework;

public abstract class JogoPainel extends JPanel implements ActionListener,KeyListener {
    protected Bola bola;
    protected Raquete raquete_esq;
    protected Raquete raquete_dir;
    protected Timer timer;
    protected int DELAY = 10;
        
    protected boolean chaves[]; //Vetor pra acompanhar movimento
    protected int esq_cima = 0;
    protected int esq_baixo = 1;
    protected int dir_cima = 2;
    protected int dir_baixo = 3;
    
    public JogoPainel(String modo, int Rtamanho, int Bx_vel, int By_vel, int aceleracao) {
        setBackground(Color.BLACK);
        bola = new Bola(Bx_vel, By_vel,aceleracao);
        raquete_esq = new Raquete("esquerda", Rtamanho);
        raquete_dir = new Raquete("direita", Rtamanho);
              
        if (modo == "Treino")
            raquete_dir.alteraTreino();
        
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
        checaColisao();
        if (raquete_dir.getModo() == "Treino"){
            if(chaves[esq_cima]) raquete_esq.moveCima();
            if(chaves[esq_baixo]) raquete_esq.moveBaixo();
            setY_pos(raquete_dir);
        }
        else {
            if(chaves[esq_cima]) raquete_esq.moveCima();
            if(chaves[esq_baixo]) raquete_esq.moveBaixo();
            if(chaves[dir_cima]) raquete_dir.moveCima();
            if(chaves[dir_baixo]) raquete_dir.moveBaixo();
        }
        repaint();
    }

    protected void checaColisao() {
        if (bola.getX_pos() < (raquete_esq.getX_pos() + raquete_esq.getLargura())) {
            if ((bola.getY_pos() > raquete_esq.getY_pos()) && (bola.getY_pos() < (raquete_esq.getY_pos() + raquete_esq.getAltura()))) {
                bola.revVelocidadeX();
            } else {
                bola.setX_pos(ArcadeFramework.largura / 2);
                bola.setY_pos(ArcadeFramework.altura / 2);
            }
        }
        if (bola.getX_pos() > (raquete_dir.getX_pos() - raquete_dir.getLargura())) {
            if ((bola.getY_pos() > raquete_dir.getY_pos()) && (bola.getY_pos() < (raquete_dir.getY_pos() + raquete_dir.getAltura()))) {
                bola.revVelocidadeX();
            } else {
                bola.setX_pos(ArcadeFramework.largura / 2);
                bola.setY_pos(ArcadeFramework.altura / 2);
            }

        } else if (bola.getY_pos() < 0 || bola.getY_pos() > ArcadeFramework.altura) {
            bola.revVelocidadeY();
        }

    }
    public void setY_pos(Raquete r) {
        r.y_pos = bola.getY_pos() - 20;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        desenhaBola(g);
        desenhaRaquete(g);

    }

    protected void desenhaRaquete(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(raquete_esq.getX_pos(), raquete_esq.getY_pos(), raquete_esq.getLargura(), raquete_esq.getAltura());
        g.fillRect(raquete_dir.getX_pos(), raquete_dir.getY_pos(), raquete_dir.getLargura(), raquete_dir.getAltura());
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
