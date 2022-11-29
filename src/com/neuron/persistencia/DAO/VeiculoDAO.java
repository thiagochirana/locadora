/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/
package com.neuron.persistencia.DAO;

import com.neuron.persistencia.IVeiculoDAO;
import com.neuron.templates.DataBase;
import com.neuron.templates.Disponibilidade;
import com.neuron.templates.TipoCombustivel;
import com.neuron.templates.TipoVeiculo;
import com.neuron.templates.Veiculo;
import com.neuron.utils.Gerador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class VeiculoDAO implements IVeiculoDAO{
    
    @Override
    public ArrayList<Veiculo> listagemVeiculo() throws Exception {
        try {
            ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
            FileReader fr = new FileReader(DataBase.VEICULO.getPathDB());
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Veiculo veiculo = new Veiculo();
                String aux[] = linha.split(";");
                veiculo.setIdVeiculo(Integer.parseInt(aux[0]));
                veiculo.setCor(aux[1]);
                veiculo.setNomeModelo(aux[2]);
                veiculo.setDisponivel(getDisponivel(aux[3]));
                veiculo.setNomeMarca(aux[4]);
                veiculo.setPlaca(aux[5]);
                veiculo.setAnoFabricacao(aux[6]);
                veiculo.setTipoCombustivel(getTipoCombustivel(aux[7]));
                veiculo.setQulometragem(Integer.parseInt(aux[8]));
                veiculo.setTipoVeiculo(getTipoVeiculo(aux[9]));
                veiculo.setRenavan(Integer.parseInt(aux[10]));
                veiculo.setPrecoCompra(Float.parseFloat(aux[11]));
                veiculo.setPrecoVenda(Float.parseFloat(aux[12]));
                veiculo.setDataCompra(aux[13]);
                veiculo.setDataVenda(aux[14]);
                veiculo.setIdModeloRelacionado(Integer.parseInt(aux[15]));
                listaVeiculo.add(veiculo);
            }
            br.close();

            return listaVeiculo;

        } catch (Exception erro) {
            throw new Exception(erro);
        }
    }
    
    @Override
    public void incluirVeiculo(Veiculo veiculo) throws Exception {
        try{
            //cria o arquivo
            FileWriter fw = new FileWriter(DataBase.VEICULO.getPathDB(),true);
            //Criar o buffer do arquivo
            BufferedWriter bw =new BufferedWriter(fw);
            // Incluindo o id no objeto ******
            veiculo.setIdVeiculo(Gerador.getIdVeiculo());
            //Escreve no arquivo
            bw.write(veiculo.toString()+"\n");
            //fecha o arquivo
            bw.close();	
            
            //Backup.Database();
        }catch(IOException erro){
            throw erro;
      }
    }
    
    @Override
    public void alterarVeiculo(Veiculo veiculo) throws Exception {
        try {
            Veiculo v;
            String linha = "";
            
            //Criar o txt auxiliar para manipulacao da pilha 
            String dbAux1 ="./src/com/neuron/database/dbVeiculoAux1.txt";
            Gerador.createDB("dbVeiculoAux1");
            FileWriter fwAux1 = new FileWriter(dbAux1);
            BufferedWriter bwAux1 = new BufferedWriter(fwAux1);
            
            //Leitura do banco atual
            String caminhoDbVeiculo= "./src/com/neuron/database/dbVeiculo.txt";
            File dbVeiculo = new File(caminhoDbVeiculo);
            BufferedReader br = new BufferedReader( new FileReader(caminhoDbVeiculo) );

            //altera a linha caso o ID for igual ao do selecionado na tabelaMarca
            int idSelecionado = veiculo.getIdVeiculo();
            while ((linha = br.readLine()) != null) {
                String[] vet = linha.split(";");
                if(vet[0].equals(idSelecionado+"")){
                    
                    int id = veiculo.getIdVeiculo();
                    String cor = veiculo.getCor();
                    String modelo = veiculo.getNomeModelo();
                    Disponibilidade dispo = veiculo.getDisponivel();
                    String marca = veiculo.getNomeMarca();
                    String placa = veiculo.getPlaca();
                    String anoFabri = veiculo.getAnoFabricacao();
                    TipoCombustivel tipo = veiculo.getTipoCombustivel();
                    int quilometro = veiculo.getQulometragem();
                    TipoVeiculo tipoVeiculo = veiculo.getTipoVeiculo();
                    int renavam = veiculo.getRenavan();
                    float precoCompra = veiculo.getPrecoCompra();
                    float precoVenda = veiculo.getPrecoVenda();
                    String dataCompra = veiculo.getDataCompra();
                    String dataVenda = veiculo.getDataVenda();
                    String info = veiculo.getInfoAdicional();
                    int idModelo = veiculo.getIdModelo();
                    v = new Veiculo(id, cor, modelo, dispo, marca, placa, anoFabri, tipo, quilometro, tipoVeiculo, renavam, precoCompra, precoVenda, dataCompra, dataVenda,info, idModelo);

                    bwAux1.write(veiculo.toString()+"\n");
                } else {
                    bwAux1.write(linha+"\n");
                }
            }
            br.close();
            bwAux1.close();
            
           File dbNovo = new File (dbAux1);
            
            //deleta o banco atual
            dbVeiculo.delete();
            
            //renomeia o dbMarcaAux1 para ser o principal
            dbNovo.renameTo(dbVeiculo);
            
            //Backup.Database();
        } catch (Exception e) {
            throw new Exception("Nao foi possivel alterar modelo: "+e.getMessage());
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
    
    private TipoVeiculo getTipoVeiculo(String nomeCombustivel) {
        switch (nomeCombustivel) {
            case "SEDAN":
                return TipoVeiculo.SEDAN;
            case "HATCH":
                return TipoVeiculo.HATCH;
            case "SUV":
                return TipoVeiculo.SUV;
            case "PICKUP":
                return TipoVeiculo.PICKUP;
            default:
                return TipoVeiculo.SEDAN;
        }
    }
    
}
