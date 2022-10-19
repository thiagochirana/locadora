/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.utils;

import java.awt.Image;
import java.io.File;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class SelecionarArq implements ISelecionarArq{
    
    private String caminhoDoArquivo = "";

    public SelecionarArq(){
    }
    
    //sempre enviar o tamanho de onde a imagem será setada, sempre usar um getWidth e getHeigth
    @Override
    public ImageIcon abrirBuscadorImg(int w, int h) throws Exception{
        
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "png", "jpeg"));
        fc.setCurrentDirectory(new File("D:\\"));
        Action details = fc.getActionMap().get("Go Up");
        details.actionPerformed(null);
        details.actionPerformed(null);
        fc.showOpenDialog(null);
        File arquivo = fc.getSelectedFile();
        if (arquivo != null) {
            setCaminhoDoArquivo(arquivo.getPath());
            //jTextFieldUrl.setText(nomeDoArquivo);
            ImageIcon iconLogo = new ImageIcon(getCaminhoDoArquivo());
            iconLogo.setImage(iconLogo.getImage().getScaledInstance(w, h, 1));
            return iconLogo;
        } else {
            throw new Exception("Não foi possível carregar o arquivo. Arquivo não existe ou corrompido");
        }  
    }

    @Override
    public ImageIcon getImagem(String caminho) throws Exception{
        ImageIcon img = new ImageIcon(caminho);
        return img;
    }
    
    @Override
    public Image getImage(String caminho) throws Exception{
        ImageIcon imgIcon = new ImageIcon(caminho);
        Image img = imgIcon.getImage();
        return img;
    }
    
    @Override
    public ImageIcon RedimensionarImg(String caminho, int w, int h) throws Exception{
        ImageIcon imgIcon = new ImageIcon(caminho);
        Image convertImg = imgIcon.getImage();
        Image newImg = convertImg.getScaledInstance(w, h, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    @Override
    public String getCaminhoDoArquivo() throws Exception {
        return caminhoDoArquivo;
    }

    private void setCaminhoDoArquivo(String caminhoDoArquivo) {
        this.caminhoDoArquivo = caminhoDoArquivo;
    }
            
           
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
