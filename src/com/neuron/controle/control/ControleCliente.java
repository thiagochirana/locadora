/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle.control;

import com.neuron.controle.IControleCliente;
import com.neuron.persistencia.IClienteDAO;
import com.neuron.persistencia.DAO.ClienteDAO;
import com.neuron.templates.Cliente;
import java.util.ArrayList;


public class ControleCliente implements IControleCliente{
    IClienteDAO cliente;

    public ControleCliente() {
        cliente = new ClienteDAO();
    }
    
    @Override
    public ArrayList<Cliente> listagemCliente()throws Exception{
        
    }
}
// Software developed by Thiago Chirana -> https://github.com/othiagomacedo