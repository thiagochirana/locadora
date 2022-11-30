/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle.control;

import com.neuron.controle.IControleMarca;
import com.neuron.persistencia.DAO.MarcaDAO;
import com.neuron.persistencia.IMarcaDAO;
import com.neuron.templates.Marca;
import com.neuron.utils.Logs;
import java.util.ArrayList;


public class ControleMarca implements IControleMarca{
    
    IMarcaDAO dao;

    public ControleMarca() {
        dao = new MarcaDAO();
    }
    
    
    
    private boolean buscarMarca(int id, String descricao) throws Exception {
        try {
            ArrayList<Marca> listagem = dao.listagemMarca();
            for (Marca marca : listagem) {
                if (marca.getNomeMarca().equalsIgnoreCase(descricao) && marca.getIdMarca() != id) {
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            Logs.logger("Nao foi possivel identificar se ha outra Marca com o nome " + descricao + " - " + erro.getMessage(), getThisClass());
            throw erro;
        }
    }

    @Override
    public void incluirMarca(Marca m) throws Exception {
        Marca marca = m;
        if (buscarMarca(marca.getIdMarca(), marca.getNomeMarca())) {
            throw new Exception("Marca já foi cadastrada");
        }
        if (marca.getNomeMarca() == null || marca.getNomeMarca().equals("")) {
            throw new Exception("Marca sem nome inserido para cadastro! Por favor insira um nome de Marca");
        }
        String nomemarca = marca.getNomeMarca();
        if (nomemarca.charAt(nomemarca.length() - 1) == ' ') {
            throw new Exception("Nome da Marca com espacos invalidos no final");
        }
        char[] carac = marca.getNomeMarca().toCharArray();
        char ver = ' ';
        if (marca.getNomeMarca().contains("  ") || carac[0] == ver) {
            throw new Exception("Nome da Marca com espacos excessivos ou nao permitidos!");
        }
        if (marca.getDirLogo() == null || marca.getDirLogo().equals("")) {
            throw new Exception("Marca " + marca.getNomeMarca() + " sem logo!");
        }

        dao.incluirMarca(marca);

    }

    @Override
    public void alterarMarca(int id, String nomeMarca, String caminhoLogo) throws Exception {
        if (buscarMarca(id, nomeMarca.replace(" ", ""))) {
            throw new Exception("Nome de marca ja existe! Por favor escolha outro nome");
        }
        String nomemarca = nomeMarca;
        if (nomemarca.charAt(nomemarca.length() - 1) == ' ') {
            throw new Exception("Nome da Marca com espacos invalidos no final");
        }
        char[] carac = nomeMarca.toCharArray();
        char ver = ' ';
        if (nomeMarca.contains("  ") || carac[0] == ver) {
            throw new Exception("Nome da Marca com espacos excessivos ou nao permitidos!");
        }
        dao.alterarMarca(id, nomeMarca.toUpperCase(), caminhoLogo);
    }

    @Override
    public ArrayList<Marca> listagemMarca() throws Exception {
        return dao.listagemMarca();
    }

    @Override
    public ArrayList<String> listagemNomeMarcas() throws Exception {
        return dao.listagemNomeMarcas();
    }
    
    private String getThisClass() {
        String thisClass = getClass() + "";
        thisClass = thisClass.replace("class ", "");
        return thisClass;
    }
}
// Software developed by Thiago Chirana -> https://github.com/othiagomacedo