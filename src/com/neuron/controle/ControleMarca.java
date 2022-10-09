/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle;

import com.neuron.templates.Marca;
import com.neuron.persistencia.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;


public class ControleMarca implements IControleMarca{
    IReadWriteMarca rw = null;
    
    public ControleMarca(){
        this.rw = new ReadWriteMarca() {};
    }
    
    private boolean buscarMarca(String descricao)throws Exception{
        try {
            ArrayList<Marca> listagem = rw.listagem();
            Iterator<Marca> lista = listagem.iterator();
            while(lista.hasNext()){
                 Marca marca = lista.next();
                if(marca.getNomeMarca().equalsIgnoreCase(descricao)){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            throw erro;
        }  
    }
    
    @Override
    public void incluir(Marca m) throws Exception {
        Marca marca = m;
        if (buscarMarca(marca.getNomeMarca())) {
            throw new Exception("Marca já foi cadastrada");
        }
        
        rw.incluir(marca);
    }

    @Override
    public ArrayList<Marca> listagem() throws Exception {
        return rw.listagem(); 
    }

}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
