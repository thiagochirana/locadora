/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neuron.persistencia;

import com.neuron.templates.Marca;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public interface IMarcaDAO {
    void incluirMarca(Marca marca) throws Exception;
    void alterarMarca(int id, String nomeMarca, String caminhoLogo) throws Exception;
    ArrayList<Marca> listagemMarca() throws Exception;
    ArrayList<String> listagemNomeMarcas() throws Exception;
}
