/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.templates;


public class ClienteCNPJ extends Cliente{
    
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

    public ClienteCNPJ() {
        super();
    }

    public void setIdPJ(int idPJ) {
        this.idPJ = idPJ;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public void setUfEmpresa(String ufEmpresa) {
        this.ufEmpresa = ufEmpresa;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSituacaoMulta(String situacaoMulta) {
        this.situacaoMulta = situacaoMulta;
    }

    public void setValorMulta(float valorMulta) {
        this.valorMulta = valorMulta;
    }

    public int getIdPJ() {
        return idPJ;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public int getCnpj() {
        return cnpj;
    }

    public String getUfEmpresa() {
        return ufEmpresa;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSituacaoMulta() {
        return situacaoMulta;
    }

    public float getValorMulta() {
        return valorMulta;
    }
    
    
}
