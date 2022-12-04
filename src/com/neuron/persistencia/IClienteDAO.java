/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neuron.persistencia;

import com.neuron.templates.Cliente;
import com.neuron.templates.Estados;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thiag
 */
public interface IClienteDAO {
    ArrayList<Cliente> listagemClientes() throws Exception;
    void InserirCliente(Cliente cliente) throws Exception;
    Estados getEstadoByNome(String nomeEstado) throws Exception;
    List<String> getStatusMulta() throws Exception;
    List<String> getNomeEstados() throws Exception;
}
