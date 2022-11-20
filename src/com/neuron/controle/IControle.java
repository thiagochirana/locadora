/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle;

import com.neuron.icons.Telas;
import com.neuron.templates.*;
import java.util.ArrayList;


public interface IControle {
    void incluirMarca(Marca marca)throws Exception;
    void alterarMarca(int id, String nomeMarca,String caminhoLogo) throws Exception;
    ArrayList<Marca> listagemMarca()throws Exception;
    public ArrayList<String> listagemNomeMarcas() throws Exception;
    
    void incluirModelo(Modelo modelo)throws Exception;
    void alterarModelo(int id, String nomeModelo,String caminhoFotoModelo, int idMarca) throws Exception;
    ArrayList<Modelo> listagemModelo()throws Exception;
    ArrayList<String> listagemNomeModelo() throws Exception;

    void verificaBanco(Telas tela) throws Exception;
    
    void inserirNovaCor(String nomeCor) throws Exception;
    ArrayList<String> listagemCores() throws Exception;
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
