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
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyFiles {
    
    public CopyFiles(){
        
    }

    public static void copiarImgMarca(String origem, String destino, String nomeArquivo) throws Exception{
        File orig = new File(origem);
        File dest = new File(destino+nomeArquivo);
        
        BufferedImage imgSelecionada = ImageIO.read(orig);
        BufferedImage buffer = new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);        
        
        Graphics2D gImg = buffer.createGraphics();
        gImg.drawImage(imgSelecionada,0,0,300,300,null);
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
