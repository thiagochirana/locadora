/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle.control;
import com.neuron.controle.*;
import com.neuron.persistencia.IMotoristaDAO;
import com.neuron.persistencia.DAO.*;
import com.neuron.templates.*;
import java.util.ArrayList;


public class ControleMotorista implements IControleMotorista{
    
    IMotoristaDAO motor;
    
    public ControleMotorista() {
        motor = new MotoristaDAO();
    }
    
    @Override
    public ArrayList<Motorista> listagemMotorista() throws Exception{
        return motor.listagemMotorista();
    }
    
    @Override
    public Estados getEstadoByNome(String nomeEstado) throws Exception{
        return motor.getEstadoByNome(nomeEstado);
    }
    
    @Override
    public void inserirMotorista(Motorista motorista) throws Exception{
        motor.inserirMotorista(motorista);
    }
    
    @Override
    public void alterarMotorista(Motorista motorista) throws Exception{
        motor.alterarMotorista(motorista);
    }
} 

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo