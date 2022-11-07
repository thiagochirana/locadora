/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.persistencia;

import com.neuron.icons.*;
import com.neuron.templates.Marca;
import com.neuron.templates.Modelo;
import com.neuron.utils.CopyFiles;
import com.neuron.utils.Gerador;
import com.neuron.utils.Logs;
import com.neuron.utils.ISelecionarArq;
import com.neuron.utils.SelecionarArq;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class ReadWrite implements IReadWrite{
    
    IControladorImg iImg;
    ISelecionarArq iArquivo;
    private String dirMarca;
    private String dirModelo;
    String caminhoImg = "";
    
    String thisClass;
    
    public ReadWrite(){
        this.iImg = new ControladorImg();
        this.iArquivo = new SelecionarArq();
        this.dirMarca = "./src/com/neuron/database/dbMarca.txt";
        this.dirModelo = "./src/com/neuron/database/dbModelo.txt";
    }
    
    @Override
    public void incluirMarca(Marca marca) throws Exception {
        try{
            String caminho = getCaminhoImg();
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
            
            CopyFiles.copiarImgSelecionada(caminho, "./src/com/neuron/icons/logo/", marca.getNomeMarca()+".jpeg");
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
                String[] vet = linha.split(";");
                if(vet[0].equals(id+"")){
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
            
            iImg.limparImgNaoUsadas(Telas.MODELO);
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
            String caminho = getCaminhoImg();
            
            //cria o arquivo
            FileWriter fw = new FileWriter(dirModelo, true);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            Logs.logger("Conectando ao database de modelos "+dirModelo,getThisClass());
            
            // Incluindo o id no objeto ******
            modelo.setIdModelo(Gerador.getIdModelo());
            Logs.logger("Criando novo ID para o modelo = "+modelo.getIdModelo(),getThisClass());
            //Escreve no arquivo
            bw.write(modelo.toString() + "\n");
            Logs.logger("Salvando no database...",getThisClass());
            //fecha o arquivo
            bw.close();

            
            CopyFiles.copiarImgSelecionada(caminho, "./src/com/neuron/icons/modelo/", modelo.getNomeModelo()+".jpeg");
            Logs.logger("Arquivo imagem Modelo transferido e armazenado no caminho: ./src/com/neuron/icons/modelo/" + modelo.getNomeModelo()+".jpeg", getThisClass());
            
            Logs.logger(modelo.getNomeModelo()+" salvo com sucesso! ",getThisClass());
        } catch (Exception erro) {
            Logs.logger("Nao foi possivel Salvar o modelo "+modelo.getNomeModelo()+" no database! "+erro.getMessage(),getThisClass());
            throw erro;
        }
        
    }

    @Override
    public void alterarModelo(int id, String nomeModelo, String caminhoFotoModelo, int idMarca) throws Exception {
        try {
            System.out.println(caminhoFotoModelo);
            Modelo modelo = new Modelo();
            //ArrayList<Modelo> aux = new ArrayList<Modelo>();
            String linha = "";
            
            //Criar o txt auxiliar para manipulacao da pilha 
            String dbAux1 ="./src/com/neuron/database/dbModeloAux1.txt";
            Gerador.createDB("dbModeloAux1");
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
                String[] vet = linha.split(";");
                if(vet[0].equals(id+"")){
                    modelo.setIdModelo(id);
                    modelo.setNomeModelo(nomeModelo);
                    modelo.setDirFotoModelo(iImg.alterNomeImgModelo(nomeModelo, caminhoFotoModelo));
                    modelo.setIdMarcaRelacinado(idMarca);
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
            throw new Exception("Nao foi possivel alterar modelo: "+e.getMessage());
        }
    }

    @Override
    public ArrayList<Modelo> listagemModelo() throws Exception {
        try {
            Logs.logger("Iniciando Listagem dos Moledos disponiveis", getThisClass());
            ArrayList<Modelo> listaModelo = new ArrayList<Modelo>();
            FileReader fr = new FileReader("./src/com/neuron/database/dbModelo.txt");
            BufferedReader br  = new BufferedReader(fr);         
            
            String linha=br.readLine();
            int qtde = 0;
            while(linha!=null){
                
                Modelo modelo = new Modelo();
                String vetorString[] = linha.split(";");
               //int idModelo = vetorString[0].equals("") ? 0 : Integer.parseInt(vetorString[0]);
                modelo.setIdModelo(Integer.parseInt(vetorString[0]));
                modelo.setNomeModelo(vetorString[1]);
                modelo.setDirFotoModelo(vetorString[2]);
                modelo.setIdMarcaRelacinado(Integer.parseInt(vetorString[3]));
                Logs.logger("ID: "+modelo.getIdModelo()+"  Nome modelo: "+modelo.getNomeModelo()+
                        "  Dir da img Modelo: "+modelo.getDirFotoModelo()+"  Id Marca | Nome Marca: "+
                        modelo.getIdMarcaRelacinado()+" | "+Gerador.getNomeMarcaByID(modelo.getIdMarcaRelacinado()), getThisClass());
                listaModelo.add(modelo);
                qtde += 1;
                Logs.logger(modelo.getNomeModelo()+ " adicionado com sucesso a lista! Quantidade inserida a lista: "+qtde, getThisClass());
                linha=br.readLine();
            }
            br.close();
            Logs.logger("Consulta completa a base de dados. Em processamento para exibir Modelos cadastrados",getThisClass());
            return listaModelo;
            
        } catch(Exception erro){
            throw new Exception("Erro ao acessar Modelos cadastrados! Lista vazia ou com problemas! \n"+erro);
        }
    }

    @Override
    public ArrayList<String> listagemNomeMarcas() throws Exception {
        ArrayList<String> listaNomeMarca = new ArrayList<>();
        FileReader fr = new FileReader("./src/com/neuron/database/dbMarca.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha=br.readLine())!=null){
            Modelo modelo = new Modelo();
            String vetorString[] = linha.split(";");
            listaNomeMarca.add(vetorString[1]);
        }
        br.close();
        return listaNomeMarca;
    }
    
    @Override
    public List<String> listagemNomeMarcasList() throws Exception {
        List<String> listaNomeMarca = new ArrayList<>();
        FileReader fr = new FileReader("./src/com/neuron/database/dbMarca.txt");
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha=br.readLine())!=null){
            Modelo modelo = new Modelo();
            String vetorString[] = linha.split(";");
            listaNomeMarca.add(vetorString[1]);
        }
        br.close();
        return listaNomeMarca;
    }

    
    public String getThisClass() {
        thisClass = getClass() + "";
        thisClass = thisClass.replace("class ", "");
        return thisClass;
    }

    public String getCaminhoImg() throws Exception{
        File file =  new File("./src/com/neuron/temp/pathImg.txt");
        FileReader fr = new FileReader("./src/com/neuron/temp/pathImg.txt");
        BufferedReader br = new BufferedReader(fr);
        String caminho =  br.readLine();
        br.close();
        file.delete();
        return caminho;
    }
    
    
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
