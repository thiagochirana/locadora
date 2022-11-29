/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neuron.persistencia;

import com.neuron.exceptions.ComboBoxException;
import com.neuron.templates.Modelo;
import java.util.ArrayList;

/**
 *
 * @author thiag
 */
public interface IModeloDAO {
    void incluirModelo(Modelo modelo) throws Exception;
    void alterarModelo(int id, String nomeModelo, String caminhoFotoModelo, int idMarca) throws Exception;
    ArrayList<Modelo> listagemModelo() throws ComboBoxException;
    ArrayList<String> listagemNomeModelo() throws Exception;
}
