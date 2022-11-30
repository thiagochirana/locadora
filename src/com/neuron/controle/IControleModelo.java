/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle;

import com.neuron.exceptions.ComboBoxException;
import com.neuron.templates.Modelo;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public interface IControleModelo {
    void incluirModelo(Modelo modelo) throws Exception;

    void alterarModelo(int id, String nomeModelo, String caminhoFotoModelo, int idMarca) throws Exception;

    ArrayList<Modelo> listagemModelo() throws ComboBoxException;

    ArrayList<String> listagemNomeModelo() throws Exception;
}

// Software developed by Thiago Chirana -> https://github.com/othiagomacedo