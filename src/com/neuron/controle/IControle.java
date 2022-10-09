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
import java.util.ArrayList;


public interface IControle {
    void incluir(Marca marca)throws Exception;
    ArrayList<Marca> listagem()throws Exception;

}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
