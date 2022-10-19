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
import java.util.ArrayList;
import java.util.Iterator;


public class Controle implements IControle{
    IReadWrite rw = null;
    
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
            Iterator<Modelo> lista = listagem.iterator();
            while(lista.hasNext()){
                 Modelo modelo = lista.next();
                if(modelo.getNomeModelo().equalsIgnoreCase(descricao)){
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            throw erro;
        }  
    }

    @Override
    public void incluirModelo(Modelo model) throws Exception {
        Modelo modelo = model;
        if (buscarModelo(modelo.getNomeModelo())) {
            throw new Exception("Modelo já foi cadastrado");
        }
        rw.incluirModelo(modelo);
    }

    @Override
    public void alterarModelo(int id, String nomeModelo, String caminhoFotoModelo) throws Exception {
        rw.alterarMarca(id, nomeModelo.toUpperCase(), caminhoFotoModelo);
    }

    @Override
    public ArrayList<Modelo> listagemModelo() throws Exception {
        return rw.listagemModelo(); 
    }

}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
