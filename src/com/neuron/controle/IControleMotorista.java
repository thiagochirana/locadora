/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle;

import com.neuron.templates.Estados;
import com.neuron.templates.Motorista;
import java.util.ArrayList;


public interface IControleMotorista {
    ArrayList<Motorista> listagemMotorista() throws Exception;

    Estados getEstadoByNome(String nomeEstado) throws Exception;

    void inserirMotorista(Motorista motorista) throws Exception;

    void alterarMotorista(Motorista motorista) throws Exception;
} 

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo