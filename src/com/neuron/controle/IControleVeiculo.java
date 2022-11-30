/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle;

import com.neuron.templates.Veiculo;
import java.util.ArrayList;


public interface IControleVeiculo {
    void incluirVeiculo(Veiculo veiculo) throws Exception;

    void alterarVeiculo(Veiculo veiculo) throws Exception;

    ArrayList<Veiculo> listagemVeiculo() throws Exception;
    ArrayList<String> listarTipoCombustivel() throws Exception;

    ArrayList<String> listarTipoVeiculo() throws Exception;

    ArrayList<String> listarDisponivel() throws Exception;
}

// Software developed by Thiago Chirana -> https://github.com/othiagomacedo