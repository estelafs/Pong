package jogos;

import java.awt.*;
import java.awt.event.*;
import principal.*;

public class ParedaoPainel extends JogoPainel {
    
    public ParedaoPainel(String modo, int Rtamanho, int Bx_vel, int By_vel, int aceleracao) {
        super(modo, Rtamanho, Bx_vel, By_vel, aceleracao);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        bola.movimento();
        checaColisao();
 
        if(chaves[esq_cima]) raquete_esq.moveCima();
        if(chaves[esq_baixo]) raquete_esq.moveBaixo();

        repaint();
    }

    @Override
    protected void checaColisao() {
        if (bola.getX_pos() < (raquete_esq.getX_pos() + raquete_esq.getLargura())) {
            if ((bola.getY_pos() > raquete_esq.getY_pos()) && (bola.getY_pos() < (raquete_esq.getY_pos() + raquete_esq.getAltura()))) {
                bola.revVelocidadeX();
            } else {
                bola.setX_pos(Arcade1977.largura / 2);
                bola.setY_pos(Arcade1977.altura / 2);
            }
        }
        if (bola.getX_pos() > (raquete_dir.getX_pos() - raquete_dir.getLargura())) {
            if ((bola.getY_pos() > raquete_dir.getY_pos()) && (bola.getY_pos() < (raquete_dir.getY_pos() + raquete_dir.getAltura()))) {
                bola.revVelocidadeX();
            } else {
                bola.revVelocidadeX();
            }

        } else if (bola.getY_pos() < 0 || bola.getY_pos() > Arcade1977.altura) {
            bola.revVelocidadeY();
        }
    }
    
    protected void desenhaRaquete(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(raquete_esq.getX_pos(), raquete_esq.getY_pos(), raquete_esq.getLargura(), raquete_esq.getAltura());
        Toolkit.getDefaultToolkit().sync();
    }
}
