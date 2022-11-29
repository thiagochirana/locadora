/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neuron.persistencia;

import com.neuron.templates.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author thiag
 */
public interface IVeiculoDAO {
    ArrayList<Veiculo> listagemVeiculo() throws Exception;
    void incluirVeiculo(Veiculo veiculo) throws Exception;
    void alterarVeiculo(Veiculo veiculo) throws Exception;
}
