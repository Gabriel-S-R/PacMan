package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

public class Pinky extends Fantasma implements Serializable{
    //Construtor
    public Pinky(String imageName){
        super(imageName);
    }
    
    //Metodos
    @Override
    public void move(){
        switch (this.getMovDirection()) {
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
    
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
    
}
