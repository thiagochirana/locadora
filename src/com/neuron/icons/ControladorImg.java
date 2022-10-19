/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.icons;

import java.io.File;


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
        file.delete();
    }
    
    @Override
    public void limparImgNaoUsadas(String caminho) throws Exception{
        
    }
    

}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
