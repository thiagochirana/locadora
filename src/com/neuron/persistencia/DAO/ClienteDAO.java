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
import com.neuron.utils.CopyFiles;
import com.neuron.utils.Gerador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import jdk.jfr.events.FileWriteEvent;


public class ClienteDAO implements IClienteDAO{
    
    @Override
    public ArrayList<Cliente> listagemClientes() throws Exception{
        File dbCliente = new File(DataBase.CLIENTE.getPathDB());
        // verifica se banco existe, se nao tenta puxar do backup
        try {
            if (!dbCliente.exists()) {
                FileWriter fl = new FileWriter(dbCliente);
                fl.close();
                throw new Exception("Lista vazia! Por gentileza cadastre um novo cliente");
            }             

            ArrayList<Cliente> lista = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(DataBase.CLIENTE.getPathDB()));
            String linha = "";

            while ((linha = br.readLine()) != null) {
                Cliente cli = new Cliente();
                String vet[] = linha.split(";");
                cli.setId(Integer.parseInt(vet[0]));
                cli.setCpfCnpj(vet[1]);
                cli.setNomeRazaoSocial(vet[2]);
                cli.setRg(vet[3]);
                cli.setEmail(vet[4]);
                cli.setMotorista(vet[5]);
                cli.setnCNH(Integer.parseInt(vet[6]));
                cli.setCaminhoImgCNH(vet[9]);
                cli.setStatusMulta(getStatusMulta(vet[10]));
                cli.setValorMulta(Float.parseFloat(vet[11]));
                cli.setLogradouro(vet[12]);
                cli.setComplemento(vet[13]);
                cli.setCEP(Integer.parseInt(vet[14]));
                cli.setBairro(vet[15]);
                cli.setCidade(vet[16]);
                cli.setEstado(getEstadoByNome(vet[14]));
                cli.setDDI(Integer.parseInt(vet[17]));
                cli.setDDD(Integer.parseInt(vet[18]));
                cli.setNumero(Integer.parseInt(vet[19]));

                lista.add(cli);
            }
            br.close();

            return lista;

        } catch (Exception erro) {
            //Gerador.createDB(DataBase.MARCA.getPathDB());

            throw new Exception(erro);
        }
    }
    
    @Override
    public void InserirCliente(Cliente cliente) throws Exception{
        try {
            String path = getCaminhoImg();
            int id = Gerador.getIdCliente();
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(DataBase.CLIENTE.getPathDB()));
            cliente.setId(id);
            
            CopyFiles.copiarImgSelecionada(caminho, "./src/com/neuron/icons/logo/", marca.getNomeMarca() + ".jpeg");
            
            bw.write(cliente.toString());
            bw.close();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public List<String> getStatusMulta() throws Exception{
        List<String> aux = new ArrayList<>();
        List<StatusMulta> l = Arrays.asList(StatusMulta.values());
        for (StatusMulta statusMulta : l) {
            aux.add(statusMulta.toString().replace("_", " "));
        }
        return aux;
    }
    
    @Override
    public List<String> getNomeEstados() throws Exception{
        List<String> aux = new ArrayList<>();
        List<Estados> l = Arrays.asList(Estados.values());
        for (Estados estados : l) {
            aux.add(estados.toString().replace("_", " "));
        }
        return aux;
    }
    
    @Override
    public Estados getEstadoByNome(String nomeEstado) throws Exception{
        switch (nomeEstado) {
            case "ACRE":
                return Estados.ACRE;
            case "ALAGOAS":
                return Estados.ALAGOAS;
            case "AMAPA":
                return Estados.AMAPA;
            case "AMAZONAS":
                return Estados.AMAZONAS;
            case "BAHIA":
                return Estados.BAHIA;
            case "CEARA":
                return Estados.CEARA;
            case "DISTRITO_FEDERAL":
                return Estados.DISTRITO_FEDERAL;
            case "ESPIRITO_SANTO":
                return Estados.ESPIRITO_SANTO;
            case "GOIAS":
                return Estados.GOIAS;
            case "MARANHAO":
                return Estados.MARANHAO;
            case "MATO_GROSSO":
                return Estados.MATO_GROSSO;
            case "MATO_GROSSO_DO_SUL":
                return Estados.MATO_GROSSO_DO_SUL;
            case "MINAS_GERAIS":
                return Estados.MINAS_GERAIS;
            case "PARA":
                return Estados.PARA;
            case "PARAIBA":
                return Estados.PARAIBA;
            case "PARANA":
                return Estados.PARANA;
            case "PERNAMBUCO":
                return Estados.PERNAMBUCO;
            case "PIAUI":
                return Estados.PIAUI;
            case "RIO_DE_JANEIRO":
                return Estados.RIO_DE_JANEIRO;
            case "RIO_GRANDE_DO_NORTE":
                return Estados.RIO_GRANDE_DO_NORTE;
            case "RIO_GRANDE_DO_SUL":
                return Estados.RIO_GRANDE_DO_SUL;
            case "RONDONIA":
                return Estados.RONDONIA;
            case "RORAIMA":
                return Estados.RORAIMA;
            case "SANTA_CATARINA":
                return Estados.SANTA_CATARINA;
            case "SAO_PAULO":
                return Estados.SAO_PAULO;
            case "SERGIPE":
                return Estados.SERGIPE;
            case "TOCANTINS":
                return Estados.TOCANTINS;
            default:
                throw new Exception("Nao foi possivel identificar o Estado, tente novamente!");
        }
    }
    
    private String getCaminhoImg() throws Exception {
        File file = new File("./src/com/neuron/temp/pathImg.txt");
        FileReader fr = new FileReader("./src/com/neuron/temp/pathImg.txt");
        BufferedReader br = new BufferedReader(fr);
        String caminho = br.readLine();
        br.close();
        file.delete();
        return caminho;
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