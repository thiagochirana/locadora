/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.utils;

import javax.swing.ImageIcon;


public interface ISelecionarArq {
    ImageIcon abrirBuscadorImg(int w, int h) throws Exception;
    ImageIcon getImagem(String caminho) throws Exception;
    ImageIcon RedimensionarImg(String caminho, int w, int h) throws Exception;
    String getCaminhoDoArquivo() throws Exception;
}


// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
