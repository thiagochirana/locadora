/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle;
import com.neuron.templates.Marca;
import com.neuron.persistencia.*;
import com.neuron.templates.Modelo;
import com.neuron.utils.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Controle implements IControle{
    IReadWrite rw = null;
    String thisClass = "";
    
    public Controle(){
        this.rw = new ReadWrite() {};
    }
    
    //Marcas
    private boolean buscarMarca(String descricao)throws Exception{
        try {
            ArrayList<Marca> listagem = rw.listagemMarca();
            Iterator<Marca> lista = listagem.iterator();
            while(lista.hasNext()){
                 Marca marca = lista.next();
                if(marca.getNomeMarca().equalsIgnoreCase(descricao)){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            Logs.logger("Nao foi possivel identificar se ha outra Marca com o nome "+descricao+" - "+erro.getMessage(), getThisClass());
            throw erro;
        }  
    }
    
    @Override
    public void incluirMarca(Marca m) throws Exception {
        Marca marca = m;
        if (buscarMarca(marca.getNomeMarca())) {
            throw new Exception("Marca já foi cadastrada");
        }
        rw.incluirMarca(marca);
        
    }
    
    @Override
    public void alterarMarca(int id, String nomeMarca,String caminhoLogo) throws Exception{
        rw.alterarMarca(id, nomeMarca.toUpperCase(), caminhoLogo);
    }
   
    @Override
    public ArrayList<Marca> listagemMarca() throws Exception {
        return rw.listagemMarca(); 
    }
    
    //Modelos
    private boolean buscarModelo(String descricao)throws Exception{
        try {
            ArrayList<Modelo> listagem = rw.listagemModelo();
            for (Modelo modelo : listagem) {
                if(modelo.getNomeModelo().equalsIgnoreCase(descricao)){
                    Logs.logger("Modelo já foi cadastrado", getThisClass());
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            Logs.logger("Nao foi possivel identificar se ha outro Modelo com o nome " + descricao +" - "+erro.getMessage(), getThisClass());
            throw erro;
        }  
    }

    @Override
    public void incluirModelo(Modelo model) throws Exception {
        Modelo modelo = model;
        /*if (buscarModelo(modelo.getNomeModelo())) {
        throw new Exception("Modelo já foi cadastrado");
        }*/
        rw.incluirModelo(model);
    }

    @Override
    public void alterarModelo(int id, String nomeModelo, String caminhoFotoModelo) throws Exception {
        rw.alterarMarca(id, nomeModelo.toUpperCase(), caminhoFotoModelo);
    }

    @Override
    public ArrayList<Modelo> listagemModelo() throws Exception {
        return rw.listagemModelo(); 
    }
    
    @Override
    public ArrayList<String> listagemNomeMarcas() throws Exception{
        return rw.listagemNomeMarcas();
    }
    
    public List<String> listagemNomeMarcasList() throws Exception{
        return rw.listagemNomeMarcasList();
    }
    
    public String getThisClass() {
        thisClass = getClass() + "";
        thisClass = thisClass.replace("class ", "");
        return thisClass;
    }

}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
