package elements;


import java.io.Serializable;
import java.util.Random;

public abstract class Fantasma extends Element implements Serializable{
    //Atributos
    public static final int STOP = 0;
    public static final int MOVE_LEFT = 1;
    public static final int MOVE_RIGHT = 2;
    public static final int MOVE_UP = 3;
    public static final int MOVE_DOWN = 4;
    
    private int movDirection = STOP;
    
    private boolean pelletOn = false;     //Power pellet on ou off?
    
    private boolean UP;
    private boolean DOWN;
    private boolean LEFT;
    private boolean RIGHT;
    
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
    
    public boolean getUP(){
        return this.UP;
    }
    
    public boolean getDOWN(){
        return this.DOWN;
    }
    
    public boolean getRIGHT(){
        return this.RIGHT;
    }
    
    public boolean getLEFT(){
        return this.LEFT;
    }
    
    public void setUP(boolean UP){
        this.UP = UP;
    }
    
    public void setDOWN(boolean DOWN){
        this.DOWN = DOWN;
    }
    
    public void setRIGHT(boolean RIGHT){
        this.RIGHT = RIGHT;
    }
    
    public void setLEFT(boolean LEFT){
        this.LEFT = LEFT;
    }
    
    
    public void randomDirection(){
            Random gerador = new Random();
            
            int j = gerador.nextInt(4000);
            
            if(j>0 && j<=1000)
                this.setMovDirection(1);
            
            if(j>1000 && j<=2000)
                this.setMovDirection(2);
            
            if(j>2000 && j<=3000)
                this.setMovDirection(3);
            
            if(j>3000 && j<=4000)
                this.setMovDirection(4);
    }
            
    public void moveAleatorio(){        
            switch (movDirection) {
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
    
}
