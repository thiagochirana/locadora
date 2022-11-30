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


public interface IControleMarca {
    void incluirMarca(Marca marca) throws Exception;

    void alterarMarca(int id, String nomeMarca, String caminhoLogo) throws Exception;

    ArrayList<Marca> listagemMarca() throws Exception;

    public ArrayList<String> listagemNomeMarcas() throws Exception;
}

// Software developed by Thiago Chirana -> https://github.com/othiagomacedo