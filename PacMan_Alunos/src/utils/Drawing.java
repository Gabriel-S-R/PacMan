package utils;

import control.GameScreen;
import elements.Element;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;
import javax.swing.ImageIcon;

/**
 * Projeto de POO 2017
 * 
 * @author Luiz Eduardo
 * Baseado em material do Prof. Jose Fernando Junior
 */
public class Drawing {
    static GameScreen screen;
    static Font font;

    public static GameScreen getGameScreen() {
        return screen;
    }

    public static void setGameScreen(GameScreen newScreen) {
        screen = newScreen;
    }    
    public static void draw(Graphics g, ImageIcon imageIcon, double y, double x) {
        //System.out.println("y="+(y * Consts.CELL_SIZE)+", x="+(x * Consts.CELL_SIZE));
        imageIcon.paintIcon(screen, g, (int)Math.round(y * Consts.CELL_SIZE),(int)Math.round(x * Consts.CELL_SIZE));
    
        try{
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("imgs/SFEspressoShack-Bold.ttf")));
            font = new Font("SFEspressoShack-Bold", Font.PLAIN, 18);
        } catch (IOException | FontFormatException ex){
            System.out.println(ex.getMessage());
        }
        
        g.setColor(Color.decode("#333333"));
        
        int height = Consts.HEADER_SIZE;
        int widht = Consts.NUM_CELLS;
        g.fillRect(0, 0, widht*Consts.CELL_SIZE, height*Consts.CELL_SIZE);
        
        AttributedString word = new AttributedString("Score: " + Element.getPontuacao());
        word.addAttribute(TextAttribute.FONT, font);
        g.setColor(Color.green);
        g.drawString(word.getIterator(), Consts.CELL_SIZE, Consts.CELL_SIZE);
        
        word = new AttributedString("Lifes: " + Element.getVidas());
        word.addAttribute(TextAttribute.FONT, font);
        g.setColor(Color.green);
        g.drawString(word.getIterator(), (Consts.NUM_CELLS - 5)*Consts.CELL_SIZE, Consts.CELL_SIZE);
        
        word = new AttributedString("Level: " + Drawing.getGameScreen().getNivel());
        word.addAttribute(TextAttribute.FONT, font);
        g.setColor(Color.orange);
        g.drawString(word.getIterator(), (Consts.NUM_CELLS - 5)*Consts.CELL_SIZE, Consts.CELL_SIZE+20);
    }
}
