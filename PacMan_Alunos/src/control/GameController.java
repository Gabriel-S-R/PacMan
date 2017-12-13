package control;

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
        for(int i=0; i<elemArray.size(); i++){
            elemArray.get(i).autoDraw(g);
        }
    }
    
    //Processamento de elementos na interface gráfica.
    public void processAllElements(ArrayList<Element> e){
        if(e.isEmpty())
            return;
        
        //Caso um elemento seja intransponível, o pacman é barrado.
        Pacman ppacman = (Pacman)e.get(0);
        if (!isValidPosition(e, ppacman)) {
            ppacman.backToLastPosition();
            ppacman.setMovDirection(ppacman.STOP);
            return;
        }
        
        //Caso um elemento seja transponível, ele some quando em contato com o pacman.
        Element eTemp;
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i);
            if(ppacman.overlap(eTemp))
                if(eTemp.isTransposable())
                    e.remove(eTemp);                    
        }
        //Chama a movimentação do pacman.
        ppacman.move();
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
