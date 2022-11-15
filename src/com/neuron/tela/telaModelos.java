/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.tela;

import com.neuron.templates.Modelo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import com.neuron.controle.*;
import com.neuron.icons.*;
import com.neuron.utils.*;
import com.neuron.utils.TabelaImagemModelo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;
import javax.swing.plaf.basic.BasicMenuBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class telaModelos extends javax.swing.JFrame {

    IControle interControle = new Controle();
    ISelecionarArq iArquivo = new SelecionarArq();
    String caminhoArquivo = "";
    String thisClass = "";
    IControladorImg iImg = new ControladorImg();
    IControleUser iContUser = new ControleUser();
    public telaModelos() {
        initComponents();        
        this.setLocationRelativeTo(null);
        try {
            customizeMenuBar(jMenuBar); //customizar cor do menu
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        datahora(); //data e hora no sistema
        resizeColunas(); //tamanho colunas
        //limparTela(); //limpar tela
        
        try {
            iImg.limparImgNaoUsadas(Telas.MODELO); //limpar imagens do database que nao estao sendo usadas
        } catch (Exception ex) {
            Logs.logger("nao foi possivel iniciar limpando imagens nao vinculadas a Modelos cadastrados", telaModelos.class.getName());
        }
        
        try {
            carregarComboBoxMarcas(); //inserir nomes das marcas no jComboBox
            if (!interControle.listagemModelo().isEmpty() || interControle.listagemModelo() != null ) ImprimirGrid(interControle.listagemModelo());
           
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this,"Sem modelos cadastrados! Por favor cadastre um novo modelo!\n"+erro);
            Logs.logger("Nao foi possivel carregar lista de Modelos cadastrados. "+erro.getMessage(),getThisClass());
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
        tabelaModelo = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        cpInserir = new javax.swing.JTextField();
        txtQtdeResultados = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        saidaDiretorio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        saidaID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        saidaLogo = new javax.swing.JLabel();
        bgBtnCarregarArquivo = new javax.swing.JPanel();
        btnCarregarArquivo = new javax.swing.JLabel();
        saidaStatusOperacao = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxMarcas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnAttLista = new javax.swing.JButton();
        saidaLogoMarca = new javax.swing.JLabel();
        bgBtnInserir = new javax.swing.JPanel();
        btnInserir = new javax.swing.JLabel();
        bgBtnInserir3 = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        menuLogOff = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgBackground.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(84, 197, 255));
        jLabel1.setText("Modelos");

        cpData.setForeground(new java.awt.Color(153, 153, 153));
        cpData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cpUser.setForeground(new java.awt.Color(153, 153, 153));
        cpUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        logoNeuron.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logoNeuron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/neuron/icons/logoMin.png"))); // NOI18N

        tabelaModelo.setAutoCreateRowSorter(true);
        tabelaModelo.setBackground(new java.awt.Color(255, 255, 255));
        tabelaModelo.setForeground(new java.awt.Color(1, 75, 222));
        tabelaModelo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Modelo", "Marca", "Diretório", "Logo", "Logo Marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaModelo.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaModelo.setRowHeight(40);
        tabelaModelo.setSelectionBackground(new java.awt.Color(1, 132, 222));
        tabelaModelo.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabelaModelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaModeloMouseClicked(evt);
            }
        });
        tabelaModelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaModeloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaModelo);
        if (tabelaModelo.getColumnModel().getColumnCount() > 0) {
            tabelaModelo.getColumnModel().getColumn(4).setCellRenderer(new TabelaImagemMarca());
        }
        if (tabelaModelo.getColumnModel().getColumnCount() > 0) {
            tabelaModelo.getColumnModel().getColumn(4).setCellRenderer(new TabelaImagemModelo());
            tabelaModelo.getColumnModel().getColumn(5).setCellRenderer(new TabelaImagemLogoMarca());
        }
        tabelaModelo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jSeparator1.setBackground(new java.awt.Color(1, 132, 222));
        jSeparator1.setForeground(new java.awt.Color(1, 132, 222));
        jSeparator1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 132, 222));
        jLabel2.setText("Modelo:");

        cpInserir.setBackground(new java.awt.Color(250, 250, 250));
        cpInserir.setForeground(new java.awt.Color(1, 132, 222));
        cpInserir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        cpInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpInserirActionPerformed(evt);
            }
        });

        txtQtdeResultados.setBackground(new java.awt.Color(250, 250, 250));
        txtQtdeResultados.setForeground(new java.awt.Color(100, 210, 243));
        txtQtdeResultados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtQtdeResultados.setText("n modelos cadastrados.");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 132, 222));
        jLabel3.setText("Diretório:");

        saidaDiretorio.setForeground(new java.awt.Color(11, 149, 187));
        saidaDiretorio.setText("   ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 132, 222));
        jLabel5.setText("ID:");

        saidaID.setForeground(new java.awt.Color(11, 149, 187));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 132, 222));
        jLabel4.setText("Foto:");

        saidaLogo.setVerifyInputWhenFocusTarget(false);

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
            .addComponent(btnCarregarArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        bgBtnCarregarArquivoLayout.setVerticalGroup(
            bgBtnCarregarArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCarregarArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        saidaStatusOperacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saidaStatusOperacao.setForeground(new java.awt.Color(1, 132, 222));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 132, 222));
        jLabel6.setText("Marca:");

        jComboBoxMarcas.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxMarcas.setForeground(new java.awt.Color(1, 132, 222));
        jComboBoxMarcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMarcas.setBorder(null);
        jComboBoxMarcas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcasActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 132, 222));
        jLabel7.setText("Logo da Marca:");

        btnAttLista.setBackground(new java.awt.Color(1, 132, 222));
        btnAttLista.setForeground(new java.awt.Color(255, 255, 255));
        btnAttLista.setText("Atualizar");
        btnAttLista.setAlignmentX(0.5F);
        btnAttLista.setAutoscrolls(true);
        btnAttLista.setBorder(null);
        btnAttLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttListaActionPerformed(evt);
            }
        });

        bgBtnInserir.setBackground(new java.awt.Color(1, 132, 222));

        btnInserir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInserir.setForeground(new java.awt.Color(255, 255, 255));
        btnInserir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInserir.setText("INSERIR");
        btnInserir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInserirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bgBtnInserirLayout = new javax.swing.GroupLayout(bgBtnInserir);
        bgBtnInserir.setLayout(bgBtnInserirLayout);
        bgBtnInserirLayout.setHorizontalGroup(
            bgBtnInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        bgBtnInserirLayout.setVerticalGroup(
            bgBtnInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        bgBtnInserir3.setBackground(new java.awt.Color(1, 132, 222));
        bgBtnInserir3.setPreferredSize(new java.awt.Dimension(170, 35));

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
        });

        javax.swing.GroupLayout bgBtnInserir3Layout = new javax.swing.GroupLayout(bgBtnInserir3);
        bgBtnInserir3.setLayout(bgBtnInserir3Layout);
        bgBtnInserir3Layout.setHorizontalGroup(
            bgBtnInserir3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        bgBtnInserir3Layout.setVerticalGroup(
            bgBtnInserir3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgBackgroundLayout = new javax.swing.GroupLayout(bgBackground);
        bgBackground.setLayout(bgBackgroundLayout);
        bgBackgroundLayout.setHorizontalGroup(
            bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBackgroundLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addComponent(saidaStatusOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtQtdeResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgBackgroundLayout.createSequentialGroup()
                        .addComponent(cpUser, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpData, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoNeuron, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgBackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAttLista, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgBackgroundLayout.createSequentialGroup()
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxMarcas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cpInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                                .addComponent(bgBtnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bgBtnInserir3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(30, 30, 30)
                                .addComponent(saidaID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(saidaLogoMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saidaDiretorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saidaLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bgBtnCarregarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)))
                .addGap(19, 19, 19))
        );
        bgBackgroundLayout.setVerticalGroup(
            bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAttLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQtdeResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saidaStatusOperacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cpInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(saidaDiretorio)
                    .addComponent(jLabel5)
                    .addComponent(saidaID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bgBtnCarregarArquivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgBackgroundLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saidaLogoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoNeuron, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jComboBoxMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bgBtnInserir3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bgBtnInserir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(saidaLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 43, Short.MAX_VALUE)))
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

    private void ImprimirGrid(ArrayList<Modelo> listaDeModelos) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabelaModelo.getModel();
            TabelaImagemModelo tabelaImagem = new TabelaImagemModelo();
            tabelaModelo.getColumnModel().getColumn(4).setCellRenderer(tabelaImagem);
            ImageIcon logoCell = new ImageIcon();
            ImageIcon logoMarcaCell = new ImageIcon();
            
            //Limpa a tabela 
            modelo.setNumRows(0); //setar numero de linhas exibidas para 0
            Iterator<Modelo> lista = listaDeModelos.iterator();
            
            while (lista.hasNext()) {
                String[] grid = new String[5];
                Modelo listaModelo = lista.next();
                grid[0] = listaModelo.getIdModelo() + "";
                grid[1] = listaModelo.getNomeModelo();
                grid[2] = Gerador.getNomeMarcaByID(listaModelo.getIdMarcaRelacinado());
                grid[3] = listaModelo.getDirFotoModelo().replace("./src/com/neuron/icons/","/");
                
                logoCell = new ImageIcon(listaModelo.getDirFotoModelo());
                logoMarcaCell = new ImageIcon("./src/com/neuron/icons/logo/"+grid[2]+".jpeg");
                modelo.addRow(new Object[]{grid[0],grid[1],grid[2],grid[3],logoCell,logoMarcaCell});
                
            }          
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
        limparTela();
    }
    
    public void limparTela(){
        saidaLogo.setIcon(null);
        saidaDiretorio.setText("");
        saidaLogoMarca.setIcon(null);
        saidaID.setText("");
        cpInserir.setText("");
        
    }
    
    public void carregarComboBoxMarcas() throws Exception{
        String[] arrayNomeMarcas = interControle.listagemNomeMarcasList().toArray(new String[interControle.listagemNomeMarcas().size()]);
        jComboBoxMarcas.removeAllItems();
        for (String itemMarca : arrayNomeMarcas) {
            jComboBoxMarcas.addItem(itemMarca);
        }
        
    }
    
    public void resizeColunas(){
        TableColumnModel tCM = tabelaModelo.getColumnModel();
        tCM.getColumn(0).setPreferredWidth(30);
        tCM.getColumn(1).setPreferredWidth(120);
        tCM.getColumn(2).setPreferredWidth(120);
        tCM.getColumn(3).setPreferredWidth(180);
        tCM.getColumn(4).setPreferredWidth(80);
        tCM.getColumn(5).setPreferredWidth(80);
    }
    
    public void datahora(){
        Date data = new Date();
        SimpleDateFormat horaFormatada = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        cpData.setText("Hora do Acesso: "+dataFormatada.format(data) + " às " + horaFormatada.format(data));
    }
    
    private void cpInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpInserirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpInserirActionPerformed

    private void tabelaModeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaModeloMouseClicked
       
        try {
            this.saidaID.setText((String) this.tabelaModelo.getValueAt(tabelaModelo.getSelectedRow(), 0));
            this.cpInserir.setText((String) this.tabelaModelo.getValueAt(tabelaModelo.getSelectedRow(), 1));

            caminhoArquivo = (String) this.tabelaModelo.getValueAt(tabelaModelo.getSelectedRow(), 3);
            String nomeMarcaSelecionado = this.tabelaModelo.getValueAt(tabelaModelo.getSelectedRow(), 2) + "";
            
            String caminhoLogoMarca = "./src/com/neuron/icons/logo/"+nomeMarcaSelecionado.toUpperCase()+".jpeg";
            
            saidaDiretorio.setText(caminhoArquivo);
            
            ImageIcon imgLogo = new ImageIcon();
            
            imgLogo = iArquivo.RedimensionarImg("./src/com/neuron/icons"+caminhoArquivo,150,150);
            saidaLogo.setIcon(imgLogo);
            jComboBoxMarcas.setSelectedIndex(Gerador.getIDMarcaSelecionada(nomeMarcaSelecionado)-1);
            
            Logs.logger("Modelo selecionado na tabela: "+this.tabelaModelo.getValueAt(tabelaModelo.getSelectedRow(), 1),getThisClass());
            
            saidaLogoMarca.setIcon(iArquivo.RedimensionarImg(caminhoLogoMarca, 105, 105));
            
            
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err);
            Logs.logger("Nao foi possivel selecionar modelo\n"+err.getMessage(),getThisClass());
        }
        //Set imagem da Marca
        
        try {
            //saidaLogoMarca.setIcon(Gerador.getLogoMarcaByNome((String) this.tabelaModelo.getValueAt(tabelaModelo.getSelectedRow(), 2)));
        } catch (Exception e) {
            Logs.logger("Nao foi possivel capturar imagem da logo Marca"+e.getMessage(), telaModelos.class.getName());
        }
    }//GEN-LAST:event_tabelaModeloMouseClicked

    private void btnCarregarArquivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarregarArquivoMouseClicked
        Logs.logger("Iniciando selecao de imagem",getThisClass());
        try {
            ImageIcon imgLogo = new ImageIcon();
            imgLogo = iArquivo.abrirBuscadorImg(saidaLogo.getWidth(),saidaLogo.getHeight());
            setCaminhoArquivo((String) iArquivo.getCaminhoDoArquivo());
            saidaLogo.setIcon(imgLogo);
            Logs.logger("Imagem selecionada com sucesso do diretorio "+iArquivo.getCaminhoDoArquivo(),getThisClass());
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, e.getMessage());
            Logs.logger("Nao foi possivel selecionar imagem para este modelo\n"+e.getMessage(),getThisClass());
        }
        
        
    }//GEN-LAST:event_btnCarregarArquivoMouseClicked

    private void btnCarregarArquivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarregarArquivoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCarregarArquivoMouseEntered

    private void menuLogOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLogOffMouseClicked
        Logs.logger("Encerrando Software",getThisClass());
        this.dispose();
    }//GEN-LAST:event_menuLogOffMouseClicked

    private void jComboBoxMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcasActionPerformed
        //setComboBoxMarcaSelecionada(jComboBoxMarcas.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxMarcasActionPerformed

    private void btnAttListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttListaActionPerformed
        try {
            ImprimirGrid(interControle.listagemModelo());
            Logs.logger("Lista atualizada em ", telaModelos.class.getName());
        } catch (Exception ex) {
            Logs.logger("Nao foi possivel atualizar a lista. "+ex.getMessage(), telaModelos.class.getName());
        }
    }//GEN-LAST:event_btnAttListaActionPerformed

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        try {
            int auxID = (Integer.parseInt(saidaID.getText()));
            int idCombo = jComboBoxMarcas.getSelectedIndex() + 1;
            interControle.alterarModelo(auxID, cpInserir.getText().toUpperCase(), "./src/com/neuron/icons" + saidaDiretorio.getText(),idCombo);
            ImprimirGrid(interControle.listagemModelo());
            JOptionPane.showMessageDialog(this, "Modelo " + cpInserir.getText().toUpperCase() + " alterado com sucesso!");
            //cpInfoAdicional.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        limparTela();
    }//GEN-LAST:event_btnAlterarMouseClicked

    private void btnInserirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInserirMouseClicked
        try {
            String arquivoSelecionado = cpInserir.getText().toUpperCase() + ".jpeg";
            Logs.logger("Nome do modelo a ser cadastrado: " + cpInserir.getText().toUpperCase(), getThisClass());

            String caminhoImg = "./src/com/neuron/icons/modelo/" + arquivoSelecionado;
            int idCombo = jComboBoxMarcas.getSelectedIndex();
            Logs.logger("ID do Item Selecionado na ComboBox: " + idCombo, getThisClass());

            String nomeMarcaSelecionada = jComboBoxMarcas.getSelectedItem().toString();
            Logs.logger("Marca selecionada no ComboBox " + nomeMarcaSelecionada, getThisClass());

            Modelo modelo = new Modelo(0, cpInserir.getText().toUpperCase(), caminhoImg, Gerador.getIDMarcaSelecionada(nomeMarcaSelecionada));
            Logs.logger("Preparado os dados para inserir na tabela", getThisClass());

            Logs.logger("Modelo Inserido: " + modelo.getNomeModelo(), getThisClass());
            Logs.logger("Dir do Modelo: " + modelo.getDirFotoModelo(), getThisClass());
            Logs.logger("ID da Marca do Modelo Selecionado: " + modelo.getIdMarcaRelacinado(), getThisClass());

            try {
                if ((saidaLogo.getIcon())==null){
                    Logs.logger("Nao e possivel salvar Modelo sem uma imagem o representado! - Por favor selecione uma imagem!", getThisClass());
                    throw new Exception("Nao e possivel salvar Modelo sem uma imagem o representado!\nPor favor selecione uma imagem!");
                }
                
                interControle.incluirModelo(modelo);                
                Logs.logger("Novo modelo Inserido com sucesso!", getThisClass());
            } catch (Exception e) {
                Logs.logger("Não foi possível inserir novo modelo - " + e.getMessage(), getThisClass());
                throw new Exception("Nao foi possivel inserir novo modelo - " + e.getMessage());
            }

            
            ImprimirGrid(interControle.listagemModelo());

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(this, "Erro Inserir novo Cadastro\n" + erro.getMessage());
        }
        
        cpInserir.setText("");
        saidaLogo.setIcon(null);

        
        Logs.logger("Limpeza da tela e lista atualizada disponível na tela Modelos", getThisClass());
    }//GEN-LAST:event_btnInserirMouseClicked

    private void btnAlterarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarMouseEntered
    
    
    
    //COLORIR BARRA DE MENU
    Color azulSistema = new Color(1, 132, 222, 255);

    private void customizeMenuBar(JMenuBar menuBar) throws Exception{

        menuBar.add(iContUser.customMenuBar());
        menuBar.setUI(new BasicMenuBarUI() {

            @Override
            public void paint(Graphics g, JComponent c) {
                g.setColor(azulSistema);
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
        thisClass = getClass()+"";
        thisClass = thisClass.replace("class ","");
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
            java.util.logging.Logger.getLogger(telaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaModelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new telaModelos().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgBackground;
    private javax.swing.JPanel bgBtnCarregarArquivo;
    private javax.swing.JPanel bgBtnInserir;
    private javax.swing.JPanel bgBtnInserir3;
    private javax.swing.JLabel btnAlterar;
    private javax.swing.JButton btnAttLista;
    private javax.swing.JLabel btnCarregarArquivo;
    private javax.swing.JLabel btnInserir;
    private javax.swing.JLabel cpData;
    private javax.swing.JTextField cpInserir;
    private javax.swing.JLabel cpUser;
    private javax.swing.JComboBox<String> jComboBoxMarcas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logoNeuron;
    private javax.swing.JMenu menuLogOff;
    private javax.swing.JLabel saidaDiretorio;
    private javax.swing.JLabel saidaID;
    private javax.swing.JLabel saidaLogo;
    private javax.swing.JLabel saidaLogoMarca;
    private javax.swing.JLabel saidaStatusOperacao;
    private javax.swing.JTable tabelaModelo;
    private javax.swing.JLabel txtQtdeResultados;
    // End of variables declaration//GEN-END:variables
}
