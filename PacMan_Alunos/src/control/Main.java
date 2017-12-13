package control;

/*TODO List
#Fantasmas
#Stages
#Sprites do mesmo tamanho
#Terminar fruta
#Power pellets
#Parades
#Save
*/
public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GameScreen screen = new GameScreen();
                screen.setVisible(true);
                screen.createBufferStrategy(2);
                screen.go();
            }
        });
    }
}

