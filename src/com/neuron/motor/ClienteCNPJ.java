/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.motor;


public class ClienteCNPJ {
    private int idPJ = 1; //tipo serial, NUMERO DEVE SER IMPAR, sempre vai ser idPJ += 2;
    private String razaoSocial = ""; //razao Social do cliente
    private String nomeFantasia = ""; //Nome fantasia da empresa cliente
    private int cnpj = 0; //Campo não deverá ter máscaras ao salvar nesta variável
    private String ufEmpresa = ""; //de qual UF a empresa faz parte
    private String inscricaoEstadual = ""; //IE da empresa
    private String endereco = ""; //Endereco do cliente
    private String telefone = ""; //Telefone do cliente
    private String situacaoMulta = ""; //Situação da Multa, caso tenha -  | Pago | Em débito | Nenhuma multa
    private float valorMulta = 0; //Valor da multa atual, caso tenha
    private boolean estaEmContrato = false; // Se está contratando algum carro no momento ou não
    
    public ClienteCNPJ(){
        
    }
    
    //Getters and Setters

    public int getIdPJ() {
        return idPJ;
    }

    public void setIdPJ(int idPJ) {
        this.idPJ = idPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getUfEmpresa() {
        return ufEmpresa;
    }

    public void setUfEmpresa(String ufEmpresa) {
        this.ufEmpresa = ufEmpresa;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSituacaoMulta() {
        return situacaoMulta;
    }

    public void setSituacaoMulta(String situacaoMulta) {
        this.situacaoMulta = situacaoMulta;
    }

    public float getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(float valorMulta) {
        this.valorMulta = valorMulta;
    }

    public boolean isEstaEmContrato() {
        return estaEmContrato;
    }

    public void setEstaEmContrato(boolean estaEmContrato) {
        this.estaEmContrato = estaEmContrato;
    }

    @Override
    public String toString() {
        return idPJ + ";" + razaoSocial + ";" + nomeFantasia + ";" + cnpj + ";" + ufEmpresa + ";" 
                + inscricaoEstadual + ";" + endereco + ";" + telefone + ";" + situacaoMulta + ";"
                + valorMulta + ";" + estaEmContrato;
    }
    
    
    
}
