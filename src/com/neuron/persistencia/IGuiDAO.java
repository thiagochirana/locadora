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
import com.neuron.templates.Cor;
import com.neuron.templates.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public interface IGuiDAO {
    void inserirNovaCor(Cor cor) throws Exception;
    ArrayList<String> listagemCores() throws ComboBoxException, FileNotFoundException, IOException;
    
    boolean validarAcesso(Usuario user, JFrame jf) throws Exception;
    JMenuBar customMenuBar(JFrame jf) throws Exception;
    
    ArrayList<String> UserDataHoraAcesso() throws Exception;
    
}
