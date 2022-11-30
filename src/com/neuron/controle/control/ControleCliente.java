/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle.control;

import com.neuron.controle.IControleCliente;
import com.neuron.persistencia.IClienteDAO;
import com.neuron.persistencia.DAO.ClienteDAO;
import com.neuron.templates.Cliente;
import com.neuron.utils.Logs;
import java.util.ArrayList;


public class ControleCliente implements IControleCliente{
    IClienteDAO cliente;

    public ControleCliente() {
        cliente = new ClienteDAO();
    }
    
    @Override
    public ArrayList<Cliente> listagemCliente()throws Exception{
        return new ArrayList<>();
    }
    
    @Override
    public void alterarCliente(Cliente cliente) throws Exception{
        if (buscarCliente(cliente.getId(),cliente.getNome(), Integer.valueOf(cliente.getCpfCnpj()))){
            
        }
    }
    
    private boolean buscarCliente(int id, String descricao, int cpfCnpj)throws Exception{
        try {
            ArrayList<Cliente> listagem = cliente.listagemClientes();
            for (Cliente cli : listagem) {
                if (cli.getNome().equalsIgnoreCase(descricao) && cli.getId() != id && !cli.getCpfCnpj().equals(cpfCnpj)) {
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            Logs.logger("Nao foi possivel identificar se ha outra Marca com o nome " + descricao + " - " + erro.getMessage(), getThisClass());
            throw erro;
        }
    }
    
    private String getThisClass() {
        String thisClass = getClass() + "";
        thisClass = thisClass.replace("class ", "");
        return thisClass;
    }
}
// Software developed by Thiago Chirana -> https://github.com/othiagomacedo