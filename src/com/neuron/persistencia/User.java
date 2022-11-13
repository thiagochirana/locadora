/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.neuron.persistencia;

/**
 *
 * @author thiag
 */
public enum User {
    //ADMIN - acesso total a aplicacao
    //GERENTE - Pode realizar Cadastros
    //FINANCEIRO - visualiza apenas, tem acesso a vendas e compras de veiculos e servicos
    //VENDAS - realiza apenas o atendimento ao Cliente - aluguel de carros, cadastro de clientes e verifica os atrasados, etc.
    ADMIN,GERENTE,FINANCEIRO,VENDAS;
}
