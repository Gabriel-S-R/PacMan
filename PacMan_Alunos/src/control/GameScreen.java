package control;

import elements.Bloco;
import elements.Pinky;
import elements.Pacdots;
import elements.Fruta;
import elements.Pacman;
import elements.Element;
import utils.Consts;
import utils.Drawing;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Projeto de POO 2017
 * 
 * @author Luiz Eduardo
 * Baseado em material do Prof. Jose Fernando Junior
 */
public class GameScreen extends javax.swing.JFrame implements KeyListener {
    
    private final Pacman pacman;
    private final Pinky pinky;
    private final ArrayList<Element> elemArray;                        //Array que representa os elementos da interface.
    private final GameController controller = new GameController();    
    Timer timer;

    public GameScreen() {
        Drawing.setGameScreen(this);
        initComponents();
        
        this.addKeyListener(this);   /*teclado*/
        
        /*Cria a janela do tamanho do tabuleiro + insets (bordas) da janela*/
        this.setSize(Consts.NUM_CELLS * Consts.CELL_SIZE + getInsets().left + getInsets().right,
                     Consts.NUM_CELLS * Consts.CELL_SIZE + getInsets().top + getInsets().bottom);

        elemArray = new ArrayList<Element>();

        /*Cria e adiciona elementos*/
        //PacMan
        pacman = new Pacman("pacman.png");
        pacman.setPosition(4, 2);
        this.addElement(pacman); 
        
        //Fantasmas
        
            //Pinky
        pinky = new Pinky("pinky.png");
        pinky.setPosition(12, 13);
        this.addElement(pinky);
        
        //Blocos horizontais
        for(int i=0; i<Consts.NUM_CELLS; i++){
            Bloco hbloco = new Bloco("blocohorizontal.png");
            hbloco.setPosition(2, i);
            this.addElement(hbloco);
        }
        
        for(int i=0; i<Consts.NUM_CELLS; i++){
            Bloco hbloco = new Bloco("blocohorizontal.png");
            hbloco.setPosition(14, i);
            this.addElement(hbloco);
        }
        
        //Blocos verticais
        for(int i=3; i<Consts.NUM_CELLS-1; i++){
            Bloco vbloco = new Bloco("blocovertical.png");
            vbloco.setPosition(i, 0);
            this.addElement(vbloco);
        }
        for(int i=3; i<Consts.NUM_CELLS-1; i++){
            Bloco vbloco = new Bloco("blocovertical.png");
            vbloco.setPosition(i, 14);
            this.addElement(vbloco);
        }
        
        for(int i=3; i<14; i = i+2){
            for(int j=2; j<14; j = j+2){
                Bloco vbloco = new Bloco("blocovertical.png");
                vbloco.setPosition(i, j);
                this.addElement(vbloco);
            }
        }
        
        
        //Pacdots
        for(int i=3; i<Consts.NUM_CELLS; i = i+2){
            for(int j=1; j<Consts.NUM_CELLS;j = j+2){
               Pacdots pacdot = new Pacdots("pacdot.png");
               pacdot.setPosition(i, j);
               this.addElement(pacdot);
               Pacdots.adicionarPacdot();
            }
        }
       
        //Fruta
        Fruta f = new Fruta("fruta.png");
        f.setTimerFruta();
        
        Bloco vbloco = new Bloco("blocovertical.png");
                vbloco.setPosition(5, 1);
                this.addElement(vbloco);
        
    }
    
    public final void addElement(Element elem) {
        elemArray.add(elem);
    }
    
    public void removeElement(Element elem) {
        elemArray.remove(elem);
    }
    
    @Override
    public void paint(Graphics gOld) {
        Graphics g = getBufferStrategy().getDrawGraphics();
        
        /*Criamos um contexto grafico*/
        Graphics g2 = g.create(getInsets().right, getInsets().top, getWidth() - getInsets().left, getHeight() - getInsets().bottom);
        
        /* DESENHA CENARIO
           Trocar essa parte por uma estrutura mais bem organizada
           Utilizando a classe Stage
        */
        for (int i = 0; i < Consts.NUM_CELLS; i++) {
            for (int j = 0; j < Consts.NUM_CELLS; j++) {
                try {
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "fundo.png");
                    g2.drawImage(newImage,
                            j * Consts.CELL_SIZE, i * Consts.CELL_SIZE, Consts.CELL_SIZE, Consts.CELL_SIZE, null);
                    
                } catch (IOException ex) {
                    Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        this.controller.drawAllElements(elemArray, g2);
        this.controller.processAllElements(elemArray);
        this.setTitle("-> Cell: " + pacman.getStringPosition());
       
        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }
    
    public void go() {
        TimerTask task = new TimerTask() {
            
            public void run() {
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, Consts.DELAY);
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pacman.setMovDirection(pacman.MOVE_UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pacman.setMovDirection(pacman.MOVE_DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pacman.setMovDirection(pacman.MOVE_LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pacman.setMovDirection(pacman.MOVE_RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            pacman.setMovDirection(pacman.STOP);
        }
        
        //repaint(); /*invoca o paint imediatamente, sem aguardar o refresh*/
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCC0604 - Pacman");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(20, 20));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
