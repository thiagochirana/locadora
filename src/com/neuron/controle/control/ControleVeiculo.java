/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle.control;

import com.neuron.controle.IControleVeiculo;
import com.neuron.persistencia.IVeiculoDAO;
import com.neuron.persistencia.DAO.VeiculoDAO;
import com.neuron.templates.Veiculo;
import com.neuron.utils.Logs;
import java.util.ArrayList;
import java.util.Iterator;


public class ControleVeiculo implements IControleVeiculo{
    
    IVeiculoDAO rw;

    public ControleVeiculo() {
        rw = new VeiculoDAO();
    }
    
    @Override
    public void incluirVeiculo(Veiculo veiculo) throws Exception {
        validadorDeInformacoesVeiculoInserir(veiculo);
        rw.incluirVeiculo(veiculo);
    }

    @Override
    public void alterarVeiculo(Veiculo veiculo) throws Exception {
        if (veiculo.getAnoFabricacao().length() != 4) {
            throw new Exception("Ano de Fabricacao invalido");
        }
        if (veiculo.getRenavan() < 100000000) {
            throw new Exception("RENAVAM invalido! Insira RENAVAM de nove digitos");
        }
        if (!validaPlacaPertenceAoID(veiculo.getIdVeiculo(), veiculo.getPlaca())) {
            throw new Exception("Placa ja cadastrada! Por favor insira outra Placa");
        }
        if (!validaRENAVAMPertenceAoID(veiculo.getIdVeiculo(), veiculo.getRenavan())) {
            throw new Exception("RENAVAM ja cadastrado! Por favor insira outro RENAVAM");
        }
        rw.alterarVeiculo(veiculo);
    }

    //valida os dados antes de inserir/alterar no sistema
    private void validadorDeInformacoesVeiculoInserir(Veiculo veiculo) throws Exception {
        if (veiculo.getAnoFabricacao().length() != 4) {
            throw new Exception("Ano de Fabricacao invalido");
        }
        if (veiculo.getPlaca().contains(" ")) {
            throw new Exception("Placa invalida! Insira a informacao sem espacos");
        }
        if (buscarPlacaVeiculo(veiculo.getPlaca())) {
            throw new Exception("Placa ja cadastrada! Insira outra placa");
        }
        if (veiculo.getPlaca().equals("")) {
            throw new Exception("Placa sem Informacoes!");
        }
        if (veiculo.getPlaca().length() != 8) {
            throw new Exception("Formato Invalido de Placa!");
        }
        if (buscarRenavamVeiculo(veiculo.getRenavan())) {
            throw new Exception("RENAVAM ja cadastrado! Insira outro RENAVAM");
        }
        if ((veiculo.getRenavan() + "").equals("")) {
            throw new Exception("RENAVAM vazio! Insira RENAVAM valido");
        }
        if (veiculo.getRenavan() < 100000000) {
            throw new Exception("RENAVAM invalido! Insira RENAVAM de nove digitos");
        }
        if (veiculo.getDataCompra().length() < 10) {
            throw new Exception("Data de Compra invalido!");
        }
    }

    private boolean validaPlacaPertenceAoID(int id, String placa) throws Exception {
        ArrayList<Veiculo> listagem = rw.listagemVeiculo();
        for (Iterator<Veiculo> it = listagem.iterator(); it.hasNext();) {
            Veiculo veiculo = it.next();
            if (veiculo.getPlaca().equalsIgnoreCase(placa) && veiculo.getIdVeiculo() == id) {
                return true;
            }
        }
        return false;

    }

    private boolean validaRENAVAMPertenceAoID(int id, int renavam) throws Exception {
        ArrayList<Veiculo> listagem = rw.listagemVeiculo();
        for (Iterator<Veiculo> it = listagem.iterator(); it.hasNext();) {
            Veiculo veiculo = it.next();
            if (veiculo.getRenavan() == renavam && veiculo.getIdVeiculo() == id) {
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
                    Logs.logger("Nao e possivel inserir este Veiculo! Placa " + placa + " ja cadastrada!", getThisClass());
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
                    Logs.logger("Nao e possivel inserir este Veiculo! Placa " + renavam + " ja cadastrada!", getThisClass());
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
    public ArrayList<Veiculo> listagemVeiculo() throws Exception {
        return rw.listagemVeiculo();
    }

    @Override
    public ArrayList<String> listarTipoVeiculo() throws Exception {
        return rw.listarTipoVeiculo();
    }

    @Override
    public ArrayList<String> listarDisponivel() throws Exception {
        return rw.listarDisponivel();
    }

    @Override
    public ArrayList<String> listarTipoCombustivel() throws Exception {
        return rw.listarTipoCombustivel();
    }


    public String getThisClass() {
        String thisClass = getClass() + "";
        thisClass = thisClass.replace("class ", "");
        return thisClass;
    }

}
// Software developed by Thiago Chirana -> https://github.com/othiagomacedo