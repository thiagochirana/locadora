/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.motor;


public class Motor {
    
    //****************************************************
    //############ VARIAVEIS DO CLIENTE CPF ##############
    //****************************************************
    protected int idPF = 0; //tipo serial, NUMERO DEVE SER PAR, sempre vai ser idPF += 2;
    protected String nome = ""; //Nome do cliente
    protected String dataNasc = ""; //data de nascimento
    protected String sexo = ""; //Masculino, Feminino, não-Binário, etc...
    protected int cpf = 0; //Campo não deverá ter máscaras ao salvar nesta variável
    protected int rg = 0; //Campo não deverá ter máscaras ao salvar nesta variável
    protected int numCNH = 0; //Campo não deverá ter máscaras ao salvar nesta variável
    protected String orgaoEmissor = ""; //Orgao emissor da CNH
    protected String UFEmissor = ""; //UF emissor da CNH
    
    //****************************************************
    //########### VARIAVEIS DO CLIENTE CNPJ ##############
    //****************************************************
    protected int idPJ = 1; //tipo serial, NUMERO DEVE SER IMPAR, sempre vai ser idPJ += 2;
    protected String razaoSocial = ""; //razao Social do cliente
    protected String nomeFantasia = ""; //Nome fantasia da empresa cliente
    protected int cnpj = 0; //Campo não deverá ter máscaras ao salvar nesta variável
    protected String ufEmpresa = ""; //de qual UF a empresa faz parte
    protected String inscricaoEstadual = ""; //IE da empresa
    protected String endereco = ""; //Endereco do cliente
    protected String telefone = ""; //Telefone do cliente
    protected String situacaoMulta = ""; //Situação da Multa, caso tenha -  | Pago | Em débito | Nenhuma multa
    protected float valorMulta = 0; //Valor da multa atual, caso tenha

    protected boolean estaEmContrato = false; // Se está contratando algum carro no momento ou não
    
    //****************************************************
    //############### VARIAVEIS DO CARRO #################
    //****************************************************
    protected int idCarro = 0; //tipo serial, sempre vai ser idCarro += 1;
    protected String categoria = ""; //Economico, Intermediario, SUV, Executivo e Utilitario.
    protected String marca = ""; //marca do produto
    protected String modelo = ""; //modelo do carro
    protected String cor = ""; // cor do Carro
    protected int ano = 0000; //ano de fabricacao do carro
    protected String estadoMaterial = ""; // Estado do carro | Novo | Usado | Precisa de Manutenção | em Venda | Sofreu Acidente | Perca Total
    protected boolean alugado = false; // Se o carro está alugado ou não
    protected int idClienteContratante = 00; // id do cliente que contratou o aluguel do carro | deve ser referenciado pelo seu id original (idPF ou idPJ)
    protected String dataProxManutencao = ""; // se necessário, este campo informa a data da proxima manutencao
    protected String situacaoDocumento = ""; // Quitado | Com Multa | Em Quitação | Vendido
    protected boolean disponibilidade = true; // Se o carro está disponivel para aluguel ou não
    protected String finalidadeAluguel = ""; //o porque o cliente está contratando o aluguel
    protected String rotasProgramadas = ""; //por onde o cliente irá trafegar | Fora da Cidade | Fora do Estado | Somente pela Cidade
    protected float valorContratado = 0; //Valor do contrato atual, no qual cliente está pagando
    protected float valorCaucao = 0; //valor de Caucao
    protected float quilometragemAoSair = 0; // Kilometragem rodada ao sair da Locadora
    protected String dataRetirada = ""; //data no qual o Cliente retirou o carro para aluguel
    protected String dataEntregaPrevista = ""; //data prevista para entrega do carro
    protected String dataEntrega = ""; //Data real da entrega do carro
    protected String estadoEntrega = ""; //Estado da entrega do veículo a locadora
    protected float kilometragemEntregada = 0; //Kilometragem ao entregar o veiculo a Locadora
    
    public Motor(){
        
    }
    
    
    // Getters and Setters

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

       
}
