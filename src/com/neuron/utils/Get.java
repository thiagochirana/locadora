/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neuron.utils;

import com.neuron.exceptions.TipoCombustivelException;
import com.neuron.templates.DataBase;
import com.neuron.templates.Disponibilidade;
import com.neuron.templates.TipoCombustivel;
import com.neuron.templates.TipoVeiculo;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author thiag
 */
public class Get {
    public static TipoCombustivel combustivelByNome(String nome) throws TipoCombustivelException{
        switch (nome){
            case "DIESEL":
                return TipoCombustivel.DIESEL;
            case "ETANOL":
                return TipoCombustivel.ETANOL;    
            case "FLEX":
                return TipoCombustivel.FLEX;
            case "GASOLINA":
                return TipoCombustivel.GASOLINA;
            case "GNV":
                return TipoCombustivel.GNV;
            default: throw new TipoCombustivelException("Nao foi encontrado o tipo "+nome+" registrado");
        }
    }
    
    public static Disponibilidade disponibilidadeByNome(String nome) throws Exception {
        switch (nome) {
            case "ALUGADO":
                return Disponibilidade.ALUGADO;
            case "DISPONÍVEL":
                return Disponibilidade.DISPONÍVEL;
            case "MANUTENÇÃO":
                return Disponibilidade.MANUTENÇÃO;
            case "PERCA":
                return Disponibilidade.PERCA;
            case "VENDIDO":
                return Disponibilidade.VENDIDO;
            default: throw new Exception("Nao foi encontrado a disponibilidade de nome "+nome);
        }
    }
    
    public static int IDModeloSelecionado(String nomeModelo) throws Exception {
        FileReader fr = new FileReader(DataBase.MODELO.getPathDB());
        BufferedReader modelo = new BufferedReader(fr);
        String linha;
        int id = 0;
        while ((linha = modelo.readLine()) != null) {
            if (linha.contains(nomeModelo)) {
                String[] vetor = linha.split(";");
                id = Integer.parseInt(vetor[0]);
            }
        }
        modelo.close();
        if (id == 0) {
            throw new Exception("ID do modelo " + nomeModelo + " nao encontrado!");
        }
        return id;
    }
    
    public static TipoVeiculo TipoVeiculoByNome(String nomeTipo) throws Exception{
        switch (nomeTipo) {
            case "HATCH":
                return TipoVeiculo.HATCH;
            case "PICKUP":
                return TipoVeiculo.PICKUP;
            case "SEDAN":
                return TipoVeiculo.SEDAN;
            case "SUV":
                return TipoVeiculo.SUV;
            default: throw new Exception("Nao foi encontrado o tipo Veiculo "+nomeTipo);
        }
    }
    
    public static int getIdMotoristaByCNH(int CNH) throws Exception{
        try {
            
            IControle
            
            return 0 ;
        } catch (Exception e) {
            throw new Exception (e + " | nao foi possivel encontrar motorista com a CNH n: "+CNH);
        }
    }
}
