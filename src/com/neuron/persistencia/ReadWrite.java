/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.persistencia;

import com.neuron.icons.ControladorImg;
import com.neuron.icons.IControladorImg;
import com.neuron.templates.Marca;
import com.neuron.templates.Modelo;
import com.neuron.utils.Gerador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class ReadWrite implements IReadWrite{
    
    IControladorImg iImg;
    private String dirMarca;
    private String dirModelo;
    public ReadWrite(){
        this.iImg = new ControladorImg();
        this.dirMarca = "./src/com/neuron/database/dbMarca.txt";
        this.dirModelo = "./src/com/neuron/database/dbModelo.txt";
    }
    
    @Override
    public void incluirMarca(Marca marca) throws Exception {
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
    public void alterarMarca(int id, String nomeMarca,String caminhoLogo) throws Exception{
        try {
            System.out.println(caminhoLogo);
            Marca marca = new Marca();
            ArrayList<Marca> aux = new ArrayList<Marca>();
            String linha = "";
            
            //Criar o txt auxiliar para manipulacao da pilha 
            String dbAux1 ="./src/com/neuron/database/dbMarcaAux1.txt";
            FileWriter fwAux1 = new FileWriter(dbAux1);
            BufferedWriter bwAux1 = new BufferedWriter(fwAux1);
            
            //Leitura do banco atual
            String caminhoDbMarca= "./src/com/neuron/database/dbMarca.txt";
            File dbMarca = new File(caminhoDbMarca);
            File dbMarcaAux = new File(caminhoDbMarca);
            FileReader fr = new FileReader(caminhoDbMarca);
            BufferedReader br = new BufferedReader(fr);

            //altera a linha caso o ID for igual ao do selecionado na tabelaMarca
            while ((linha = br.readLine()) != null) {
                if(linha.contains(id+"")){
                    marca.setIdMarca(id);
                    marca.setNomeMarca(nomeMarca);
                    marca.setDirLogo(iImg.alterNomeImgMarca(nomeMarca, caminhoLogo));
                    bwAux1.write(marca.toString()+"\n");
                } else {
                    bwAux1.write(linha+"\n");
                }
            }
            fr.close();
            br.close();
            bwAux1.close();
            
            File dbMarcaNovo = new File (dbAux1);
            
            //deleta o banco atual
            dbMarca.delete();
            
            //renomeia o dbMarcaAux1 para ser o principal
            dbMarcaNovo.renameTo(dbMarcaAux);
        } catch (Exception e) {
            throw new Exception("");
        }
    }
    
    @Override
    public ArrayList<Marca> listagemMarca() throws Exception {
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
         throw new Exception(erro);
        }
    }

    @Override
    public void incluirModelo(Modelo modelo) throws Exception {
        try {
            //cria o arquivo
            FileWriter fw = new FileWriter(dirModelo, true);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            // Incluindo o id no objeto ******
            modelo.setIdModelo(Gerador.getIdModelo());
            //Escreve no arquivo
            bw.write(modelo.toString() + "\n");
            //fecha o arquivo
            bw.close();
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public void alterarModelo(int id, String nomeModelo, String caminhoFotoModelo) throws Exception {
        try {
            System.out.println(caminhoFotoModelo);
            Modelo modelo = new Modelo();
            ArrayList<Modelo> aux = new ArrayList<Modelo>();
            String linha = "";
            
            //Criar o txt auxiliar para manipulacao da pilha 
            String dbAux1 ="./src/com/neuron/database/dbModeloAux1.txt";
            FileWriter fwAux1 = new FileWriter(dbAux1);
            BufferedWriter bwAux1 = new BufferedWriter(fwAux1);
            
            //Leitura do banco atual
            String caminhoDbModelo= "./src/com/neuron/database/dbModelo.txt";
            File dbModelo = new File(caminhoDbModelo);
            File dbModeloAux = new File(caminhoDbModelo);
            FileReader fr = new FileReader(caminhoDbModelo);
            BufferedReader br = new BufferedReader(fr);

            //altera a linha caso o ID for igual ao do selecionado na tabelaMarca
            while ((linha = br.readLine()) != null) {
                if(linha.contains(id+"")){
                    modelo.setIdModelo(id);
                    modelo.setNomeModelo(nomeModelo);
                    //IMPLEMENTAR MARCA NA SETAGEM DE MODELOS
                    modelo.setNomeMarcaRelacionado(nomeModelo);
                    modelo.setDirFotoModelo(iImg.alterNomeImgMarca(nomeModelo, caminhoFotoModelo));
                    bwAux1.write(modelo.toString()+"\n");
                } else {
                    bwAux1.write(linha+"\n");
                }
            }
            fr.close();
            br.close();
            bwAux1.close();
            
            File dbModeloNovo = new File (dbAux1);
            
            //deleta o banco atual
            dbModelo.delete();
            
            //renomeia o dbMarcaAux1 para ser o principal
            dbModeloNovo.renameTo(dbModeloAux);
        } catch (Exception e) {
            throw new Exception("");
        }
    }

    @Override
    public ArrayList<Modelo> listagemModelo() throws Exception {
        try {
            ArrayList<Modelo> listaModelo = new ArrayList<Modelo>();
            FileReader fr = new FileReader("./src/com/neuron/database/dbModelo.txt");
            BufferedReader br  = new BufferedReader(fr);
            String linha = "";
            while((linha=br.readLine())!=null){
                Modelo modelo = new Modelo();
                String vetorString[] = linha.split(";");
                modelo.setIdModelo(Integer.parseInt(vetorString[0]));
                modelo.setNomeModelo(vetorString[1]);
                modelo.setNomeMarcaRelacionado(vetorString[2]);
                modelo.setDirFotoModelo(vetorString[3].replace("./src/com/neuron/icons/","/"));
                listaModelo.add(modelo);
            }
            br.close();
         return listaModelo;
        } catch(Exception erro){
         throw new Exception(erro);
        }
    }

   
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
