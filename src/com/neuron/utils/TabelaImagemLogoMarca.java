/******** About this Software *********
 
@Author Thiago Chirana 
@Github https://github.com/othiagomacedo
@Email thiago.chirana@gmail.com
@Year 2022
@Course Software Engineering
@College FATESG Senai
  
 ************* enjoy ******************/

package com.neuron.utils;


import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author aluno
 */
public class TabelaImagemLogoMarca extends DefaultTableCellRenderer {

    JLabel icone = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        if (isSelected) {
            this.setBackground(table.getBackground());
            this.setForeground(table.getForeground());
        } else {
            this.setBackground(table.getBackground());
            this.setForeground(table.getForeground());
        }

        if (value != null) {
            ImageIcon iconLogo = new ImageIcon("./src/com/neuron/icons/logo/"+table.getValueAt(row, 2).toString()+".jpeg");
            int tamanho = table.getRowHeight();
            int recuo = 20 * tamanho / 100;
            //icone.setText((String) value);
            iconLogo.setImage(iconLogo.getImage().getScaledInstance(tamanho - recuo, tamanho - recuo, 1));
            icone.setIcon(iconLogo);
        }

        icone.setHorizontalAlignment(JLabel.LEFT);
        return icone;
    }
}

// Software developed by Thiago Macedo -> https://github.com/othiagomacedo
