/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.persistencia;

import com.neuron.icons.*;
import com.neuron.exceptions.*;
import com.neuron.templates.Marca;
import com.neuron.templates.Modelo;
import com.neuron.utils.Backup;
import com.neuron.utils.CopyFiles;
import com.neuron.templates.*;
import com.neuron.utils.Gerador;
import com.neuron.utils.Logs;
import com.neuron.utils.ISelecionarArq;
import com.neuron.utils.SelecionarArq;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReadWrite implements IReadWrite{
    
    IControladorImg iImg;
    ISelecionarArq iArquivo;
    
    String thisClass;
    
    public ReadWrite(){
        this.iImg = new ControladorImg();
        this.iArquivo = new SelecionarArq();
    }
    
    @Override
    public void incluirMarca(Marca marca) throws Exception {
        try{
            String caminho = getCaminhoImg();
            //cria o arquivo
            FileWriter fw = new FileWriter(DataBase.MARCA.getPathDB(),true);
            //Criar o buffer do arquivo
            BufferedWriter bw =new BufferedWriter(fw);
            // Incluindo o id no objeto ******
            marca.setIdMarca(Gerador.getIdMarca());
            //Escreve no arquivo
            bw.write(marca.toString()+"\n");
            //fecha o arquivo
            bw.close();	
            
            CopyFiles.copiarImgSelecionada(caminho, "./src/com/neuron/icons/logo/", marca.getNomeMarca()+".jpeg");
            
            //Backup.Database();
      }catch(DataBaseException erro){
            throw erro;
      }
    }
    
    @Override
    public void alterarMarca(int id, String nomeMarca,String caminhoLogo) throws Exception{
        try {
            System.out.println(caminhoLogo);
            Marca marca = new Marca();
            ArrayList<Marca> aux = new ArrayList<Marca>();
            String linha = "";
            
            //Criar o txt auxiliar para manipulacao da pilha 
            String dbAux1 ="./src/com/neuron/database/dbMarcaAux1.txt";
            FileWriter fwAux1 = new FileWriter(dbAux1);
            BufferedWriter bwAux1 = new BufferedWriter(fwAux1);
            
            //Leitura do banco atual
            String caminhoDbMarca= DataBase.MARCA.getPathDB();
            File dbMarca = new File(caminhoDbMarca);
            File dbMarcaAux = new File(caminhoDbMarca);
            FileReader fr = new FileReader(caminhoDbMarca);
            BufferedReader br = new BufferedReader(fr);

            //altera a linha caso o ID for igual ao do selecionado na tabelaMarca
            while ((linha = br.readLine()) != null) {
                String[] vet = linha.split(";");
                if(vet[0].equals(id+"")){
                    marca.setIdMarca(id);
                    marca.setNomeMarca(nomeMarca);
                    marca.setDirLogo(iImg.alterNomeImgMarca(nomeMarca, caminhoLogo));
                    bwAux1.write(marca.toString()+"\n");
                } else {
                    bwAux1.write(linha+"\n");
                }
            }
            fr.close();
            br.close();
            bwAux1.close();
            
            File dbMarcaNovo = new File (dbAux1);
            
            //deleta o banco atual
            dbMarca.delete();
            
            //renomeia o dbMarcaAux1 para ser o principal
            dbMarcaNovo.renameTo(dbMarcaAux);
            
            iImg.limparImgNaoUsadas(Telas.MODELO);
            
            //Backup.Database();
        } catch (DataBaseException e) {
            throw e;
        }
    }
    
    @Override
    public ArrayList<Marca> listagemMarca() throws Exception {
        try {
            ArrayList<Marca> listaDeMarcas = new ArrayList<Marca>();
            FileReader fr = new FileReader(DataBase.MARCA.getPathDB());
            BufferedReader br  = new BufferedReader(fr);
            String linha = "";
            while((linha=br.readLine())!=null){
                Marca marca = new Marca();
                String vetorString[] = linha.split(";");
                marca.setIdMarca(Integer.parseInt(vetorString[0]));
                marca.setNomeMarca(vetorString[1]);
                marca.setDirLogo(vetorString[2].replace("./src/com/neuron/icons/","/"));
                listaDeMarcas.add(marca);
            }
            br.close();
            
            return listaDeMarcas;
            
        } catch(Exception erro){
            //Gerador.createDB(DataBase.MARCA.getPathDB());
            
            throw new Exception(erro +"Marcas nao foram encontradas\nFoi criado um database de contingência ");
        } 
    }

    @Override
    public void incluirModelo(Modelo modelo) throws Exception {
        try {
            String caminho = getCaminhoImg();
            
            //cria o arquivo
            FileWriter fw = new FileWriter(DataBase.MODELO.getPathDB(), true);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            Logs.logger("Conectando ao database de modelos "+DataBase.MODELO.getPathDB(),getThisClass());
            
            // Incluindo o id no objeto ******
            modelo.setIdModelo(Gerador.getIdModelo());
            Logs.logger("Criando novo ID para o modelo = "+modelo.getIdModelo(),getThisClass());
            //Escreve no arquivo
            bw.write(modelo.toString() + "\n");
            Logs.logger("Salvando no database...",getThisClass());
            //fecha o arquivo
            bw.close();

            
            CopyFiles.copiarImgSelecionada(caminho, "./src/com/neuron/icons/modelo/", modelo.getNomeModelo()+".jpeg");
            Logs.logger("Arquivo imagem Modelo transferido e armazenado no caminho: ./src/com/neuron/icons/modelo/" + modelo.getNomeModelo()+".jpeg", getThisClass());
            
            Logs.logger(modelo.getNomeModelo()+" salvo com sucesso! ",getThisClass());
            
           // Backup.Database();
        } catch (Exception erro) {
            Logs.logger("Nao foi possivel Salvar o modelo "+modelo.getNomeModelo()+" no database! "+erro.getMessage(),getThisClass());
            throw erro;
        }
        
    }

    @Override
    public void alterarModelo(int id, String nomeModelo, String caminhoFotoModelo, int idMarca) throws Exception {
        try {
            System.out.println(caminhoFotoModelo);
            Modelo modelo = new Modelo();
            //ArrayList<Modelo> aux = new ArrayList<Modelo>();
            String linha = "";
            
            //Criar o txt auxiliar para manipulacao da pilha 
            String dbAux1 ="./src/com/neuron/database/dbModeloAux1.txt";
            Gerador.createDB("dbModeloAux1");
            FileWriter fwAux1 = new FileWriter(dbAux1);
            BufferedWriter bwAux1 = new BufferedWriter(fwAux1);
            
            //Leitura do banco atual
            String caminhoDbModelo= "./src/com/neuron/database/dbModelo.txt";
            File dbModelo = new File(caminhoDbModelo);
            File dbModeloAux = new File(caminhoDbModelo);
            FileReader fr = new FileReader(caminhoDbModelo);
            BufferedReader br = new BufferedReader(fr);

            //altera a linha caso o ID for igual ao do selecionado na tabelaMarca
            while ((linha = br.readLine()) != null) {
                String[] vet = linha.split(";");
                if(vet[0].equals(id+"")){
                    modelo.setIdModelo(id);
                    modelo.setNomeModelo(nomeModelo);
                    modelo.setDirFotoModelo(iImg.alterNomeImgModelo(nomeModelo, caminhoFotoModelo));
                    modelo.setIdMarcaRelacinado(idMarca);
                    bwAux1.write(modelo.toString()+"\n");
                } else {
                    bwAux1.write(linha+"\n");
                }
            }
            fr.close();
            br.close();
            bwAux1.close();
            
           File dbModeloNovo = new File (dbAux1);
            
            //deleta o banco atual
            dbModelo.delete();
            
            //renomeia o dbMarcaAux1 para ser o principal
            dbModeloNovo.renameTo(dbModeloAux);
            
            //Backup.Database();
        } catch (Exception e) {
            throw new Exception("Nao foi possivel alterar modelo: "+e.getMessage());
        }
    }

    @Override
    public ArrayList<Modelo> listagemModelo() throws ComboBoxException {
        try {
            Logs.logger("Iniciando Listagem dos Moledos disponiveis", getThisClass());
            ArrayList<Modelo> listaModelo = new ArrayList<Modelo>();
            FileReader fr = new FileReader(DataBase.MODELO.getPathDB());
            BufferedReader br  = new BufferedReader(fr);         
            
            String linha=br.readLine();
            int qtde = 0;
            while(linha!=null){
                
                Modelo modelo = new Modelo();
                String vetorString[] = linha.split(";");
               //int idModelo = vetorString[0].equals("") ? 0 : Integer.parseInt(vetorString[0]);
                modelo.setIdModelo(Integer.parseInt(vetorString[0]));
                modelo.setNomeModelo(vetorString[1]);
                modelo.setDirFotoModelo(vetorString[2]);
                modelo.setIdMarcaRelacinado(Integer.parseInt(vetorString[3]));
                Logs.logger("ID: "+modelo.getIdModelo()+"  Nome modelo: "+modelo.getNomeModelo()+
                        "  Dir da img Modelo: "+modelo.getDirFotoModelo()+"  Id Marca | Nome Marca: "+
                        modelo.getIdMarcaRelacinado()+" | "+Gerador.getNomeMarcaByID(modelo.getIdMarcaRelacinado()), getThisClass());
                listaModelo.add(modelo);
                qtde += 1;
                Logs.logger(modelo.getNomeModelo()+ " adicionado com sucesso a lista! Quantidade inserida a lista: "+qtde, getThisClass());
                linha=br.readLine();
            }
            br.close();
            Logs.logger("Consulta completa a base de dados. Em processamento para exibir Modelos cadastrados",getThisClass());
            return listaModelo;
            
        } catch(Exception erro){
            throw new ComboBoxException("Erro ao acessar Modelos cadastrados! Lista vazia ou com problemas! \n"+erro);
        }
    }
    
    // VEICULOS
    @Override
    public ArrayList<Veiculo> listagemVeiculo() throws Exception {
        try {
            ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
            FileReader fr = new FileReader(DataBase.VEICULO.getPathDB());
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Veiculo veiculo = new Veiculo();
                String aux[] = linha.split(";");
                veiculo.setIdVeiculo(Integer.parseInt(aux[0]));
                veiculo.setCor(aux[1]);
                veiculo.setNomeModelo(aux[2]);
                veiculo.setDisponivel(getDisponivel(aux[3]));
                veiculo.setNomeMarca(aux[4]);
                veiculo.setPlaca(aux[5]);
                veiculo.setAnoFabricacao(aux[6]);
                veiculo.setTipoCombustivel(getTipoCombustivel(aux[7]));
                veiculo.setQulometragem(Integer.parseInt(aux[8]));
                veiculo.setTipoVeiculo(getTipoVeiculo(aux[9]));
                veiculo.setRenavan(Integer.parseInt(aux[10]));
                veiculo.setPrecoCompra(Float.parseFloat(aux[11]));
                veiculo.setPrecoVenda(Float.parseFloat(aux[12]));
                veiculo.setDataCompra(aux[13]);
                veiculo.setDataVenda(aux[14]);
                veiculo.setIdModeloRelacionado(Integer.parseInt(aux[15]));
                listaVeiculo.add(veiculo);
            }
            br.close();

            return listaVeiculo;

        } catch (Exception erro) {
            throw new Exception(erro);
        }
    }
    
    @Override
    public void incluirVeiculo(Veiculo veiculo) throws Exception {
        try{
            //cria o arquivo
            FileWriter fw = new FileWriter(DataBase.VEICULO.getPathDB(),true);
            //Criar o buffer do arquivo
            BufferedWriter bw =new BufferedWriter(fw);
            // Incluindo o id no objeto ******
            veiculo.setIdVeiculo(Gerador.getIdVeiculo());
            //Escreve no arquivo
            bw.write(veiculo.toString()+"\n");
            //fecha o arquivo
            bw.close();	
            
            //Backup.Database();
        }catch(IOException erro){
            throw erro;
      }
    }
    
    @Override
    public void alterarVeiculo(Veiculo veiculo) throws Exception {
        try {
            Veiculo v;
            String linha = "";
            
            //Criar o txt auxiliar para manipulacao da pilha 
            String dbAux1 ="./src/com/neuron/database/dbVeiculoAux1.txt";
            Gerador.createDB("dbVeiculoAux1");
            FileWriter fwAux1 = new FileWriter(dbAux1);
            BufferedWriter bwAux1 = new BufferedWriter(fwAux1);
            
            //Leitura do banco atual
            String caminhoDbVeiculo= "./src/com/neuron/database/dbVeiculo.txt";
            File dbVeiculo = new File(caminhoDbVeiculo);
            BufferedReader br = new BufferedReader( new FileReader(caminhoDbVeiculo) );

            //altera a linha caso o ID for igual ao do selecionado na tabelaMarca
            int idSelecionado = veiculo.getIdVeiculo();
            while ((linha = br.readLine()) != null) {
                String[] vet = linha.split(";");
                if(vet[0].equals(idSelecionado+"")){
                    
                    int id = veiculo.getIdVeiculo();
                    String cor = veiculo.getCor();
                    String modelo = veiculo.getNomeModelo();
                    Disponibilidade dispo = veiculo.getDisponivel();
                    String marca = veiculo.getNomeMarca();
                    String placa = veiculo.getPlaca();
                    String anoFabri = veiculo.getAnoFabricacao();
                    TipoCombustivel tipo = veiculo.getTipoCombustivel();
                    int quilometro = veiculo.getQulometragem();
                    TipoVeiculo tipoVeiculo = veiculo.getTipoVeiculo();
                    int renavam = veiculo.getRenavan();
                    float precoCompra = veiculo.getPrecoCompra();
                    float precoVenda = veiculo.getPrecoVenda();
                    String dataCompra = veiculo.getDataCompra();
                    String dataVenda = veiculo.getDataVenda();
                    String info = veiculo.getInfoAdicional();
                    int idModelo = veiculo.getIdModelo();
                    v = new Veiculo(id, cor, modelo, dispo, marca, placa, anoFabri, tipo, quilometro, tipoVeiculo, renavam, precoCompra, precoVenda, dataCompra, dataVenda,info, idModelo);

                    bwAux1.write(veiculo.toString()+"\n");
                } else {
                    bwAux1.write(linha+"\n");
                }
            }
            br.close();
            bwAux1.close();
            
           File dbNovo = new File (dbAux1);
            
            //deleta o banco atual
            dbVeiculo.delete();
            
            //renomeia o dbMarcaAux1 para ser o principal
            dbNovo.renameTo(dbVeiculo);
            
            //Backup.Database();
        } catch (Exception e) {
            throw new Exception("Nao foi possivel alterar modelo: "+e.getMessage());
        }
    }

    @Override
    public void inserirNovaCor(String nomeCor) throws Exception{
        BufferedWriter cor = new BufferedWriter(new FileWriter(DataBase.COR.getPathDB(),true));
        cor.write(nomeCor+"\n");
        cor.close();
    }
    
    //Listagem de nomes de Marca e Modelos,
    @Override
    public ArrayList<String> listagemNomeMarcas() throws Exception {
        ArrayList<String> listaNomeMarca = new ArrayList<>();
        FileReader fr = new FileReader(DataBase.MARCA.getPathDB());
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha=br.readLine())!=null){
            String vetorString[] = linha.split(";");
            listaNomeMarca.add(vetorString[1]);
        }
        br.close();
        return listaNomeMarca;
    }
    
    @Override
    public ArrayList<String> listagemNomeModelo() throws Exception {
        ArrayList<String> listaNomeModelo = new ArrayList<>();
        FileReader fr = new FileReader(DataBase.MODELO.getPathDB());
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha=br.readLine())!=null){
            String vetorString[] = linha.split(";");
            listaNomeModelo.add(vetorString[1]);
        }
        br.close();
        return listaNomeModelo;
    }
    
    @Override
    public ArrayList<String> listagemCores() throws ComboBoxException, FileNotFoundException, IOException {
        ArrayList<String> listaNomeCores = new ArrayList<>();
        FileReader fr = new FileReader(DataBase.COR.getPathDB());
        BufferedReader br = new BufferedReader(fr);

        String linha = "";

        while ((linha = br.readLine()) != null) {
            listaNomeCores.add(linha);
        }
        br.close();
        return listaNomeCores;
    }
    
    @Override
    public ArrayList<String> listarTipoCombustivel() throws Exception{
        List<TipoCombustivel> combustivel = Arrays.asList(TipoCombustivel.values());
        ArrayList<String> lista = new ArrayList<>();
        for (TipoCombustivel tipoC : combustivel) {
            lista.add(tipoC.toString());
        }
        return lista;
    }
    
    @Override
    public ArrayList<String> listarTipoVeiculo() throws Exception{
        List<TipoVeiculo> veiculo = Arrays.asList(TipoVeiculo.values());
        ArrayList<String> lista = new ArrayList<>();
        for (TipoVeiculo tipoC : veiculo) {
            lista.add(tipoC.toString());
        }
        return lista;
    }

    @Override
    public ArrayList<String> listarDisponivel() throws Exception{
        List<Disponibilidade> veiculo = Arrays.asList(Disponibilidade.values());
        ArrayList<String> lista = new ArrayList<>();
        for (Disponibilidade dispo : veiculo) {
            lista.add(dispo.toString());
        }
        return lista;
    }
    
    @Override
    public boolean verificaUser(ArrayList<String> usuario) throws Exception{
        return true;
    }
    
    public String getThisClass() {
        thisClass = getClass() + "";
        thisClass = thisClass.replace("class ", "");
        return thisClass;
    }

    public String getCaminhoImg() throws Exception{
        File file =  new File("./src/com/neuron/temp/pathImg.txt");
        FileReader fr = new FileReader("./src/com/neuron/temp/pathImg.txt");
        BufferedReader br = new BufferedReader(fr);
        String caminho =  br.readLine();
        br.close();
        file.delete();
        return caminho;
    }
    
    public void verificaBanco(Telas tela) throws Exception{
        File dbOrig;
        File idDBOrig;
        File dbBkp;
        File idDBBkp;
        
        //verificar qual tela partiu a solicitacao
        switch (tela) {
            case MARCA:
                dbOrig = new File(DataBase.MARCA.getPathDB());
                idDBOrig = new File(DataBase.IDMARCA.getPathDB());
                dbBkp = new File(DataBase.BKPMARCA.getPathDB());
                idDBBkp = new File(DataBase.BKPIDMARCA.getPathDB());
                break;
                
            case MODELO:
                dbOrig = new File(DataBase.MODELO.getPathDB());
                idDBOrig = new File(DataBase.IDMODELO.getPathDB());
                dbBkp = new File(DataBase.BKPMODELO.getPathDB());
                idDBBkp = new File(DataBase.BKPIDMODELO.getPathDB());
                break;
                
            case VEICULO:
                dbOrig = new File(DataBase.VEICULO.getPathDB());
                idDBOrig = new File(DataBase.IDVEICULO.getPathDB());
                dbBkp = new File(DataBase.BKPVEICULO.getPathDB());
                idDBBkp = new File(DataBase.BKPIDVEICULO.getPathDB());
                break;
            
            default :
                throw new Exception("Nao foi possivel identificar tela para verificacao do seu database");
        }
        
        //verificar os bancos
        FileReader fr = new FileReader(dbOrig);
        BufferedReader dataOriginal = new BufferedReader(fr);
        
        fr = new FileReader(dbBkp);
        BufferedReader dataBack = new BufferedReader(fr);
        
        String orig = dataOriginal.readLine();
        String bkp = dataBack.readLine();
        
        boolean stop = false;
        
        if (orig != null || bkp != null) {
            while (stop == false && bkp != null && orig != null && orig.equals(bkp)) {
                if (orig.equals(bkp)) {
                    orig = dataOriginal.readLine();
                    bkp = dataBack.readLine();
                } else {
                    dataOriginal.close();
                    dataBack.close();
                   // Backup.Restaurar();
                    stop = true;
                }
            }
            if (!orig.equals(bkp)) {
                dataOriginal.close();
                dataBack.close();
                //Backup.Restaurar();
            }
        } else {
            dataOriginal.close();
            dataBack.close();
            //Backup.Restaurar();
        }
    }
    
    private Disponibilidade getDisponivel(String nomeDispo) {
        switch (nomeDispo) {
            case "DISPONÍVEL":
                return Disponibilidade.DISPONÍVEL;
            case "ALUGADO":
                return Disponibilidade.ALUGADO;
            case "MANUTENÇÃO":
                return Disponibilidade.MANUTENÇÃO;
            case "PERCA":
                return Disponibilidade.PERCA;
            case "VENDIDO":
                return Disponibilidade.VENDIDO;
            default:
                return Disponibilidade.DISPONÍVEL;
        }
    }
    
    private TipoCombustivel getTipoCombustivel(String nomeCombustivel) {
        switch (nomeCombustivel) {
            case "GASOLINA":
                return TipoCombustivel.GASOLINA;
            case "ETANOL":
                return TipoCombustivel.ETANOL;
            case "DIESEL":
                return TipoCombustivel.DIESEL;
            case "GNV":
                return TipoCombustivel.GNV;
            case "FLEX":
                return TipoCombustivel.FLEX;
            default:
                return TipoCombustivel.GASOLINA;
        }
    }
    
    private TipoVeiculo getTipoVeiculo(String nomeCombustivel) {
        switch (nomeCombustivel) {
            case "SEDAN":
                return TipoVeiculo.SEDAN;
            case "HATCH":
                return TipoVeiculo.HATCH;
            case "SUV":
                return TipoVeiculo.SUV;
            case "PICKUP":
                return TipoVeiculo.PICKUP;
            default:
                return TipoVeiculo.SEDAN;
        }
    }
    
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
