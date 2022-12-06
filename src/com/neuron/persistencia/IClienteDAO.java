/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neuron.persistencia;

import com.neuron.templates.Cliente;
import com.neuron.templates.Estados;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author thiag
 */
public interface IClienteDAO {
    ArrayList<Cliente> listagemClientes() throws Exception;
    void InserirCliente(Cliente cliente) throws Exception;
    void alterarCliente(Cliente cliente) throws Exception;
    Estados getEstadoByNome(String nomeEstado) throws Exception;
    List<String> getListaStatusMulta() throws Exception;
    List<String> getNomeEstados() throws Exception;
    ImageIcon getImgCNHById(int id,int width,int heigth) throws Exception;
    String[] getClienteById(int id) throws Exception;
}
