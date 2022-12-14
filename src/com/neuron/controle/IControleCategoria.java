/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.neuron.controle;

import com.neuron.templates.Categoria;
import java.util.ArrayList;

/** About this Software **
 *
 * @Author Thiago Chirana
 * @Year 2022
 * @Course Software Engineering
 * @College FATESG Senai
 * 
 */

public interface IControleCategoria {
    void inserirCategoria(Categoria categoria) throws Exception;
    void alterarCategoria(Categoria categoria) throws Exception;
    ArrayList<Categoria> listagemCategoria() throws Exception;
}
