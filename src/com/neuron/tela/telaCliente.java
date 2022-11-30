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
import com.neuron.controle.control.*;
import com.neuron.icons.*;
import com.neuron.utils.*;
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
    String caminhoArquivo = "";
    String thisClass = "";
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
            customizeMenuBar(jMenuBar); //customizar cor do menu
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        datahora(); //data e hora no sistema
        resizeColunas(); //tamanho colunas
        //limparTela(); //limpar tela
        

        try { 
            carregarComboBoxStatus();            
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
        jPanelFotoCNH = new javax.swing.JPanel();
        jLabelFotoCNH = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxStatusCliente = new javax.swing.JComboBox<>();
        jTextFieldPlacaVeiculo4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bgBtnCarregarArquivo = new javax.swing.JPanel();
        btnCarregarArquivo = new javax.swing.JLabel();
        jTextFieldNumRG = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
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
        if (tabelaClientes.getColumnModel().getColumnCount() > 0) {
            tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(1).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(2).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(3).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(4).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(5).setResizable(false);
            tabelaClientes.getColumnModel().getColumn(6).setResizable(false);
        }
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
            .addComponent(btnInserirCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
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
            .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
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
        jLabel4.setText("Foto CNH:");

        javax.swing.GroupLayout jPanelFotoCNHLayout = new javax.swing.GroupLayout(jPanelFotoCNH);
        jPanelFotoCNH.setLayout(jPanelFotoCNHLayout);
        jPanelFotoCNHLayout.setHorizontalGroup(
            jPanelFotoCNHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelFotoCNH, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );
        jPanelFotoCNHLayout.setVerticalGroup(
            jPanelFotoCNHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelFotoCNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 132, 222));
        jLabel9.setText("Status:");

        jComboBoxStatusCliente.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxStatusCliente.setForeground(new java.awt.Color(1, 132, 222));
        jComboBoxStatusCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxStatusCliente.setBorder(null);

        jTextFieldPlacaVeiculo4.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldPlacaVeiculo4.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldPlacaVeiculo4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldPlacaVeiculo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlacaVeiculo4ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 132, 222));
        jLabel10.setText("Valor Multa:");

        bgBtnCarregarArquivo.setBackground(new java.awt.Color(1, 132, 222));

        btnCarregarArquivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCarregarArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/neuron/icons/carregarImg.png"))); // NOI18N
        btnCarregarArquivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCarregarArquivoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCarregarArquivoMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout bgBtnCarregarArquivoLayout = new javax.swing.GroupLayout(bgBtnCarregarArquivo);
        bgBtnCarregarArquivo.setLayout(bgBtnCarregarArquivoLayout);
        bgBtnCarregarArquivoLayout.setHorizontalGroup(
            bgBtnCarregarArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCarregarArquivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        bgBtnCarregarArquivoLayout.setVerticalGroup(
            bgBtnCarregarArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCarregarArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(1, 132, 222));
        jLabel12.setText("Telefone:");

        jTextFieldTelefone.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldTelefone.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldTelefone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgBackgroundLayout = new javax.swing.GroupLayout(bgBackground);
        bgBackground.setLayout(bgBackgroundLayout);
        bgBackgroundLayout.setHorizontalGroup(
            bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBackgroundLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(saidaStatusOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQtdeResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscarVeiculo))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addComponent(bgBtnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(bgBtnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(12, 12, 12)
                                        .addComponent(jComboBoxStatusCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldNomeRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgBackgroundLayout.createSequentialGroup()
                                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel6))
                                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                        .addGap(7, 7, 7)
                                                        .addComponent(jTextFieldNomeMotorista))
                                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldTelefone)))))
                                        .addGroup(bgBackgroundLayout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextFieldNumCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextFieldPlacaVeiculo4))
                                                .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextFieldNumRG, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(59, 59, 59)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addComponent(jPanelFotoCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bgBtnCarregarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 66, Short.MAX_VALUE))
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addComponent(cpUser, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(saidaStatusOperacao))
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarVeiculo)
                            .addComponent(txtQtdeResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(14, 14, 14)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addComponent(bgBtnCarregarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148))
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addComponent(jPanelFotoCNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))))
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNomeRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldNomeMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldNumCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNumRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBoxStatusCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPlacaVeiculo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bgBtnAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bgBtnInserir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
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
            //set imagem no grid

            //Limpa a tabela 
            veiculo.setNumRows(0); //setar numero de linhas exibidas para 0
            Iterator<Cliente> lista = listaDeClientes.iterator();

            while (lista.hasNext()) {
                String[] grid = new String[7];
                Cliente cliente = lista.next();
                grid[0] = cliente.getId() + "";
                grid[1] = cliente.getNome();
                grid[2] = cliente.getCpfCnpj();
                grid[3] = cliente.getMotorista()+ "";
                grid[4] = cliente.getDDI() + "("+ cliente.getDDD()+")" + cliente.getNumero();
                grid[5] = cliente.getStatusMulta().toString();
                grid[6] = cliente.getValorMulta()%.2+"";

                veiculo.addRow(new Object[]{grid});

            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
        limparTela();
    }

    public void limparTela() {
        /*saidaLogo.setIcon(null);
        saidaDiretorio.setText("");
        saidaLogoMarca.setIcon(null);
        saidaID.setText("");*/

    }

    public void carregarComboBoxStatus() throws Exception {
        String[] array = interControle.listagemCliente().toArray(new String[interControle.listagemCliente().size()]);
        jComboBoxStatusCliente.removeAllItems();
        for (String item : array) {
            jComboBoxStatusCliente.addItem(item);
        }
    }

    public void resizeColunas() {
        TableColumnModel tCM = tabelaClientes.getColumnModel();
        tCM.getColumn(0).setPreferredWidth(30);
        tCM.getColumn(1).setPreferredWidth(80);
        tCM.getColumn(2).setPreferredWidth(120);
        tCM.getColumn(3).setPreferredWidth(70);
        tCM.getColumn(4).setPreferredWidth(30);
        tCM.getColumn(5).setPreferredWidth(70);
        tCM.getColumn(6).setPreferredWidth(50);
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

    private void jTextFieldTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefoneActionPerformed

    private void jTextFieldNumRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumRGActionPerformed

    private void btnCarregarArquivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarregarArquivoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCarregarArquivoMouseEntered

    private void btnCarregarArquivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarregarArquivoMouseClicked
        Logs.logger("Iniciando selecao de imagem",getThisClass());
        try {
            ImageIcon imgLogo = new ImageIcon();
            imgLogo = iArquivo.abrirBuscadorImg(jLabelFotoCNH.getWidth(),jLabelFotoCNH.getHeight());
            setCaminhoArquivo((String) iArquivo.getCaminhoDoArquivo());
            jLabelFotoCNH.setIcon(imgLogo);
            Logs.logger("Imagem selecionada com sucesso do diretorio "+iArquivo.getCaminhoDoArquivo(),getThisClass());
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());
            Logs.logger("Nao foi possivel selecionar imagem para a CNH"+e.getMessage(),getThisClass());
        }
    }//GEN-LAST:event_btnCarregarArquivoMouseClicked

    private void jTextFieldPlacaVeiculo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlacaVeiculo4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlacaVeiculo4ActionPerformed

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
            int id = Integer.parseInt((String)this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0));
            
            Cliente cliente = new Cliente();
            interControle.alterarCliente(cliente);
            //ImprimirGrid(interControle.listagemModelo());

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
            String cor = jComboBoxCorVeiculo.getSelectedItem().toString();
            String modelo = jComboBoxModelo.getSelectedItem().toString();
            Disponibilidade dispo = Get.disponibilidadeByNome(jComboBoxDisponivel.getSelectedItem().toString());
            String marca = jComboBoxMarcas.getSelectedItem().toString();
            String placa = jTextFieldNomeRazao.getText();
            String anoFabri = jTextFieldAno.getText();
            TipoCombustivel tipo = Get.combustivelByNome(jComboBoxTipoVeiculo.getSelectedItem().toString());
            int quilometro = 0;
            TipoVeiculo tipoVeiculo = Get.TipoVeiculoByNome(jComboBoxTipoCombustivel.getSelectedItem().toString());
            int renavam = Integer.parseInt(jTextFieldRenavamVeiculo.getText());
            float precoCompra =  0;
            float precoVenda = 0;
            String dataCompra = jTextFieldDataCompra.getText();
            String dataVenda = jLabelDataVenda.getText();
            String info = jTextAreaObs.getText();
            int idModelo = Get.IDModeloSelecionado(modelo);
            Veiculo v = new Veiculo(0,cor,modelo,dispo,marca,placa,anoFabri,tipo,quilometro,tipoVeiculo,renavam,precoCompra,precoVenda,dataCompra,dataVenda,info,idModelo);

            interControle.incluirVeiculo(v);
            //ImprimirGrid(interControle.listagemModelo());
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(this, "Erro Inserir novo Cadastro\n" + erro.getMessage());
        }

        jTextFieldNomeRazao.setText("");
        //saidaLogo.setIcon(null);

        Logs.logger("Limpeza da tela e lista atualizada disponível na tela Modelos", getThisClass());
    }//GEN-LAST:event_btnInserirClienteMouseClicked

    private void jTextFieldNomeRazaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeRazaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeRazaoActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked

        try {
            caminhoArquivo = (String) this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 3);
            String nomeMarcaSelecionado = this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 4) + "";
            nomeMarcaSelecionado = nomeMarcaSelecionado.replace("./src/com/neuron/icons/logo/", "").replace(".jpeg", "");
            String idSelecionado = (String) this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 0);

            Iterator<Veiculo> lista = interControle.listagemVeiculo().iterator();

            while (lista.hasNext()) {
                String[] grid = new String[15];
                Veiculo listaVeiculo = lista.next();
                grid[0] = "" + listaVeiculo.getIdVeiculo();
                if (grid[0].equals(idSelecionado)) {
                    jTextFieldRenavamVeiculo.setText(listaVeiculo.getRenavan() + "");
                    jTextFieldDataCompra.setText(listaVeiculo.getDataCompra());
                    jLabelDataVenda.setText(listaVeiculo.getDataVenda());
                }

            }

            this.jTextFieldNomeRazao.setText((String) this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 5));
            jComboBoxMarcas.setSelectedItem(nomeMarcaSelecionado);
            jComboBoxModelo.setSelectedItem((String) this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 2));
            jComboBoxCorVeiculo.setSelectedItem((String) this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 1));
            jComboBoxTipoVeiculo.setSelectedItem((String) this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 7));
            jComboBoxTipoCombustivel.setSelectedItem((String) this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 9));
            jComboBoxDisponivel.setSelectedItem((String) this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 3));
            this.jTextFieldAno.setText((String) this.tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 6));

        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err);
            Logs.logger(err.getMessage(), getThisClass());
        }
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void customizeMenuBar(JMenuBar menuBar) throws Exception {
        IControleUser iContUser = new ControleUser();
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

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
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
    private javax.swing.JPanel bgBtnCarregarArquivo;
    private javax.swing.JPanel bgBtnInserir;
    private javax.swing.JLabel btnAlterar;
    private javax.swing.JLabel btnAttLista;
    private javax.swing.JLabel btnBuscarVeiculo;
    private javax.swing.JLabel btnCarregarArquivo;
    private javax.swing.JLabel btnInserirCliente;
    private javax.swing.JLabel btnVoltarPagAnt;
    private javax.swing.JLabel cpData;
    private javax.swing.JLabel cpUser;
    private javax.swing.JComboBox<String> jComboBoxStatusCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFotoCNH;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanelFotoCNH;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldCpfCnpj;
    private javax.swing.JTextField jTextFieldNomeMotorista;
    private javax.swing.JTextField jTextFieldNomeRazao;
    private javax.swing.JTextField jTextFieldNumCNH;
    private javax.swing.JTextField jTextFieldNumRG;
    private javax.swing.JTextField jTextFieldPlacaVeiculo4;
    private javax.swing.JTextField jTextFieldTelefone;
    private javax.swing.JLabel logoNeuron;
    private javax.swing.JMenu menuLogOff;
    private javax.swing.JLabel saidaStatusOperacao;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JLabel txtQtdeResultados;
    // End of variables declaration//GEN-END:variables
}
