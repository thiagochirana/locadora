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
import com.neuron.templates.*;
import com.neuron.persistencia.*;
import com.neuron.exceptions.*;
import com.neuron.utils.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Controle implements IControle{
    IReadWrite rw = null;
    String thisClass = "";
    
    public Controle(){
        this.rw = new ReadWrite() {};
    }
    
    //********************************************
    //****************** MARCAS ******************
    //********************************************
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
    
    @Override
    public ArrayList<String> listagemNomeMarcas() throws Exception{
        return rw.listagemNomeMarcas();
    }
    
    //********************************************
    //***************** MODELOS ******************
    //********************************************
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
    public ArrayList<Modelo> listagemModelo() throws ComboBoxException {
        return rw.listagemModelo();

    }

    @Override
    public ArrayList<String> listagemNomeModelo() throws Exception {
        return rw.listagemNomeModelo();
    }
    
    //********************************************
    //***************** VEICULOS *****************
    //********************************************
    @Override
    public void incluirVeiculo(Veiculo veiculo) throws Exception{
        validadorDeInformacoesVeiculoInserir(veiculo);
        rw.incluirVeiculo(veiculo);
    }
    
    @Override
    public void alterarVeiculo(Veiculo veiculo) throws Exception{
        if (veiculo.getAnoFabricacao().length() != 4) throw new Exception("Ano de Fabricacao invalido");
        if (veiculo.getRenavan() < 100000000 ) throw new Exception("RENAVAM invalido! Insira RENAVAM de nove digitos");
        if (!validaPlacaPertenceAoID(veiculo.getIdVeiculo(), veiculo.getPlaca())) throw new Exception("Placa ja cadastrada! Por favor insira outra Placa");
        if (!validaRENAVAMPertenceAoID(veiculo.getIdVeiculo(), veiculo.getRenavan())) throw new Exception("RENAVAM ja cadastrado! Por favor insira outro RENAVAM");
        rw.alterarVeiculo(veiculo);
    }
    
    //valida os dados antes de inserir/alterar no sistema
    private void validadorDeInformacoesVeiculoInserir(Veiculo veiculo) throws Exception{
        if (veiculo.getAnoFabricacao().length() != 4) throw new Exception("Ano de Fabricacao invalido");
        if (veiculo.getPlaca().contains(" ")) throw new Exception("Placa invalida! Insira a informacao sem espacos");
        if (buscarPlacaVeiculo(veiculo.getPlaca())) throw new Exception("Placa ja cadastrada! Insira outra placa");
        if (veiculo.getPlaca().equals("")) throw new Exception("Placa sem Informacoes!");
        if (veiculo.getPlaca().length() != 8) throw new Exception("Formato Invalido de Placa!");
        if (buscarRenavamVeiculo(veiculo.getRenavan())) throw new Exception("RENAVAM ja cadastrado! Insira outro RENAVAM");
        if ((veiculo.getRenavan() + "").equals("")) throw new Exception("RENAVAM vazio! Insira RENAVAM valido");
        if (veiculo.getRenavan() < 100000000 ) throw new Exception("RENAVAM invalido! Insira RENAVAM de nove digitos");
        if (veiculo.getDataCompra().length() <= 10) throw new Exception("Data de Compra invalido!");
    }
    
    private boolean validaPlacaPertenceAoID(int id, String placa) throws Exception{
        ArrayList<Veiculo> listagem = rw.listagemVeiculo();
        for (Iterator<Veiculo> it = listagem.iterator(); it.hasNext();) {
            Veiculo veiculo = it.next();
            if (veiculo.getPlaca().equalsIgnoreCase(placa) && veiculo.getIdVeiculo()==id) {
                return true;
            }
        }
        return false;
        
    }
    
    private boolean validaRENAVAMPertenceAoID(int id, int renavam) throws Exception{
        ArrayList<Veiculo> listagem = rw.listagemVeiculo();
        for (Iterator<Veiculo> it = listagem.iterator(); it.hasNext();) {
            Veiculo veiculo = it.next();
            if (veiculo.getRenavan()==renavam && veiculo.getIdVeiculo()==id) {
                return true;
            }
        }
        return false;
        
    }
    
    private boolean buscarPlacaVeiculo(String placa) throws Exception {
        try {
            ArrayList<Veiculo> listagem = rw.listagemVeiculo();
            for (Iterator<Veiculo> it = listagem.iterator(); it.hasNext();) {
                Veiculo veiculo = it.next();
                if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                    Logs.logger("Nao e possivel inserir este Veiculo! Placa "+placa+" ja cadastrada!", getThisClass());
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            Logs.logger("Nao foi possivel identificar se ha outro Veiculo de placa " + placa + " - " + erro.getMessage(), getThisClass());
            throw erro;
        }
    }
    
    private boolean buscarRenavamVeiculo(int renavam) throws Exception {
        try {
            ArrayList<Veiculo> listagem = rw.listagemVeiculo();
            for (Iterator<Veiculo> it = listagem.iterator(); it.hasNext();) {
                Veiculo veiculo = it.next();
                if (veiculo.getRenavan() == renavam) {
                    Logs.logger("Nao e possivel inserir este Veiculo! Placa "+renavam+" ja cadastrada!", getThisClass());
                    return true;
                }
            }
            return false;
        } catch (Exception erro) {
            Logs.logger("Nao foi possivel identificar se ha outro Veiculo de placa " + renavam + " - " + erro.getMessage(), getThisClass());
            throw erro;
        }
    }
    
    @Override
    public ArrayList<Veiculo> listagemVeiculo() throws Exception{
        return rw.listagemVeiculo();
    }

    
    
    @Override
    public void inserirNovaCor(String nomeCor) throws Exception{
        rw.inserirNovaCor(nomeCor.toUpperCase());
    }
    
    @Override
    public ArrayList<String> listagemCores() throws ComboBoxException, FileNotFoundException, IOException{
        if (rw.listagemCores() == null) throw new ComboBoxException("lista de Cores vazia! Acrescente uma cor"); 
        return rw.listagemCores();
    }
    
    @Override
    public ArrayList<String> listarTipoVeiculo() throws Exception{
        return rw.listarTipoVeiculo();
    }
    
    @Override
    public ArrayList<String> listarDisponivel() throws Exception{
        return rw.listarDisponivel();
    }
    
    @Override
    public ArrayList<String> listarTipoCombustivel() throws Exception{
        return rw.listarTipoCombustivel();
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
