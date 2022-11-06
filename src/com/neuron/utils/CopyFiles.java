/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.utils;


import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyFiles {
    
    public CopyFiles(){
        
    }

    public static void copiarImgSelecionada(String origem, String destino, String nomeArquivo) throws Exception{
        File orig = new File(origem);
        File dest = new File(destino+nomeArquivo);
        
        BufferedImage imgSelecionada = ImageIO.read(orig);
        BufferedImage buffer = new BufferedImage(450,450,BufferedImage.SCALE_SMOOTH);        
        
        Graphics2D gImg = buffer.createGraphics();
        gImg.drawImage(imgSelecionada,0,0,450,450,null);
        gImg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gImg.dispose();
        
        ImageIO.write(buffer, "JPEG", dest);
    }
    
    
    public static void copiarArquivo(String origem, String destino, String nomeArquivo)throws Exception{
        File orig = new File(origem);
        File dest = new File(destino + nomeArquivo);
        Files.copy(orig.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
