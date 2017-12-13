package elements;

import utils.Consts;
import utils.Position;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 * Projeto de POO 2017
 * 
 * @author Luiz Eduardo
 * Baseado em material do Prof. Jose Fernando Junior
 */
public abstract class Element implements Serializable{

    protected ImageIcon imageIcon;
    protected Position pos;
    protected boolean isTransposable; // Pode passar por cima?
    protected boolean isMortal;       // Se encostar, morre?
    protected static int pontuacao = 0;
    protected static int vidas = 3;

    protected Element(String imageName) {
        this.pos = new Position(1, 1);
        this.isTransposable = true;
        this.isMortal = false;
        
        try {
            imageIcon = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + imageName);
            Image img = imageIcon.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIZE, Consts.CELL_SIZE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIZE, Consts.CELL_SIZE, null);
            imageIcon = new ImageIcon(bi);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean overlap(Element elem) {
        double xDist = Math.abs(elem.pos.getX() - this.pos.getX());
        double yDist = Math.abs(elem.pos.getY() - this.pos.getY());
        
        if (xDist < 0.8 && yDist < 0.8){
            if(elem.isMortal == false && elem.isTransposable == true && elem instanceof Pacdots)
                Element.incrementPontuacaoPacdot();     
            if(elem.isMortal == false && elem.isTransposable == true && elem instanceof Fruta)
                Element.incrementPontuacaoFruta();
            return true;
            }            
        else
            return false;
    }
    
    public boolean overlapFantasma(Element elem) {
        double xDist = Math.abs(elem.pos.getX() - this.pos.getX());
        double yDist = Math.abs(elem.pos.getY() - this.pos.getY());
        
        if (xDist < 0.8 && yDist < 0.8){
           // if(elem.isMortal == false && elem.isTransposable == true)
              //  Element.incrementPontuacao();
            
            return true;
        }         
        else
            return false;
    }
    
    public boolean overlapUp(Element elem){
        double xDist = (elem.pos.getX() - this.pos.getX());
        
        if(xDist < 0 && Math.abs(xDist) < 1)
            return true;
        else
            return false;
    }
    
    public boolean overlapDown(Element elem){
        double xDist = (elem.pos.getX() - this.pos.getX());
        
        if(xDist > 0 && Math.abs(xDist) < 1)
            return true;
        else
            return false;
    }
    
    public boolean overlapLeft(Element elem){
        double yDist = (elem.pos.getY() - this.pos.getY());
        
        if(yDist < 0 && Math.abs(yDist) < 1)
            return true;
        else
            return false;
    }
    
    public boolean overlapRight(Element elem){
        double yDist = (elem.pos.getY() - this.pos.getY());
        
        if(yDist > 0 && Math.abs(yDist) < 1)
            return true;
        else
            return false;
    }
    
    public String getStringPosition() {
        return ("(" + pos.getX() + ", " + pos.getY() + ")");
    }
    
    public boolean setPosition(double x, double y) {
        return pos.setPosition(x, y);
    }

    public boolean isTransposable() {
        return isTransposable;
    }
    
    public boolean isMortal(){
        return isMortal;
    }
    
    public void isMortal(boolean isMortal){
        this.isMortal = isMortal;
    }
    
    public void setTransposable(boolean isTransposable) {
        this.isTransposable = isTransposable;
    }

    abstract public void autoDraw(Graphics g);

    public boolean moveUp() {
        return this.pos.moveUp();
    }

    public boolean moveDown() {
        return this.pos.moveDown();
    }

    public boolean moveRight() {
        return this.pos.moveRight();
    }

    public boolean moveLeft() {
        return this.pos.moveLeft();
    }
    
    public static void incrementPontuacaoPacdot(){
        Element.pontuacao += 10;
    } 
    
    public static void incrementPontuacaoFruta(){
        Element.pontuacao += 100;
    }
    
     public static int getPontuacao(){
        return Element.pontuacao;
    }
     
     public static int getVidas(){
         return Element.vidas;
     }
     
     public static void perdeuVida(){
         Element.vidas--;
     }
}
