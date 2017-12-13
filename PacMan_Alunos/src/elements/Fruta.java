package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class Fruta extends Element implements Serializable{
    Timer timer;
    
    public Fruta(String imageName) {
        super(imageName);
        this.isMortal = false;
    }
    
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
  
    public void setTimerFruta() {
        Fruta fruta = new Fruta("fruta.png");
        fruta.setPosition(3, 1);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Drawing.getGameScreen().addElement(fruta);
                setTimer(fruta);
                setTimerFruta();
            }
        }, 45000);
    } 
    
    public void setTimer(Fruta f) {
        Fruta self = f;
        timer = new Timer();
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Drawing.getGameScreen().removeElement(self);
                }
            }, 15000);

    }
}
