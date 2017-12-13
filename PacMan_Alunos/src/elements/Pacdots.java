/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.awt.Graphics;
import utils.Drawing;

/**
 *
 * @author mmiranda
 */
public class Pacdots extends Element {
    //Construtor
    public Pacdots(String imageName){
        super(imageName);
    }
    
    public void autoDraw(Graphics g) {
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
}
