/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Transaksi extends javax.swing.JFrame {
    //variable id
    private int id = 0;
    //varable code
    private String code;
    //Jcombo box model
    private DefaultComboBoxModel cbModel;
    //Jtable Model
    private DefaultTableModel tbModel;
    //arraylist untuk menyimbpan transaksi
    private  ArrayList<Item> cart = new ArrayList<>();
    
    public Transaksi(){
        ComboModel comboModel = new ComboModel();
        this.cbModel = new DefaultComboBoxModel<>(comboModel.getNama().toArray()); // Set Combo items
        
        TableModel tableModel = new TableModel(); 
        this.tbModel = new DefaultTableModel(tableModel.getColumnName(), 0); // Set Table Column name
        
        initComponents();
    }
    
    //function setCode
    private String setCode() {
        this.incId();
        // get Current date as String;
        String dt = new SimpleDateFormat("yyMMdd").format(new Date());
        // then merge it with id with 0 pad
        this.code = String.format(dt+"%02d", this.id);  
        return code;
    }
    
    //penambahan id
    private void incId() {
        this.id += 1;
    }
    
    //pengurangan id
    private void decId() {
        this.id -= 1;
    }
    
    private Object[] addItem(String name, int qty) {
        float price = 0;
        ComboModel items = new ComboModel();
        for(int i = 0; i < items.getHarga().size(); i++) {
            if(name.equalsIgnoreCase(items.getNama().get(i))) {
                price = items.getHarga().get(i);
            }
        } 
        Object[] obj = {
          name,
          price,
          qty
        };
        return obj;
    }
    
    //update jumlah 
    
    
    //mengcek apakah ada duplikasi atau tidak
    private boolean isDuplicate(String name) {
        boolean result = false;
        ArrayList<String> item = new ArrayList<>();
        for (int i = 0; i < tbModel.getRowCount(); i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for(String i : item) {
            if(i.equals(name)) {
                result = true;
            } 
        }
        return result;
    } 
    
    //mengecek apakah table kosong
    private boolean isEmpty() {
        return this.listItem.getModel().getRowCount()<=0;
    }
    
    //disable remove dan save jika tabel kosong
    private void belanja() {
        if (isEmpty()) {
            this.saveButton.setEnabled(false) ;
            this.removeButton.setEnabled(false) ;
        } else {
            this.saveButton.setEnabled(true) ;
            this.removeButton.setEnabled(true) ;
        }
    }
    
    //commit newTransaksi ketika transaksi selsai
    private void newTransaksi () {
        this.jumlahItem.setText(" ") ;
        this.codeBrg.setText(" ") ;
        this.newButton.setEnabled(true) ;
        this.saveButton.setEnabled(false) ;
        this.cencelButton.setEnabled(false) ;
        this.addButton.setEnabled(false) ;
        this.removeButton.setEnabled(false) ;
        this.removeButton.setEnabled(false) ;
        this.jumlahItem.setEnabled(false) ;
        this.itemCombo.setEnabled(false) ;
        this.tbModel.setRowCount(0) ;
        this.cart.clear() ;
    }
    /**
     * Creates new form Transaksi
     */
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codeBrg = new javax.swing.JTextField();
        itemCombo = new javax.swing.JComboBox<>();
        jumlahItem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listItem = new javax.swing.JTable();
        newButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        cencelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Code");

        jLabel2.setText("Items");

        itemCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gula", "Kopi", "Susu" }));
        itemCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemComboActionPerformed(evt);
            }
        });

        listItem.setModel(this.tbModel);
        jScrollPane1.setViewportView(listItem);

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cencelButton.setText("Cencel");
        cencelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cencelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(itemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jumlahItem, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(codeBrg)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cencelButton)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codeBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(itemCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumlahItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cencelButton))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemComboActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        this.jumlahItem.setText("1");
        this.newButton.setEnabled(false);
        this.cencelButton.setEnabled(true);
        this.addButton.setEnabled(true);
        this.jumlahItem.setEnabled(true);
        this.itemCombo.setEnabled(true);
        this.codeBrg.setText(this.setCode());
    }//GEN-LAST:event_newButtonActionPerformed

    private void cencelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cencelButtonActionPerformed
        newTransaksi();
        this.decId();
    }//GEN-LAST:event_cencelButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if(listItem.getSelectedRow()<0) { // check if theres a row selected;
            String str = "Pilih item yang ingin dihapus !"; // if theres none, dialog will appear
            JOptionPane.showMessageDialog(this, str, "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int count = listItem.getSelectedRows().length; // if theres a row selected, a row will be removed
            for(int i = 0; i < count; i++) {
                tbModel.removeRow(listItem.getSelectedRow());
            }
        }
        this.belanja();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String nama = this.itemCombo.getSelectedItem().toString();
        int jumlah  = new Integer(this.jumlahItem.getText());
        if(isDuplicate(nama)) {
            updateJumlah(nama , jumlah);
        } else {
            tbModel.addRow(addItem(nama , jumlah)) ;
        }
        this.belanja() ;
    }//GEN-LAST:event_addButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            for (int i = 0; i < tbModel.getRowCount(); i++) {                   // loop each rows of the table then;
                String name = tbModel.getValueAt(i, 0).toString();              // store the name and the qty into variables then;
                float price = new Float(tbModel.getValueAt(i, 1).toString());   // add each result to cart global variable as an Item object 
                int qty = new Integer(tbModel.getValueAt(i, 2).toString());     //
                this.cart.add(new Item(name, price, qty));                      //
            }
            Pembayaran bayar = new Pembayaran(this.code, this.cart); // instantiate Transact class with the current code and previously ommited cart
            StringBuilder str = new StringBuilder(); // Stringbuilder to handle the transaction output
            str.append(bayar.prtDetail()); // append transaction output
            JOptionPane.showMessageDialog(this, str, "Detil Transaksi", JOptionPane.INFORMATION_MESSAGE); // call the dialog with the stringbuilder's string
            newTransaksi();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_saveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cencelButton;
    private javax.swing.JTextField codeBrg;
    private javax.swing.JComboBox<String> itemCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahItem;
    private javax.swing.JTable listItem;
    private javax.swing.JButton newButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
