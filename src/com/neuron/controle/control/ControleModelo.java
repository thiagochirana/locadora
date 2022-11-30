/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle.control;

import com.neuron.controle.IControleModelo;
import com.neuron.exceptions.ComboBoxException;
import com.neuron.persistencia.DAO.ModeloDAO;
import com.neuron.persistencia.IModeloDAO;
import com.neuron.templates.Modelo;
import com.neuron.utils.Logs;
import java.util.ArrayList;


public class ControleModelo implements IControleModelo {
    
    IModeloDAO rw;

    public ControleModelo(){
        rw = new ModeloDAO();
    }
    
    private boolean buscarModelo(int id, String descricao) throws Exception {
        try {
            ArrayList<Modelo> listagem = rw.listagemModelo();
            for (Modelo modelo : listagem) {
                if (modelo.getNomeModelo().equalsIgnoreCase(descricao) && id != modelo.getIdModelo()) {
                    Logs.logger("Modelo já foi cadastrado", getThisClass());
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            Logs.logger("Nao foi possivel identificar se ha outro Modelo com o nome " + descricao + " - " + erro.getMessage(), getThisClass());
            throw erro;
        }
    }

    @Override
    public void incluirModelo(Modelo model) throws Exception {
        Modelo modelo = model;
        if (buscarModelo(modelo.getIdModelo(), modelo.getNomeModelo())) {
            throw new Exception("Modelo ja foi cadastrado");
        }
        if (modelo.getNomeModelo().isEmpty() || modelo.getNomeModelo() == null) {
            throw new Exception("Modelo sem nome");
        }

        String nomeModelo = modelo.getNomeModelo();
        if (nomeModelo.charAt(nomeModelo.length() - 1) == ' ') {
            throw new Exception("Nome do Modelo com espacos invalidos no final");
        }

        char[] carac = modelo.getNomeModelo().toCharArray();
        char ver = ' ';
        if (modelo.getNomeModelo().contains("  ") || carac[0] == ver) {
            throw new Exception("Nome do Modelo com espacos excessivos ou nao permitidos!");
        }
        if (modelo.getDirFotoModelo() == null || modelo.getDirFotoModelo().equals("./src/com/neuron/icons/modelo/.jpeg")) {
            throw new Exception("Modelo " + modelo.getNomeModelo() + " sem uma imagem!");
        }
        rw.incluirModelo(model);
    }

    @Override
    public void alterarModelo(int id, String nome, String caminhoFotoModelo, int idMarca) throws Exception {

        if (buscarModelo(id, nome)) {
            throw new Exception("Modelo ja foi cadastrado");
        }

        String nomeModelo = nome;
        if (nomeModelo.charAt(nomeModelo.length() - 1) == ' ') {
            throw new Exception("Nome do Modelo com espacos invalidos no final");
        }

        char[] carac = nome.toCharArray();
        char ver = ' ';
        if (nomeModelo.contains("  ") || carac[0] == ver) {
            throw new Exception("Nome do Modelo com espacos excessivos ou nao permitidos!");
        }
        rw.alterarModelo(id, nomeModelo.toUpperCase(), caminhoFotoModelo, idMarca);
    }

    @Override
    public ArrayList<Modelo> listagemModelo() throws ComboBoxException {
        return rw.listagemModelo();

    }

    @Override
    public ArrayList<String> listagemNomeModelo() throws Exception {
        return rw.listagemNomeModelo();
    }
    
    private String getThisClass() {
        String thisClass = getClass() + "";
        thisClass = thisClass.replace("class ", "");
        return thisClass;
    }
}
// Software developed by Thiago Chirana -> https://github.com/othiagomacedo