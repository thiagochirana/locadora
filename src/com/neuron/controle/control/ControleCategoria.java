/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle.control;

import com.neuron.controle.IControleCategoria;
import com.neuron.persistencia.DAO.CategoriaDAO;
import com.neuron.persistencia.ICategoriaDAO;
import com.neuron.templates.*;
import java.util.ArrayList;


public class ControleCategoria implements IControleCategoria{

    ICategoriaDAO icd;
    
    public ControleCategoria() {
        icd = new CategoriaDAO();
    }
    
    @Override
    public void inserirCategoria(Categoria categoria) throws Exception{
        icd.inserirCategoria(categoria);
    }
    
    @Override
    public void alterarCategoria(Categoria categoria) throws Exception{
        icd.alterarCategoria(categoria);
    }
    
    @Override
    public ArrayList<Categoria> listagemCategoria() throws Exception{
        return icd.listagemCategoria();
    }
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
