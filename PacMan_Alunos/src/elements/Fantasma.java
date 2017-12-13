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
    
    private int grauDeLiberdade;
    
    //Construtor
    public Fantasma(String imageName){
        super(imageName);
        this.isMortal = true;
    }
    
    //Métodos
    public abstract void move();
    
    public int getGrauDeLiberdade(){
        return this.grauDeLiberdade;
    }
    
    public void setGrauDeLiberdade(int grauDeLiberdade){
        this.grauDeLiberdade = grauDeLiberdade;
    }
    
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
    
    
    public void moveAleatorio(){
            Random gerador = new Random();
            
            if(this.getGrauDeLiberdade() == 1){
                //1 grau de liberdade
                if(!this.getDOWN() && !this.getLEFT() && this.getRIGHT()){
                    this.moveUp();
               }
                if(!this.getUP() && !this.getLEFT() && this.getRIGHT()){
                    this.moveDown();
                }
                if(!this.getDOWN() && !this.getUP() && this.getRIGHT()){
                    this.moveLeft();
                }
                if(!this.getDOWN() && !this.getLEFT() && this.getUP()){
                    this.moveRight();
                }
            }
            if(this.getGrauDeLiberdade() == 2){
                //2 graus de liberdade
                if(!this.getUP() && !this.getRIGHT()){
                    if(gerador.nextInt(2) == 0)
                        this.moveDown();
                    else
                        this.moveLeft();
                }
            
                if(!this.getUP() && !this.getLEFT()){
                    if(gerador.nextInt(2) ==0)
                        this.moveDown();
                    else
                        this.moveRight();
                }
            
                if(!this.getUP() && !this.getDOWN()){
                    if(gerador.nextInt(2) == 0)
                        this.moveLeft();
                    else
                        this.moveRight();
                }
            
                if(!this.getLEFT() && !this.getRIGHT()){
                    if(gerador.nextInt(2) ==0)
                        this.moveDown();
                    else
                        this.moveUp();
                }
            
                if(!this.getLEFT() && !this.getDOWN()){
                    if(gerador.nextInt(2) == 0)
                        this.moveRight();
                    else
                        this.moveUp();
                }
            
                if(!this.getDOWN() && !this.getRIGHT()){
                    if(gerador.nextInt(2) == 0)
                        this.moveLeft();
                    else
                        this.moveUp();
                }
            }
            if(this.getGrauDeLiberdade() == 3){
            //3 graus de liberdade
            if(!this.getUP()){
                int aux = gerador.nextInt(3);
                switch(aux){
                    case 0:
                        this.moveLeft();
                        break;
                    case 1:
                        this.moveDown();
                        break;
                    case 2:
                        this.moveRight();
                }
            }
            
            if(!this.getRIGHT()){
                int aux = gerador.nextInt(3);
                switch(aux){
                    case 0:
                        this.moveLeft();
                        break;
                    case 1:
                        this.moveDown();
                        break;
                    case 2:
                        this.moveUp();
                }
            }
            
            if(!this.getDOWN()){
                int aux = gerador.nextInt(3);
                switch(aux){
                    case 0:
                        this.moveLeft();
                        break;
                    case 1:
                        this.moveUp();
                        break;
                    case 2:
                        this.moveRight();
                }
            }
            
            if(!this.getLEFT()){
                int aux = gerador.nextInt(3);
                switch(aux){
                    case 0:
                        this.moveUp();
                        break;
                    case 1:
                        this.moveDown();
                        break;
                    case 2:
                        this.moveRight();
                }
            }
            }
            if(this.getGrauDeLiberdade() == 4)
                this.moveUp();
            if(this.getGrauDeLiberdade() == 0)
                this.setMovDirection(0);
    }
    
}
