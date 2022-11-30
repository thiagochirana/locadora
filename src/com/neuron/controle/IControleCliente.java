/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle;

import com.neuron.templates.Cliente;
import java.util.ArrayList;


public interface IControleCliente {
    ArrayList<Cliente> listagemCliente()throws Exception;
    void alterarCliente(Cliente cliente) throws Exception;
}

// Software developed by Thiago Chirana -> https://github.com/othiagomacedo