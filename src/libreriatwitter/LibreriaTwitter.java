/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriatwitter;

import javax.swing.JOptionPane;
import twitter4j.TwitterException;

/**
 *
 * @author Zarza
 */
public class LibreriaTwitter {

    /**
     * @param args the command line arguments
     * @throws twitter4j.TwitterException
     */
    public static void main(String[] args) throws TwitterException {
        String tweet, buscar;
        int op;

        Metodos obj = new Metodos();

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("1 - TimeLine\n2 - Buscar\n3 - Escribir Tweet\n4 - Salir"));
            switch (op) {
                case 1:
                    obj.verTimeLine();
                    break;
                case 2:
                    buscar = JOptionPane.showInputDialog("¿Qué quieres buscar?");
                    obj.buscarTweet(buscar);
                    break;
                case 3:
                    tweet = JOptionPane.showInputDialog("Escribir Tweet:");
                    obj.escribirTweet(tweet);
                    break;
                case 4:
                    System.exit(0);
                
            }
        } while (op != 4);
    
    }
    
}
