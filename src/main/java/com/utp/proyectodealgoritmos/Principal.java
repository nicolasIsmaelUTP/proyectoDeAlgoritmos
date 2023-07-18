/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.utp.proyectodealgoritmos;

/**
 *
 * @author Usuario
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Proyecto");
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_asistencia = new javax.swing.JButton();
        btn_sae = new javax.swing.JButton();
        btn_notas_cola = new javax.swing.JButton();
        btn_notas_pila = new javax.swing.JButton();
        btn_evaluador = new javax.swing.JButton();
        panel = new javax.swing.JDesktopPane();
        btn_arbol = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_asistencia.setText("Registro de asistencia");
        btn_asistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_asistenciaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_asistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        btn_sae.setText("Solicitudes SAE");
        btn_sae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saeActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sae, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        btn_notas_cola.setText("Registro de notas (cola)");
        btn_notas_cola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_notas_colaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_notas_cola, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        btn_notas_pila.setText("Registro de notas (pila)");
        btn_notas_pila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_notas_pilaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_notas_pila, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        btn_evaluador.setText("Evaluador");
        btn_evaluador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_evaluadorActionPerformed(evt);
            }
        });
        getContentPane().add(btn_evaluador, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 790, 600));

        btn_arbol.setText("Arbol binario");
        btn_arbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_arbolActionPerformed(evt);
            }
        });
        getContentPane().add(btn_arbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saeActionPerformed
        SolicitudesSAE ventana = new SolicitudesSAE();
        panel.add(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_saeActionPerformed

    private void btn_asistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asistenciaActionPerformed
        RegistroDeAsistencia ventana = new RegistroDeAsistencia();
        panel.add(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_asistenciaActionPerformed

    private void btn_evaluadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_evaluadorActionPerformed
        Evaluador ventana = new Evaluador();
        panel.add(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_evaluadorActionPerformed

    private void btn_notas_colaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notas_colaActionPerformed
        NotasCola ventana = new NotasCola();
        panel.add(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_notas_colaActionPerformed

    private void btn_notas_pilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notas_pilaActionPerformed
        NotasPila ventana = new NotasPila();
        panel.add(ventana);
        ventana.setVisible(true);
    }//GEN-LAST:event_btn_notas_pilaActionPerformed

    private void btn_arbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_arbolActionPerformed
       ArbolNotas ventana = new ArbolNotas();
       panel.add(ventana);
       ventana.setVisible(true);
    }//GEN-LAST:event_btn_arbolActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_arbol;
    private javax.swing.JButton btn_asistencia;
    private javax.swing.JButton btn_evaluador;
    private javax.swing.JButton btn_notas_cola;
    private javax.swing.JButton btn_notas_pila;
    private javax.swing.JButton btn_sae;
    private javax.swing.JDesktopPane panel;
    // End of variables declaration//GEN-END:variables
}
