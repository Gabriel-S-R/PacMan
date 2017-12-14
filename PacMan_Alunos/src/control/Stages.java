package control;

import elements.Clyde;
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
    protected final Clyde clyde;
    public Stages(int numeroStage){
        elemArray = new ArrayList<Element>();
        pacman = new Pacman("pacman.png");
        pacman.setPosition(3, 1);
        elemArray.add(pacman); 
            
        pinky = new Pinky("pinky.png");
        pinky.setPosition(11, 13);
        elemArray.add(pinky);
         
        blinky = new Blinky("blinky.png");
        blinky.setPosition(7, 10);
        elemArray.add(blinky);
         
        inky = new Inky("inky.png");
        inky.setPosition(9, 5);
        elemArray.add(inky);
        
        clyde = new Clyde("clyde.png");
        clyde.setPosition(5, 13);
        elemArray.add(clyde);
        
        if(numeroStage == 1){       
                     
             //Blocos horizontais                      
        for(int i=0; i<Consts.NUM_CELLS; i++){
            Bloco hbloco = new Bloco("blocohorizontal.png");
            hbloco.setPosition(2, i);
            elemArray.add(hbloco);
        }
        
        for(int i=0; i<Consts.NUM_CELLS; i++){
            Bloco hbloco = new Bloco("blocohorizontal.png");
            hbloco.setPosition(14, i);
            elemArray.add(hbloco);
        }
        
        //Blocos verticais
        for(int i=3; i<Consts.NUM_CELLS-1; i++){
            Bloco vbloco = new Bloco("blocovertical.png");
            vbloco.setPosition(i, 0);
            elemArray.add(vbloco);
        }
        for(int i=3; i<Consts.NUM_CELLS-1; i++){
            Bloco vbloco = new Bloco("blocovertical.png");
            vbloco.setPosition(i, 14);
            elemArray.add(vbloco);
        }
        
        for(int i=4; i<14; i = i+2){
            for(int j=2; j<14; j = j+2){
                Bloco vbloco = new Bloco("blocovertical.png");
                vbloco.setPosition(i, j);
                elemArray.add(vbloco);
            }
        }
        
        
        //Pacdots
        for(int i=3; i<Consts.NUM_CELLS; i = i+2){
            for(int j=1; j<Consts.NUM_CELLS;j = j+2){
               Pacdots pacdot = new Pacdots("pacdot.png");
               pacdot.setPosition(i, j);
               elemArray.add(pacdot);
               Pacdots.adicionarPacdot();
            }
        }
       
        //Fruta
        Fruta f = new Fruta("fruta.png");
        f.setTimerFruta();
        
        }
        
        if(numeroStage == 3){
            
        for(int i=3; i<Consts.NUM_CELLS-1; i++){
            Bloco vbloco = new Bloco("blocovertical.png");
            vbloco.setPosition(i, 0);
            elemArray.add(vbloco);
        }
        
        for(int i=3; i<Consts.NUM_CELLS-3; i++){
            Bloco hbloco = new Bloco("blocohorizontal.png");
            hbloco.setPosition(11, i);
            elemArray.add(hbloco);
        }
        
        for(int i=3; i<Consts.NUM_CELLS-3; i++){
            Bloco hbloco = new Bloco("blocohorizontal.png");
            hbloco.setPosition(5, i);
            elemArray.add(hbloco);
        }
        
        for(int i=0; i<Consts.NUM_CELLS; i++){
            Bloco hbloco = new Bloco("blocohorizontal.png");
            hbloco.setPosition(2, i);
            elemArray.add(hbloco);
        }
            
        for(int i=0; i<Consts.NUM_CELLS; i++){
            Bloco hbloco = new Bloco("blocohorizontal.png");
            hbloco.setPosition(14, i);
            elemArray.add(hbloco);
        }
            
        for(int i=3; i<Consts.NUM_CELLS-1; i++){
            Bloco vbloco = new Bloco("blocovertical.png");
            vbloco.setPosition(i, 14);
            elemArray.add(vbloco);
        }
        
        for(int i=5; i<Consts.NUM_CELLS-3; i++){
            if(i != 6 && i != 7 && i != 8 && i != 9 && i!= 10){
                Bloco vbloco = new Bloco("blocovertical.png");
                vbloco.setPosition(i, 3);
                elemArray.add(vbloco);
            }
        }
             
        for(int i=3; i<Consts.NUM_CELLS; i = i+2){
            for(int j=1; j<Consts.NUM_CELLS;j = j+2){
               if((i!=5 || j!= 5) &&(i!=5 || j!= 7) && (i!=5 || j!= 3) && (i!=5 || j!= 9) && (i!=5 || j!=11) && (i!=7 || j!= 11) && (i!=9 || j!=11) && (i!=11 || j!=11) && (i!=11 || j!= 9) && (i!=7 || j!= 11) && (i!=11 || j!= 5) && (i!=11 || j!= 7) && (i!=11 || j!= 3)){
                Pacdots pacdot = new Pacdots("pacdot.png");
                pacdot.setPosition(i, j);
                elemArray.add(pacdot);
                Pacdots.adicionarPacdot();
               }
            }
        }
        }     
        if(numeroStage == 2){
            
            for(int i=0; i<Consts.NUM_CELLS; i++){
                Bloco hbloco = new Bloco("blocohorizontal.png");
                hbloco.setPosition(2, i);
                elemArray.add(hbloco);
            }

            for(int i=0; i<Consts.NUM_CELLS; i++){
                Bloco hbloco = new Bloco("blocohorizontal.png");
                hbloco.setPosition(14, i);
                elemArray.add(hbloco);
            }
            for(int i=3; i<Consts.NUM_CELLS-1; i++){
                Bloco vbloco = new Bloco("blocovertical.png");
                vbloco.setPosition(i, 0);
                elemArray.add(vbloco);
            }
            for(int i=3; i<Consts.NUM_CELLS-1; i++){
                Bloco vbloco = new Bloco("blocovertical.png");
                vbloco.setPosition(i, 14);
                elemArray.add(vbloco);
            }
            
            for(int i=2; i<Consts.NUM_CELLS-2; i++){
                Bloco hbloco = new Bloco("blocohorizontal.png");
                hbloco.setPosition(4, i);
                elemArray.add(hbloco);
            }
            
            for(int i=3; i<Consts.NUM_CELLS-3; i++){
                Bloco hbloco = new Bloco("blocohorizontal.png");
                hbloco.setPosition(6, i);
                elemArray.add(hbloco);
            }
            
            for(int i=4; i<Consts.NUM_CELLS-4; i++){
                Bloco hbloco = new Bloco("blocohorizontal.png");
                hbloco.setPosition(8, i);
                elemArray.add(hbloco);
            }
            
            for(int i=3; i<Consts.NUM_CELLS-3; i++){
                Bloco hbloco = new Bloco("blocohorizontal.png");
                hbloco.setPosition(10, i);
                elemArray.add(hbloco);
            }
            
            for(int i=2; i<Consts.NUM_CELLS-2; i++){
                Bloco hbloco = new Bloco("blocohorizontal.png");
                hbloco.setPosition(12, i);
                elemArray.add(hbloco);
            }
            
            for(int i=3; i<Consts.NUM_CELLS-1; i = i+2){
                for(int j=1; j<Consts.NUM_CELLS;j = j+2){
                    Pacdots pacdot = new Pacdots("pacdot.png");
                    pacdot.setPosition(i, j);
                    elemArray.add(pacdot);
                    Pacdots.adicionarPacdot();
            }
        }
      
        }
        
 
    }
 
    
    public ArrayList<Element> getArrayElem(){
        return (this.elemArray);
    }
}

