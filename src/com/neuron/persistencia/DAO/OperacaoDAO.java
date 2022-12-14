/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.persistencia.DAO;

import com.neuron.persistencia.*;
import com.neuron.templates.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;


public class OperacaoDAO implements IOperacaoDAO{

    public OperacaoDAO() {
    }
    
    @Override
    public ArrayList<Cliente> listarCliente() throws Exception{
        File dbOper = new File(DataBase.OPERACAO.getPathDB());
        File idOper = new File(DataBase.IDOPERACAO.getPathDB());
        // verifica se banco existe, se nao tenta puxar do backup
        try {
            if (!dbOper.exists()) {
                //criar banco
                FileWriter fl = new FileWriter(dbOper);
                fl.close();
                //criar o ID
                FileWriter fC = new FileWriter(idOper);
                fC.write("0");
                fC.close();
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
                cli.setMotorista(vet[5]);
                cli.setnCNH(Integer.parseInt(vet[6]));
                cli.setDDI(Integer.parseInt(vet[16]));
                cli.setDDD(Integer.parseInt(vet[17]));
                cli.setNumero(Integer.parseInt(vet[18]));

                lista.add(cli);
            }
            br.close();

            return lista;

        } catch (Exception erro) {
            throw new Exception(erro);
        }
    }
    
    @Override
    public ArrayList<Veiculo> listagemVeiculo() throws Exception {
        try {
            ArrayList<Veiculo> listaVeiculo = new ArrayList<>();
            FileReader fr = new FileReader(DataBase.VEICULO.getPathDB());
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                
                String aux[] = linha.split(";");
                
                if (getDisponivel(aux[3]) == Disponibilidade.DISPONÍVEL) {
                    Veiculo veiculo = new Veiculo();
                    veiculo.setIdVeiculo(Integer.parseInt(aux[0]));
                    veiculo.setCor(aux[1]);
                    veiculo.setNomeModelo(aux[2]);
                    veiculo.setNomeMarca(aux[4]);
                    veiculo.setPlaca(aux[5]);
                    veiculo.setTipoCombustivel(getTipoCombustivel(aux[7]));
                    veiculo.setIdModeloRelacionado(Integer.parseInt(aux[15]));
                    listaVeiculo.add(veiculo);
                }
            }
            
            br.close();

            return listaVeiculo;

        } catch (Exception erro) {
            throw new Exception(erro);
        }
    }
    
    @Override
    public void realizarVenda(Operacao operacao) throws Exception{
        int id = getID();
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(DataBase.OPERACAO.getPathDB(),true));
        BufferedWriter mot = new BufferedWriter(new FileWriter(DataBase.MOTIVO.getPathDB(),true));
        
        operacao.setIdOperacao(id);
        
        //setar carro para o mesmo estar alugado
        setAlugado(operacao.getIdVeiculo());
        
        String motivos = operacao.getIdOperacao()+";"+operacao.getMotivo();
        operacao.setMotivo("");
        
        mot.write(motivos+"\n");
        bw.write(operacao.toString()+"\n");
        
        mot.close();
        bw.close();
    }    
    
    public float estimaValorAluguel(int idVeiculo,int dias) throws Exception{
        ArrayList<Veiculo> veiculo = listagemVeiculo();
        
        Iterator<Veiculo> lista = veiculo.iterator();
        
        while (lista.hasNext()){
            Veiculo ve = new Veiculo();
            if (ve.getIdVeiculo() == idVeiculo) {
                //categoria
            }
        }
        
        return 0F;
    }
    
    private int getID() throws Exception {
        String idGeral = DataBase.IDOPERACAO.getPathDB();
        FileReader fr = new FileReader(idGeral);
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();
        int id = Integer.parseInt(linha);
        br.close();
        id = id + 1;
        //cria o arquivo
        FileWriter fw = new FileWriter(idGeral);
        //Criar o buffer do arquivo
        BufferedWriter bw = new BufferedWriter(fw);
        //Escreve no arquivo
        String saida = id + "";
        bw.write(saida);
        //fecha o arquivo
        bw.close();
        return id;
    }
    
    private TipoCombustivel getTipoCombustivel(String nomeCombustivel) {
        switch (nomeCombustivel) {
            case "GASOLINA":
                return TipoCombustivel.GASOLINA;
            case "ETANOL":
                return TipoCombustivel.ETANOL;
            case "DIESEL":
                return TipoCombustivel.DIESEL;
            case "GNV":
                return TipoCombustivel.GNV;
            case "FLEX":
                return TipoCombustivel.FLEX;
            default:
                return TipoCombustivel.GASOLINA;
        }
    }
    
    private Disponibilidade getDisponivel(String nomeDispo) {
        switch (nomeDispo) {
            case "DISPONÍVEL":
                return Disponibilidade.DISPONÍVEL;
            case "ALUGADO":
                return Disponibilidade.ALUGADO;
            case "MANUTENÇÃO":
                return Disponibilidade.MANUTENÇÃO;
            case "PERCA":
                return Disponibilidade.PERCA;
            case "VENDIDO":
                return Disponibilidade.VENDIDO;
            default:
                return Disponibilidade.DISPONÍVEL;
        }
    }
    
    private void setAlugado(int idVeiculo) {
        
    }
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
