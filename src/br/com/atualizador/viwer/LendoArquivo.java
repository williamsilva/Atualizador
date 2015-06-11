package br.com.atualizador.viwer;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WILLIAM
 */
public class LendoArquivo {

    public static void verifica() throws IOException {
        String VersaoAtual = versaoAtual();
        String VersaoNova = novaVersao();

        if ((VersaoAtual == null ? VersaoNova != null : !VersaoAtual.equals(VersaoNova)) && Integer.parseInt(VersaoAtual) < Integer.parseInt(VersaoNova)) {
            try {
                //Abrindo o programa se não tiver nova versão
                Runtime.getRuntime().exec("java -jar C:\\Users\\william\\Documents\\NetBeansProjects\\Solutions\\dist\\acqua.jar");
                System.exit(0);
            } catch (IOException ex) {
                Logger.getLogger(SpleshScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Transferindo Novos Arquivos 
            File origem = new File("C:\\Users\\william\\Documents\\NetBeansProjects\\Solutions");
            File destino = new File("C:\\Users\\william\\Google Drive\\Solutions");
            CopyDir.copyFiles(origem, destino);
            
            try {
                
                Runtime.getRuntime().exec("java -jar C:\\Users\\william\\Documents\\NetBeansProjects\\Solutions\\dist\\acqua.jar");
                System.exit(0);
            } catch (IOException ex) {
                Logger.getLogger(SpleshScreen.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static String versaoAtual() throws FileNotFoundException, IOException {

        String diretorio = "C:\\Users\\william\\Documents\\NetBeansProjects\\WssAtualizador\\WssAtualizador.txt";
        BufferedReader br = new BufferedReader(new FileReader(diretorio));

        String ultimaLinha = br.readLine();
        String versaoAtual = null;
        while (ultimaLinha != null) {

            versaoAtual = ultimaLinha;
            ultimaLinha = br.readLine();
        }
        br.close();
        return versaoAtual;
    }

    public static String novaVersao() throws FileNotFoundException, IOException {

        String diretorio = "C:\\Users\\william\\Documents\\NetBeansProjects\\WssAtualizador\\Wss.txt";
        BufferedReader br = new BufferedReader(new FileReader(diretorio));

        String ultimaLinha = br.readLine();
        String versaoNova = null;
        while (ultimaLinha != null) {

            versaoNova = ultimaLinha;
            ultimaLinha = br.readLine();
        }
        br.close();
        return versaoNova;

    }

}
