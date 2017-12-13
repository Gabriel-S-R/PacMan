package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Fantasma extends Element implements Serializable{
    //Atributos
    public static final int STOP = 0;
    public static final int MOVE_LEFT = 1;
    public static final int MOVE_RIGHT = 2;
    public static final int MOVE_UP = 3;
    public static final int MOVE_DOWN = 4;
    
    private int movDirection = STOP;
    
    private boolean pelletOn = false;     //Power pellet on ou off?
    
    //Construtor
    public Fantasma(String imageName){
        super(imageName);
        this.isMortal = true;
    }
    
    //Métodos
    public abstract void move();
    
    public boolean getPelletOn(){
        return this.pelletOn;
    }
    
    public void setPelletOn(boolean status){
        this.pelletOn = status;
    }
    
    public void setMovDirection(int direction) {
        movDirection = direction;
    }
    
    public int getMovDirection(){
        return this.movDirection;
    }
}
