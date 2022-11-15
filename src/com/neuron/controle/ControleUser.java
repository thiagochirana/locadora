/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neuron.controle;

import com.neuron.persistencia.*;
import com.neuron.templates.*;
import java.util.ArrayList;
import javax.swing.JMenuBar;

/**
 *
 * @author thiag
 */
public class ControleUser implements IControleUser{
    String user = "";
    String pass = "";
    IReadWriteUsers iRWU = null;

    public ControleUser() {
        this.iRWU = new ReadWriteUsers() {};
    }
    
    public ControleUser(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    @Override
    public boolean validarAcesso(Usuario usuario) throws Exception{
        Usuario user = usuario;
        if (user.getUser().contains(" ")){
            throw new Exception("Usuario invalido por conter espacos");
        }
        if (user.getPass().length() < 8 && !user.getPass().equals("admin")) {
            throw new Exception("Senha muito curta! Por favor informe uma senha maior que 8 digitos!");
        }
        
        return iRWU.validarAcesso(user);
    }
    
    @Override
    public JMenuBar customMenuBar() throws Exception{
        return iRWU.customMenuBar();
    }
    
    @Override
    public ArrayList<String> UserDataHoraAcesso() throws Exception{
        return iRWU.UserDataHoraAcesso();
    }
    
    public void inserirNovoUsuario(){
        
    }
}
