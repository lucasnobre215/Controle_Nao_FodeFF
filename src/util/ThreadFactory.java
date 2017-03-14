/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author lucasnobre
 */
public class ThreadFactory {
    
    public static Thread produzirThread(Runnable classe, String nomeThread){
        return new Thread(classe, nomeThread);
    }
    
}
