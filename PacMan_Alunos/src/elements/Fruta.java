package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;
import utils.Position;
/**
 *
 * @author Gabriel
 */
public class Fruta extends Element implements Serializable{
    
    public Fruta(String imageName) {
        super(imageName);
        this.isMortal = false;
        pos.setPosition(3, 0);
    }
    
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
}
