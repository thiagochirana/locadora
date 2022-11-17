/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.templates;

import java.util.Date;


public class Veiculo extends Modelo{
    int idVeiculo;
    String placa;
    int renavan;
    float precoCompra;
    float precoVenda;
    Date anoFabricacao;
    Date anoModelo;
    int quilometragem;
    
    public Veiculo(){
        
    }

    public Veiculo(int idVeiculo, String placa, int renavan, float precoCompra, float precoVenda, Date anoFabricacao, Date anoModelo, int quilometragem) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.renavan = renavan;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.quilometragem = quilometragem;
    }

    public Veiculo(int idVeiculo, String placa, int renavan, float precoCompra, float precoVenda, Date anoFabricacao, Date anoModelo, int quilometragem, int idModelo, String nomeModelo, String dirFotoModelo, int idMarcaRelacinado) {
        super(idModelo, nomeModelo, dirFotoModelo, idMarcaRelacinado);
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.renavan = renavan;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.quilometragem = quilometragem;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getRenavan() {
        return renavan;
    }

    public void setRenavan(int renavan) {
        this.renavan = renavan;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Date getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Date anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Date getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Date anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    @Override
    public String toString() {
        return idVeiculo + ";" + placa + ";" + renavan + ";" + precoCompra + ";" + 
               precoVenda + ";" + anoFabricacao + ";" + anoModelo + ";" + quilometragem;
    }
    
    
           
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
