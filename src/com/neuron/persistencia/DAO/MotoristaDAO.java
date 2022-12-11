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
import com.neuron.utils.CopyFiles;
import com.neuron.utils.Gerador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class MotoristaDAO implements IMotoristaDAO{
    
    @Override
    public ArrayList<Motorista> listagemMotorista() throws Exception{
        ArrayList<Motorista> motora = new ArrayList<>();
        File bancoMotorista = new File(DataBase.MOTORISTA.getPathDB());
        BufferedReader br = new BufferedReader(new FileReader(bancoMotorista));
        String linha;
        
        if (!bancoMotorista.exists()) {
            FileWriter bdMotora = new FileWriter(DataBase.MOTORISTA.getPathDB());
            FileWriter idMotora = new FileWriter(DataBase.IDMOTORISTA.getPathDB());
            bdMotora.write("");
            idMotora.write("0");
            bdMotora.close();
            idMotora.close();
        }
        
        while ((linha = br.readLine()) != null) {
            Motorista mot = new Motorista();
            String vet[] = linha.split(";");
            mot.setIdMotorista(Integer.parseInt(vet[0]));
            mot.setNomeMotorista(vet[1]);
            mot.setNumeroCNH(Integer.parseInt(vet[2]));
            mot.setDataVencimento(vet[3]);
            mot.setCaminhoImgCNH(vet[4]);
            mot.setStatusMulta(getStatusMulta(vet[5]));
            mot.setValorMulta(Float.parseFloat(vet[6]));
            mot.setLogradouro(vet[7]);
            mot.setComplemento(vet[8]);
            mot.setCEP(Integer.parseInt(vet[9]));
            mot.setBairro(vet[10]);
            mot.setCidade(vet[11]);
            mot.setEstado(getEstadoByNome(vet[12]));
            mot.setDDI(Integer.parseInt(vet[13]));
            mot.setDDD(Integer.parseInt(vet[14]));
            mot.setNumero(Integer.parseInt(vet[15]));
            mot.setIdClienteVinculado(Integer.parseInt(vet[16]));
            
            motora.add(mot);
        }
        br.close();
         
        return motora;
    }
    
    @Override
    public void inserirMotorista(Motorista motorista) throws Exception{
        try {
            String path = getCaminhoImg();
            int id = Gerador.getIdCliente();
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(DataBase.CLIENTE.getPathDB(),true));
            motorista.setIdMotorista(id);
            motorista.setCaminhoImgCNH("./src/com/neuron/icons/motorista/fotoCNH/"+ motorista.getNomeMotorista()+"_"+motorista.getNumeroCNH()+ ".jpeg");
            bw.write(motorista.toString()+"\n");
            bw.close();
            
            CopyFiles.copiarImgSelecionada(path, "./src/com/neuron/icons/motorista/fotoCNH/", motorista.getNomeMotorista()+"_"+motorista.getNumeroCNH() + ".jpeg",250,200);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public void alterarMotorista(Motorista motorista) throws Exception{
        File dbMotorista = new File(DataBase.MOTORISTA.getPathDB());
        Motorista motora = new Motorista();
        try {
            if (!dbMotorista.exists()) {
                inserirMotorista(motorista);
                throw new Exception("Lista vazia! Este cadastro sera o primeiro Motorista");
            }

            String linha = "";

            //Criar o txt auxiliar para manipulacao da pilha 
            String dbAux1 = "./src/com/neuron/database/dbMotoristaAux1.txt";
            FileWriter fwAux1 = new FileWriter(dbAux1);
            BufferedWriter bwAux1 = new BufferedWriter(fwAux1);

            //Leitura do banco atual
            String caminhoDbMotorista = DataBase.MOTORISTA.getPathDB();
            File dbmotora = new File(caminhoDbMotorista);
            File dbmotoraAux = new File(caminhoDbMotorista);
            FileReader fr = new FileReader(caminhoDbMotorista);
            BufferedReader br = new BufferedReader(fr);

            //altera a linha caso o ID for igual ao do selecionado na tabelaMarca
            while ((linha = br.readLine()) != null) {
                String[] vet = linha.split(";");
                if (vet[0].equals(motorista.getIdMotorista()+"")) {
                    motora.setIdMotorista(Integer.parseInt(vet[0]));
                    motora.setNomeMotorista(vet[1]);
                    motora.setNumeroCNH(Integer.parseInt(vet[2]));
                    motora.setDataVencimento(vet[3]);
                    motora.setCaminhoImgCNH(vet[4]);
                    motora.setStatusMulta(getStatusMulta(vet[5]));
                    motora.setValorMulta(Float.parseFloat(vet[6]));
                    motora.setLogradouro(vet[7]);
                    motora.setComplemento(vet[8]);
                    motora.setCEP(Integer.parseInt(vet[9]));
                    motora.setBairro(vet[10]);
                    motora.setCidade(vet[11]);
                    motora.setEstado(getEstadoByNome(vet[12]));
                    motora.setDDI(Integer.parseInt(vet[13]));
                    motora.setDDD(Integer.parseInt(vet[14]));
                    motora.setNumero(Integer.parseInt(vet[15]));
                    motora.setIdClienteVinculado(Integer.parseInt(vet[16]));
                } else {
                        bwAux1.write(linha + "\n");
                }
            }
            br.close();
            bwAux1.close();

            File dbmotoraNovo = new File(dbAux1);

            //deleta o banco atual
            dbmotora.delete();

            //renomeia o dbMarcaAux1 para ser o principal
            dbmotoraNovo.renameTo(dbmotoraAux);

        } catch (Exception e) {
            throw new Exception("Nao foi possivel realizar a alteracao: "+e.getMessage());
        }
    }
    
    @Override
    public Estados getEstadoByNome(String nomeEstado) throws Exception {
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
    
    private StatusMulta getStatusMulta(String status) throws Exception{
        switch (status){
            case "EM_DIVIDA":
                return StatusMulta.EM_DIVIDA;
            case "SEM_MULTA":
                return StatusMulta.SEM_MULTA;
            case "QUITADO":
                return StatusMulta.QUITADO;
            case "EM DIVIDA":
                return StatusMulta.EM_DIVIDA;
            case "SEM MULTA":
                return StatusMulta.SEM_MULTA;
            default:
                throw new Exception("Status nao encontrado");
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
    
}
// Software developed by Thiago Chirana -> https://github.com/othiagomacedo