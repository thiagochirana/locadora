/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.templates;

import javax.swing.ImageIcon;


public class Marca{
    
    private int idMarca = 0;
    private String nomeMarca = "";
    private String dirLogo = "";
    private String logoMarca = "";

    public Marca() {
        
    } 
    
    public Marca(int id, String descricao, String url){
        this.idMarca = id;
        this.nomeMarca = descricao;
        this.dirLogo = url;
        
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public void setNomeMarca(String nomeMarca) {
        this.nomeMarca = nomeMarca;
    }

    public void setDirLogo(String dirLogo) {
        this.dirLogo = dirLogo;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public String getNomeMarca() {
        return nomeMarca;
    }

    public String getDirLogo() {
        return dirLogo;
    }

    public String getLogoMarca() {
        return logoMarca;
    }

    public void setLogoMarca(String logoMarca) {
        this.logoMarca = logoMarca;
    }

    @Override
    public String toString() {
        return idMarca + ";" + nomeMarca + ";" + dirLogo;
    }

    
}
