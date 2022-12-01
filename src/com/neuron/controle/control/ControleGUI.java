/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.controle.control;

import com.neuron.controle.IControleGUI;
import com.neuron.persistencia.DAO.GUIDAO;
import com.neuron.persistencia.IGUIDAO;
import com.neuron.templates.Cor;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuBar;


public class ControleGUI implements IControleGUI{
    
    IGUIDAO gui;

    public ControleGUI() {
        gui = new GUIDAO();
    }
    
    @Override
    public void inserirNovaCor(Cor cor) throws Exception {
        
        if (cor.getNomeCor().equals("")) throw new Exception("Cor sem nome! Por favor insira nome compativel/nao vazio");
        
        gui.inserirNovaCor(cor);
    }
    
    @Override
    public ArrayList<String> listagemCores() throws Exception {
        return gui.listagemCores();
    }
    
    public JMenuBar customMenuBar(JFrame jf) throws Exception{
        return gui.customMenuBar(jf);
    }
    
}
// Software developed by Thiago Chirana -> https://github.com/othiagomacedo