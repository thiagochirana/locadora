/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle;
import com.neuron.icons.Telas;
import com.neuron.templates.Marca;
import com.neuron.persistencia.*;
import com.neuron.templates.Modelo;
import com.neuron.utils.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.neuron.templates.DataBase;


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
                if(marca.getNomeMarca().replace(" ","").equalsIgnoreCase(descricao.replace(" ",""))){
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
        if (buscarMarca(marca.getNomeMarca() )) {
            throw new Exception("Marca já foi cadastrada");
        }
        if(marca.getNomeMarca()==null ||marca.getNomeMarca().equals("")){
            throw new Exception("Marca sem nome!");
        }
        char[] carac = marca.getNomeMarca().toCharArray();
        char ver = ' ';
        if (marca.getNomeMarca().contains("  ") || carac[0] == ver) {
            throw new Exception("Nome da Marca com espacos excessivos ou nao permitidos!");
        }
        if(marca.getDirLogo()==null || marca.getDirLogo().equals("")){
            throw new Exception("Marca "+marca.getNomeMarca()+" sem logo!");
        }
        rw.incluirMarca(marca);
        
    }
    
    @Override
    public void alterarMarca(int id, String nomeMarca,String caminhoLogo) throws Exception{
        if (buscarMarca(nomeMarca.replace(" ",""))) throw new Exception("Nome de marca ja existe! Por favor escolha outro nome");
        char[] carac = nomeMarca.toCharArray();
        char ver = ' ';
        if (nomeMarca.contains("  ") || carac[0] == ver) {
            throw new Exception("Nome da Marca com espacos excessivos ou nao permitidos!");
        }
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
            for (Iterator<Modelo> it = listagem.iterator(); it.hasNext();) {
                Modelo modelo = it.next();
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
        if (buscarModelo(modelo.getNomeModelo())) {
        throw new Exception("Modelo ja foi cadastrado");
        }
        if (modelo.getNomeModelo().isEmpty() || modelo.getNomeModelo() == null){
            throw new Exception("Modelo sem nome");
        }
        
        char[] carac = modelo.getNomeModelo().toCharArray();
        char ver = ' ';
        if (modelo.getNomeModelo().contains("  ")  || carac[0] == ver){
            throw new Exception("Nome do Modelo com espacos excessivos ou nao permitidos!");
        }
        if(modelo.getDirFotoModelo()==null || modelo.getDirFotoModelo().equals("./src/com/neuron/icons/modelo/.jpeg")){
            throw new Exception("Modelo "+modelo.getNomeModelo()+" sem uma imagem!");
        }
        rw.incluirModelo(model);
    }

    @Override
    public void alterarModelo(int id, String nomeModelo, String caminhoFotoModelo, int idMarca) throws Exception {
        char[] carac = nomeModelo.toCharArray();
        char ver = ' ';
        if (nomeModelo.contains("  ") || carac[0] == ver) {
            throw new Exception("Nome do Modelo com espacos excessivos ou nao permitidos!");
        }
        rw.alterarModelo(id, nomeModelo.toUpperCase(), caminhoFotoModelo, idMarca);
    }

    @Override
    public ArrayList<Modelo> listagemModelo() throws Exception {
        return rw.listagemModelo(); 
    
    }
    
    @Override
    public ArrayList<String> listagemNomeModelo() throws Exception{
        return rw.listagemNomeModelo();
    }
    
    @Override
    public ArrayList<String> listagemNomeMarcas() throws Exception{
        return rw.listagemNomeMarcas();
    }
    
    @Override
    public void inserirNovaCor(String nomeCor) throws Exception{
        rw.inserirNovaCor(nomeCor.toUpperCase());
    }
    
    @Override
    public ArrayList<String> listagemCores() throws Exception{
        return rw.listagemCores();
    }
    
    @Override
    public void verificaBanco(Telas tela) throws Exception{
        rw.verificaBanco(tela);
    }
    
    public String getThisClass() {
        thisClass = getClass() + "";
        thisClass = thisClass.replace("class ", "");
        return thisClass;
    }
    
    //Databases
    public void backupDatabase() throws Exception {
        String dirBkp = "./src/com/neuron/temp/database/";
        File dirDB = new File("./src/com/neuron/database/");
        String[] listaData = dirDB.list(); //listar os db
        
        for (String nome : listaData) {
            CopyFiles.copiarArquivo(dirDB.getPath()+nome, dirBkp+nome);
        }
    }
    
    public void verificarIntegridadeBanco(Telas tela) throws Exception {
        String dir = "";
        switch (tela) {
            case MARCA: 
                dir = DataBase.MARCA.getPathDB(); 
                break;
            case MODELO: 
                dir = DataBase.MODELO.getPathDB(); 
                break;
            case VEICULO:
                dir = DataBase.VEICULO.getPathDB();
                break;
            default: throw new Exception ("Nao existe banco associado a esta Tela!");
        }
        
        File db = new File(dir);
        File dirBkp = new File("./src/com/neuron/temp/database/");
        
        List<String> listaArqBackup = new ArrayList<>();
        List<String> listaArqExistentes = new ArrayList<>();
        
        String[] listaBackup = dirBkp.list();
        String[] listaExistentes = db.list();
        
        for (String listaExis : listaExistentes) {
            listaArqExistentes.add(listaExis);
        }
        
        for (String bkp : listaBackup) {
            listaArqBackup.add(bkp);
        }
        
        List<String> emComum = new ArrayList<>(listaArqBackup);
        
        emComum.retainAll(listaArqExistentes);
        
        if (!db.exists()) {
            
        }
    }

}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
