/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/
package com.neuron.templates;

public class Cliente extends Endereco{
    
    int id;
    String cpfCnpj;
    String nomeRazaoSocial;
    String rg;
    String email;
    String motorista;
    int nCNH;
    String caminhoImgCNH;
    StatusMulta statusMulta;
    float valorMulta;

    public Cliente(){
        
    }

    public Cliente(int id, String cpfCnpj, String nomeRazaoSocial, String rg, String email, String motorista, int nCNH, String caminhoImgCNH, StatusMulta statusMulta, float valorMulta, String logradouro, String complemento, int CEP, String bairro, String cidade, Estados estado, int DDI, int DDD, int numero) {
        super(logradouro, complemento, CEP, bairro, cidade, estado, DDI, DDD, numero);
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.nomeRazaoSocial = nomeRazaoSocial;
        this.rg = rg;
        this.email = email;
        this.motorista = motorista;
        this.nCNH = nCNH;
        this.caminhoImgCNH = caminhoImgCNH;
        this.statusMulta = statusMulta;
        this.valorMulta = valorMulta;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String razaoSocial) {
        this.nomeRazaoSocial = razaoSocial;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public int getnCNH() {
        return nCNH;
    }

    public void setnCNH(int nCNH) {
        this.nCNH = nCNH;
    }

    public String getCaminhoImgCNH() {
        return caminhoImgCNH;
    }

    public void setCaminhoImgCNH(String caminhoImgCNH) {
        this.caminhoImgCNH = caminhoImgCNH;
    }

    public StatusMulta getStatusMulta() {
        return statusMulta;
    }

    public void setStatusMulta(StatusMulta statusMulta) {
        this.statusMulta = statusMulta;
    }

    public float getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(float valorMulta) {
        this.valorMulta = valorMulta;
    }

    @Override
    public String getLogradouro() {
        return logradouro;
    }

    @Override
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @Override
    public String getComplemento() {
        return complemento;
    }

    @Override
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public int getCEP() {
        return CEP;
    }

    @Override
    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    @Override
    public String getBairro() {
        return bairro;
    }

    @Override
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String getCidade() {
        return cidade;
    }

    @Override
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public Estados getEstado() {
        return estado;
    }

    @Override
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
        return id + ";" + cpfCnpj + ";" + nomeRazaoSocial + ";" + rg + ";" + email + ";" + motorista + ";" + nCNH + ";" + caminhoImgCNH + ";" + statusMulta + ";" + valorMulta + ";" + logradouro + ";" + complemento + ";" + CEP + ";" + bairro + ";" + cidade + ";" + estado + ";" + DDI + ";" + DDD + ";" + numero;
    }
   
}
