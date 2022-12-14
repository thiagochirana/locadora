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
[1].setNomeMotorista
[2].setNumeroCNH
[3].setDataVencimento
[4].setCaminhoImgCNH
[5].setStatusMulta
[6].setValorMulta
[7].setLogradouro
[8].setComplemento
[9].setCEP
[10].setBairro
[11].setCidade
[12].setEstado
[13].setDDI
[14].setDDD
[15].setNumero
[16].setIdClienteVinculado
*/

package com.neuron.templates;


public class Motorista extends Endereco{
    
    int idMotorista;
    String nomeMotorista;
    int numeroCNH;
    String dataVencimento;
    String caminhoImgCNH;
    StatusMulta statusMulta;
    float valorMulta;
    int IdClienteVinculado;

    public Motorista() {
    }

    public Motorista(int idMotorista, String nomeMotorista, int numeroCNH, String dataVencimento, String caminhoImgCNH, StatusMulta statusMulta, float valorMulta, int IdClienteVinculado, String logradouro, String complemento, int CEP, String bairro, String cidade, Estados estado, int DDI, int DDD, int numero) {
        super(logradouro, complemento, CEP, bairro, cidade, estado, DDI, DDD, numero);
        this.idMotorista = idMotorista;
        this.nomeMotorista = nomeMotorista;
        this.numeroCNH = numeroCNH;
        this.dataVencimento = dataVencimento;
        this.caminhoImgCNH = caminhoImgCNH;
        this.statusMulta = statusMulta;
        this.valorMulta = valorMulta;
        this.IdClienteVinculado = IdClienteVinculado;
        setLogradouro(logradouro);
        setComplemento(complemento);
        setCEP(CEP);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
        setDDI(DDI);
        setDDD(DDD);
        setNumero(numero);
    }

    
    
    public int getIdMotorista() {
        return idMotorista;
    }

    public void setIdMotorista(int idMotorista) {
        this.idMotorista = idMotorista;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
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