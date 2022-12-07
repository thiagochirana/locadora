/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.persistencia.DAO;

import com.neuron.persistencia.*;
import com.neuron.templates.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class MotoristaDAO implements IMotoristaDAO{
    
    public ArrayList<Motorista> listagemMotorista() throws Exception{
        ArrayList<Motorista> motora = new ArrayList<>();
        
        File bancoMotorista = new File(DataBase.MOTORISTA.getPathDB());
        BufferedReader br = new BufferedReader(new FileReader(bancoMotorista));
        String linha;
        
        if (!bancoMotorista.exists()) {
            FileWriter bdMotora = new FileWriter(DataBase.MOTORISTA.getPathDB());
            FileWriter idMotora = new FileWriter(DataBase.IDMOTORISTA.getPathDB());
            bdMotora.write("");
            idMotora.write("0");
            bdMotora.close();
            idMotora.close();
        }
            
        return motora;
    }
    
}
// Software developed by Thiago Chirana -> https://github.com/othiagomacedo