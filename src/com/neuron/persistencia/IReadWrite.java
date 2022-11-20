/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.persistencia;

import com.neuron.icons.Telas;
import com.neuron.persistencia.exceptions.ComboBoxException;
import com.neuron.templates.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public interface IReadWrite{
    void incluirMarca(Marca marca)throws Exception;
    void alterarMarca(int id, String nomeMarca,String caminhoLogo) throws Exception;
    ArrayList<Marca> listagemMarca()throws Exception;
    ArrayList<String> listagemNomeMarcas() throws Exception;
    
    void incluirModelo(Modelo modelo)throws Exception;
    void alterarModelo(int id, String nomeModelo,String caminhoFotoModelo, int idMarca) throws Exception;
    ArrayList<Modelo> listagemModelo()throws ComboBoxException;
    ArrayList<String> listagemNomeModelo() throws Exception;
    
    ArrayList<Veiculo> listagemVeiculo() throws Exception;
    
    void inserirNovaCor(String nomeCor) throws Exception;
    ArrayList<String> listagemCores() throws ComboBoxException, FileNotFoundException, IOException;
    ArrayList<String> listarTipoCombustivel() throws Exception;
    ArrayList<String> listarTipoVeiculo() throws Exception;
    ArrayList<String> listarDisponivel() throws Exception;
    
    void verificaBanco(Telas tela) throws Exception;
    
    boolean verificaUser(ArrayList<String> usuario) throws Exception;
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
