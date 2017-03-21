/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import funcoesControlador.FuncaoControle;
import funcoesControlador.FuncaoP;
import funcoesControlador.FuncaoPD;
import funcoesControlador.FuncaoPI;
import funcoesControlador.FuncaoPID;
import funcoesControlador.FuncaoPID2;

/**
 *
 * @author lucasnobre
 */
public class FabricaFuncaoControlador {
    
    
    public static FuncaoControle fabricarFuncaoControlador(ConfiguracaoProjeto cfg) {
        FuncaoControle funcaoControle = null;
        switch (cfg.getTipoControlador()) {
            case P:
                funcaoControle = new FuncaoP(cfg);
                break;
            case PI:
                funcaoControle = new FuncaoPI(cfg);
                break;
            case PD:
                funcaoControle = new FuncaoPD(cfg);
                break;
            case PID:
                funcaoControle = new FuncaoPID(cfg);  
                break;
            case PI_D:
                funcaoControle = new FuncaoPID2(cfg);
                break;

            default:
                throw new UnsupportedOperationException("Tipo de Funcao inválida");
        }

        return funcaoControle;
    }
    
    
}
