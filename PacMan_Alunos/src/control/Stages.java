package control;

import elements.Inky;
import elements.Blinky;
import elements.Bloco;
import elements.Element;
import elements.Fruta;
import elements.Pacdots;
import elements.Pacman;
import elements.Pinky;
import java.util.ArrayList;
import utils.Consts;
import utils.Drawing;

/**
 *
 * @author Gabriel
 */
public class Stages {
    protected final ArrayList<Element> elemArray;
    protected final Pacman pacman;
    protected final Pinky pinky;
    protected final Blinky blinky;
    protected final Inky inky;
    public Stages(int numeroStage){
        elemArray = new ArrayList<Element>();
        pacman = new Pacman("pacman.png");
        pacman.setPosition(3, 1);
        elemArray.add(pacman); 
            
        pinky = new Pinky("pinky.png");
        pinky.setPosition(11, 13);
        elemArray.add(pinky);
         
        blinky = new Blinky("blinky.png");
        blinky.setPosition(11, 8);
        elemArray.add(blinky);
         
        inky = new Inky("inky.png");
        inky.setPosition(11, 4);
        elemArray.add(inky);
        
        if(numeroStage == 1){       
                     
             //Blocos horizontais                      
        for(int i=0; i<Consts.NUM_CELLS; i++){
            Bloco hbloco = new Bloco("blocohorizontal.png");
            hbloco.setPosition(2, i);
            elemArray.add(hbloco);
          //  Drawing.getGameScreen().addElement(hbloco);
        }
        
        for(int i=0; i<Consts.NUM_CELLS; i++){
            Bloco hbloco = new Bloco("blocohorizontal.png");
            hbloco.setPosition(14, i);
            elemArray.add(hbloco);
         //   Drawing.getGameScreen().addElement(hbloco);
        }
        
        //Blocos verticais
        for(int i=3; i<Consts.NUM_CELLS-1; i++){
            Bloco vbloco = new Bloco("blocovertical.png");
            vbloco.setPosition(i, 0);
            elemArray.add(vbloco);
         //   Drawing.getGameScreen().addElement(vbloco);
        }
        for(int i=3; i<Consts.NUM_CELLS-1; i++){
            Bloco vbloco = new Bloco("blocovertical.png");
            vbloco.setPosition(i, 14);
            elemArray.add(vbloco);
       //     Drawing.getGameScreen().addElement(vbloco);
        }
        
        for(int i=4; i<14; i = i+2){
            for(int j=2; j<14; j = j+2){
                Bloco vbloco = new Bloco("blocovertical.png");
                vbloco.setPosition(i, j);
                elemArray.add(vbloco);
          //      Drawing.getGameScreen().addElement(vbloco);
            }
        }
        
        
        //Pacdots
        for(int i=3; i<Consts.NUM_CELLS; i = i+2){
            for(int j=1; j<Consts.NUM_CELLS;j = j+2){
               Pacdots pacdot = new Pacdots("pacdot.png");
               pacdot.setPosition(i, j);
               elemArray.add(pacdot);
         //      Drawing.getGameScreen().addElement(pacdot);
               Pacdots.adicionarPacdot();
            }
        }
       
        //Fruta
        Fruta f = new Fruta("fruta.png");
        f.setTimerFruta();
        
        }
    }
    
    public ArrayList<Element> getArrayElem(){
        return (this.elemArray);
    }
}

