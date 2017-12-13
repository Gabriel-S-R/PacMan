package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

public class Blinky extends Fantasma implements Serializable {
    
    public int ultimoMov;
    
    public Blinky(String imageName){
        super(imageName);
    }
    
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
    
    public void backToLastPosition(){
        this.pos.comeBack();
    }
    
    public void pacPos(Pacman pacman){
        double xDist;
        xDist = (pacman.pos.getX() - this.pos.getX());
        double yDist;
        yDist = (pacman.pos.getY() - this.pos.getY());
        
        if(Math.abs(xDist) > 1.5 && this.getUP() == true && this.getDOWN() == true ){
            this.setLEFT(true);
            this.setRIGHT(true);            
            if(xDist < 0.0 && this.getUP() == true ){
                this.setMovDirection(3);
                this.setUP(false);
                this.ultimoMov = 3;
            }
            if(xDist > 0.0 && this.getDOWN() == true ){
                this.setMovDirection(4);
                this.setDOWN(false);
                this.ultimoMov = 4;

            }
        }
        
        if(Math.abs(yDist) > 1.5 && this.getLEFT() == true && this.getRIGHT() == true){
            this.setDOWN(true);
            this.setUP(true);
            if(yDist < 0.0 && this.getLEFT() == true){
                this.setMovDirection(1);
                this.setLEFT(false);
                this.ultimoMov = 1;
            }
            if(yDist > 0.0 && this.getRIGHT() == true){
                this.setMovDirection(2);
                this.setRIGHT(false);
                this.ultimoMov = 2;
            }
        }
        
        else if(Math.abs(yDist) < 1.5 && Math.abs(xDist) < 1.5){
            if(this.ultimoMov == 3 || this.ultimoMov == 4){
                this.setDOWN(true);
                this.setUP(true);
                if(yDist < 0.0){
                    this.setMovDirection(1);
                }
                if(yDist > 0.0){
                    this.setMovDirection(2);
                }
            }
            else{     
                if(xDist < 0.0){
                    this.setMovDirection(3);
                }
                if(xDist > 0.0){
                    this.setMovDirection(4);
                }
            }
        }
    }
    
    
}