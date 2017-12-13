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
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
    
    public void backToLastPosition(){
        this.pos.comeBack();
    }
    
}
