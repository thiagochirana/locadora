/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.icons;

import com.neuron.utils.Gerador;
import com.neuron.utils.Logs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class ControladorImg implements IControladorImg{
    
    
    public ControladorImg(){
        
    }
    
    @Override
    public String alterNomeImgMarca(String novoNome, String caminho) throws Exception{
        File caminhoAtual = new File(caminho);
        File novoCaminho = new File("./src/com/neuron/icons/logo/"+novoNome+".jpeg");
        
        caminhoAtual.renameTo(novoCaminho);
        
        return ("./src/com/neuron/icons/logo/"+novoNome+".jpeg");
    }
    
    @Override
    public String alterNomeImgModelo(String novoNome, String caminho) throws Exception{
        File caminhoAtual = new File(caminho);
        File novoCaminho = new File("./src/com/neuron/icons/modelo/"+novoNome+".jpeg");
        
        caminhoAtual.renameTo(novoCaminho);
        
        return ("./src/com/neuron/icons/modelo/"+novoNome+".jpeg");
    }
    
    @Override
    public void deleteFile(String caminho) throws Exception{
        File file = new File(caminho);
        try {
            file.delete();
        } catch (Exception e) {
            throw new Exception("Nao foi possivel deletar "+caminho+" | "+e.getMessage());
        }
        
    }
    
    
    @Override
    public void limparImgNaoUsadas(Telas qualTelaSelecionada) throws Exception{
        String dirLocalImgSalvas = "";
        String dbImgs = "";
        try {
            switch (qualTelaSelecionada) {
                case MARCA:
                    dirLocalImgSalvas = "./src/com/neuron/icons/logo/";
                    dbImgs = "./src/com/neuron/database/dbMarca.txt";
                    break;
                    
                case MODELO:
                    dirLocalImgSalvas = "./src/com/neuron/icons/modelo/";
                    dbImgs = "./src/com/neuron/database/dbModelo.txt";
                    break;
                
                case VEICULO:
                    dirLocalImgSalvas = "./src/com/neuron/icons/veiculo/";
                    dbImgs = "./src/com/neuron/database/dbVeiculo.txt";
                    break;
                    
                default :
                    throw new Exception ("nao foi possivel realizar a limpeza dos arquivos");
            }
            
            File f = new File(dirLocalImgSalvas);
            FileReader fr = new FileReader(dbImgs);
            BufferedReader br  = new BufferedReader(fr);
            
            List<String> listaArqDataBase = new ArrayList<>();
            List<String> listaArqExistentes = new ArrayList<>();
            
            String[] lista = f.list(); //listar arquivos da pasta
            String linhaLida = "";

            //listar todos os modelos salvos no Banco
            while ( (linhaLida = br.readLine()) != null) {
                String[] vetLinha = linhaLida.split(";");
                listaArqDataBase.add(vetLinha[2].replace(dirLocalImgSalvas, ""));
            }
            
            //listar todos as imagens que estão na pasta e transferir para o List
            for (String arq : lista) {
                listaArqExistentes.add(arq);
            }
            
            List<String> emComum = new ArrayList<>(listaArqDataBase);
            
            //listar os nomes em comum
            emComum.retainAll(listaArqExistentes);
            
            //listar arquivos que nao tem vinculo
            List<String> arqSemVinculo = new ArrayList<>();
            for (String element : listaArqExistentes)
                if (!emComum.contains(element))
                    arqSemVinculo.add(element);
            
            //deletar arquivos
            for (String nomeArqDel : arqSemVinculo) {
                File file = new File (dirLocalImgSalvas+nomeArqDel);
                file.delete();
            }
            
        } catch (Exception e) {
            throw new Exception ("nao foi possivel realizar a limpeza dos arquivos : "+e.getMessage());
        }
        
    }
    

}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
