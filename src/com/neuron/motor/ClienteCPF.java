/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.motor;


public class ClienteCPF {
    private int idPF = 0; //tipo serial, NUMERO DEVE SER PAR, sempre vai ser idPF += 2;
    private String nome = ""; //Nome do cliente
    private String dataNasc = ""; //data de nascimento
    private String sexo = ""; //Masculino, Feminino, não-Binário, etc...
    private int cpf = 0; //Campo não deverá ter máscaras ao salvar nesta variável
    private int rg = 0; //Campo não deverá ter máscaras ao salvar nesta variável
    private int numCNH = 0; //Campo não deverá ter máscaras ao salvar nesta variável
    private String orgaoEmissor = ""; //Orgao emissor da CNH
    private String UFEmissor = ""; //UF emissor da CNH
    private String endereco = ""; //Endereco do cliente
    private String telefone = ""; //Telefone do cliente
    private String situacaoMulta = ""; //Situação da Multa, caso tenha -  | Pago | Em débito | Nenhuma multa
    private float valorMulta = 0; //Valor da multa atual, caso tenha
    private boolean estaEmContrato = false; // Se está contratando algum carro no momento ou não
    
    public ClienteCPF(){
        
    }
    
    //Getters and Setters

    public int getIdPF() {
        return idPF;
    }

    public void setIdPF(int idPF) {
        this.idPF = idPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getNumCNH() {
        return numCNH;
    }

    public void setNumCNH(int numCNH) {
        this.numCNH = numCNH;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getUFEmissor() {
        return UFEmissor;
    }

    public void setUFEmissor(String UFEmissor) {
        this.UFEmissor = UFEmissor;
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
        return idPF + ";" + nome + ";" + dataNasc + ";" + sexo + ";" + cpf + ";" + rg + ";" + numCNH + ";" 
                + orgaoEmissor + ";" + UFEmissor + ";" + endereco + ";" + telefone + ";" + situacaoMulta + ";" 
                + valorMulta + ";" + estaEmContrato;
    }
    
    
    
}
