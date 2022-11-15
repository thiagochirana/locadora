
package com.neuron.templates;

import com.neuron.persistencia.PermissaoUsuario;

/**
 *
 * @author thiag
 */
public class Usuario {
    int IdUsuario;
    String user;
    String pass;
    String email;
    String telefone;
    PermissaoUsuario permissao;

    public Usuario(){
        
    }
    
    //constructor para validar usuario já existente no banco
    public Usuario(int IdUsuario, String user, String pass) {
        this.IdUsuario = IdUsuario;
        this.user = user;
        this.pass = pass;
    }

    //constructor para criar um novo usuário
    public Usuario(int idUsuario, String user, String pass, String email, String telefone, PermissaoUsuario permissao) {
        this.IdUsuario = idUsuario;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.telefone = telefone;
        this.permissao = permissao;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public PermissaoUsuario getPermissao() {
        return permissao;
    }

    public void setPermissao(PermissaoUsuario permissao) {
        this.permissao = permissao;
    }

    @Override
    public String toString() {
        return IdUsuario + ";" +user + ";" + pass + ";" + email + ";" + telefone + ";" + permissao;
    }
    
    
    
}
