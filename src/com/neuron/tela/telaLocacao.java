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
import com.neuron.controle.control.*;
import com.neuron.icons.*;
import com.neuron.utils.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicMenuBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class telaLocacao extends javax.swing.JFrame {

    IControleOperacao interControle = new ControleOperacao();
    ISelecionarArq iArquivo = new SelecionarArq();
    String thisClass = "";
    String caminhoCNHSelecionado;
    IControladorImg iImg = new ControladorImg();
    Color azulHover = new Color(0, 23, 100, 255);
    Color azulPadrao = new Color(1, 132, 222, 255);
    Color verdeHover = new Color(51, 186, 0, 255);
    Color amareloHover = new Color(250, 196, 0, 255);

    public telaLocacao() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Veículos");
        
        try {
            menuLogOff.setVisible(false);
            customizeMenuBar(jMenuBar); //customizar menu
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        datahora(); //data e hora no sistema
        resizeColunas(); //tamanho colunas   
        
        //listar veiculos
        try { 
            if (!interControle.listagemVeiculo().isEmpty() || interControle.listagemVeiculo()!= null) {
                ImprimirGridVeiculo(interControle.listagemVeiculo());
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
            Logs.logger(erro.getMessage(), getThisClass());
        }
        
        //listar clientes
        try { 
            if (!interControle.listarCliente().isEmpty() || interControle.listarCliente()!= null) {
                ImprimirGridCliente(interControle.listarCliente());
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
        tabelaCarrosAlugar = new javax.swing.JTable();
        saidaStatusOperacao = new javax.swing.JLabel();
        bgBtnInserir = new javax.swing.JPanel();
        btnCadastrarMotorista = new javax.swing.JLabel();
        btnAttLista = new javax.swing.JLabel();
        btnVoltarPagAnt = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        txtQtdeResultados = new javax.swing.JLabel();
        jTextFieldBuscaVeiculo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBuscarVeiculo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldBuscaCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JLabel();
        jTextFieldDataEntrada = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldDataRetorno = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelCNHMotorista = new javax.swing.JLabel();
        jLabelNomeMotorista = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabelValorEstimado = new javax.swing.JLabel();
        jTextFieldValorRealEntrada = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabelValorCaucao = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldValorRealCaucao = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaMotivoAluguel = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldDiasAluguel = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        bgBtnInserir7 = new javax.swing.JPanel();
        btnRealizarAluguel = new javax.swing.JLabel();
        bgBtnInserir9 = new javax.swing.JPanel();
        btnRealizarDevolucao = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        menuLogOff = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bgBackground.setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(40, 106, 255));
        jLabel1.setText("Alocar Veículo");

        cpData.setForeground(new java.awt.Color(153, 153, 153));
        cpData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cpUser.setForeground(new java.awt.Color(153, 153, 153));
        cpUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        logoNeuron.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logoNeuron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/neuron/icons/logoMin.png"))); // NOI18N

        tabelaCarrosAlugar.setAutoCreateRowSorter(true);
        tabelaCarrosAlugar.setBackground(new java.awt.Color(255, 255, 255));
        tabelaCarrosAlugar.setForeground(new java.awt.Color(1, 75, 222));
        tabelaCarrosAlugar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Placa", "Cor", "Modelo", "Marca", "Combustível"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCarrosAlugar.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaCarrosAlugar.setRowHeight(40);
        tabelaCarrosAlugar.setSelectionBackground(new java.awt.Color(1, 132, 222));
        tabelaCarrosAlugar.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabelaCarrosAlugar.getTableHeader().setReorderingAllowed(false);
        tabelaCarrosAlugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCarrosAlugarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCarrosAlugar);
        tabelaCarrosAlugar.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        saidaStatusOperacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saidaStatusOperacao.setForeground(new java.awt.Color(1, 132, 222));

        bgBtnInserir.setBackground(new java.awt.Color(1, 132, 222));

        btnCadastrarMotorista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrarMotorista.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrarMotorista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCadastrarMotorista.setText("CADASTRAR MOTORISTA");
        btnCadastrarMotorista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastrarMotoristaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCadastrarMotoristaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCadastrarMotoristaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgBtnInserirLayout = new javax.swing.GroupLayout(bgBtnInserir);
        bgBtnInserir.setLayout(bgBtnInserirLayout);
        bgBtnInserirLayout.setHorizontalGroup(
            bgBtnInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCadastrarMotorista, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );
        bgBtnInserirLayout.setVerticalGroup(
            bgBtnInserirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCadastrarMotorista, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
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

        tabelaCliente.setAutoCreateRowSorter(true);
        tabelaCliente.setBackground(new java.awt.Color(255, 255, 255));
        tabelaCliente.setForeground(new java.awt.Color(1, 75, 222));
        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Cliente", "Nome", "CPF/CNPJ", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaCliente.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaCliente.setRowHeight(40);
        tabelaCliente.setSelectionBackground(new java.awt.Color(1, 132, 222));
        tabelaCliente.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabelaCliente.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelaCliente);

        txtQtdeResultados.setBackground(new java.awt.Color(250, 250, 250));
        txtQtdeResultados.setForeground(new java.awt.Color(100, 210, 243));
        txtQtdeResultados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtQtdeResultados.setText("n Veículos disponíveis para alugar.");

        jTextFieldBuscaVeiculo.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldBuscaVeiculo.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldBuscaVeiculo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldBuscaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscaVeiculoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 132, 222));
        jLabel2.setText("Buscar Veiculo:");

        btnBuscarVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/neuron/icons/search_icon.png"))); // NOI18N
        btnBuscarVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarVeiculoMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 132, 222));
        jLabel3.setText("Buscar Cliente:");

        jTextFieldBuscaCliente.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldBuscaCliente.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldBuscaCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscaClienteActionPerformed(evt);
            }
        });

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/neuron/icons/search_icon.png"))); // NOI18N
        btnBuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarClienteMouseClicked(evt);
            }
        });

        jTextFieldDataEntrada.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldDataEntrada.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldDataEntrada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldDataEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataEntradaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(1, 132, 222));
        jLabel15.setText("Data Entrada:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(1, 132, 222));
        jLabel16.setText("Data Retorno:");

        jTextFieldDataRetorno.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldDataRetorno.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldDataRetorno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldDataRetorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataRetornoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(1, 132, 222));
        jLabel17.setText("Motorista:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(1, 132, 222));
        jLabel18.setText("CNH:");

        jLabelCNHMotorista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCNHMotorista.setForeground(new java.awt.Color(1, 132, 222));
        jLabelCNHMotorista.setText("123456789010");

        jLabelNomeMotorista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNomeMotorista.setForeground(new java.awt.Color(1, 132, 222));
        jLabelNomeMotorista.setText("NOME MOTORISTA");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(1, 132, 222));
        jLabel20.setText("Valor Estimado:");

        jLabelValorEstimado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelValorEstimado.setForeground(new java.awt.Color(1, 132, 222));
        jLabelValorEstimado.setText("R$ 99999,00");

        jTextFieldValorRealEntrada.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldValorRealEntrada.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldValorRealEntrada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldValorRealEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorRealEntradaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(1, 132, 222));
        jLabel12.setText("Valor de Entrada:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(1, 132, 222));
        jLabel22.setText("Valor Caução:");

        jLabelValorCaucao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelValorCaucao.setForeground(new java.awt.Color(1, 132, 222));
        jLabelValorCaucao.setText("R$ 99999,00");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(1, 132, 222));
        jLabel13.setText("Valor Caução:");

        jTextFieldValorRealCaucao.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldValorRealCaucao.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldValorRealCaucao.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldValorRealCaucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorRealCaucaoActionPerformed(evt);
            }
        });

        jTextAreaMotivoAluguel.setBackground(new java.awt.Color(255, 255, 255));
        jTextAreaMotivoAluguel.setColumns(20);
        jTextAreaMotivoAluguel.setForeground(new java.awt.Color(1, 132, 222));
        jTextAreaMotivoAluguel.setRows(5);
        jTextAreaMotivoAluguel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 132, 222)));
        jScrollPane3.setViewportView(jTextAreaMotivoAluguel);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(1, 132, 222));
        jLabel24.setText("Motivo do Aluguel do Carro:");

        jTextFieldDiasAluguel.setBackground(new java.awt.Color(250, 250, 250));
        jTextFieldDiasAluguel.setForeground(new java.awt.Color(1, 132, 222));
        jTextFieldDiasAluguel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 132, 222), 1, true));
        jTextFieldDiasAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDiasAluguelActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(1, 132, 222));
        jLabel21.setText("Dias de Aluguel:");

        bgBtnInserir7.setBackground(new java.awt.Color(1, 132, 222));

        btnRealizarAluguel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRealizarAluguel.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizarAluguel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRealizarAluguel.setText("ALUGAR");
        btnRealizarAluguel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRealizarAluguelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRealizarAluguelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRealizarAluguelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgBtnInserir7Layout = new javax.swing.GroupLayout(bgBtnInserir7);
        bgBtnInserir7.setLayout(bgBtnInserir7Layout);
        bgBtnInserir7Layout.setHorizontalGroup(
            bgBtnInserir7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRealizarAluguel, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );
        bgBtnInserir7Layout.setVerticalGroup(
            bgBtnInserir7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRealizarAluguel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        bgBtnInserir9.setBackground(new java.awt.Color(1, 132, 222));

        btnRealizarDevolucao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRealizarDevolucao.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizarDevolucao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRealizarDevolucao.setText("DEVOLVER");
        btnRealizarDevolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRealizarDevolucaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRealizarDevolucaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRealizarDevolucaoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout bgBtnInserir9Layout = new javax.swing.GroupLayout(bgBtnInserir9);
        bgBtnInserir9.setLayout(bgBtnInserir9Layout);
        bgBtnInserir9Layout.setHorizontalGroup(
            bgBtnInserir9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRealizarDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        bgBtnInserir9Layout.setVerticalGroup(
            bgBtnInserir9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRealizarDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bgBackgroundLayout = new javax.swing.GroupLayout(bgBackground);
        bgBackground.setLayout(bgBackgroundLayout);
        bgBackgroundLayout.setHorizontalGroup(
            bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBackgroundLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgBackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAttLista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVoltarPagAnt)
                        .addGap(21, 21, 21))
                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addComponent(cpUser, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(cpData, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logoNeuron, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(txtQtdeResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                        .addComponent(saidaStatusOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(38, 38, 38))))
                                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelNomeMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel18)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabelCNHMotorista))
                                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextFieldBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnBuscarCliente))
                                            .addComponent(bgBtnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                        .addComponent(jLabel22)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabelValorCaucao, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgBackgroundLayout.createSequentialGroup()
                                                        .addComponent(jLabel20)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelValorEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel13))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldValorRealCaucao)
                                                    .addComponent(jTextFieldValorRealEntrada)))
                                            .addComponent(jScrollPane3)
                                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addGap(8, 8, 8)
                                                .addComponent(jTextFieldDiasAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel24)
                                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addGap(8, 8, 8)
                                                .addComponent(jTextFieldDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(bgBackgroundLayout.createSequentialGroup()
                                                .addComponent(bgBtnInserir7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                                .addComponent(bgBtnInserir9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(bgBackgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldBuscaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscarVeiculo)))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saidaStatusOperacao)
                .addGap(9, 9, 9)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextFieldBuscaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQtdeResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarVeiculo))
                .addGap(37, 37, 37)
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jTextFieldBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuscarCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabelNomeMotorista)
                            .addComponent(jLabel18)
                            .addComponent(jLabelCNHMotorista))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBackgroundLayout.createSequentialGroup()
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextFieldDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jTextFieldDataRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jTextFieldDiasAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabelValorEstimado)
                            .addComponent(jLabel12)
                            .addComponent(jTextFieldValorRealEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabelValorCaucao)
                            .addComponent(jLabel13)
                            .addComponent(jTextFieldValorRealCaucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGroup(bgBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bgBtnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bgBtnInserir7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bgBtnInserir9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void ImprimirGridVeiculo(ArrayList<Veiculo> listaDeCarros) {
        try {
            DefaultTableModel veiculo = (DefaultTableModel) tabelaCarrosAlugar.getModel();
            //Limpa a tabela 
            veiculo.setNumRows(0); //setar numero de linhas exibidas para 0
            Iterator<Veiculo> lista = listaDeCarros.iterator();

            while (lista.hasNext()) {
                String[] grid = new String[7];
                Veiculo aux = lista.next();
                grid[0] = aux.getIdVeiculo()+"";
                grid[1] = aux.getPlaca();
                grid[2] = aux.getCor()+ "";
                grid[3] = aux.getNomeModelo();
                grid[4] = aux.getNomeMarca();
                grid[5] = aux.getTipoCombustivel()+"";

                veiculo.addRow(new Object[]{grid[0],grid[1],grid[2],grid[3],grid[4],grid[5]});

            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }
    
    private void ImprimirGridCliente(ArrayList<Cliente> listaDeClientes) {
        try {
            DefaultTableModel veiculo = (DefaultTableModel) tabelaCliente.getModel();
            //Limpa a tabela 
            veiculo.setNumRows(0); //setar numero de linhas exibidas para 0
            Iterator<Cliente> lista = listaDeClientes.iterator();

            while (lista.hasNext()) {
                String[] grid = new String[4];
                Cliente aux = lista.next();
                grid[0] = aux.getId() + "";
                grid[1] = aux.getNomeRazaoSocial()+"";
                grid[2] = aux.getCpfCnpj();
                grid[3] = aux.getDDI()+ "(" + aux.getDDD() + ")" + aux.getNumero();

                veiculo.addRow(new Object[]{grid[0],grid[1],grid[2],grid[3]});

            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
        }
    }

       
    public void resizeColunas() {
        TableColumnModel tCM = tabelaCarrosAlugar.getColumnModel();
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

    private void btnVoltarPagAntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarPagAntMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnVoltarPagAntMouseClicked

    private void btnAttListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAttListaMouseClicked
        try {
            ImprimirGridVeiculo(interControle.listagemVeiculo());
            Logs.logger("lista de Veiculos disponiveis para alugar atualizada com sucesso!", telaLocacao.class.getName());
        } catch (Exception ex) {
            Logs.logger("Nao foi atualizada a lista!", telaLocacao.class.getName());
        }
    }//GEN-LAST:event_btnAttListaMouseClicked

    private void btnCadastrarMotoristaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMotoristaMouseExited
        bgBtnInserir.setBackground(azulPadrao);
    }//GEN-LAST:event_btnCadastrarMotoristaMouseExited

    private void btnCadastrarMotoristaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMotoristaMouseEntered
        bgBtnInserir.setBackground(verdeHover);
    }//GEN-LAST:event_btnCadastrarMotoristaMouseEntered
    
    private void btnCadastrarMotoristaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMotoristaMouseClicked
        try {
            telaMotorista.setVisible(true);
            this.dispose();
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(this, "Erro Inserir novo Cadastro\n" + erro.getMessage());
        }

        //jTextFieldNomeRazao.setText("");
        //saidaLogo.setIcon(null);

        Logs.logger("Limpeza da tela e lista atualizada disponível na tela", getThisClass());
    }//GEN-LAST:event_btnCadastrarMotoristaMouseClicked

    private void tabelaCarrosAlugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCarrosAlugarMouseClicked
        
        try {
            int idSelecionado = Integer.parseInt((String) this.tabelaCarrosAlugar.getValueAt(tabelaCarrosAlugar.getSelectedRow(), 0) );
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        
    }//GEN-LAST:event_tabelaCarrosAlugarMouseClicked

    private void jTextFieldBuscaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscaVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscaVeiculoActionPerformed

    private void btnBuscarVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarVeiculoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarVeiculoMouseClicked

    private void jTextFieldBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscaClienteActionPerformed

    private void btnBuscarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarClienteMouseClicked

    private void jTextFieldDataEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataEntradaActionPerformed

    private void jTextFieldDataRetornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataRetornoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataRetornoActionPerformed

    private void jTextFieldValorRealEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorRealEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorRealEntradaActionPerformed

    private void jTextFieldValorRealCaucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorRealCaucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorRealCaucaoActionPerformed

    private void jTextFieldDiasAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDiasAluguelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDiasAluguelActionPerformed

    private void btnRealizarAluguelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRealizarAluguelMouseClicked
        
        try {
            
            int idOperacao = 0;
            String dataEntrada = jTextFieldDataEntrada.getText();
            String dataSaida = jTextFieldDataRetorno.getText();
            int diasAlugado = Integer.parseInt(jTextFieldDiasAluguel.getText());
            float QtdeLitrosCombustivel = 0;
            float vlrEstimadoAluguel = Float.parseFloat(jLabelValorEstimado.getText());
            float vlrEstimadoCaucao = Float.parseFloat(jLabelValorCaucao.getText());
            float vlrRealAluguel = Float.parseFloat(jTextFieldValorRealEntrada.getText());
            float vlrRealCaucao = Float.parseFloat(jTextFieldValorRealCaucao.getText());
            int idVeiculo = Integer.parseInt((String) this.tabelaCarrosAlugar.getValueAt(tabelaCarrosAlugar.getSelectedRow(), 0));
            int idModelo = 0 ;
            int idMarca = 0;
            int idCliente = Integer.parseInt((String) this.tabelaCliente.getValueAt(tabelaCliente.getSelectedRow(), 0));
            int idMotorista = 0;
            String motivo;
            Operacao op = new Operacao(idOperacao,dataEntrada,dataSaida,diasAlugado,QtdeLitrosCombustivel,vlrEstimadoAluguel,vlrEstimadoCaucao,
            vlrRealAluguel,vlrRealCaucao,idVeiculo,idModelo,idMarca,idCliente,idMotorista,motivo);
            
        } catch (Exception e) {
        }



    }//GEN-LAST:event_btnRealizarAluguelMouseClicked

    private void btnRealizarAluguelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRealizarAluguelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRealizarAluguelMouseEntered

    private void btnRealizarAluguelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRealizarAluguelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRealizarAluguelMouseExited

    private void btnRealizarDevolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRealizarDevolucaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRealizarDevolucaoMouseClicked

    private void btnRealizarDevolucaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRealizarDevolucaoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRealizarDevolucaoMouseEntered

    private void btnRealizarDevolucaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRealizarDevolucaoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRealizarDevolucaoMouseExited

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
            java.util.logging.Logger.getLogger(telaLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaLocacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new telaLocacao().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgBackground;
    private javax.swing.JPanel bgBtnInserir;
    private javax.swing.JPanel bgBtnInserir1;
    private javax.swing.JPanel bgBtnInserir2;
    private javax.swing.JPanel bgBtnInserir3;
    private javax.swing.JPanel bgBtnInserir4;
    private javax.swing.JPanel bgBtnInserir5;
    private javax.swing.JPanel bgBtnInserir7;
    private javax.swing.JPanel bgBtnInserir8;
    private javax.swing.JPanel bgBtnInserir9;
    private javax.swing.JLabel btnAttLista;
    private javax.swing.JLabel btnBuscarCliente;
    private javax.swing.JLabel btnBuscarVeiculo;
    private javax.swing.JLabel btnCadastrarMotorista;
    private javax.swing.JLabel btnInserirCliente1;
    private javax.swing.JLabel btnInserirCliente2;
    private javax.swing.JLabel btnInserirCliente3;
    private javax.swing.JLabel btnInserirCliente4;
    private javax.swing.JLabel btnInserirCliente5;
    private javax.swing.JLabel btnRealizarAluguel;
    private javax.swing.JLabel btnRealizarAluguel1;
    private javax.swing.JLabel btnRealizarDevolucao;
    private javax.swing.JLabel btnVoltarPagAnt;
    private javax.swing.JLabel cpData;
    private javax.swing.JLabel cpUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCNHMotorista;
    private javax.swing.JLabel jLabelNomeMotorista;
    private javax.swing.JLabel jLabelValorCaucao;
    private javax.swing.JLabel jLabelValorEstimado;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextAreaMotivoAluguel;
    private javax.swing.JTextField jTextFieldBuscaCliente;
    private javax.swing.JTextField jTextFieldBuscaVeiculo;
    private javax.swing.JTextField jTextFieldDataEntrada;
    private javax.swing.JTextField jTextFieldDataRetorno;
    private javax.swing.JTextField jTextFieldDiasAluguel;
    private javax.swing.JTextField jTextFieldValorRealCaucao;
    private javax.swing.JTextField jTextFieldValorRealEntrada;
    private javax.swing.JLabel logoNeuron;
    private javax.swing.JMenu menuLogOff;
    private javax.swing.JLabel saidaStatusOperacao;
    private javax.swing.JTable tabelaCarrosAlugar;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JLabel txtQtdeResultados;
    // End of variables declaration//GEN-END:variables
}
