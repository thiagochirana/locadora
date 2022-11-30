/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neuron.persistencia;

import com.neuron.templates.Cliente;
import java.util.ArrayList;

/**
 *
 * @author thiag
 */
public interface IClienteDAO {
    ArrayList<Cliente> listagemClientes() throws Exception;
}
