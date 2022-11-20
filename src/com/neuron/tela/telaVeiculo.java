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
import com.neuron.controle.*;
import com.neuron.icons.*;
import com.neuron.exceptions.*;
import com.neuron.utils.*;
import com.neuron.utils.TabelaImagemModelo;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicMenuBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class telaVeiculo extends javax.swing.JFrame {

    IControle interControle = new Controle();
    ISelecionarArq iArquivo = new SelecionarArq();
    String caminhoArquivo = "";
    String thisClass = "";
    IControladorImg iImg = new ControladorImg();
    Color azulHover = new Color(0, 23, 132, 255);
    Color azulPadrao = new Color(1, 132, 222, 255);
    Color verdeHover = new Color(51, 186, 0, 255);

    public telaVeiculo() {
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
            iImg.limparImgNaoUsadas(Telas.MODELO); //limpar imagens do database que nao estao sendo usadas
        } catch (Exception ex) {
            Logs.logger("nao foi possivel iniciar limpando imagens nao vinculadas a Modelos cadastrados", telaVeiculo.class.getName());
        }

        try {
            if (!interControle.listagemVeiculo().isEmpty() || interControle.listagemVeiculo() != null) {
                ImprimirGrid(interControle.listagemVeiculo());
            }
            carregarComboBoxMarcas();
            carregarComboBoxModelo();
            carregarComboBoxCores();
            carregarComboBoxTipoCombustivel();
            carregarComboBoxTipoVeiculo();
            carregarComboBoxDisponivel();

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
        tabelaVeiculo = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPlacaVeiculo = new javax.swing.JTextField();
        txtQtdeResultados = new javax.swing.JLabel();
        saidaStatusOperacao = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bgBtnInserir = new javax.swing.JPanel();
        btnInserirVeiculo = new javax.swing.JLabel();
        bgBtnInserir3 = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JLabel();
        btnAttLista = new javax.swing.JLabel();
        btnVoltarPagAnt = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldRenavamVeiculo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxCorVeiculo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldAno = new javax.swing.JTextField();
        jComboBoxTipoCombustivel = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxTipoVeiculo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldDataCompra = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldDataVenda = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxDisponivel = new javax.swing.JComboBox<>();
        btnAddColor = new javax.swing.JLabel();
        bgBtnIniciarAluguel2 = new javax.swing.JPanel();
        btnIniciarAluguel2 = new javax.swing.JLabel();
        jComboBoxMarcas = new javax.swing.JComboBox<>();
        jComboBoxModelo = new javax.swing.JComboBox<>();
        bgBtnAlugarVeiculo = new javax.swing.JPanel();
        btnAlugarVeiculo = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        menuLogOff = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgBackground.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 106, 255));
        jLabel1.setText("Veículos");

        cpData.setForeground(new java.awt.Color(153, 153, 153));
        cpData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cpUser.setForeground(new java.awt.Color(153, 153, 153));
        cpUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        logoNeuron.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logoNeuron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/neuron/icons/logoMin.png"))); // NOI18N

        tabelaVeiculo.setAutoCreateRowSorter(true);
        tabelaVeiculo.setBackground(new java.awt.Color(255, 255, 255));
        tabelaVeiculo.setForeground(new java.awt.Color(1, 75, 222));
        tabelaVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cor", "Modelo", "Disponível", "Marca", "Placa", "Ano", "Combustível", "Quilometragem", "Tipo Veiculo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaVeiculo.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaVeiculo.setRowHeight(40);
        tabelaVeiculo.setSelectionBackground(new java.awt.Color(1, 132, 222));
        tabelaVeiculo.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabelaVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVeiculoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVeiculo);
        if (tabelaVeiculo.getColumnModel().getColumnCount() > 0) {
            tabelaVeiculo.getColumnModel().getColumn(0).setResizable(false);
            tabelaVeiculo.getColumnModel().getColumn(1).setResizable(false);
            tabelaVeiculo.getColumnModel().getColumn(2).setResizable(false);
            tabelaVeiculo.getColumnModel().getColumn(3).setResizable(false);
            tabelaVeiculo.getColumnModel().getColumn(4).setResizable(false);
            tabelaVeiculo.getColumnModel().getColumn(4).setCellRenderer(new TabelaImagem());
            tabelaVeiculo.getColumnModel().getColumn(5).setResizable(false);
            tabelaVeiculo.getColumnModel().getColumn(6).setResizable(false);
            tabelaVeiculo.getColumnModel().getColumn(7).setResizable(false);
            tabelaVeiculo.getColumnModel().getColumn(8).setResizable(false);
            tabelaVeiculo.getColumnModel().getColumn(9).setResizable(false);
        }
        tabelaVeiculo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jSeparator1.setBackground(new java.awt.Color(1, 132, 222));
        jSeparator1.setForeground(new java.awt.Color(1, 132, 222));
        jSeparator1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 132, 222));
        jLabel2.setText("Placa:");

        jTextFieldPlacaVeiculo.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldPlacaVeiculo.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldPlacaVeiculo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldPlacaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPlacaVeiculoActionPerformed(evt);
            }
        });

        txtQtdeResultados.setBackground(new java.awt.Color(250, 250, 250));
        txtQtdeResultados.setForeground(new java.awt.Color(100, 210, 243));
        txtQtdeResultados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtQtdeResultados.setText("n modelos cadastrados.");

        saidaStatusOperacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saidaStatusOperacao.setForeground(new java.awt.Color(1, 132, 222));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 132, 222));
        jLabel6.setText("Marca:");

        bgBtnInserir.setBackground(new java.awt.Color(1, 132, 222));

        btnInserirVeiculo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInserirVeiculo.setForeground(new java.awt.Color(255, 255, 255));
        btnInserirVeiculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInserirVeiculo.setText("INSERIR");
        btnInserirVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInserirVeiculoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInserirVeiculoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInserirVeiculoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgBtnInserirLayout = new javax.swing.GroupLayout(bgBtnInserir);
        bgBtnInserir.setLayout(bgBtnInserirLayout);
        bgBtnInserirLayout.setHorizontalGroup(
            bgBtnInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInserirVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        bgBtnInserirLayout.setVerticalGroup(
            bgBtnInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInserirVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
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
        jLabel8.setText("Modelo:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(1, 132, 222));
        jLabel9.setText("Renavam:");

        jTextFieldRenavamVeiculo.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldRenavamVeiculo.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldRenavamVeiculo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldRenavamVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRenavamVeiculoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(1, 132, 222));
        jLabel10.setText("Cor:");

        jComboBoxCorVeiculo.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxCorVeiculo.setForeground(new java.awt.Color(1, 132, 222));
        jComboBoxCorVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCorVeiculo.setBorder(null);
        jComboBoxCorVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxCorVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCorVeiculoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(1, 132, 222));
        jLabel11.setText("Ano:");

        jTextFieldAno.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldAno.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldAno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnoActionPerformed(evt);
            }
        });

        jComboBoxTipoCombustivel.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxTipoCombustivel.setForeground(new java.awt.Color(1, 132, 222));
        jComboBoxTipoCombustivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTipoCombustivel.setBorder(null);
        jComboBoxTipoCombustivel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxTipoCombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoCombustivelActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(1, 132, 222));
        jLabel12.setText("Tipo Combustível:");

        jComboBoxTipoVeiculo.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxTipoVeiculo.setForeground(new java.awt.Color(1, 132, 222));
        jComboBoxTipoVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTipoVeiculo.setBorder(null);
        jComboBoxTipoVeiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxTipoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoVeiculoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 132, 222));
        jLabel13.setText("Tipo do Veículo:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(1, 132, 222));
        jLabel14.setText("Data de Compra:");

        jTextFieldDataCompra.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDataCompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 132, 222)));
        jTextFieldDataCompra.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldDataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(1, 132, 222));
        jLabel15.setText("Data de Venda:");

        jTextFieldDataVenda.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldDataVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 132, 222)));
        jTextFieldDataVenda.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldDataVenda.setText("00/00/0000");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(1, 132, 222));
        jLabel16.setText("Disponível:");

        jComboBoxDisponivel.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxDisponivel.setForeground(new java.awt.Color(1, 132, 222));
        jComboBoxDisponivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxDisponivel.setBorder(null);
        jComboBoxDisponivel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxDisponivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDisponivelActionPerformed(evt);
            }
        });

        btnAddColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/neuron/icons/add_color.png"))); // NOI18N
        btnAddColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddColorMouseClicked(evt);
            }
        });

        bgBtnIniciarAluguel2.setBackground(new java.awt.Color(1, 132, 222));
        bgBtnIniciarAluguel2.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnIniciarAluguel2.setPreferredSize(new java.awt.Dimension(170, 35));
        bgBtnIniciarAluguel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bgBtnIniciarAluguel2MouseEntered(evt);
            }
        });

        btnIniciarAluguel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIniciarAluguel2.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarAluguel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnIniciarAluguel2.setText("INICIAR ORDEM DE VENDA");
        btnIniciarAluguel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIniciarAluguel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarAluguel2MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout bgBtnIniciarAluguel2Layout = new javax.swing.GroupLayout(bgBtnIniciarAluguel2);
        bgBtnIniciarAluguel2.setLayout(bgBtnIniciarAluguel2Layout);
        bgBtnIniciarAluguel2Layout.setHorizontalGroup(
            bgBtnIniciarAluguel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnIniciarAluguel2, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        bgBtnIniciarAluguel2Layout.setVerticalGroup(
            bgBtnIniciarAluguel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnIniciarAluguel2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

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

        jComboBoxModelo.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxModelo.setForeground(new java.awt.Color(1, 132, 222));
        jComboBoxModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxModelo.setBorder(null);
        jComboBoxModelo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBoxModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxModeloActionPerformed(evt);
            }
        });

        bgBtnAlugarVeiculo.setBackground(new java.awt.Color(1, 132, 222));
        bgBtnAlugarVeiculo.setForeground(new java.awt.Color(255, 255, 255));
        bgBtnAlugarVeiculo.setPreferredSize(new java.awt.Dimension(170, 35));
        bgBtnAlugarVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bgBtnAlugarVeiculoMouseEntered(evt);
            }
        });

        btnAlugarVeiculo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAlugarVeiculo.setForeground(new java.awt.Color(255, 255, 255));
        btnAlugarVeiculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAlugarVeiculo.setText("ALUGAR ESTE VEÍCULO");
        btnAlugarVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlugarVeiculoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAlugarVeiculoMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout bgBtnAlugarVeiculoLayout = new javax.swing.GroupLayout(bgBtnAlugarVeiculo);
        bgBtnAlugarVeiculo.setLayout(bgBtnAlugarVeiculoLayout);
        bgBtnAlugarVeiculoLayout.setHorizontalGroup(
            bgBtnAlugarVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlugarVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );
        bgBtnAlugarVeiculoLayout.setVerticalGroup(
            bgBtnAlugarVeiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAlugarVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgBackgroundLayout = new javax.swing.GroupLayout(bgBackground);
        bgBackground.setLayout(bgBackgroundLayout);
        bgBackgroundLayout.setHorizontalGroup(
            bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBackgroundLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addComponent(cpUser, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpData, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logoNeuron, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE))
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
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxCorVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAddColor))
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxMarcas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addGap(4, 4, 4)
                                        .addComponent(jTextFieldRenavamVeiculo))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                                        .addComponent(bgBtnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bgBtnInserir3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(55, 55, 55)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxTipoCombustivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBoxTipoVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgBackgroundLayout.createSequentialGroup()
                                                        .addComponent(jLabel11)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldAno))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgBackgroundLayout.createSequentialGroup()
                                                        .addComponent(jLabel16)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jComboBoxDisponivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(12, 12, 12))
                                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                .addComponent(bgBtnAlugarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel15))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextFieldDataCompra)
                                                    .addComponent(jTextFieldDataVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
                                            .addComponent(bgBtnIniciarAluguel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addComponent(saidaStatusOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtQtdeResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQtdeResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saidaStatusOperacao))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTextFieldRenavamVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBoxMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jComboBoxCorVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAddColor))
                        .addGap(22, 22, 22)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bgBtnInserir3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bgBtnInserir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jComboBoxTipoCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jComboBoxTipoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jTextFieldDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextFieldDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jComboBoxDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bgBtnIniciarAluguel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bgBtnAlugarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpUser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoNeuron, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void ImprimirGrid(ArrayList<Veiculo> listaDeVeiculo) {
        try {
            DefaultTableModel veiculo = (DefaultTableModel) tabelaVeiculo.getModel();
            TabelaImagem tabelaImagem = new TabelaImagem();
            //set imagem no grid
            tabelaVeiculo.getColumnModel().getColumn(4).setCellRenderer(tabelaImagem);

            ImageIcon logoMarcaCell;

            //Limpa a tabela 
            veiculo.setNumRows(0); //setar numero de linhas exibidas para 0
            Iterator<Veiculo> lista = listaDeVeiculo.iterator();

            while (lista.hasNext()) {
                String[] grid = new String[15];
                Veiculo listaVeiculo = lista.next();
                grid[0] = listaVeiculo.getIdVeiculo() + "";
                grid[1] = listaVeiculo.getCor();
                grid[2] = listaVeiculo.getNomeModelo();
                grid[3] = listaVeiculo.getDisponivel() + "";
                grid[4] = listaVeiculo.getNomeMarca();
                grid[5] = listaVeiculo.getPlaca();
                grid[6] = listaVeiculo.getAnoFabricacao() + "";
                grid[7] = listaVeiculo.getTipoCombustivel().toString();
                grid[8] = listaVeiculo.getQulometragem() + "";
                grid[9] = listaVeiculo.getTipoVeiculo() + "";

                //logoCell = new ImageIcon(listaVeiculo.getDirFotoModelo());
                logoMarcaCell = new ImageIcon("./src/com/neuron/icons/logo/" + grid[4] + ".jpeg");
                veiculo.addRow(new Object[]{grid[0], grid[1], grid[2], grid[3], logoMarcaCell, grid[5], grid[6], grid[7], grid[8], grid[9]});

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
        jTextFieldPlacaVeiculo.setText("");

    }

    public void carregarComboBoxMarcas() throws Exception {
        String[] array = interControle.listagemNomeMarcas().toArray(new String[interControle.listagemNomeMarcas().size()]);
        jComboBoxMarcas.removeAllItems();
        for (String item : array) {
            jComboBoxMarcas.addItem(item);
        }
    }

    public void carregarComboBoxModelo() throws Exception {
        String[] array = interControle.listagemNomeModelo().toArray(new String[interControle.listagemNomeModelo().size()]);
        jComboBoxModelo.removeAllItems();
        for (String item : array) {
            jComboBoxModelo.addItem(item);
        }
    }

    public void carregarComboBoxCores() throws Exception {
        String[] arrayCores = interControle.listagemCores().toArray(new String[interControle.listagemCores().size()]);
        jComboBoxCorVeiculo.removeAllItems();
        for (String cor : arrayCores) {
            jComboBoxCorVeiculo.addItem(cor);
        }
    }

    public void carregarComboBoxTipoCombustivel() throws Exception {
        String[] arrayCombustivel = interControle.listarTipoCombustivel().toArray(new String[interControle.listarTipoCombustivel().size()]);
        jComboBoxTipoCombustivel.removeAllItems();
        for (String combustivel : arrayCombustivel) {
            jComboBoxTipoCombustivel.addItem(combustivel);
        }
    }

    public void carregarComboBoxTipoVeiculo() throws Exception {
        String[] arrayVeiculo = interControle.listarTipoVeiculo().toArray(new String[interControle.listarTipoVeiculo().size()]);
        jComboBoxTipoVeiculo.removeAllItems();
        for (String veiculo : arrayVeiculo) {
            jComboBoxTipoVeiculo.addItem(veiculo);
        }
    }

    public void carregarComboBoxDisponivel() throws Exception {
        String[] arrayDispo = interControle.listarDisponivel().toArray(new String[interControle.listarDisponivel().size()]);
        jComboBoxDisponivel.removeAllItems();
        for (String dispo : arrayDispo) {
            jComboBoxDisponivel.addItem(dispo);
        }
    }

    public void resizeColunas() {
        TableColumnModel tCM = tabelaVeiculo.getColumnModel();
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

    private void btnAddColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddColorMouseClicked
        try {
            String cor = JOptionPane.showInputDialog("Informe o nome da Cor desejada: ");
            interControle.inserirNovaCor(cor);
            carregarComboBoxCores();
            JOptionPane.showMessageDialog(this, "Cor " + cor + " inserida com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnAddColorMouseClicked

    private void jComboBoxDisponivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDisponivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDisponivelActionPerformed

    private void jComboBoxTipoVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoVeiculoActionPerformed

    private void jComboBoxTipoCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoCombustivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoCombustivelActionPerformed

    private void jTextFieldAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnoActionPerformed

    private void jComboBoxCorVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCorVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCorVeiculoActionPerformed

    private void jTextFieldRenavamVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRenavamVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRenavamVeiculoActionPerformed

    private void btnVoltarPagAntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarPagAntMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnVoltarPagAntMouseClicked

    private void btnAttListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttListaMouseClicked
        try {
            ImprimirGrid(interControle.listagemVeiculo());
            Logs.logger("lista de Marcas atualizada com sucesso!", telaMarcaCarros.class.getName());
        } catch (Exception ex) {
            Logs.logger("Nao foi atualizada a lista!", telaMarcaCarros.class.getName());
        }
    }//GEN-LAST:event_btnAttListaMouseClicked

    private void btnAlterarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarMouseEntered

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        try {
            //int auxID = (Integer.parseInt(saidaID.getText()));
            //interControle.alterarModelo(auxID, cpInserir.getText().toUpperCase(), "./src/com/neuron/icons" + saidaDiretorio.getText(),idCombo);
            //ImprimirGrid(interControle.listagemModelo());
            JOptionPane.showMessageDialog(this, "Modelo " + jTextFieldPlacaVeiculo.getText().toUpperCase() + " alterado com sucesso!");
            //cpInfoAdicional.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        limparTela();
    }//GEN-LAST:event_btnAlterarMouseClicked

    private void btnInserirVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInserirVeiculoMouseClicked
        try {
            String cor = jComboBoxCorVeiculo.getSelectedItem().toString();
            String modelo = jComboBoxModelo.getSelectedItem().toString();
            Disponibilidade dispo = Get.disponibilidadeByNome(jComboBoxDisponivel.getSelectedItem().toString());
            String marca = jComboBoxMarcas.getSelectedItem().toString();
            String placa = jTextFieldPlacaVeiculo.getText();
            String anoFabri = jTextFieldAno.getText();
            TipoCombustivel tipo = Get.combustivelByNome(jComboBoxTipoCombustivel.getSelectedItem().toString());
            int quilometro = 0;
            TipoVeiculo tipoVeiculo = Get.TipoVeiculoByNome(jComboBoxTipoVeiculo.getSelectedItem().toString());
            int renavam = Integer.parseInt(jTextFieldRenavamVeiculo.getText());
            float precoCompra =  0;
            float precoVenda = 0;
            String dataCompra = jTextFieldDataCompra.getText();
            String dataVenda = jTextFieldDataVenda.getText();
            int idModelo = Get.IDModeloSelecionado(modelo);
            Veiculo v = new Veiculo(0,cor,modelo,dispo,marca,placa,anoFabri,tipo,quilometro,tipoVeiculo,renavam,precoCompra,precoVenda,dataCompra,dataVenda,idModelo);
            
            interControle.incluirVeiculo(v);
            //ImprimirGrid(interControle.listagemModelo());
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(this, "Erro Inserir novo Cadastro\n" + erro.getMessage());
        }

        jTextFieldPlacaVeiculo.setText("");
        //saidaLogo.setIcon(null);

        Logs.logger("Limpeza da tela e lista atualizada disponível na tela Modelos", getThisClass());
    }//GEN-LAST:event_btnInserirVeiculoMouseClicked

    private void jTextFieldPlacaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPlacaVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPlacaVeiculoActionPerformed

    private void tabelaVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVeiculoMouseClicked

        try {
            caminhoArquivo = (String) this.tabelaVeiculo.getValueAt(tabelaVeiculo.getSelectedRow(), 3);
            String nomeMarcaSelecionado = this.tabelaVeiculo.getValueAt(tabelaVeiculo.getSelectedRow(), 4) + "";
            nomeMarcaSelecionado = nomeMarcaSelecionado.replace("./src/com/neuron/icons/logo/", "");
            nomeMarcaSelecionado = nomeMarcaSelecionado.replace(".jpeg", "");
            String idSelecionado = (String) this.tabelaVeiculo.getValueAt(tabelaVeiculo.getSelectedRow(), 0);

            Iterator<Veiculo> lista = interControle.listagemVeiculo().iterator();

            while (lista.hasNext()) {
                String[] grid = new String[15];
                Veiculo listaVeiculo = lista.next();
                grid[0] = "" + listaVeiculo.getIdVeiculo();
                if (grid[0].equals(idSelecionado)) {
                    jTextFieldRenavamVeiculo.setText(listaVeiculo.getRenavan() + "");
                    jTextFieldDataCompra.setText(listaVeiculo.getDataCompra());
                    jTextFieldDataVenda.setText(listaVeiculo.getDataVenda());
                }

            }

            this.jTextFieldPlacaVeiculo.setText((String) this.tabelaVeiculo.getValueAt(tabelaVeiculo.getSelectedRow(), 5));
            jComboBoxMarcas.setSelectedItem(nomeMarcaSelecionado);
            jComboBoxModelo.setSelectedItem((String) this.tabelaVeiculo.getValueAt(tabelaVeiculo.getSelectedRow(), 2));
            jComboBoxCorVeiculo.setSelectedItem((String) this.tabelaVeiculo.getValueAt(tabelaVeiculo.getSelectedRow(), 1));
            jComboBoxTipoCombustivel.setSelectedItem((String) this.tabelaVeiculo.getValueAt(tabelaVeiculo.getSelectedRow(), 7));
            jComboBoxTipoVeiculo.setSelectedItem((String) this.tabelaVeiculo.getValueAt(tabelaVeiculo.getSelectedRow(), 9));
            jComboBoxDisponivel.setSelectedItem((String) this.tabelaVeiculo.getValueAt(tabelaVeiculo.getSelectedRow(), 3));
            this.jTextFieldAno.setText((String) this.tabelaVeiculo.getValueAt(tabelaVeiculo.getSelectedRow(), 6));

        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err);
            Logs.logger(err.getMessage(), getThisClass());
        }
    }//GEN-LAST:event_tabelaVeiculoMouseClicked

    private void bgBtnIniciarAluguel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgBtnIniciarAluguel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bgBtnIniciarAluguel2MouseEntered

    private void btnIniciarAluguel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarAluguel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarAluguel2MouseClicked

    private void btnIniciarAluguel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarAluguel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarAluguel2MouseEntered

    private void jComboBoxMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMarcasActionPerformed

    private void jComboBoxModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxModeloActionPerformed

    private void bgBtnAlugarVeiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgBtnAlugarVeiculoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bgBtnAlugarVeiculoMouseEntered

    private void btnAlugarVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlugarVeiculoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlugarVeiculoMouseClicked

    private void btnAlugarVeiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlugarVeiculoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlugarVeiculoMouseEntered

    private void btnInserirVeiculoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInserirVeiculoMouseEntered
        bgBtnInserir.setBackground(azulHover);
    }//GEN-LAST:event_btnInserirVeiculoMouseEntered

    private void btnInserirVeiculoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInserirVeiculoMouseExited
        bgBtnInserir.setBackground(azulPadrao);
    }//GEN-LAST:event_btnInserirVeiculoMouseExited

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
            java.util.logging.Logger.getLogger(telaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaVeiculo().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgBackground;
    private javax.swing.JPanel bgBtnAlugarVeiculo;
    private javax.swing.JPanel bgBtnIniciarAluguel2;
    private javax.swing.JPanel bgBtnInserir;
    private javax.swing.JPanel bgBtnInserir3;
    private javax.swing.JLabel btnAddColor;
    private javax.swing.JLabel btnAlterar;
    private javax.swing.JLabel btnAlugarVeiculo;
    private javax.swing.JLabel btnAttLista;
    private javax.swing.JLabel btnIniciarAluguel2;
    private javax.swing.JLabel btnInserirVeiculo;
    private javax.swing.JLabel btnVoltarPagAnt;
    private javax.swing.JLabel cpData;
    private javax.swing.JLabel cpUser;
    private javax.swing.JComboBox<String> jComboBoxCorVeiculo;
    private javax.swing.JComboBox<String> jComboBoxDisponivel;
    private javax.swing.JComboBox<String> jComboBoxMarcas;
    private javax.swing.JComboBox<String> jComboBoxModelo;
    private javax.swing.JComboBox<String> jComboBoxTipoCombustivel;
    private javax.swing.JComboBox<String> jComboBoxTipoVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JFormattedTextField jTextFieldDataCompra;
    private javax.swing.JFormattedTextField jTextFieldDataVenda;
    private javax.swing.JTextField jTextFieldPlacaVeiculo;
    private javax.swing.JTextField jTextFieldRenavamVeiculo;
    private javax.swing.JLabel logoNeuron;
    private javax.swing.JMenu menuLogOff;
    private javax.swing.JLabel saidaStatusOperacao;
    private javax.swing.JTable tabelaVeiculo;
    private javax.swing.JLabel txtQtdeResultados;
    // End of variables declaration//GEN-END:variables
}
