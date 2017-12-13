package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

public class Fruta extends Element implements Serializable{
    
    public Fruta(String imageName) {
        super(imageName);
        this.isMortal = false;
    }
    
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
}
