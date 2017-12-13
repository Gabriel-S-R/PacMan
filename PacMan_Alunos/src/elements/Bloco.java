package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

public class Bloco extends Element implements Serializable {
    //Construtor
    public Bloco(String imageName){
        super(imageName);
        this.isTransposable = false;
    }
    
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
    
}
