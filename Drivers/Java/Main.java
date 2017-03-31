/*
 * Main.java
 *
 * Created on March 14, 2008, 4:18 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package javaapplication1;

import br.ufrn.dca.controle.QuanserClient;
import br.ufrn.dca.controle.QuanserClientException;

/**
 *
 * @author Leo
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        QuanserClient quanserClient;
        try {
            quanserClient = new QuanserClient("127.0.0.1", 20072);
            double _read = quanserClient.read(0);
            System.out.println("Leitura Canal 0: " + _read);
            System.out.println("Gravando 1.2 volts no canal 4...");
            quanserClient.write(4,1.2);
        } 
        catch (QuanserClientException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}
