package objetos;

import principal.Arcade1977;

public class Raquete {
    private int altura;
    private int largura;
    public int x_pos;
    public int y_pos;
    private int velocidade;
    private String modo_jogo;
    
    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }
    
    public String getModo(){
        return modo_jogo;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    //A string r diz se é a raqueta da esquerda ou a da direita
    public Raquete(String r, int tamanho) {
        velocidade = 10;
        altura = tamanho;
        largura = 10;
        y_pos = (Arcade1977.altura / 2) - (altura / 2); //no centro

        if(r.equals("esquerda")){
            x_pos = 10;
        }
        if(r.equals("direita")){
            x_pos = Arcade1977.largura - 25;
        }
    }

    public void moveCima(){
        if(y_pos > 0)
            y_pos -= velocidade;
    }

    public void moveBaixo(){
        if(y_pos < (Arcade1977.altura - altura))
            y_pos += velocidade;
    }

    public void alteraTreino(){
        this.modo_jogo = "Treino";
    }
}
