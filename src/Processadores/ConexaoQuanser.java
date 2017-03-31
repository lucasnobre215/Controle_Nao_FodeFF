/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processadores;

import br.ufrn.dca.controle.QuanserClient;
import br.ufrn.dca.controle.QuanserClientException;
import java.awt.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConfiguracaoProjeto;

/**
 *
 * @author lucasnobre
 */
public class ConexaoQuanser {
    
    ConfiguracaoProjeto cfg;
    QuanserClient quanser;

    public ConexaoQuanser(ConfiguracaoProjeto cfg) {
        try {
            this.cfg = cfg;
            quanser = new QuanserClient(cfg.getIpServidor(), cfg.getPortaServidor());
        } catch (QuanserClientException ex) {
            Logger.getLogger(ConexaoQuanser.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
     
   public void lerSensorControle(int porta){
       readValue(porta);
   } 
   
   public double lerSensorSegurnacao(int porta){
       double retorno = 0; 
       try {
            retorno = 6.25*quanser.read(porta);
        } catch (QuanserClientException ex) {
            Logger.getLogger(ConexaoQuanser.class.getName()).log(Level.SEVERE, null, ex);
        }
       return retorno;
   }
   /*retorna o valor  do nivel em cm*/
   public void readValue(int porta){
        try {
            cfg.setValorAnteriorSensor(cfg.getValorSensor());
            cfg.setValorSensor(6.25*quanser.read(porta));
        } catch (QuanserClientException ex) {
            Logger.getLogger(ConexaoQuanser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void writeValue(int porta, Double valor){
        try {
            quanser.write(porta, valor);
        } catch (QuanserClientException ex) {
            Logger.getLogger(ConexaoQuanser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    
}
