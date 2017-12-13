package elements;

import java.awt.Graphics;
import java.io.Serializable;
import utils.Drawing;

/**
 *
 * @author mmiranda
 */
public class Pacdots extends Element implements Serializable{
    private static int numeroPacdots = 0;
    //Construtor
    public Pacdots(String imageName){
        super(imageName);
        this.isMortal = false;
    }
    
    @Override
    public void autoDraw(Graphics g) {
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
    
    public static void adicionarPacdot(){
        Pacdots.numeroPacdots++;
    }
    
    public static void removerPacdot(){
        Pacdots.numeroPacdots--;
    }
    
    public static int getNumeroPacdots(){
        return Pacdots.numeroPacdots;
    }
}
