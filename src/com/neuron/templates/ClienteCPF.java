/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.templates;


public class ClienteCPF{
    
    private int idPF = 0; //tipo serial, NUMERO DEVE SER PAR, sempre vai ser idPF += 2;
    private String nome = ""; //Nome do cliente
    private String dataNasc = ""; //data de nascimento
    private String sexo = ""; //Masculino, Feminino, não-Binário, etc...
    private int cpf = 0; //Campo não deverá ter máscaras ao salvar nesta variável
    private int rg = 0; //Campo não deverá ter máscaras ao salvar nesta variável
    private int numCNH = 0; //Campo não deverá ter máscaras ao salvar nesta variável
    private String orgaoEmissor = ""; //Orgao emissor da CNH
    private String UFEmissor = ""; //UF emissor da CNH

    public ClienteCPF() {
        super();
    }

    
    //Getters and Setters

    public void setIdPF(int idPF) {
        this.idPF = idPF;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public void setNumCNH(int numCNH) {
        this.numCNH = numCNH;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public void setUFEmissor(String UFEmissor) {
        this.UFEmissor = UFEmissor;
    }

    public int getIdPF() {
        return idPF;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public int getCpf() {
        return cpf;
    }

    public int getRg() {
        return rg;
    }

    public int getNumCNH() {
        return numCNH;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public String getUFEmissor() {
        return UFEmissor;
    }
    
    
}
