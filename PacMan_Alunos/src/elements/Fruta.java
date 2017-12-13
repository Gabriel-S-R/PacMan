package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import utils.Consts;

public class Fruta extends Element implements Serializable{
    private int contIntervalos;
    Timer timer;
    
    public Fruta(String imageName) {
        super(imageName);
        this.isMortal = false;
        this.contIntervalos = 0;
        //setTimerFruta();
    }
    
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    
    
   /* this.contIntervalos++;
        if(this.contIntervalos == Consts.TIMER_FRUTA){
            this.contIntervalos = 0;
            Fruta f = new Fruta("fruta.png");
            f.setPosition(5,5);
            Drawing.getGameScreen().addElement(f);
            setTimer();
        }*/
    }
  
    public void setTimerFruta() {
        Fruta fruta = new Fruta("fruta.png");
        fruta.setPosition(3, 1);
        //this.addElement(fruta);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Drawing.getGameScreen().addElement(fruta);
                setTimer(fruta);
            }
        }, 4000);
    } 
    
    public void setTimer(Fruta f) {
        Fruta self = f;
        timer = new Timer();
        timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Drawing.getGameScreen().removeElement(self);
                }
            }, 2000);

    }
}
