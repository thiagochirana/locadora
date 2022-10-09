/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.persistencia;

import com.neuron.templates.Marca;
import com.neuron.utils.Gerador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class ReadWrite implements IReadWrite{
    
    private String dirMarca;
    public ReadWrite(){
        //this.dirLogos = "./src/com/neuron/data/dbMarca.txt";
        this.dirMarca = "./src/com/neuron/database/dbMarca.txt";
    }
    
    @Override
    public void incluir(Marca marca) throws Exception {
        try{
            //cria o arquivo
            FileWriter fw = new FileWriter(dirMarca,true);
            //Criar o buffer do arquivo
            BufferedWriter bw =new BufferedWriter(fw);
            // Incluindo o id no objeto ******
            marca.setIdMarca(Gerador.getIdMarca());
            //Escreve no arquivo
            bw.write(marca.toString()+"\n");
            //fecha o arquivo
            bw.close();		
      }catch(Exception erro){
            throw erro;
      }
    }
    
    @Override
    public ArrayList<Marca> listagem() throws Exception {
        try {
            ArrayList<Marca> listaDeMarcas = new ArrayList<Marca>();
            FileReader fr = new FileReader("./src/com/neuron/database/dbMarca.txt");
            BufferedReader br  = new BufferedReader(fr);
            String linha = "";
            while((linha=br.readLine())!=null){
                Marca marca = new Marca();
                String vetorString[] = linha.split(";");
                marca.setIdMarca(Integer.parseInt(vetorString[0]));
                marca.setNomeMarca(vetorString[1]);
                marca.setDirLogo(vetorString[2].replace("./src/com/neuron/icons/","/"));
                listaDeMarcas.add(marca);
            }
            br.close();
         return listaDeMarcas;
        } catch(Exception erro){
         throw erro;
        }
    }

}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
