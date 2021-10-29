/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepadsamu;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author samuel ludueña 2021
 */
public class Notepad1 extends javax.swing.JFrame {

    /**
     * Creates new form Notepad
     */
    public Notepad1() {
        initComponents();
     //   this.setExtendedState(6); /*esto es para que arranque maximizado. el 6 corresponde a maximized both*/
     
     
     this.setExtendedState(JFrame.MAXIMIZED_BOTH); /*otra forma de maximizar*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArch = new javax.swing.JMenu();
        jNuevo = new javax.swing.JMenuItem();
        jAbrir = new javax.swing.JMenuItem();
        jGuardar = new javax.swing.JMenuItem();
        jMenuOpc = new javax.swing.JMenu();
        jAcerca = new javax.swing.JMenuItem();
        jSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NotePad");

        jRadioButton1.setText("jRadioButton1");

        jArea.setColumns(20);
        jArea.setRows(5);
        jScrollPane1.setViewportView(jArea);

        jMenuArch.setText("Archivo");

        jNuevo.setText("Nuevo");
        jNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNuevoActionPerformed(evt);
            }
        });
        jMenuArch.add(jNuevo);

        jAbrir.setText("Abrir");
        jAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAbrirActionPerformed(evt);
            }
        });
        jMenuArch.add(jAbrir);

        jGuardar.setText("Guardar");
        jGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarActionPerformed(evt);
            }
        });
        jMenuArch.add(jGuardar);

        jMenuBar1.add(jMenuArch);

        jMenuOpc.setText("Opciones");

        jAcerca.setText("Acerca");
        jAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAcercaActionPerformed(evt);
            }
        });
        jMenuOpc.add(jAcerca);

        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });
        jMenuOpc.add(jSalir);

        jMenuBar1.add(jMenuOpc);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNuevoActionPerformed
    
        //si el usuario presiona 0, es que confirma como si en el metodo showconfirm
        
        
        
        if( !(jArea.getText().isEmpty()) &&
                JOptionPane.showConfirmDialog(this, "Desea borrar el texto ? ")==0){
         
         
            
            
            jArea.setText("");  //nos borra el contenido
            
     }
        
        
        
        
        
        
    }//GEN-LAST:event_jNuevoActionPerformed

    private void jGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarActionPerformed
       
        // nos abrira una ventana para buscar en donde guardar dicho archivo
        //esto hara que quede en la espera de que el usuario busque en donde guardar el archivo.
        
        JFileChooser fc = new JFileChooser();
        
        fc.showSaveDialog(fc);
        
        File file = fc.getSelectedFile();
        
        //si el archivo seleccionado es distinto de nulo, guardo
        if(file != null){
            
            FileText1 fileT = new FileText1(file);
            
            fileT.setText(jArea.getText());
            
        }
        
               
          
    }//GEN-LAST:event_jGuardarActionPerformed

    private void jAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAcercaActionPerformed
     JOptionPane.showMessageDialog(this, "by samu");
    }//GEN-LAST:event_jAcercaActionPerformed

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
   System.exit(0);
    }//GEN-LAST:event_jSalirActionPerformed

    private void jAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAbrirActionPerformed
       
        
        JFileChooser fc = new JFileChooser();
        
        fc.showOpenDialog(fc);
        
        File file = fc.getSelectedFile();
        
        //si el archivo seleccionado es distinto de nulo, guardo
        if(file != null){
            
            FileText1 fileT = new FileText1(file);
            
            jArea.setText(fileT.getText());
            
        }
        
        
        
        
        
    }//GEN-LAST:event_jAbrirActionPerformed


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
            java.util.logging.Logger.getLogger(Notepad1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notepad1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notepad1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notepad1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notepad1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAbrir;
    private javax.swing.JMenuItem jAcerca;
    private javax.swing.JTextArea jArea;
    private javax.swing.JMenuItem jGuardar;
    private javax.swing.JMenu jMenuArch;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuOpc;
    private javax.swing.JMenuItem jNuevo;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JMenuItem jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
