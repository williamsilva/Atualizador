/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atualizador.viwer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author William
 */
public class SpleshScreen {

    private static Timer tempo;
    private static ActionListener al;

    /**
     *
     * @param label
     * @param barra
     */
    public static void Splesh(JLabel label, JProgressBar barra) {
        al = (ActionEvent e) -> {
            if (barra.getValue() < 50) {
                barra.setValue(barra.getValue() + 1);
                label.setText("Copiando Arquivos...");
            } else if (barra.getValue() < 100) {
                barra.setValue(barra.getValue() + 1);
                label.setText("Aplicando atualizações...");

            } else {
                tempo.stop();
                newPrograma();
                System.exit(0);
            }
        };
        tempo = new Timer(20, al);
        tempo.start();
    }

    public static void newPrograma() {
        try {
            Runtime.getRuntime().exec("java -jar C:\\Users\\william\\Documents\\NetBeansProjects\\Solutions\\dist\\acqua.jar");

        } catch (IOException ex) {
            Logger.getLogger(SpleshScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
