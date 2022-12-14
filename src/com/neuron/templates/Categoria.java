/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.templates;


public class Categoria {
    int idCategoria;
    String nomeCategoria;
    float valorAluguelCategoria;

    public Categoria() {
    }

    public Categoria(int idCategoria, String nomeCategoria, float valorAluguelCategoria) {
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.valorAluguelCategoria = valorAluguelCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public float getValorAluguelCategoria() {
        return valorAluguelCategoria;
    }

    public void setValorAluguelCategoria(float valorAluguelCategoria) {
        this.valorAluguelCategoria = valorAluguelCategoria;
    }

    @Override
    public String toString() {
        return idCategoria + ";" + nomeCategoria + ";" + valorAluguelCategoria;
    }
    
    
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
