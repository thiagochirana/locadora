/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.persistencia.DAO;

import com.neuron.exceptions.ComboBoxException;
import com.neuron.persistencia.IGuiDAO;
import com.neuron.templates.DataBase;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GuiDAO implements IGuiDAO{

    public GuiDAO() {
    }
    
    @Override
    public ArrayList<String> listagemCores() throws ComboBoxException, FileNotFoundException, IOException {
        ArrayList<String> listaNomeCores = new ArrayList<>();
        FileReader fr = new FileReader(DataBase.COR.getPathDB());
        BufferedReader br = new BufferedReader(fr);

        String linha = "";

        while ((linha = br.readLine()) != null) {
            listaNomeCores.add(linha);
        }
        br.close();
        return listaNomeCores;
    }
}
