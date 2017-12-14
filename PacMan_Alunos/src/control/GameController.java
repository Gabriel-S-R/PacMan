package control;

import elements.Clyde;
import elements.Inky;
import elements.Blinky;
import elements.Pinky;
import elements.Element;
import elements.Pacdots;
import elements.Pacman;
import java.awt.Graphics;
import java.util.ArrayList;
import utils.Drawing;

/**
 * Projeto de POO 2017
 * 
 * @author Luiz Eduardo
 * Baseado em material do Prof. Jose Fernando Junior
 */
public class GameController {
    
    public void drawAllElements(ArrayList<Element> elemArray, Graphics g){
        for(int i=5; i<elemArray.size(); i++){
            elemArray.get(i).autoDraw(g);
        }
        
        for(int i=0; i<5; i++){
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
        Blinky fblinky = (Blinky)e.get(2);
        Inky finky = (Inky)e.get(3);
        Clyde fclyde = (Clyde)e.get(4);
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
        
        if (!isValidPosition(e, fblinky)) {
            fblinky.backToLastPosition();
            fblinky.setMovDirection(fblinky.STOP);
            return;
        }
        
        if (!isValidPosition(e, finky)) {
            finky.backToLastPosition();
            finky.setMovDirection(finky.STOP);
            return;
        }
        
        if (!isValidPosition(e, fclyde)) {
            fclyde.backToLastPosition();
            fclyde.setMovDirection(fclyde.STOP);
            return;
        }
        
        //Caso um elemento seja transponível, ele some quando em contato com o pacman.
        Element eTemp;
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i);
            if(ppacman.overlap(eTemp))
                if(eTemp.isMortal()){
                    Element.perdeuVida();
                    if(Element.getVidas() == 0)
                        System.exit(0);
                    ppacman.setPosition(3, 1);
                    fpinky.setPosition(11, 13);
                    fblinky.setPosition(7, 10);
                    finky.setPosition(9, 5);
                    fclyde.setPosition(5, 13);
                }
                else if(eTemp.isTransposable()){
                    e.remove(eTemp);
                    if(eTemp instanceof Pacdots){
                       Pacdots.removerPacdot();
                       if(Pacdots.getNumeroPacdots() == 0)
                           if(Drawing.getGameScreen().getNivel() < 3)
                                Drawing.getGameScreen().passarNivel();
                    }
                }
        }
        
        
        
        //Chama a movimentação.
        ppacman.move();
        
        
        if(fpinky.getMovDirection() == 0){
            fpinky.randomDirection();
        }
        
        fpinky.move();
        
        if(fblinky.getMovDirection() == 0)
            fblinky.pacPos(ppacman);
        
        fblinky.move();
        
        if(finky.getMovDirection() == 0){
            if(finky.isFar(fblinky))
                finky.randomDirection();
            else
                finky.pacPos(ppacman);
        }
        
        finky.move();
        
        if(fclyde.getMovDirection() == 0){
            if(!fclyde.isFar(ppacman))
                fclyde.randomDirection();
            else
                fclyde.pacPos(ppacman);
        }
        
        fclyde.move();
        
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
