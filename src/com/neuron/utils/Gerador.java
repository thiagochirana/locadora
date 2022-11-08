/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.utils;

import com.neuron.templates.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;

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
    
    public static void createDB(String nome)throws FileNotFoundException, IOException{
        String db = nome;
        FileWriter fw = new FileWriter(db);
        BufferedWriter bw =new BufferedWriter(fw);
        bw.write("");
        bw.close();
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
    
    public static int getIdModelo()throws FileNotFoundException, IOException{
        String nomeDoArquivo ="./src/com/neuron/database/idControleModelo.txt";
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
    
    public static int getIDMarcaSelecionada(String nomeMarca) throws FileNotFoundException, IOException {
        String dirMarca ="./src/com/neuron/database/dbMarca.txt";
        FileReader fr = new FileReader(dirMarca);
        BufferedReader br  = new BufferedReader(fr);
        
        String linha = "";
        int res=0;
        boolean achou = false;
        
        while((linha=br.readLine())!=null && achou == false){
            if (linha.contains(nomeMarca)){
                String vetorString[] = linha.split(";");
                res = Integer.parseInt(vetorString[0]);
                achou = true;
            }
        }
        
        if (achou == true) return res; else throw new IOException("Marca nao encontrada pelo nome!");
    }
    
    public static String getNomeMarcaByID(int IDMarca)throws FileNotFoundException, IOException, Exception{
        String dirMarca = "./src/com/neuron/database/dbMarca.txt";
        FileReader fr = new FileReader(dirMarca);
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        String res="";
        boolean achou = false;
        
        while((linha=br.readLine())!=null && achou == false){
            if (linha.contains(IDMarca+"")){
                String vetorString[] = linha.split(";");
                res = vetorString[1];
                achou = true;
            }
        }
        
        if (achou == true) return res; else throw new IOException("Marca nao encontrada pelo ID!");
    }
    
    public static ImageIcon getLogoMarcaByID (int IDMarca) throws FileNotFoundException, IOException, Exception{
        String dirMarca = "./src/com/neuron/database/dbMarca.txt";
        FileReader fr = new FileReader(dirMarca);
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        boolean achou = false;
        ImageIcon img = new ImageIcon();
        
        while ((linha = br.readLine()) != null && achou == false) {
            if (linha.contains(IDMarca + "")) {
                String vetorString[] = linha.split(";");
                int id = Integer.parseInt(vetorString[1]);
                img = new ImageIcon(".src/com/neuron/icons/logo/"+getNomeMarcaByID(id).toUpperCase()+".jpeg");
                achou = true;
            }
        }
        
        if (achou == true) return img; else throw new IOException("Logo da Marca nao encontrada pelo ID!");
    }
    
    public static ImageIcon getLogoMarcaByNome (String nomeMarca) throws FileNotFoundException, IOException, Exception{
        Logs.logger("Marca selecionada: "+nomeMarca, Gerador.class.getName());
        String caminho = ".src/com/neuron/icons/logo/"+nomeMarca.toUpperCase()+".jpeg";
        Logs.logger("Procurando arquivo: "+caminho, Gerador.class.getName());
        return new ImageIcon(caminho);
    }
}
