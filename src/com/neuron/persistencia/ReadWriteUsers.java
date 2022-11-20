/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neuron.persistencia;

import com.neuron.icons.Telas;
import com.neuron.tela.*;
import com.neuron.templates.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;
import javax.swing.plaf.basic.BasicMenuBarUI;

/**
 *
 * @author thiag
 */
public class ReadWriteUsers implements IReadWriteUsers{
    int IdUsuario;
    String user;
    String nomeUser;
    String pass;
    String email;
    String telefone;
    PermissaoUsuario permissao;
    String userTemp = "./src/com/neuron/temp/User.txt";
    Color azulSistema = new Color(1, 132, 222, 255);
    
    //JMenus
    JMenu jMDashboard = new JMenu("Dashboard");
    JMenu jMAluguel = new JMenu("Aluguel");
    JMenu jMCliente = new JMenu("Clientes");
    JMenu jMCarros = new JMenu("Carros");
    JMenu jMFin = new JMenu("Financeiro");
    JMenu jMAdmin = new JMenu("Administrador");
    JMenu jMPerfil = new JMenu("Sua Conta");
    
    //JMenuItens Aluguel
    JMenuItem itemAluguelAlugar = new JMenuItem("Realizar Aluguel");
    JMenuItem itemAluguelDevolver = new JMenuItem("Devolucão Carro");
    JMenuItem itemAluguelAtraso = new JMenuItem("Atrasados");
    
    //JMenuItens Clientes
    JMenuItem itemCliBusAlt = new JMenuItem("Buscar/Alterar");
    JMenuItem itemCliCadastro = new JMenuItem("Cadastrar");
    JMenuItem itemCliLista = new JMenuItem("Listar");
    JMenuItem itemCliContrato = new JMenuItem("Em contrato");
    JMenuItem itemCliPendentes = new JMenuItem("Pendentes Devolucao");
    
    //jMenuItens Carros
    JMenuItem itemCarDisponivel = new JMenuItem("Disponíveis");
    JMenuItem itemCarAlugados = new JMenuItem("Em Aluguel");
    JMenuItem itemCarVenda = new JMenuItem("À venda");
    JMenuItem itemCarVendidos = new JMenuItem("Vendidos");
    JMenuItem itemCarManut = new JMenuItem("Em Manutenção");
    JMenuItem itemCarAcidente = new JMenuItem("Acidentados");
    JMenuItem itemCarMarca = new JMenuItem("Marcas");
    JMenuItem itemCarModelo = new JMenuItem("Modelos");
    JMenuItem itemCarVeiculo = new JMenuItem("Veículos");

    //JMenuItem Financeiro
    JMenuItem itemFinVendasPeriodo = new JMenuItem("Vendas Periodo");
    JMenuItem itemFinCompradosRec = new JMenuItem("Comprados Recentemente");
    JMenuItem itemFinVenda = new JMenuItem("À venda");
    
    //jMenuItem Administrador
    JMenuItem itemAdmCadastro = new JMenuItem("Cadastrar Usuário");
    JMenuItem itemAdmListar = new JMenuItem("Mostrar Usuários");
    JMenuItem itemAdmAlterar = new JMenuItem("Alterar/Remover Usuários");
    
    //jMenuItem Perfil
    JMenuItem itemPerSuaConta = new JMenuItem("Perfil");
    JMenuItem itemPerLogout = new JMenuItem("Logout");
    
    @Override
    public boolean validarAcesso(Usuario user, JFrame jf) throws Exception{
        Usuario u = user;
        FileReader fr = new FileReader(DataBase.USER.getPathDB());
        BufferedReader dbUser = new BufferedReader(fr);
        boolean valido = false;
        String linha = "";
        while ( (linha=dbUser.readLine()) != null ){
            String[] usuario = linha.split(";");
            if ( usuario[1].equals(u.getUser()) && usuario[2].equals(u.getPass()) ) {
                valido = true;
                FileWriter fw = new FileWriter(userTemp);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(usuario[3]+";"+usuario[6]);
                bw.close();
                jf.dispose();
            }
        }
        dbUser.close();
        return valido;
    }
    
    //Configuracao de Menu Bar de acordo com permissao do User
    @Override
    public JMenuBar customMenuBar(JFrame jf) throws Exception{
        
        JMenuBar jmb = jMenuStd(jf);
        
        //setando cor do menuBar
        jmb.setUI(new BasicMenuBarUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                g.setColor(azulSistema);
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });
        
        //inicio customizacao do menu para o visual do sistema
        MenuElement[] menus = jmb.getSubElements();

        for (MenuElement menuElement : menus) {

            JMenu menu = (JMenu) menuElement.getComponent();
            changeComponentColors(menu);
            menu.setOpaque(true);

            MenuElement[] menuElements = menu.getSubElements();

            for (MenuElement popupMenuElement : menuElements) {

                JPopupMenu popupMenu = (JPopupMenu) popupMenuElement.getComponent();
                popupMenu.setBorder(null);

                MenuElement[] menuItens = popupMenuElement.getSubElements();

                for (MenuElement menuItemElement : menuItens) {

                    JMenuItem menuItem = (JMenuItem) menuItemElement.getComponent();
                    changeComponentColors(menuItem);
                    menuItem.setOpaque(true);

                }
            }
        }
        
        return jmb; 
    }
    
    private void changeComponentColors(Component comp) {
        comp.setBackground(azulSistema);
        comp.setForeground(Color.white);
    }
    
    private JMenuBar jMenuStd(JFrame jf) throws Exception{
        FileReader f = new FileReader(userTemp);
        BufferedReader br = new BufferedReader(f);
        
        String aux = br.readLine();
        String[] user = aux.split(";");
        br.close();
        
        JMenuBar jmenubar = new JMenuBar();   
        
        jmenubar.add(setEvtMenu(jMDashboard, Telas.DASHBOARD, jf));
        
        //primeiro adiciona o item ao menu
        jMAluguel.add(itemMenu(itemAluguelAlugar));
        jMAluguel.add(itemMenu(itemAluguelAtraso));
        jMAluguel.add(itemMenu(itemAluguelDevolver));
        //adiciona menu ao menubar
        jmenubar.add(jMAluguel).setFont(new java.awt.Font("Segoe UI", 0, 14));
        
        jMCliente.add(itemMenu(itemCliBusAlt));
        jMCliente.add(itemMenu(itemCliCadastro));
        jMCliente.add(itemMenu(itemCliLista));
        jMCliente.add(itemMenu(itemCliContrato));
        jMCliente.add(itemMenu(itemCliPendentes));
        jmenubar.add(jMCliente).setFont(new java.awt.Font("Segoe UI", 0, 14));
        
        jMCarros.add(itemMenu(itemCarDisponivel));
        jMCarros.add(itemMenu(itemCarAlugados));
        
        if (user[1].equals("FINANCEIRO") || user[1].equals("GERENTE") || user[1].equals("ADMIN")) {
            jMCarros.add(itemMenu(itemCarVenda));
            jMCarros.add(itemMenu(itemCarVendidos));
            jMCarros.add(itemMenu(itemCarManut));
            jMCarros.add(itemMenu(itemCarAcidente));
            jMCarros.add(itemMenu(itemCarMarca,jf));
            jMCarros.add(itemMenu(itemCarModelo,jf));
            jMCarros.add(itemMenu(itemCarVeiculo)); 
        }
        jmenubar.add(jMCarros).setFont(new java.awt.Font("Segoe UI", 0, 14));
        
        if (user[1].equals("FINANCEIRO") || user[1].equals("GERENTE") || user[1].equals("ADMIN")) {
            jMFin.add(itemMenu(itemFinVendasPeriodo));
            jMFin.add(itemMenu(itemFinCompradosRec));
            jMFin.add(itemMenu(itemFinVenda));
            jmenubar.add(jMFin).setFont(new java.awt.Font("Segoe UI", 0, 14));
        }
        
        if (user[1].equals("ADMIN") || user[1].equals("GERENTE")) {
            jMAdmin.add(itemMenu(itemAdmCadastro));
            jMAdmin.add(itemMenu(itemAdmAlterar));
            jMAdmin.add(itemMenu(itemAdmListar));
            jmenubar.add(jMAdmin).setFont(new java.awt.Font("Segoe UI", 0, 14));
        } 
        
        jmenubar.add(Box.createHorizontalGlue());
        jMPerfil.add(itemMenu(itemPerSuaConta));
        jMPerfil.add(itemMenu(itemPerLogout,jf));
        jmenubar.add(jMPerfil);
        
        return jmenubar;
    }
    
    private JMenuItem itemMenu(JMenuItem item){
        JMenuItem jmi = item;
        jmi.setFont(new java.awt.Font("Segoe UI", 0, 14));
        return jmi;
    }
    
    private JMenuItem itemMenu(JMenuItem item, JFrame jf){
        JMenuItem jmi = item;
        jmi.setFont(new java.awt.Font("Segoe UI", 0, 14));
        
        jmi.addMouseListener(new MouseListener(){
        @Override
        public void mousePressed(MouseEvent evt){
            jf.dispose();
            if (jmi == itemCarMarca) new telaMarcaCarros().setVisible(true);
            if (jmi == itemCarModelo) new telaModelos().setVisible(true);
            if (jmi == itemPerLogout) new telaLogin().setVisible(true);
        }
        
        @Override
        public void mouseClicked(MouseEvent e){}
        @Override
        public void mouseReleased(MouseEvent e){}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        });
        
        return jmi;
    }
    
    private JMenu setEvtMenu(JMenu jm, Telas tela,JFrame jf){
        jm.addMouseListener(new MouseListener(){
        @Override
        public void mousePressed(MouseEvent evt){
            switch (tela){
                case DASHBOARD:
                    new telaDashboard().setVisible(true); 
                    break;
            }            
        }
        @Override
        public void mouseClicked(MouseEvent e){}
        @Override
        public void mouseReleased(MouseEvent e){}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        });
        jm.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jf.dispose();
        return jm;
    }
    
    @Override
    public ArrayList<String> UserDataHoraAcesso() throws Exception{
        ArrayList<String> res = new ArrayList<>();
        Date data = new Date();
        FileReader fr = new FileReader("./src/com/neuron/temp/User.txt");
        BufferedReader user = new BufferedReader(fr);
        String linha = user.readLine();
        String[] u = linha.split(";");

        res.add(u[0]);
        res.add(u[1]);

        user.close();
        
        SimpleDateFormat horaFormatada = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        res.add("Último Login: " + dataFormatada.format(data) + " às " + horaFormatada.format(data));
        
        return res;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }
    
    
}
