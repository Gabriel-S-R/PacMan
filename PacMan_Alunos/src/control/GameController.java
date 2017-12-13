package control;

import elements.Pinky;
import elements.Element;
import elements.Pacman;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Projeto de POO 2017
 * 
 * @author Luiz Eduardo
 * Baseado em material do Prof. Jose Fernando Junior
 */
public class GameController {
    public void drawAllElements(ArrayList<Element> elemArray, Graphics g){
        for(int i=2; i<elemArray.size(); i++){
            elemArray.get(i).autoDraw(g);
        }
        
        for(int i=0; i<2; i++){
            elemArray.get(i).autoDraw(g);
        }
    }
    
    //Processamento de elementos na interface gráfica.
    public void processAllElements(ArrayList<Element> e){
        if(e.isEmpty())
            return;
        
        //inicializa os objetos do cenário.
        Pacman ppacman = (Pacman)e.get(0);
        Pinky fpinky = (Pinky)e.get(1);
        
        //Caso um elemento seja intransponível, o pacman é barrado.
        if (!isValidPosition(e, ppacman)) {
            ppacman.backToLastPosition();
            ppacman.setMovDirection(ppacman.STOP);
            return;
        }
        
        if (!isValidPosition(e, fpinky)) {
            fpinky.backToLastPosition();
            fpinky.setMovDirection(fpinky.STOP);
            return;
        }
        
        //Caso um elemento seja transponível, ele some quando em contato com o pacman.
        Element eTemp;
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i);
            if(ppacman.overlap(eTemp))
                if(eTemp.isMortal())
                    ppacman.setPosition(3, 2);
                else if(eTemp.isTransposable())
                    e.remove(eTemp);
        }
        int l = 4;
        //Seta os graus de liberdade dos fantasmas
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i);
            if(!eTemp.isTransposable()){
                if(fpinky.overlapUp(eTemp)){
                    fpinky.setUP(false);
                    l--;
                }
                if(fpinky.overlapDown(eTemp)){
                    fpinky.setDOWN(false);
                    l--;
                }
                if(fpinky.overlapLeft(eTemp)){
                    fpinky.setLEFT(false);
                    l--;
                }
                if(fpinky.overlapRight(eTemp)){
                    fpinky.setRIGHT(false);
                    l--;
                }
            }
        }
        fpinky.setGrauDeLiberdade(l);
        
        
        //Chama a movimentação.
        ppacman.move();
        fpinky.moveAleatorio();
        
    }
    public boolean isValidPosition(ArrayList<Element> elemArray, Element elem){
        Element elemAux;
        for(int i = 1; i < elemArray.size(); i++){
            elemAux = elemArray.get(i);            
            if(!elemAux.isTransposable())
                if(elemAux.overlap(elem))
                    return false;
        }        
        return true;
    }
}
