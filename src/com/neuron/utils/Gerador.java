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
        String idGeral ="./src/com/neuron/database/idControle.txt";
        String idCPF ="./src/com/neuron/database/idControlePessoaFisica.txt";
        String idCNPJ ="./src/com/neuron/database/idControlePessoaJuridica.txt";
        String idUser = "./src/com/neuron/database/idControleUsers.txt";
        String idControleMarca = "./src/com/neuron/database/idControleMarca.txt";
        
        FileWriter fwGeral = new FileWriter(idGeral);
        FileWriter fwCPF = new FileWriter(idCPF);
        FileWriter fwCNPJ = new FileWriter(idCNPJ);
        FileWriter fwUser = new FileWriter(idUser);
        FileWriter fwIDMarca = new FileWriter(idControleMarca);
        
        //Criar o buffer do arquivo
        BufferedWriter bwGeral =new BufferedWriter(fwGeral);
        BufferedWriter bwCPF =new BufferedWriter(fwCPF);
        BufferedWriter bwCNPJ =new BufferedWriter(fwCNPJ);
        BufferedWriter bwUser =new BufferedWriter(fwUser);
        BufferedWriter bwIDMarca =new BufferedWriter(fwIDMarca);
        
        //Escreve no arquivo
        String saidaID = 1+""; //ID Geral, ID para CNPJs, ID para Users
        String saidaIDCPF = 2+""; //ID para CPFs
        bwGeral.write(saidaID);
        bwCNPJ.write(saidaID);
        bwCPF.write(saidaID);
        bwUser.write(saidaID);
        bwIDMarca.write(saidaID);
        
        //fecha o arquivo
        bwGeral.close();
        bwCPF.close();
        bwCNPJ.close();
        bwUser.close();
        bwIDMarca.close();
    }
    
    public static void createDataBase()throws FileNotFoundException, IOException{
        String dbCarro ="./src/com/neuron/database/dbCarro.txt";
        String dbUser ="./src/com/neuron/database/dbUser.txt";
        String dbCliente ="./src/com/neuron/database/dbCliente.txt";
        String dbMarca ="./src/com/neuron/database/dbMarca.txt";
        
        FileWriter fwCarro = new FileWriter(dbCarro);
        BufferedWriter bwCarro =new BufferedWriter(fwCarro);
        
        FileWriter fwUser = new FileWriter(dbUser);
        BufferedWriter bwUser =new BufferedWriter(fwUser);
        
        FileWriter fwCliente = new FileWriter(dbCliente);
        BufferedWriter bwCliente =new BufferedWriter(fwCliente);
        
        FileWriter fwMarca = new FileWriter(dbMarca);
        BufferedWriter bwMarca =new BufferedWriter(fwMarca);
        
        String saida = "";
        //continuar aqui, criar bancos
        bwCarro.write(saida);
        bwUser.write(saida);
        bwCliente.write(saida);
        bwMarca.write(saida);
        
        bwCarro.close();
        bwCliente.close();
        bwMarca.close();
        bwUser.close();
    }
    
    public static int getID()throws FileNotFoundException, IOException{
        String idGeral ="./src/com/neuron/database/idControle.txt";
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
        String nomeDoArquivo ="./src/com/neuron/database/idControlePessoaFisica.txt";
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
        String nomeDoArquivo ="./src/com/neuron/database/idControlePessoaJuridica.txt";
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
    
    public static int getIdMarca()throws FileNotFoundException, IOException{
        String nomeDoArquivo ="./src/com/neuron/database/idControleMarca.txt";
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br  = new BufferedReader(fr);
        String linha=br.readLine();
        int id = Integer.parseInt(linha);
        br.close();
        id=id+1;
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
