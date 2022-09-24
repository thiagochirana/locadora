/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Gerador {
    
    public static void createDataBaseID()throws FileNotFoundException, IOException{
        String idGeral ="./src/com/neuron/data/idControle.txt";
        String idCPF ="./src/com/neuron/data/idControlePessoaFisica.txt";
        String idCNPJ ="./src/com/neuron/data/idControlePessoaJuridica.txt";
        String idUser = "./src/com/neuron/data/idControleUsers.txt";
        
        FileWriter fwGeral = new FileWriter(idGeral);
        FileWriter fwCPF = new FileWriter(idCPF);
        FileWriter fwCNPJ = new FileWriter(idCNPJ);
        FileWriter fwUser = new FileWriter(idUser);
        
        //Criar o buffer do arquivo
        BufferedWriter bwGeral =new BufferedWriter(fwGeral);
        BufferedWriter bwCPF =new BufferedWriter(fwCPF);
        BufferedWriter bwCNPJ =new BufferedWriter(fwCNPJ);
        BufferedWriter bwUser =new BufferedWriter(fwUser);
        
        //Escreve no arquivo
        String saidaID = 1+""; //ID Geral, ID para CNPJs, ID para Users
        String saidaIDCPF = 2+""; //ID para CPFs
        bwGeral.write(saidaID);
        bwCNPJ.write(saidaID);
        bwCPF.write(idCPF);
        bwUser.write(idUser);
        
        //fecha o arquivo
        bwGeral.close();
        bwCPF.close();
        bwCNPJ.close();
        bwUser.close();
    }
    
    public static void createDataBase()throws FileNotFoundException, IOException{
        String dbCarro ="./src/com/neuron/data/dbCarro.txt";
        String dbUser ="./src/com/neuron/data/dbUser.txt";
        String dbCliente ="./src/com/neuron/data/dbCliente.txt";
        
        FileWriter fwCarro = new FileWriter(dbCarro);
        BufferedWriter bwCarro =new BufferedWriter(fwCarro);
        
        FileWriter fwUser = new FileWriter(dbUser);
        BufferedWriter bwUser =new BufferedWriter(fwUser);
        
        FileWriter fwCliente = new FileWriter(dbCliente);
        BufferedWriter bwCliente =new BufferedWriter(fwCliente);
        
        //continuar aqui, criar bancos
    }
    
    public static int getID()throws FileNotFoundException, IOException{
        String idGeral ="./src/com/neuron/data/idControle.txt";
        FileReader fr = new FileReader(idGeral);
        BufferedReader br  = new BufferedReader(fr);
        String linha=br.readLine();
        int id = Integer.parseInt(linha);
        br.close();
        id=id+1;
        //cria o arquivo
        FileWriter fw = new FileWriter(idGeral);
        //Criar o buffer do arquivo
        BufferedWriter bw =new BufferedWriter(fw);
        //Escreve no arquivo
        String saida = id+"";
        bw.write(saida);
        //fecha o arquivo
        bw.close();	
        return id;
    }
    
    public static int getIdCPF()throws FileNotFoundException, IOException{
        String nomeDoArquivo ="./src/com/neuron/data/idControlePessoaFisica.txt";
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br  = new BufferedReader(fr);
        String linha=br.readLine();
        int id = Integer.parseInt(linha);
        br.close();
        id=id+2;
        //cria o arquivo
        FileWriter fw = new FileWriter(nomeDoArquivo);
        //Criar o buffer do arquivo
        BufferedWriter bw =new BufferedWriter(fw);
        //Escreve no arquivo
        String saida = id+"";
        bw.write(saida);
        //fecha o arquivo
        bw.close();	
        return id;
    }
    
    public static int getIdCNPJ()throws FileNotFoundException, IOException{
        String nomeDoArquivo ="./src/com/neuron/data/idControlePessoaJuridica.txt";
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br  = new BufferedReader(fr);
        String linha=br.readLine();
        int id = Integer.parseInt(linha);
        br.close();
        id=id+2;
        //cria o arquivo
        FileWriter fw = new FileWriter(nomeDoArquivo);
        //Criar o buffer do arquivo
        BufferedWriter bw =new BufferedWriter(fw);
        //Escreve no arquivo
        String saida = id+"";
        bw.write(saida);
        //fecha o arquivo
        bw.close();	
        return id;
    }
}
