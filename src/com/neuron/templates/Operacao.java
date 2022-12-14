/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.templates;


public class Operacao {
    int idOperacao;
    String dataEntrada;
    String dataSaida;
    int diasAlugado;
    float QtdeLitrosCombustivel;
    float vlrEstimadoAluguel;
    float vlrEstimadoCaucao;
    float vlrRealAluguel;
    float vlrRealCaucao;
    int idVeiculo;
    int idModelo;
    int idMarca;
    int idCliente;
    int idMotorista;
    String Motivo;

    public Operacao(int idOperacao, String dataEntrada, String dataSaida, int diasAlugado, float QtdeLitrosCombustivel, float vlrEstimadoAluguel, float vlrEstimadoCaucao, float vlrRealAluguel, float vlrRealCaucao, int idVeiculo, int idModelo, int idMarca, int idCliente, int idMotorista, String Motivo) {
        this.idOperacao = idOperacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.diasAlugado = diasAlugado;
        this.QtdeLitrosCombustivel = QtdeLitrosCombustivel;
        this.vlrEstimadoAluguel = vlrEstimadoAluguel;
        this.vlrEstimadoCaucao = vlrEstimadoCaucao;
        this.vlrRealAluguel = vlrRealAluguel;
        this.vlrRealCaucao = vlrRealCaucao;
        this.idVeiculo = idVeiculo;
        this.idModelo = idModelo;
        this.idMarca = idMarca;
        this.idCliente = idCliente;
        this.idMotorista = idMotorista;
        this.Motivo = Motivo;
    }

    public int getIdOperacao() {
        return idOperacao;
    }

    public void setIdOperacao(int idOperacao) {
        this.idOperacao = idOperacao;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getDiasAlugado() {
        return diasAlugado;
    }

    public void setDiasAlugado(int diasAlugado) {
        this.diasAlugado = diasAlugado;
    }

    public float getQtdeLitrosCombustivel() {
        return QtdeLitrosCombustivel;
    }

    public void setQtdeLitrosCombustivel(float QtdeLitrosCombustivel) {
        this.QtdeLitrosCombustivel = QtdeLitrosCombustivel;
    }

    public float getVlrEstimadoAluguel() {
        return vlrEstimadoAluguel;
    }

    public void setVlrEstimadoAluguel(float vlrEstimadoAluguel) {
        this.vlrEstimadoAluguel = vlrEstimadoAluguel;
    }

    public float getVlrEstimadoCaucao() {
        return vlrEstimadoCaucao;
    }

    public void setVlrEstimadoCaucao(float vlrEstimadoCaucao) {
        this.vlrEstimadoCaucao = vlrEstimadoCaucao;
    }

    public float getVlrRealAluguel() {
        return vlrRealAluguel;
    }

    public void setVlrRealAluguel(float vlrRealAluguel) {
        this.vlrRealAluguel = vlrRealAluguel;
    }

    public float getVlrRealCaucao() {
        return vlrRealCaucao;
    }

    public void setVlrRealCaucao(float vlrRealCaucao) {
        this.vlrRealCaucao = vlrRealCaucao;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    @Override
    public String toString() {
        return idOperacao + ";" + dataEntrada + ";" + dataSaida + ";" + diasAlugado + ";" + 
                QtdeLitrosCombustivel + ";" + vlrEstimadoAluguel + ";" + vlrEstimadoCaucao + ";" + 
                vlrRealAluguel + ";" + vlrRealCaucao + ";" + idVeiculo + ";" + idModelo + ";" + 
                idMarca + ";" + idCliente + ";" + idMotorista + ";" + Motivo;
    }
    
    
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
