/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.utp.proyectodealgoritmos;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class SolicitudesSAE extends javax.swing.JInternalFrame {
    Queue<Solicitud> solicitudes = new LinkedList<>();
    int cantidadMaxima = 5;
    DefaultListModel<String> modelo = new DefaultListModel<>();
    
    /**
     * Creates new form SolicitudesSAE
     */
    public SolicitudesSAE() {
        initComponents();
        this.setSize(744, 426);
        this.setTitle("Solicitudes SAE");
        actualizarTabla();
        tf_pendientes.setEditable(false);
    }

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
        jLabel3 = new javax.swing.JLabel();
        cb_tipo = new javax.swing.JComboBox<>();
        tf_telefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_solicitudes = new javax.swing.JList<>();
        btn_solicitar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_pendientes = new javax.swing.JTextField();
        btn_llamar = new javax.swing.JButton();
        btn_info = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Registrar solicitud");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 26, 247, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Tipo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 62, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Ingrese su número de teléfono:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 144, -1, -1));

        cb_tipo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inscripción a cursos", "Cambio de horario", "Solicitud de documentos", "Solicitud de becas", "Cambio de carrera" }));
        getContentPane().add(cb_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 98, 247, -1));

        tf_telefono.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tf_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_telefonoActionPerformed(evt);
            }
        });
        getContentPane().add(tf_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 186, 247, -1));

        lst_solicitudes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(lst_solicitudes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 150, 333, 192));

        btn_solicitar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_solicitar.setText("Solicitar");
        btn_solicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_solicitarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_solicitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 246, 111, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Gestión de solicitudes");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 26, 218, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Solicitudes pendientes:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 62, 196, -1));

        tf_pendientes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        getContentPane().add(tf_pendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 98, 100, -1));

        btn_llamar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_llamar.setText("Llamar");
        btn_llamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_llamarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_llamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 354, 111, -1));

        btn_info.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_info.setText("?");
        btn_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_infoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 186, 40, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_telefonoActionPerformed

    private void btn_solicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_solicitarActionPerformed
        // Registrar solicitud
        if (solicitudes.size() < cantidadMaxima) {
            String telefono = tf_telefono.getText();
            if (telefono.equals("")) {
                JOptionPane.showMessageDialog(this, "Campo vacío, ingrese su número de teléfono");
            } else {
                if (validarNumeroTelefonico(telefono)) {
                    String tipo = cb_tipo.getSelectedItem().toString();
                    solicitudes.add(new Solicitud(tipo, telefono));
                    // Actualizar pendientes y tabla
                    actualizarTabla();
                    // Limpiar campos
                    cb_tipo.setSelectedIndex(0);
                    tf_telefono.setText("");

                    JOptionPane.showMessageDialog(this,
                            "Te llamaremos pronto al " + telefono + " para atender tu solicitud sobre " + tipo);
                } else {
                    JOptionPane.showMessageDialog(this, "El número telefónico no es válido");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Inténtalo más tarde");
        }
    }//GEN-LAST:event_btn_solicitarActionPerformed

    private void btn_llamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_llamarActionPerformed
        // Responder solicitud
        if (solicitudes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay solicitudes pendientes");
        } else {
            Solicitud solicitud = solicitudes.remove();
            JOptionPane.showMessageDialog(this, "Llamando al " + solicitud.getTelefono() + "...");
            // Actualizando pendientes y tabla
            actualizarTabla();

            JOptionPane.showMessageDialog(this, "Solicitud sobre " + solicitud.getTipo() + " atendida");
        }
    }//GEN-LAST:event_btn_llamarActionPerformed

    private void btn_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_infoActionPerformed
        JOptionPane.showMessageDialog(this, "Ejemplo de número a ingresar:\n994 622 032\n(Sin espacios todo junto)");
    }//GEN-LAST:event_btn_infoActionPerformed
    
    public void actualizarTabla() {
        // Actualizando pendientes
        tf_pendientes.setText(String.valueOf(solicitudes.size()));
        // Actualizando tabla
        modelo.removeAllElements();
        lst_solicitudes.setModel(modelo);
        for (Solicitud solicitud : solicitudes) {
            modelo.addElement(solicitud.toString());
        }
    }

    private boolean validarNumeroTelefonico(String numeroTelefonico) {
        // Verificar si la longitud del número es igual a 9
        if (numeroTelefonico.length() != 9) {
            return false;
        }

        // Verificar que el primer dígito sea 9
        if (numeroTelefonico.charAt(0) != '9') {
            return false;
        }

        // Verificar que todos los caracteres sean dígitos numéricos
        for (int i = 1; i < numeroTelefonico.length(); i++) {
            if (!Character.isDigit(numeroTelefonico.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_info;
    private javax.swing.JButton btn_llamar;
    private javax.swing.JButton btn_solicitar;
    private javax.swing.JComboBox<String> cb_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lst_solicitudes;
    private javax.swing.JTextField tf_pendientes;
    private javax.swing.JTextField tf_telefono;
    // End of variables declaration//GEN-END:variables
}
