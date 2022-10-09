/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.templates;


public class Marca{
    
    private int idMarca = 0;
    private String nomeMarca = "";
    private String dirLogo = "";

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

    @Override
    public String toString() {
        return idMarca + ";" + nomeMarca + ";" + dirLogo;
    }

    
}
