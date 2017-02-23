/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Travas;

/**
 *
 * @author Felipe
 */
public class Trava {

    private int tensaoMaxima;
    private int tensaoMinima;

    public Trava(int tensaoMaxima,int tensaoMinima)
    {
        this.tensaoMaxima = tensaoMaxima;
        this.tensaoMinima = tensaoMinima;
    
    }
    
    
    public int travaTensao(int tensao) {
        if (tensao >= tensaoMaxima) {
            return tensaoMaxima;
        }

        else if (tensao <= tensaoMinima)
        {
            return tensaoMinima;   
        }
        
        else
        {
             return tensao;    
        }

    }
}
