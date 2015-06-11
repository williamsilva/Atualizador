/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atualizador.viwer;

import static br.com.atualizador.viwer.SpleshScreen.newPrograma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 *
 * @author William
 */
public class CopyDir {

    private static Timer tempo;
    private static ActionListener al;
    private static String teste = null;

    public static void copyFiles(File origem, File destino) throws FileNotFoundException, IOException {

        if (origem.isDirectory()) {
            if (!destino.exists()) {
                destino.mkdir();
            }
            String[] filePaths = origem.list();

            for (String filePath : filePaths) {

                File origemFile = new File(origem, filePath);
                File destinoFile = new File(destino, filePath);

                copyFiles(origemFile, destinoFile);
            }

        } else {
            FileInputStream from = null;
            FileOutputStream to = null;

            from = new FileInputStream(origem);
            to = new FileOutputStream(destino);
            byte[] buffer = new byte[4096];
            int byteReias;
            while ((byteReias = from.read(buffer)) != -1) {
                to.write(buffer, 0, byteReias);

            }
            from.close();
            to.close();

        }
    }

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

}
