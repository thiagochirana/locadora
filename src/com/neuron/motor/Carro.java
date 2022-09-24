/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.motor;


public class Carro extends Motor {
    private int idCarro = 0; //tipo serial, sempre vai ser idCarro += 1;
    private String categoria = ""; //Economico, Intermediario, SUV, Executivo e Utilitario.
    private String marca = ""; //marca do produto
    private String modelo = ""; //modelo do carro
    private String cor = ""; // cor do Carro
    private int ano = 0000; //ano de fabricacao do carro
    private String estadoMaterial = ""; // Estado do carro | Novo | Usado | Precisa de Manutenção | em Venda | Sofreu Acidente | Perca Total
    private boolean alugado = false; // Se o carro está alugado ou não
    private int idClienteContratante = 00; // id do cliente que contratou o aluguel do carro | deve ser referenciado pelo seu id original (idPF ou idPJ)
    private String dataProxManutencao = ""; // se necessário, este campo informa a data da proxima manutencao
    private String situacaoDocumento = ""; // Quitado | Com Multa | Em Quitação | Vendido
    private boolean disponibilidade = true; // Se o carro está disponivel para aluguel ou não
    private String finalidadeAluguel = ""; //o porque o cliente está contratando o aluguel
    private String rotasProgramadas = ""; //por onde o cliente irá trafegar | Fora da Cidade | Fora do Estado | Somente pela Cidade
    private float valorContratado = 0; //Valor do contrato atual, no qual cliente está pagando
    private float valorCaucao = 0; //valor de Caucao
    private float quilometragemAoSair = 0; // Kilometragem rodada ao sair da Locadora
    private String dataRetirada = ""; //data no qual o Cliente retirou o carro para aluguel
    private String dataEntregaPrevista = ""; //data prevista para entrega do carro
    private String dataEntrega = ""; //Data real da entrega do carro
    private String estadoEntrega = ""; //Estado da entrega do veículo a locadora
    private float kilometragemEntregada = 0; //Kilometragem ao entregar o veiculo a Locadora

    public Carro() {
    }
    
    //Getters and Setters 

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEstadoMaterial() {
        return estadoMaterial;
    }

    public void setEstadoMaterial(String estadoMaterial) {
        this.estadoMaterial = estadoMaterial;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public int getIdClienteContratante() {
        return idClienteContratante;
    }

    public void setIdClienteContratante(int idClienteContratante) {
        this.idClienteContratante = idClienteContratante;
    }

    public String getDataProxManutencao() {
        return dataProxManutencao;
    }

    public void setDataProxManutencao(String dataProxManutencao) {
        this.dataProxManutencao = dataProxManutencao;
    }

    public String getSituacaoDocumento() {
        return situacaoDocumento;
    }

    public void setSituacaoDocumento(String situacaoDocumento) {
        this.situacaoDocumento = situacaoDocumento;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getFinalidadeAluguel() {
        return finalidadeAluguel;
    }

    public void setFinalidadeAluguel(String finalidadeAluguel) {
        this.finalidadeAluguel = finalidadeAluguel;
    }

    public String getRotasProgramadas() {
        return rotasProgramadas;
    }

    public void setRotasProgramadas(String rotasProgramadas) {
        this.rotasProgramadas = rotasProgramadas;
    }

    public float getValorContratado() {
        return valorContratado;
    }

    public void setValorContratado(float valorContratado) {
        this.valorContratado = valorContratado;
    }

    public float getValorCaucao() {
        return valorCaucao;
    }

    public void setValorCaucao(float valorCaucao) {
        this.valorCaucao = valorCaucao;
    }

    public float getQuilometragemAoSair() {
        return quilometragemAoSair;
    }

    public void setQuilometragemAoSair(float quilometragemAoSair) {
        this.quilometragemAoSair = quilometragemAoSair;
    }

    public String getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(String dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public String getDataEntregaPrevista() {
        return dataEntregaPrevista;
    }

    public void setDataEntregaPrevista(String dataEntregaPrevista) {
        this.dataEntregaPrevista = dataEntregaPrevista;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getEstadoEntrega() {
        return estadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        this.estadoEntrega = estadoEntrega;
    }

    public float getKilometragemEntregada() {
        return kilometragemEntregada;
    }

    public void setKilometragemEntregada(float kilometragemEntregada) {
        this.kilometragemEntregada = kilometragemEntregada;
    }

    @Override
    public String toString() {
        return idCarro + ";" + categoria + ";" + marca + ";" + modelo + ";" + cor + ";" + ano 
                + ";" + estadoMaterial + ";" + alugado + ";" + idClienteContratante + ";"
                + dataProxManutencao + ";" + situacaoDocumento + ";" + disponibilidade 
                + ";" + finalidadeAluguel + ";" + rotasProgramadas + ";" + valorContratado 
                + ";" + valorCaucao + ";" + quilometragemAoSair + ";" + dataRetirada + ";" 
                + dataEntregaPrevista + ";" + dataEntrega + ";" + estadoEntrega + ";" + kilometragemEntregada;
    }
    
    
    
}
