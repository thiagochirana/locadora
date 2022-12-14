/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle.control;

import com.neuron.controle.*;
import com.neuron.persistencia.*;
import com.neuron.persistencia.DAO.*;
import com.neuron.templates.*;
import java.util.ArrayList;


public class ControleOperacao implements IControleOperacao{
    
    IOperacaoDAO oper;
    
    public ControleOperacao(){
        oper = new OperacaoDAO();
    }
    
    @Override
    public void realizarVenda(Operacao operacao) throws Exception{
        oper.realizarVenda(operacao);
    }
    
    @Override
    public ArrayList<Cliente> listarCliente() throws Exception{
        return oper.listarCliente();
    }
    
    @Override
    public ArrayList<Veiculo> listagemVeiculo() throws Exception{
        return oper.listagemVeiculo();
    }
    
    
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
