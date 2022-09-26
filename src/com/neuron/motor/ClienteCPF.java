/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.motor;


public class ClienteCPF extends Motor {

    public ClienteCPF() {
        super();
    }

    
    //Getters and Setters
    
    @Override
    public int getIdPF() {
        return idPF;
    }

    @Override
    public void setIdPF(int idPF) {
        this.idPF = idPF;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getDataNasc() {
        return dataNasc;
    }

    @Override
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String getSexo() {
        return sexo;
    }

    @Override
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public int getRg() {
        return rg;
    }

    @Override
    public void setRg(int rg) {
        this.rg = rg;
    }

    @Override
    public int getNumCNH() {
        return numCNH;
    }

    @Override
    public void setNumCNH(int numCNH) {
        this.numCNH = numCNH;
    }

    @Override
    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    @Override
    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    @Override
    public String getUFEmissor() {
        return UFEmissor;
    }

    @Override
    public void setUFEmissor(String UFEmissor) {
        this.UFEmissor = UFEmissor;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getSituacaoMulta() {
        return situacaoMulta;
    }

    @Override
    public void setSituacaoMulta(String situacaoMulta) {
        this.situacaoMulta = situacaoMulta;
    }

    @Override
    public float getValorMulta() {
        return valorMulta;
    }

    @Override
    public void setValorMulta(float valorMulta) {
        this.valorMulta = valorMulta;
    }

    @Override
    public boolean isEstaEmContrato() {
        return estaEmContrato;
    }

    @Override
    public void setEstaEmContrato(boolean estaEmContrato) {
        this.estaEmContrato = estaEmContrato;
    }

    @Override
    public int getIdCarro() {
        return idCarro;
    }

    @Override
    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    @Override
    public String getSituacaoDocumento() {
        return situacaoDocumento;
    }

    @Override
    public void setSituacaoDocumento(String situacaoDocumento) {
        this.situacaoDocumento = situacaoDocumento;
    }
    
    
    
}
