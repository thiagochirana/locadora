/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.neuron.persistencia;

import com.neuron.templates.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 *
 * @author thiag
 */
public interface IReadWriteUsers {
    boolean validarAcesso(Usuario usuario,JFrame jf) throws Exception;
    JMenuBar customMenuBar(JFrame jf) throws Exception;
    public ArrayList<String> UserDataHoraAcesso() throws Exception;
}
