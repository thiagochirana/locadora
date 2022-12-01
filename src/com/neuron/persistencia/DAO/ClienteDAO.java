/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.persistencia.DAO;

import com.neuron.persistencia.IClienteDAO;
import com.neuron.templates.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class ClienteDAO implements IClienteDAO{
    
    @Override
    public ArrayList<Cliente> listagemClientes() throws Exception{
        File dbCliente = new File(DataBase.CLIENTE.getPathDB());
        // verifica se banco existe, se nao tenta puxar do backup
        try {
            if (!dbCliente.exists()) {
                FileWriter fl = new FileWriter(dbCliente);
                fl.close();
            }             

            ArrayList<Cliente> lista = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(DataBase.CLIENTE.getPathDB()));
            String linha = "";

            while ((linha = br.readLine()) != null) {
                Cliente cli = new Cliente();
                String vet[] = linha.split(";");
                cli.setId(Integer.parseInt(vet[0]));
                cli.setNome(vet[1]);
                cli.setRazaoSocial(vet[2]);
                cli.setRg(vet[3]);
                cli.setEmail(vet[4]);
                cli.setMotorista(vet[5]);
                cli.setnCNH(Integer.parseInt(vet[6]));
                cli.setCaminhoImgCNH(vet[7]);
                cli.setCaminhoImgCNHCompleto(vet[8]);
                cli.setStatusMulta(getStatusMulta(vet[9]));
                cli.setValorMulta(Float.parseFloat(vet[10]));
                cli.setLogradouro(vet[11]);
                cli.setComplemento(vet[12]);
                cli.setCEP(Integer.parseInt(vet[13]));
                cli.setBairro(vet[14]);
                cli.setCidade(vet[15]);
                cli.setEstado(vet[16]);
                cli.setDDI(Integer.parseInt(vet[17]));
                cli.setDDD(Integer.parseInt(vet[18]));
                cli.setNumero(Integer.parseInt(vet[19]));

                lista.add(cli);
            }
            br.close();

            return lista;

        } catch (Exception erro) {
            //Gerador.createDB(DataBase.MARCA.getPathDB());

            throw new Exception(erro + "Marcas nao foram encontradas\nFoi criado um database de contingência ");
        }
    }
    
    private StatusMulta getStatusMulta(String status) throws Exception{
        switch (status){
            case "EM DIVIDA":
                return StatusMulta.EM_DIVIDA;
            case "SEM MULTA":
                return StatusMulta.SEM_MULTA;
            case "QUITADO":
                return StatusMulta.QUITADO;
            default:
                throw new Exception("Status nao encontrado");
        }
    }
}

// Software developed by Thiago Chirana -> https://github.com/othiagomacedo