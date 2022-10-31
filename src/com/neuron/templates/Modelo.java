/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.templates;


public class Modelo {
    
    private int idModelo;
    private String nomeModelo;
    private String dirFotoModelo;
    private int idMarcaRelacionado;
    
    public Modelo(){
        
    }

    public Modelo(int idModelo, String nomeModelo, String dirFotoModelo, int idMarcaRelacinado) {
        this.idModelo = idModelo;
        this.nomeModelo = nomeModelo;
        this.dirFotoModelo = dirFotoModelo;
        this.idMarcaRelacionado = idMarcaRelacinado;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getDirFotoModelo() {
        return dirFotoModelo;
    }

    public void setDirFotoModelo(String dirFotoModelo) {
        this.dirFotoModelo = dirFotoModelo;
    }

    public int getIdMarcaRelacinado() {
        return idMarcaRelacionado;
    }

    public void setIdMarcaRelacinado(int idMarcaRelacinado) {
        this.idMarcaRelacionado = idMarcaRelacinado;
    }

    @Override
    public String toString() {
        return idModelo + ";" + nomeModelo + ";" + dirFotoModelo + ";" + idMarcaRelacionado;
    }

}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
