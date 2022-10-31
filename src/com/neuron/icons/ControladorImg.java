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
    public void deleteFile(String caminho) throws Exception{
        File file = new File(caminho);
        try {
            file.delete();
        } catch (Exception e) {
            throw new Exception("Nao foi possivel deletar "+caminho+" | "+e.getMessage());
        }
        
    }
    
    @Override
    public void limparImgNaoUsadas(String caminho) throws Exception{
        try {
            String dirId = caminho;
            FileReader fr = new FileReader(dirId);
            BufferedReader br = new BufferedReader(fr);
            File f = new File(caminho);
            String[] lista = f.list();

            int qtde = 0;
            String linha;
            String nome;
            String novoCam;

            if ((linha = br.readLine()) != null) {
                qtde = Integer.parseInt(linha);
            } else {
                throw new Exception("nao ha ID no caminho " + caminho);
            }

            for (int i = 0; i < lista.length; i++) {
                if (!lista[i].contains(novoCam = Gerador.getNomeMarcaByID(i))) {

                    deleteFile(caminho + novoCam + ".jpeg");
                    Logs.logger("Limpeza de Imagens | Imagem" + novoCam + ".jpeg foi deletada por não ter vinculo com algum cadastro! ", getClass().toString());
                }
            }
        } catch (Exception e) {
            throw new Exception("Erro ao executar limpeza: "+e.getMessage());
        }
    }
    

}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
