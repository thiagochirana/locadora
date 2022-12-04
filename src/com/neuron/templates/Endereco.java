/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.templates;


public class Endereco extends Telefone{
    String logradouro;
    String complemento;
    int CEP;
    String bairro;
    String cidade;
    Estados estado;

    public Endereco() {
    }

    public Endereco(String logradouro, String complemento, int CEP, String bairro, String cidade, Estados estado, int DDI, int DDD, int numero) {
        super(DDD, DDI, numero);
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.CEP = CEP;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco(String logradouro, String complemento, int CEP, String bairro, String cidade, Estados estado) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.CEP = CEP;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    @Override
    public int getDDD() {
        return DDD;
    }

    @Override
    public void setDDD(int DDD) {
        this.DDD = DDD;
    }

    @Override
    public int getDDI() {
        return DDI;
    }

    @Override
    public void setDDI(int DDI) {
        this.DDI = DDI;
    }

    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public void setNumero(int numero) {
        this.numero = numero;
    }
     
    @Override
    public String toString() {
        return logradouro + ";" + complemento + ";" + CEP + ";" + bairro + ";" + cidade + ";" + estado;
    }
    
    
}
// Software developed by Thiago Chirana -> https://github.com/othiagomacedo