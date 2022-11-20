/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.utils;

import com.neuron.persistencia.PermissaoUsuario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.jfr.events.FileWriteEvent;
import com.neuron.templates.DataBase;

public class GUI_Utils extends javax.swing.JFrame {

    /** Creates new form GUI_Utils */
    public GUI_Utils() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    // Software developed by Thiago Macedo -> https://github.com/othiagomacedo

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFNomeMarca = new javax.swing.JTextField();
        jLabelIDMarca = new javax.swing.JLabel();
        btnConsultaRetornaIDMarca = new javax.swing.JButton();
        jLabelNomeMarca = new javax.swing.JLabel();
        jTFIDMarca = new javax.swing.JTextField();
        btnConsultaRetornaNomeMarca = new javax.swing.JButton();
        jLabelIDMarca1 = new javax.swing.JLabel();
        btnCriaBanco = new javax.swing.JButton();
        jLabelPath = new javax.swing.JLabel();
        btnGetPath = new javax.swing.JButton();
        jTFBanco = new javax.swing.JTextField();
        jLabelPath1 = new javax.swing.JLabel();
        btnSaveENUM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GUI Utils");

        jTFNomeMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomeMarcaActionPerformed(evt);
            }
        });

        jLabelIDMarca.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDMarca.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIDMarca.setText("Consulta ID Marca");

        btnConsultaRetornaIDMarca.setBackground(new java.awt.Color(102, 255, 102));
        btnConsultaRetornaIDMarca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultaRetornaIDMarca.setForeground(new java.awt.Color(0, 102, 0));
        btnConsultaRetornaIDMarca.setText("CONSULTA ID");
        btnConsultaRetornaIDMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaRetornaIDMarcaActionPerformed(evt);
            }
        });

        jLabelNomeMarca.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomeMarca.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNomeMarca.setText("Consulta Marca pelo ID");

        jTFIDMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIDMarcaActionPerformed(evt);
            }
        });

        btnConsultaRetornaNomeMarca.setBackground(new java.awt.Color(102, 255, 102));
        btnConsultaRetornaNomeMarca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConsultaRetornaNomeMarca.setForeground(new java.awt.Color(0, 102, 0));
        btnConsultaRetornaNomeMarca.setText("CONSULTA MARCA");
        btnConsultaRetornaNomeMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaRetornaNomeMarcaActionPerformed(evt);
            }
        });

        jLabelIDMarca1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelIDMarca1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIDMarca1.setText("Criar Banco");

        btnCriaBanco.setBackground(new java.awt.Color(102, 255, 102));
        btnCriaBanco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCriaBanco.setForeground(new java.awt.Color(0, 102, 0));
        btnCriaBanco.setText("CRIA BANCO TXT");
        btnCriaBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriaBancoActionPerformed(evt);
            }
        });

        jLabelPath.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPath.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPath.setText("Get Path no Enum");

        btnGetPath.setBackground(new java.awt.Color(102, 255, 102));
        btnGetPath.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGetPath.setForeground(new java.awt.Color(0, 102, 0));
        btnGetPath.setText("GET PATH");
        btnGetPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetPathActionPerformed(evt);
            }
        });

        jTFBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFBancoActionPerformed(evt);
            }
        });

        jLabelPath1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelPath1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPath1.setText("Salva ENUM no txt teste");

        btnSaveENUM.setBackground(new java.awt.Color(102, 255, 102));
        btnSaveENUM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSaveENUM.setForeground(new java.awt.Color(0, 102, 0));
        btnSaveENUM.setText("SAVE ENUM");
        btnSaveENUM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveENUMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelNomeMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTFIDMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnConsultaRetornaNomeMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelIDMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTFNomeMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnConsultaRetornaIDMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabelIDMarca1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCriaBanco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGetPath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelPath1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveENUM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelIDMarca)
                        .addGap(4, 4, 4)
                        .addComponent(jTFNomeMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultaRetornaIDMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelIDMarca1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnCriaBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelPath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGetPath, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPath1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveENUM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelNomeMarca)
                        .addGap(4, 4, 4)
                        .addComponent(jTFIDMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultaRetornaNomeMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultaRetornaIDMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaRetornaIDMarcaActionPerformed

        try {
            jLabelIDMarca.setText(Gerador.getIDMarcaSelecionada(jTFNomeMarca.getText().toUpperCase())+"");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnConsultaRetornaIDMarcaActionPerformed

    private void jTFNomeMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomeMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNomeMarcaActionPerformed

    private void jTFIDMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIDMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIDMarcaActionPerformed

    private void btnConsultaRetornaNomeMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaRetornaNomeMarcaActionPerformed
        try {
            String NomeMarca = Gerador.getNomeMarcaByID(Integer.parseInt(jTFIDMarca.getText()));
            jLabelNomeMarca.setText(NomeMarca);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
            
    }//GEN-LAST:event_btnConsultaRetornaNomeMarcaActionPerformed

    private void btnCriaBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriaBancoActionPerformed
        try {
            Gerador.createDB(jTFBanco.getText());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnCriaBancoActionPerformed

    private void btnGetPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetPathActionPerformed
        
        jLabelPath.setText(DataBase.MARCA.getPathDB());
        
    }//GEN-LAST:event_btnGetPathActionPerformed

    private void jTFBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFBancoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFBancoActionPerformed

    private void btnSaveENUMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveENUMActionPerformed
        
        try {
            File file = new File("./src/com/neuron/database/dbUsers.txt");
            FileWriter fr = new FileWriter(file);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(PermissaoUsuario.ADMIN.toString());
            br.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnSaveENUMActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Utils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Utils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Utils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Utils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Utils().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultaRetornaIDMarca;
    private javax.swing.JButton btnConsultaRetornaNomeMarca;
    private javax.swing.JButton btnCriaBanco;
    private javax.swing.JButton btnGetPath;
    private javax.swing.JButton btnSaveENUM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelIDMarca;
    private javax.swing.JLabel jLabelIDMarca1;
    private javax.swing.JLabel jLabelNomeMarca;
    private javax.swing.JLabel jLabelPath;
    private javax.swing.JLabel jLabelPath1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFBanco;
    private javax.swing.JTextField jTFIDMarca;
    private javax.swing.JTextField jTFNomeMarca;
    // End of variables declaration//GEN-END:variables

}  

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo