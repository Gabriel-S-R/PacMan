package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;
import utils.Consts;

public class Fruta extends Element implements Serializable{
    private int contIntervalos;
    
    public Fruta(String imageName) {
        super(imageName);
        this.isMortal = false;
        this.contIntervalos = 0;
    }
    
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    
    
    this.contIntervalos++;
        if(this.contIntervalos == Consts.TIMER_FRUTA){
            this.contIntervalos = 0;
            Fruta f = new Fruta("fruta.png");
            f.setPosition(5,5);
            Drawing.getGameScreen().addElement(f);
        }
    }
}
