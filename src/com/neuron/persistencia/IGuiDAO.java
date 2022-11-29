/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/
package com.neuron.persistencia;

import com.neuron.exceptions.ComboBoxException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IGuiDAO {
    ArrayList<String> listagemCores() throws ComboBoxException, FileNotFoundException, IOException;
}
