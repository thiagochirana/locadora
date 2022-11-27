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
    String cor;
    String nomeModelo;
    Disponibilidade disponivel;
    String nomeMarca;
    String placa;
    String anoFabricacao;
    TipoCombustivel tipoCombustivel;
    int qulometragem;
    TipoVeiculo tipoVeiculo;
    
    int renavan;
    float precoCompra;
    float precoVenda;
    
    String dataCompra;
    String dataVenda;
    String infoAdicional;
    int idModeloRelacionado;
    
    public Veiculo(){
        
    }

    public Veiculo(int idVeiculo, String cor, String nomeModelo, Disponibilidade disponivel, String nomeMarca, String placa, String anoFabricacao, TipoCombustivel tipoCombustivel, int qulometragem, TipoVeiculo tipoVeiculo) {
        this.idVeiculo = idVeiculo;
        this.cor = cor;
        this.nomeModelo = nomeModelo;
        this.disponivel = disponivel;
        this.nomeMarca = nomeMarca;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.tipoCombustivel = tipoCombustivel;
        this.qulometragem = qulometragem;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Veiculo(int idVeiculo, String cor, String nomeModelo, Disponibilidade disponivel, String nomeMarca, String placa, String anoFabricacao, TipoCombustivel tipoCombustivel, int qulometragem, TipoVeiculo tipoVeiculo, int renavan, float precoCompra, float precoVenda, String dataCompra, String dataVenda, String infoAdicional,int idModeloRelacionado) {
        this.idVeiculo = idVeiculo;
        this.cor = cor;
        this.nomeModelo = nomeModelo;
        this.disponivel = disponivel;
        this.nomeMarca = nomeMarca;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.tipoCombustivel = tipoCombustivel;
        this.qulometragem = qulometragem;
        this.tipoVeiculo = tipoVeiculo;
        this.renavan = renavan;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.dataCompra = dataCompra;
        this.dataVenda = dataVenda;
        this.infoAdicional = infoAdicional;
        this.idModeloRelacionado = idModeloRelacionado;
    }

    public Veiculo(int idModelo, String nomeModelo, String dirFotoModelo, int idMarcaRelacinado) {
        super(idModelo, nomeModelo, dirFotoModelo, idMarcaRelacinado);
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public Disponibilidade getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Disponibilidade disponivel) {
        this.disponivel = disponivel;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getQulometragem() {
        return qulometragem;
    }

    public void setQulometragem(int qulometragem) {
        this.qulometragem = qulometragem;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
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

    public int getIdModeloRelacionado() {
        return idModeloRelacionado;
    }

    public void setIdModeloRelacionado(int idModeloRelacionado) {
        this.idModeloRelacionado = idModeloRelacionado;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }
    
    
    

    @Override
    public String toString() {
        return idVeiculo + ";" + cor + ";" + nomeModelo + ";" + disponivel + ";" + nomeMarca + ";" + placa + ";" + 
                anoFabricacao + ";" + tipoCombustivel + ";" + qulometragem + ";" + tipoVeiculo + ";" + 
                renavan + ";" + precoCompra + ";" + precoVenda + ";" +dataCompra+";" +dataVenda+";"+infoAdicional+";"+ idModeloRelacionado;
    }
         
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
