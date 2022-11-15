/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neuron.controle;

import com.neuron.templates.*;
import javax.swing.JMenuBar;

/**
 *
 * @author thiag
 */
public interface IControleUser {
    boolean validarAcesso(Usuario usuario) throws Exception;
    JMenuBar customMenuBar();
}
