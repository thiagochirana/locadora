/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle;

import com.neuron.templates.Cor;
import java.util.ArrayList;



public interface IControleGUI {
    void inserirNovaCor(Cor cor) throws Exception;
    ArrayList<String> listagemCores() throws Exception;
}

// Software developed by Thiago Chirana -> https://github.com/othiagomacedo