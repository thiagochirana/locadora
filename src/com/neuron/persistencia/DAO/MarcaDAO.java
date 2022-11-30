/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/
package com.neuron.persistencia.DAO;

import com.neuron.exceptions.DataBaseException;
import com.neuron.icons.ControladorImg;
import com.neuron.icons.IControladorImg;
import com.neuron.icons.Telas;
import com.neuron.persistencia.IMarcaDAO;
import com.neuron.templates.DataBase;
import com.neuron.templates.Marca;
import com.neuron.utils.CopyFiles;
import com.neuron.utils.Gerador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class MarcaDAO implements IMarcaDAO{
    
    IControladorImg iImg;

    public MarcaDAO() {
        iImg = new ControladorImg();
        
    }
    
    
    
    @Override
    public void incluirMarca(Marca marca) throws Exception {
        try {
            String caminho = getCaminhoImg();
            //cria o arquivo
            FileWriter fw = new FileWriter(DataBase.MARCA.getPathDB(), true);
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            // Incluindo o id no objeto ******
            marca.setIdMarca(Gerador.getIdMarca());
            //Escreve no arquivo
            bw.write(marca.toString() + "\n");
            //fecha o arquivo
            bw.close();

            CopyFiles.copiarImgSelecionada(caminho, "./src/com/neuron/icons/logo/", marca.getNomeMarca() + ".jpeg");

            //Backup.Database();
        } catch (DataBaseException erro) {
            throw erro;
        }
    }

    @Override
    public void alterarMarca(int id, String nomeMarca, String caminhoLogo) throws Exception {
        try {
            System.out.println(caminhoLogo);
            Marca marca = new Marca();
            String linha = "";

            //Criar o txt auxiliar para manipulacao da pilha 
            String dbAux1 = "./src/com/neuron/database/dbMarcaAux1.txt";
            FileWriter fwAux1 = new FileWriter(dbAux1);
            BufferedWriter bwAux1 = new BufferedWriter(fwAux1);

            //Leitura do banco atual
            String caminhoDbMarca = DataBase.MARCA.getPathDB();
            File dbMarca = new File(caminhoDbMarca);
            File dbMarcaAux = new File(caminhoDbMarca);
            FileReader fr = new FileReader(caminhoDbMarca);
            BufferedReader br = new BufferedReader(fr);

            //altera a linha caso o ID for igual ao do selecionado na tabelaMarca
            while ((linha = br.readLine()) != null) {
                String[] vet = linha.split(";");
                if (vet[0].equals(id + "")) {
                    marca.setIdMarca(id);
                    marca.setNomeMarca(nomeMarca);
                    marca.setDirLogo(iImg.alterNomeImgMarca(nomeMarca, caminhoLogo));
                    bwAux1.write(marca.toString() + "\n");
                } else {
                    bwAux1.write(linha + "\n");
                }
            }
            br.close();
            bwAux1.close();

            File dbMarcaNovo = new File(dbAux1);

            //deleta o banco atual
            dbMarca.delete();

            //renomeia o dbMarcaAux1 para ser o principal
            dbMarcaNovo.renameTo(dbMarcaAux);

            iImg.limparImgNaoUsadas(Telas.MODELO);

            //Backup.Database();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ArrayList<Marca> listagemMarca() throws Exception {
        try {
            ArrayList<Marca> listaDeMarcas = new ArrayList<Marca>();
            FileReader fr = new FileReader(DataBase.MARCA.getPathDB());
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                Marca marca = new Marca();
                String vetorString[] = linha.split(";");
                marca.setIdMarca(Integer.parseInt(vetorString[0]));
                marca.setNomeMarca(vetorString[1]);
                marca.setDirLogo(vetorString[2].replace("./src/com/neuron/icons/", "/"));
                listaDeMarcas.add(marca);
            }
            br.close();

            return listaDeMarcas;

        } catch (Exception erro) {
            //Gerador.createDB(DataBase.MARCA.getPathDB());

            throw new Exception(erro + "Marcas nao foram encontradas\nFoi criado um database de contingência ");
        }
    }
    
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
    
    private String getCaminhoImg() throws Exception{
        File file =  new File("./src/com/neuron/temp/pathImg.txt");
        FileReader fr = new FileReader("./src/com/neuron/temp/pathImg.txt");
        BufferedReader br = new BufferedReader(fr);
        String caminho =  br.readLine();
        br.close();
        file.delete();
        return caminho;
    }
    
}
