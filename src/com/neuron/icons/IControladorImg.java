/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.icons;


public interface IControladorImg {
    String alterNomeImgMarca(String novoNome, String caminho) throws Exception;
    void deleteFile(String caminho) throws Exception;
    void limparImgNaoUsadas(String caminho) throws Exception;
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
