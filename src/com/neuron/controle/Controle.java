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


public class Controle implements IControle{
    IReadWrite rw = null;
    
    public Controle(){
        this.rw = new ReadWrite() {};
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
