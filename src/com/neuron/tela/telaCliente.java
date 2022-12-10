/** ****** About this Software *********
 *
 * @Author Thiago Chirana
 * @Github https://github.com/othiagomacedo
 * @Email thiago.chirana@gmail.com
 * @Year 2022
 * @Course Software Engineering
 * @College FATESG Senai
 *
 ************* enjoy *****************
 */
package com.neuron.tela;

import com.neuron.templates.*;
import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import com.neuron.controle.IControleCliente;
import com.neuron.controle.IControleGUI;
import com.neuron.controle.control.*;
import com.neuron.icons.*;
import com.neuron.utils.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicMenuBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class telaCliente extends javax.swing.JFrame {

    IControleCliente interControle = new ControleCliente();
    ISelecionarArq iArquivo = new SelecionarArq();
    String thisClass = "";
    String caminhoCNHSelecionado;
    IControladorImg iImg = new ControladorImg();
    Color azulHover = new Color(0, 23, 100, 255);
    Color azulPadrao = new Color(1, 132, 222, 255);
    Color verdeHover = new Color(51, 186, 0, 255);
    Color amareloHover = new Color(250, 196, 0, 255);

    public telaCliente() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        //this.setUndecorated(true);
        this.setTitle("Veículos");
        
        try {
            menuLogOff.setVisible(false);
            customizeMenuBar(jMenuBar); //customizar menu
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        datahora(); //data e hora no sistema
        resizeColunas(); //tamanho colunas   

        try { 
            carregarComboBoxStatus();  
            carregarComboBoxEstados();
            if (!interControle.listagemCliente().isEmpty() || interControle.listagemCliente()!= null) {
                ImprimirGrid(interControle.listagemCliente());
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
            Logs.logger(erro.getMessage(), getThisClass());
        }
        this.setDefaultCloseOperation(0);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cpData = new javax.swing.JLabel();
        cpUser = new javax.swing.JLabel();
        logoNeuron = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNomeRazao = new javax.swing.JTextField();
        txtQtdeResultados = new javax.swing.JLabel();
        saidaStatusOperacao = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bgBtnInserir = new javax.swing.JPanel();
        btnInserirCliente = new javax.swing.JLabel();
        bgBtnAlterar = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JLabel();
        btnAttLista = new javax.swing.JLabel();
        btnVoltarPagAnt = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBuscarVeiculo = new javax.swing.JLabel();
        jTextFieldCpfCnpj = new javax.swing.JTextField();
        jTextFieldNomeMotorista = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNumCNH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxStatusCliente = new javax.swing.JComboBox<>();
        jTextFieldValorMulta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldNumRG = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldDDI = new javax.swing.JTextField();
        jTextFieldDDD = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jTextFieldComplemento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCEP = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxEstadoBrasil = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jComboBoxTipoCliente = new javax.swing.JComboBox<>();
        bgBtnAlterar1 = new javax.swing.JPanel();
        btnAlterar1 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        menuLogOff = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgBackground.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 106, 255));
        jLabel1.setText("Clientes");

        cpData.setForeground(new java.awt.Color(153, 153, 153));
        cpData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cpUser.setForeground(new java.awt.Color(153, 153, 153));
        cpUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        logoNeuron.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logoNeuron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/neuron/icons/logoMin.png"))); // NOI18N

        tabelaClientes.setAutoCreateRowSorter(true);
        tabelaClientes.setBackground(new java.awt.Color(255, 255, 255));
        tabelaClientes.setForeground(new java.awt.Color(1, 75, 222));
        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cliente", "CPF/CNPJ", "Motorista", "Telefone", "Status", "Valor Multa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaClientes.setRowHeight(40);
        tabelaClientes.setSelectionBackground(new java.awt.Color(1, 132, 222));
        tabelaClientes.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabelaClientes.getTableHeader().setReorderingAllowed(false);
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);
        tabelaClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jSeparator1.setBackground(new java.awt.Color(1, 132, 222));
        jSeparator1.setForeground(new java.awt.Color(1, 132, 222));
        jSeparator1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 132, 222));
        jLabel2.setText("Nome/Razao Social:");

        jTextFieldNomeRazao.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldNomeRazao.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldNomeRazao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldNomeRazao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeRazaoActionPerformed(evt);
            }
        });

        txtQtdeResultados.setBackground(new java.awt.Color(250, 250, 250));
        txtQtdeResultados.setForeground(new java.awt.Color(100, 210, 243));
        txtQtdeResultados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtQtdeResultados.setText("n clientes cadastrados.");

        saidaStatusOperacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saidaStatusOperacao.setForeground(new java.awt.Color(1, 132, 222));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 132, 222));
        jLabel6.setText("CPF/CNPJ:");

        bgBtnInserir.setBackground(new java.awt.Color(1, 132, 222));

        btnInserirCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInserirCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnInserirCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInserirCliente.setText("INSERIR");
        btnInserirCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInserirClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInserirClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInserirClienteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgBtnInserirLayout = new javax.swing.GroupLayout(bgBtnInserir);
        bgBtnInserir.setLayout(bgBtnInserirLayout);
        bgBtnInserirLayout.setHorizontalGroup(
            bgBtnInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInserirCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );
        bgBtnInserirLayout.setVerticalGroup(
            bgBtnInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInserirCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        bgBtnAlterar.setBackground(new java.awt.Color(1, 132, 222));
        bgBtnAlterar.setPreferredSize(new java.awt.Dimension(170, 35));

        btnAlterar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlterar.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAlterar.setText("ALTERAR");
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAlterarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAlterarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgBtnAlterarLayout = new javax.swing.GroupLayout(bgBtnAlterar);
        bgBtnAlterar.setLayout(bgBtnAlterarLayout);
        bgBtnAlterarLayout.setHorizontalGroup(
            bgBtnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
        );
        bgBtnAlterarLayout.setVerticalGroup(
            bgBtnAlterarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        btnAttLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/neuron/icons/att_blue.png"))); // NOI18N
        btnAttLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAttListaMouseClicked(evt);
            }
        });

        btnVoltarPagAnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/neuron/icons/voltar_blue.png"))); // NOI18N
        btnVoltarPagAnt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarPagAntMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(1, 132, 222));
        jLabel8.setText("Motorista:");

        btnBuscarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/neuron/icons/search_icon.png"))); // NOI18N
        btnBuscarVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarVeiculoMouseClicked(evt);
            }
        });

        jTextFieldCpfCnpj.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldCpfCnpj.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldCpfCnpj.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldCpfCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCpfCnpjActionPerformed(evt);
            }
        });

        jTextFieldNomeMotorista.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldNomeMotorista.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldNomeMotorista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldNomeMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeMotoristaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 132, 222));
        jLabel7.setText("Nº CNH:");

        jTextFieldNumCNH.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldNumCNH.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldNumCNH.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldNumCNH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumCNHActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 132, 222));
        jLabel4.setText("Logradouro:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 132, 222));
        jLabel9.setText("Status:");

        jComboBoxStatusCliente.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxStatusCliente.setForeground(new java.awt.Color(1, 132, 222));
        jComboBoxStatusCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxStatusCliente.setBorder(null);

        jTextFieldValorMulta.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldValorMulta.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldValorMulta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldValorMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorMultaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 132, 222));
        jLabel10.setText("Valor Multa:");

        jTextFieldNumRG.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldNumRG.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldNumRG.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldNumRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumRGActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(1, 132, 222));
        jLabel11.setText("Nº RG:");

        jTextFieldEmail.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldEmail.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 132, 222));
        jLabel13.setText("Email:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 132, 222));
        jLabel14.setText("Telefone:");

        jTextFieldDDI.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldDDI.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldDDI.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldDDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDDIActionPerformed(evt);
            }
        });

        jTextFieldDDD.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldDDD.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldDDD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldDDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDDDActionPerformed(evt);
            }
        });

        jTextFieldTelefone.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldTelefone.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldTelefone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefoneActionPerformed(evt);
            }
        });

        jTextFieldLogradouro.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldLogradouro.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldLogradouro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLogradouroActionPerformed(evt);
            }
        });

        jTextFieldComplemento.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldComplemento.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldComplemento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldComplementoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 132, 222));
        jLabel5.setText("Complemento:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(1, 132, 222));
        jLabel12.setText("CEP:");

        jTextFieldCEP.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldCEP.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldCEP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCEPActionPerformed(evt);
            }
        });

        jTextFieldBairro.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldBairro.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldBairro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBairroActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(1, 132, 222));
        jLabel15.setText("Bairro:");

        jTextFieldCidade.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldCidade.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldCidade.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCidadeActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(1, 132, 222));
        jLabel16.setText("Cidade:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(1, 132, 222));
        jLabel17.setText("Estado");

        jComboBoxEstadoBrasil.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxEstadoBrasil.setForeground(new java.awt.Color(1, 132, 222));
        jComboBoxEstadoBrasil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEstadoBrasil.setBorder(null);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(1, 132, 222));
        jLabel18.setText("Tipo Cliente:");

        jComboBoxTipoCliente.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxTipoCliente.setForeground(new java.awt.Color(1, 132, 222));
        jComboBoxTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTipoCliente.setBorder(null);

        bgBtnAlterar1.setBackground(new java.awt.Color(1, 132, 222));
        bgBtnAlterar1.setPreferredSize(new java.awt.Dimension(170, 35));

        btnAlterar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlterar1.setForeground(new java.awt.Color(255, 255, 255));
        btnAlterar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAlterar1.setText("ADICIONAR MOTORISTA");
        btnAlterar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAlterar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAlterar1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgBtnAlterar1Layout = new javax.swing.GroupLayout(bgBtnAlterar1);
        bgBtnAlterar1.setLayout(bgBtnAlterar1Layout);
        bgBtnAlterar1Layout.setHorizontalGroup(
            bgBtnAlterar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlterar1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
        );
        bgBtnAlterar1Layout.setVerticalGroup(
            bgBtnAlterar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlterar1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgBackgroundLayout = new javax.swing.GroupLayout(bgBackground);
        bgBackground.setLayout(bgBackgroundLayout);
        bgBackgroundLayout.setHorizontalGroup(
            bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBackgroundLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNomeRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6))
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jTextFieldNomeMotorista))
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBoxTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxStatusCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNumCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldValorMulta))
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldNumRG, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                                .addComponent(bgBtnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bgBtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addGap(28, 28, 28)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(bgBackgroundLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldLogradouro))
                                .addGroup(bgBackgroundLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldComplemento))
                                .addGroup(bgBackgroundLayout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldBairro))
                                .addGroup(bgBackgroundLayout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(bgBackgroundLayout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldDDI, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(bgBackgroundLayout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBoxEstadoBrasil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(bgBtnAlterar1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAttLista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVoltarPagAnt)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtQtdeResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarVeiculo))
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addComponent(saidaStatusOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addComponent(cpUser, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(cpData, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logoNeuron, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))))
        );
        bgBackgroundLayout.setVerticalGroup(
            bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAttLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVoltarPagAnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saidaStatusOperacao)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarVeiculo)
                            .addComponent(txtQtdeResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextFieldNomeRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(jComboBoxTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jTextFieldDDI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextFieldNomeMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextFieldNumCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNumRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(13, 13, 13)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jComboBoxStatusCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldValorMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(jTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(jComboBoxEstadoBrasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bgBtnAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bgBtnInserir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bgBtnAlterar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoNeuron, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        menuLogOff.setText("Log-Off");
        menuLogOff.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuLogOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLogOffMouseClicked(evt);
            }
        });
        jMenuBar.add(menuLogOff);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImprimirGrid(ArrayList<Cliente> listaDeClientes) {
        try {
            DefaultTableModel veiculo = (DefaultTableModel) tabelaClientes.getModel();
            //Limpa a tabela 
            veiculo.setNumRows(0); //setar numero de linhas exibidas para 0
            Iterator<Cliente> lista = listaDeClientes.iterator();

            while (lista.hasNext()) {
                String[] grid = new String[7];
                Cliente cliente = lista.next();
                grid[0] = cliente.getId()+"";
                grid[1] = cliente.getNomeRazaoSocial();
                grid[2] = cliente.getCpfCnpj();
                grid[3] = cliente.getMotorista()+ "";
                grid[4] = cliente.getDDI() + "("+ cliente.getDDD()+")" + cliente.getNumero();
                grid[5] = cliente.getStatusMulta().toString();
                grid[6] = cliente.getValorMulta()+"";

                veiculo.addRow(new Object[]{grid[0],grid[1],grid[2],grid[3],grid[4],grid[5],grid[6]});

            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
        limparTela();
    }

    public void limparTela() {
        jTextFieldNomeRazao.setText("");
        jTextFieldCpfCnpj.setText("");
        jTextFieldNomeMotorista.setText("");
        jTextFieldNumCNH.setText("");
        jTextFieldNumRG.setText("");
        jTextFieldValorMulta.setText("");
        jTextFieldEmail.setText("");
        jTextFieldDDI.setText("");
        jTextFieldDDD.setText("");
        jTextFieldTelefone.setText("");
        jTextFieldLogradouro.setText("");
        jTextFieldComplemento.setText("");
        jTextFieldCEP.setText("");
        jTextFieldBairro.setText("");
        jTextFieldCidade.setText("");
        jComboBoxStatusCliente.setSelectedIndex(0);
        jComboBoxEstadoBrasil.setSelectedIndex(0);
        //jLabelSetImgCNH.setIcon(null);
    }

    public void carregarComboBoxStatus() throws Exception {
        String[] array;
        array = interControle.getListaStatusMulta().toArray(new String[interControle.getListaStatusMulta().size()]);
        jComboBoxStatusCliente.removeAllItems();
        for (String item : array) {
            jComboBoxStatusCliente.addItem(item);
        }
    }
    
    public void carregarComboBoxEstados() throws Exception {
        String[] array = interControle.getNomeEstados().toArray(new String[interControle.getNomeEstados().size()]);
        jComboBoxEstadoBrasil.removeAllItems();
        for (String item : array) {
            jComboBoxEstadoBrasil.addItem(item);
        }
    }
    
    public void resizeColunas() {
        TableColumnModel tCM = tabelaClientes.getColumnModel();
        tCM.getColumn(0).setPreferredWidth(1);
        tCM.getColumn(1).setPreferredWidth(150);
        tCM.getColumn(2).setPreferredWidth(50);
        tCM.getColumn(3).setPreferredWidth(50);
        tCM.getColumn(4).setPreferredWidth(30);
        tCM.getColumn(5).setPreferredWidth(10);
    }

    public void datahora() {
        Date data = new Date();
        SimpleDateFormat horaFormatada = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        cpData.setText("Hora do Acesso: " + dataFormatada.format(data) + " às " + horaFormatada.format(data));
    }

    private void menuLogOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogOffMouseClicked
        Logs.logger("Encerrando Software", getThisClass());
        this.dispose();
    }//GEN-LAST:event_menuLogOffMouseClicked

    private void jTextFieldNumRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumRGActionPerformed

    private void jTextFieldValorMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorMultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorMultaActionPerformed

    private void jTextFieldNumCNHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumCNHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumCNHActionPerformed

    private void jTextFieldNomeMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeMotoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeMotoristaActionPerformed

    private void jTextFieldCpfCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCpfCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCpfCnpjActionPerformed

    private void btnBuscarVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarVeiculoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarVeiculoMouseClicked

    private void btnVoltarPagAntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarPagAntMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnVoltarPagAntMouseClicked

    private void btnAttListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttListaMouseClicked
        try {
            ImprimirGrid(interControle.listagemCliente());
            Logs.logger("lista de Clientes atualizada com sucesso!", telaCliente.class.getName());
        } catch (Exception ex) {
            Logs.logger("Nao foi atualizada a lista!", telaCliente.class.getName());
        }
    }//GEN-LAST:event_btnAttListaMouseClicked

    private void btnAlterarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseExited
        bgBtnAlterar.setBackground(azulPadrao);
    }//GEN-LAST:event_btnAlterarMouseExited

    private void btnAlterarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseEntered
        bgBtnAlterar.setBackground(amareloHover);
    }//GEN-LAST:event_btnAlterarMouseEntered

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        try {
            int id = Integer.parseInt((String) this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0) );
            String cpfCnpj = jTextFieldCpfCnpj.getText();
            String nomeRazaoSocial = jTextFieldNomeRazao.getText();
            String rg = jTextFieldNumRG.getText();
            String email = jTextFieldEmail.getText();
            String motorista = jTextFieldNomeMotorista.getText();
            int nCNH = Integer.parseInt(jTextFieldNumCNH.getText());
            String caminhoImgCNH = getCaminhoCNHSelecionado();
            StatusMulta statusMulta = getStatusMulta(jComboBoxStatusCliente.getSelectedItem().toString().replace("_"," "));
            float valorMulta = Float.parseFloat(jTextFieldValorMulta.getText());
            String logradouro = jTextFieldLogradouro.getText();
            String complemento = jTextFieldComplemento.getText();
            int CEP = Integer.parseInt(jTextFieldCEP.getText());
            String bairro = jTextFieldBairro.getText();
            String cidade = jTextFieldCidade.getText();
            Estados estado = interControle.getEstadoByNome(jComboBoxEstadoBrasil.getSelectedItem().toString());
            int DDI = Integer.parseInt(jTextFieldDDI.getText());
            int DDD = Integer.parseInt(jTextFieldDDD.getText());
            int numero = Integer.parseInt(jTextFieldTelefone.getText());
            
            String aux = id + " - " + cpfCnpj + " - " + nomeRazaoSocial + " - " + rg + " - " + email + " - " + motorista + " - " + nCNH + " - " + caminhoImgCNH + " - " + statusMulta + " - " + valorMulta + " - " + logradouro + " - " + complemento + " - " + CEP + " - " + bairro + " - " + cidade + " - " + estado + " - " + DDI + " - " + DDD + " - " + numero;
            
            Logs.logger(aux, getThisClass());
            Cliente cli = new Cliente(id,cpfCnpj,nomeRazaoSocial,rg,email,motorista,nCNH,caminhoImgCNH,statusMulta,valorMulta,logradouro,complemento,CEP,bairro,cidade,estado,DDI,DDD,numero);
            interControle.alterarCliente(cli);

            JOptionPane.showMessageDialog(this, "Cliente " + jTextFieldNomeRazao.getText().toUpperCase() + " alterado com sucesso!");
            ImprimirGrid(interControle.listagemCliente());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        limparTela();
    }//GEN-LAST:event_btnAlterarMouseClicked

    private void btnInserirClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInserirClienteMouseExited
        bgBtnInserir.setBackground(azulPadrao);
    }//GEN-LAST:event_btnInserirClienteMouseExited

    private void btnInserirClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInserirClienteMouseEntered
        bgBtnInserir.setBackground(verdeHover);
    }//GEN-LAST:event_btnInserirClienteMouseEntered
    
    private void btnInserirClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInserirClienteMouseClicked
        try {
            int id = 0;
            String cpfCnpj = jTextFieldCpfCnpj.getText();
            String nomeRazaoSocial = jTextFieldNomeRazao.getText();
            String rg = jTextFieldNumRG.getText();
            String email = jTextFieldEmail.getText();
            String motorista = jTextFieldNomeMotorista.getText();
            int nCNH = Integer.parseInt(jTextFieldNumCNH.getText());
            String caminhoImgCNH = getCaminhoArquivo();
            StatusMulta statusMulta = getStatusMulta(jComboBoxStatusCliente.getSelectedItem().toString().replace("_"," "));
            float valorMulta = Float.parseFloat(jTextFieldValorMulta.getText());
            String logradouro = jTextFieldLogradouro.getText();
            String complemento = jTextFieldComplemento.getText();
            int CEP = Integer.parseInt(jTextFieldCEP.getText());
            String bairro = jTextFieldBairro.getText();
            String cidade = jTextFieldCidade.getText();
            Estados estado = interControle.getEstadoByNome(jComboBoxEstadoBrasil.getSelectedItem().toString());
            int DDI = Integer.parseInt(jTextFieldDDI.getText());
            int DDD = Integer.parseInt(jTextFieldDDD.getText());
            int numero = Integer.parseInt(jTextFieldTelefone.getText());
            
            Cliente cli = new Cliente(id,cpfCnpj,nomeRazaoSocial,rg,email,motorista,nCNH,caminhoImgCNH,statusMulta,valorMulta,logradouro,complemento,CEP,bairro,cidade,estado,DDI,DDD,numero);
            
            interControle.InserirCliente(cli);
            
            ImprimirGrid(interControle.listagemCliente());
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(this, "Erro Inserir novo Cadastro\n" + erro.getMessage());
        }

        //jTextFieldNomeRazao.setText("");
        //saidaLogo.setIcon(null);

        Logs.logger("Limpeza da tela e lista atualizada disponível na tela", getThisClass());
    }//GEN-LAST:event_btnInserirClienteMouseClicked

    private void jTextFieldNomeRazaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeRazaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeRazaoActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        
        try {
            int idSelecionado = Integer.parseInt((String) this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0) );
            //jLabelSetImgCNH.setIcon(interControle.getImgCNHById(idSelecionado,jLabelSetImgCNH.getWidth(),jLabelSetImgCNH.getHeight()));
            
            String[] cli = interControle.getClienteById(idSelecionado);
            jTextFieldNomeRazao.setText(cli[2]);
            jTextFieldCpfCnpj.setText(cli[1]);
            jTextFieldNomeMotorista.setText(cli[5]);
            jTextFieldNumCNH.setText(cli[6]);
            jTextFieldNumRG.setText(cli[3]);
            jTextFieldValorMulta.setText(cli[9]);
            jTextFieldEmail.setText(cli[4]);
            jTextFieldDDI.setText(cli[16]);
            jTextFieldDDD.setText(cli[17]);
            jTextFieldTelefone.setText(cli[18]);
            jTextFieldLogradouro.setText(cli[10]);
            jTextFieldComplemento.setText(cli[11]);
            jTextFieldCEP.setText(cli[12]);
            jTextFieldBairro.setText(cli[13]);
            jTextFieldCidade.setText(cli[14]);
            jComboBoxStatusCliente.setSelectedItem(cli[8].replace(" ","_"));
            jComboBoxEstadoBrasil.setSelectedItem(cli[15].replace(" ","_"));
            //jLabelSetImgCNH.setIcon(iArquivo.RedimensionarImg(cli[7], jLabelSetImgCNH.getWidth(), jLabelSetImgCNH.getHeight()));
            setCaminhoCNHSelecionado(cli[7]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jTextFieldDDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDDIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDDIActionPerformed

    private void jTextFieldDDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDDDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDDDActionPerformed

    private void jTextFieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefoneActionPerformed

    private void jTextFieldLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLogradouroActionPerformed

    private void jTextFieldComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldComplementoActionPerformed

    private void jTextFieldCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCEPActionPerformed

    private void jTextFieldBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBairroActionPerformed

    private void jTextFieldCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCidadeActionPerformed

    private void btnAlterar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterar1MouseClicked

    private void btnAlterar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterar1MouseEntered

    private void btnAlterar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterar1MouseExited

    private void customizeMenuBar(JMenuBar menuBar) throws Exception {
        IControleGUI iContUser = new ControleGUI();
        JMenuBar jmb = menuBar;

        //Barra customizada de acordo com o perfil
        jmb.add(iContUser.customMenuBar(this));

        jmb.setUI(new BasicMenuBarUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                g.setColor(new Color(1, 132, 222, 255));
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });
    }

    private StatusMulta getStatusMulta(String status) throws Exception {
        switch (status) {
            case "EM DIVIDA":
                return StatusMulta.EM_DIVIDA;
            case "SEM MULTA":
                return StatusMulta.SEM_MULTA;
            case "QUITADO":
                return StatusMulta.QUITADO;
            case "EM_DIVIDA":
                return StatusMulta.EM_DIVIDA;
            case "SEM_MULTA":
                return StatusMulta.SEM_MULTA;
            default:
                throw new Exception("Status nao encontrado");
        }
    }
    
    public String getCaminhoArquivo() throws Exception {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/com/neuron/temp/pathImg.txt"));
            return br.readLine();
        } catch (Exception e) {
            throw new Exception("Arquivo com caminho da imagem nao encontrado");
        }
    }

    public String getCaminhoCNHSelecionado() {
        return caminhoCNHSelecionado;
    }

    public void setCaminhoCNHSelecionado(String caminhoCNHSelecionado) {
        this.caminhoCNHSelecionado = caminhoCNHSelecionado;
    }
    
    
    
    public String getThisClass() {
        thisClass = getClass() + "";
        thisClass = thisClass.replace("class ", "");
        return thisClass;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCliente().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgBackground;
    private javax.swing.JPanel bgBtnAlterar;
    private javax.swing.JPanel bgBtnAlterar1;
    private javax.swing.JPanel bgBtnInserir;
    private javax.swing.JLabel btnAlterar;
    private javax.swing.JLabel btnAlterar1;
    private javax.swing.JLabel btnAttLista;
    private javax.swing.JLabel btnBuscarVeiculo;
    private javax.swing.JLabel btnInserirCliente;
    private javax.swing.JLabel btnVoltarPagAnt;
    private javax.swing.JLabel cpData;
    private javax.swing.JLabel cpUser;
    private javax.swing.JComboBox<String> jComboBoxEstadoBrasil;
    private javax.swing.JComboBox<String> jComboBoxStatusCliente;
    private javax.swing.JComboBox<String> jComboBoxTipoCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCEP;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldCpfCnpj;
    private javax.swing.JTextField jTextFieldDDD;
    private javax.swing.JTextField jTextFieldDDI;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldNomeMotorista;
    private javax.swing.JTextField jTextFieldNomeRazao;
    private javax.swing.JTextField jTextFieldNumCNH;
    private javax.swing.JTextField jTextFieldNumRG;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JTextField jTextFieldValorMulta;
    private javax.swing.JLabel logoNeuron;
    private javax.swing.JMenu menuLogOff;
    private javax.swing.JLabel saidaStatusOperacao;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JLabel txtQtdeResultados;
    // End of variables declaration//GEN-END:variables
}
