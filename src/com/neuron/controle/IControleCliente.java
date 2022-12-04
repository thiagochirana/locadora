/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle;

import com.neuron.templates.*;
import java.util.ArrayList;
import java.util.List;


public interface IControleCliente {
    ArrayList<Cliente> listagemCliente()throws Exception;
    void InserirCliente(Cliente cliente) throws Exception;
    void alterarCliente(Cliente cliente) throws Exception;
    Estados getEstadoByNome(String nomeEstado) throws Exception;
    List<String> getStatusMulta() throws Exception;
    List<String> getNomeEstados() throws Exception;
}

// Software developed by Thiago Chirana -> https://github.com/othiagomacedo