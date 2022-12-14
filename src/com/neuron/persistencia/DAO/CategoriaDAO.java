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


public class CategoriaDAO implements ICategoriaDAO{
    
    @Override
    public void inserirCategoria(Categoria categoria) throws Exception{

        BufferedWriter bw = new BufferedWriter(new FileWriter(DataBase.CATEGORIA.getPathDB(),true));
        
        categoria.setIdCategoria(getID());
        
        bw.write(categoria.toString()+"\n");
        
        bw.close();
    }
    
    
    @Override
    public void alterarCategoria(Categoria categoria) throws Exception {
        try {
            Categoria cat = new Categoria();
            String linha = "";

            //Criar o txt auxiliar para manipulacao da pilha 
            String dbAux1 = "./src/com/neuron/database/dbCategoriaAux1.txt";
            FileWriter fwAux1 = new FileWriter(dbAux1);
            BufferedWriter bwAux1 = new BufferedWriter(fwAux1);

            //Leitura do banco atual
            String caminhoDbCat = DataBase.CATEGORIA.getPathDB();
            File dbCat = new File(caminhoDbCat);
            File dbCatAux = new File(caminhoDbCat);
            FileReader fr = new FileReader(caminhoDbCat);
            BufferedReader br = new BufferedReader(fr);

            //altera a linha caso o ID for igual ao do selecionado na tabelaCategoria
            while ((linha = br.readLine()) != null) {
                String[] vet = linha.split(";");
                if (vet[0].equals(""+categoria.getIdCategoria())) {
                    cat.setIdCategoria(categoria.getIdCategoria());
                    cat.setNomeCategoria(categoria.getNomeCategoria());
                    cat.setValorAluguelCategoria(categoria.getValorAluguelCategoria());
                    bwAux1.write(cat.toString() + "\n");
                } else {
                    bwAux1.write(linha + "\n");
                }
            }
            br.close();
            bwAux1.close();
            
            File dbCatNovo = new File(dbAux1);

            //deleta o banco atual
            dbCat.delete();

            //renomeia o dbCategoriaAux1 para ser o principal
            dbCatNovo.renameTo(dbCatAux);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    public ArrayList<Categoria> listagemCategoria() throws Exception{
        try {
            ArrayList<Categoria> listaDeCategoria = new ArrayList<>();
            FileReader fr = new FileReader(DataBase.CATEGORIA.getPathDB());
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Categoria cat = new Categoria();
                String vetorString[] = linha.split(";");
                cat.setIdCategoria(Integer.parseInt(vetorString[0]));
                cat.setNomeCategoria(vetorString[1]);
                cat.setValorAluguelCategoria(Float.parseFloat(vetorString[2]));
                listaDeCategoria.add(cat);
            }
            br.close();

            return listaDeCategoria;

        } catch (Exception erro) {
            throw new Exception(erro + " | Erro ao listar Categorias");
        }
    }
    
    
    private int getID() throws Exception {
        String idGeral = DataBase.IDCATEGORIA.getPathDB();
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
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
