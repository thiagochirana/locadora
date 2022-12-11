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
    
    public static int getIdCliente()throws Exception{
        String nomeDoArquivo ="./src/com/neuron/database/idControleClientes.txt";
        BufferedReader br  = new BufferedReader(new FileReader(nomeDoArquivo));
        String linha=br.readLine();
        int id = Integer.parseInt(linha);
        br.close();
        id=id+1;
        BufferedWriter bw =new BufferedWriter(new FileWriter(nomeDoArquivo));
        bw.write(id+"");
        bw.close();	
        return id;
    }
    
    public static int getIdMotorista()throws Exception{
        String nomeDoArquivo ="./src/com/neuron/database/idControleMotorista.txt";
        BufferedReader br  = new BufferedReader(new FileReader(nomeDoArquivo));
        String linha=br.readLine();
        int id = Integer.parseInt(linha);
        br.close();
        id=id+1;
        BufferedWriter bw =new BufferedWriter(new FileWriter(nomeDoArquivo));
        bw.write(id+"");
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
    
    public static int getIdVeiculo()throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(DataBase.IDVEICULO.getPathDB());
        BufferedReader br  = new BufferedReader(fr);
        String linha=br.readLine();
        int id = Integer.parseInt(linha);
        br.close();
        id=id+1;
        //cria o arquivo
        FileWriter fw = new FileWriter(DataBase.IDVEICULO.getPathDB());
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
