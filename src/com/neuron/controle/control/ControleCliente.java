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
import com.neuron.templates.Estados;
import com.neuron.utils.Logs;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;


public class ControleCliente implements IControleCliente{
    IClienteDAO cliente;

    public ControleCliente() {
        cliente = new ClienteDAO();
    }
    
    @Override
    public ArrayList<Cliente> listagemCliente()throws Exception{
        return cliente.listagemClientes();
    }
    
    @Override
    public void alterarCliente(Cliente cliente) throws Exception{
        if (buscarCliente(cliente.getId(),cliente.getNomeRazaoSocial(), Integer.parseInt(cliente.getCpfCnpj()))){
            
        }
    }
    
    @Override
    public void InserirCliente(Cliente c) throws Exception{
        cliente.InserirCliente(c);
    }
    
    @Override
    public Estados getEstadoByNome(String nomeEstado) throws Exception{
        return cliente.getEstadoByNome(nomeEstado);
    }
    
    @Override
    public List<String> getListaStatusMulta() throws Exception{
        return cliente.getListaStatusMulta();
    }
    
    @Override
    public List<String> getNomeEstados() throws Exception{
        return cliente.getNomeEstados();
    }
    
    @Override
    public ImageIcon getImgCNHById(int id,int width,int heigth) throws Exception{
        return cliente.getImgCNHById(id,width,heigth);
    }
    
    @Override
    public String[] getClienteById(int id) throws Exception{
        return cliente.getClienteById(id);
    }
    
    private boolean buscarCliente(int id, String descricao, int cpfCnpj)throws Exception{
        try {
            ArrayList<Cliente> listagem = cliente.listagemClientes();
            for (Cliente cli : listagem) {
                if (cli.getNomeRazaoSocial().equalsIgnoreCase(descricao) && cli.getId() != id && !cli.getCpfCnpj().equals(cpfCnpj)) {
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