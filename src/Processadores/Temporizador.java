/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processadores;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConfiguracaoProjeto;

/**
 *
 * @author lucasnobre
 */
public class Temporizador implements Runnable {

    public double tempo;
    public ConfiguracaoProjeto cfg;

    public Temporizador(ConfiguracaoProjeto cfg) {
        this.tempo = 0d;
        this.cfg = cfg;
    }

    @Override
    public void run() {
        while (cfg.isRunning()) {
            try {
                tempo += 0.001;
                sleep((long) 100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public double getTempo() {
        return tempo;
    }

}
