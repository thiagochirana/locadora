/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neuron.persistencia;

import com.neuron.templates.Usuario;
import com.neuron.utils.DataBase;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.plaf.basic.BasicMenuBarUI;

/**
 *
 * @author thiag
 */
public class ReadWriteUsers implements IReadWriteUsers{
    int IdUsuario;
    String user;
    String pass;
    String email;
    String telefone;
    PermissaoUsuario permissao;
    
    @Override
    public boolean validarAcesso(Usuario user) throws Exception{
        Usuario u = user;
        FileReader fr = new FileReader(DataBase.USER.getPathDB());
        BufferedReader dbUser = new BufferedReader(fr);
        boolean valido = false;
        String linha = "";
        while ( (linha=dbUser.readLine()) != null ){
            String[] usuario = linha.split(";");
            if ( usuario[1].equals(u.getUser()) && usuario[2].equals(u.getPass()) ) {
                valido = true;
            }
        }
        dbUser.close();
        return valido;
    }
    
    @Override
    public JMenuBar customMenuBar(){
        Color azulSistema = new Color(1, 132, 222, 255);
        JMenuBar jmb = new JMenuBar();
        
        jmb.setUI(new BasicMenuBarUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                g.setColor(azulSistema);
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });
        
        JMenu jmenu = new JMenu("TESTE");
        jmenu.setBackground(azulSistema);
        jmenu.setForeground(Color.WHITE);
        jmb.add(jmenu);     
        return jmb; 
    }
}
