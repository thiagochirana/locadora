/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

/*

Vetor de Sets da Classe Motorista
	
[0].setIdMotorista
[1].setNumeroCNH
[2].setDataVencimento
[3].setCaminhoImgCNH
[4].setStatusMulta
[5].setValorMulta
[6].setLogradouro
[7].setComplemento
[8].setCEP
[9].setBairro
[10].setCidade
[11].setEstado
[12].setDDI
[13].setDDD
[14].setNumero
[15].setIdClienteVinculado
*/

package com.neuron.templates;


public class Motorista extends Endereco{
    
    int idMotorista;
    int numeroCNH;
    String dataVencimento;
    String caminhoImgCNH;
    StatusMulta statusMulta;
    float valorMulta;
    int IdClienteVinculado;

    public Motorista() {
    }

    public Motorista(int idMotorista, int numeroCNH, String dataVencimento, String caminhoImgCNH, StatusMulta statusMulta, float valorMulta, int IdClienteVinculado, String logradouro, String complemento, int CEP, String bairro, String cidade, Estados estado, int DDI, int DDD, int numero) {
        super(logradouro, complemento, CEP, bairro, cidade, estado, DDI, DDD, numero);
        this.idMotorista = idMotorista;
        this.numeroCNH = numeroCNH;
        this.dataVencimento = dataVencimento;
        this.caminhoImgCNH = caminhoImgCNH;
        this.statusMulta = statusMulta;
        this.valorMulta = valorMulta;
        this.IdClienteVinculado = IdClienteVinculado;
    }

    
    
    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public int getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(int numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
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

    public int getIdClienteVinculado() {
        return IdClienteVinculado;
    }

    public void setIdClienteVinculado(int IdClienteVinculado) {
        this.IdClienteVinculado = IdClienteVinculado;
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
        return idMotorista + ";" + numeroCNH + ";" + dataVencimento + ";" + caminhoImgCNH + ";" + statusMulta + ";" + valorMulta + ";" + logradouro + ";" + complemento + ";" + CEP + ";" + bairro + ";" + cidade + ";" + estado + ";" + DDI + ";" + DDD + ";" + numero + ";" + IdClienteVinculado;
    }
    
    
    
    
}
// Software developed by Thiago Chirana -> https://github.com/othiagomacedo