package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

public class Pacman extends Element implements Serializable {
    //Estados de movimento.
    public static final int STOP = 0;
    public static final int MOVE_LEFT = 1;
    public static final int MOVE_RIGHT = 2;
    public static final int MOVE_UP = 3;
    public static final int MOVE_DOWN = 4;
    
    private int movDirection = STOP;
    
    //Construtor
    public Pacman(String imageName) {
        super(imageName);
        this.isMortal = true;
    }
    
    //Métodos
    
    //Redesenhar o pacman na interface.
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
    
    //Voltar a posição anterior, por exemplo quando bate em algo intransponivel.
    public void backToLastPosition(){
        this.pos.comeBack();
    }
    
    //Seta a direção para a qual o pacman irá se movimentar.
    public void setMovDirection(int direction) {
        movDirection = direction;
    }
    
    //Método de movimentação do pacman.
    public void move() {
        switch (movDirection) {
            case MOVE_LEFT:
                this.moveLeft();
                break;
            case MOVE_RIGHT:
                this.moveRight();
                break;
            case MOVE_UP:
                this.moveUp();
                break;
            case MOVE_DOWN:
                this.moveDown();
                break;
            default:
                break;
        }
    }
   
}
