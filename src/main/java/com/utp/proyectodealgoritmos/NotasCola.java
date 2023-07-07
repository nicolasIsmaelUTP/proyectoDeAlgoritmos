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
public class NotasCola extends javax.swing.JInternalFrame {

    Queue<String> cola = new LinkedList<>();
    DefaultListModel<String> modelo = new DefaultListModel<>();

    /**
     * Creates new form NotasCola
     */
    public NotasCola() {
        initComponents();
        this.setSize(379, 323);
        this.setTitle("Notas Cola");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_nota = new javax.swing.JTextField();
        btn_encolar = new javax.swing.JButton();
        btn_desencolar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst_cola = new javax.swing.JList<>();
        btn_ordenar = new javax.swing.JButton();
        btn_promedio = new javax.swing.JButton();
        btn_min = new javax.swing.JButton();
        btn_max = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Ingresa nota:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 27, -1, -1));

        tf_nota.setName("Tx_numero"); // NOI18N
        tf_nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_notaActionPerformed(evt);
            }
        });
        getContentPane().add(tf_nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 23, 110, -1));

        btn_encolar.setText("Encolar nota");
        btn_encolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_encolarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_encolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        btn_desencolar.setText("Desencolar nota");
        btn_desencolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desencolarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_desencolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jScrollPane2.setViewportView(lst_cola);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 65, 129, 200));

        btn_ordenar.setText("Ordenar notas");
        btn_ordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ordenarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ordenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        btn_promedio.setText("Promedio");
        btn_promedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_promedioActionPerformed(evt);
            }
        });
        getContentPane().add(btn_promedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        btn_min.setText("Minimo");
        btn_min.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_minActionPerformed(evt);
            }
        });
        getContentPane().add(btn_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, -1, -1));

        btn_max.setText("Maximo");
        btn_max.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_maxActionPerformed(evt);
            }
        });
        getContentPane().add(btn_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_promedioActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_promedioActionPerformed
        // Promedio
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        } else {
            // Recorriendo la cola
            int suma = 0;
            for (String i : cola) {
                suma += Integer.parseInt(i);
            }

            // Calculando el promedio
            double promedio = (double) suma / cola.size();

            // Mostrando el promedio con JOptionPane
            JOptionPane.showMessageDialog(null, "El promedio es: " + promedio);
        }
    }// GEN-LAST:event_btn_promedioActionPerformed

    private void btn_minActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_minActionPerformed
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        } else {
            // Recorriendo la cola
            int min = Integer.parseInt(cola.peek());
            for (String i : cola) {
                if (Integer.parseInt(i) < min) {
                    min = Integer.parseInt(i);
                }
            }

            // Mostrando el promedio con JOptionPane
            JOptionPane.showMessageDialog(null, "La nota minima es: " + min);
        }
    }// GEN-LAST:event_btn_minActionPerformed

    private void btn_maxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_maxActionPerformed
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        } else {
            // Recorriendo la cola
            int max = Integer.parseInt(cola.peek());
            for (String i : cola) {
                if (Integer.parseInt(i) > max) {
                    max = Integer.parseInt(i);
                }
            }

            // Mostrando el promedio con JOptionPane
            JOptionPane.showMessageDialog(null, "La nota maxima es: " + max);
        }
    }// GEN-LAST:event_btn_maxActionPerformed

    private void btn_ordenarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_ordenarActionPerformed
        // Ordenar
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        } else {
            // Convirtiendo la cola a un arreglo
            int[] array = new int[cola.size()];
            int index = 0;
            for (String i : cola) {
                array[index++] = Integer.parseInt(i);
            }

            // Ordenando el arreglo
            array = ordenarPorInsercion(array);

            // Mostando el arreglo ordenado con JOptionPane
            String mensaje = "Notas ordenadas: ";
            for (int i = 0; i < array.length; i++) {
                mensaje += "\n" + array[i];
            }
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }// GEN-LAST:event_btn_ordenarActionPerformed

    private int[] ordenarPorInsercion(int[] notas) {
        int aux;
        // Creamos una copia del arreglo de notas para no modificar el original.
        int[] notasOrdenadas = notas.clone();

        // Seleccionamos un elemento i del arreglo.
        for (int i = 0; i < notasOrdenadas.length; i++) {
            // Recorremos el arreglo desde i hasta el principio.
            for (int j = i; j > 0; j--) {
                // Si encontramos una nota menor se intercambian las posiciones.
                if (notasOrdenadas[j] < notasOrdenadas[j - 1]) {
                    aux = notasOrdenadas[j];
                    notasOrdenadas[j] = notasOrdenadas[j - 1];
                    notasOrdenadas[j - 1] = aux;
                } else {
                    // Si no se cumple la condición, el arreglo está ordenado hasta el índice i.
                    break;
                }
            }
        }

        // Devolvemos el arreglo ordenado.
        return notasOrdenadas;
    }

    private void tf_notaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tf_notaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tf_notaActionPerformed

    private void btn_encolarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_encolarActionPerformed
        if (esNotaValida(tf_nota.getText())) {
            cola.add(tf_nota.getText());
            modelo.addElement(tf_nota.getText());
            lst_cola.setModel(modelo);
            tf_nota.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "La nota no es valida");
        }
    }// GEN-LAST:event_btn_encolarActionPerformed

    private void btn_desencolarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_desencolarActionPerformed
        // Desencolar
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola esta vacia");
        } else {
            cola.remove();
            modelo.remove(0);
            lst_cola.setModel(modelo);
        }
    }// GEN-LAST:event_btn_desencolarActionPerformed

    private boolean esNotaValida(String nota) {
        // Verificar que todos los caracteres sean dígitos
        for (int i = 0; i < nota.length(); i++) {
            if (!Character.isDigit(nota.charAt(i))) {
                return false;
            }
        }

        // Convertir la cadena a un número entero
        int valorNota = Integer.parseInt(nota);

        // Verificar el rango de la nota
        if (valorNota < 1 || valorNota > 20) {
            return false;
        }

        // La nota es válida
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_desencolar;
    private javax.swing.JButton btn_encolar;
    private javax.swing.JButton btn_max;
    private javax.swing.JButton btn_min;
    private javax.swing.JButton btn_ordenar;
    private javax.swing.JButton btn_promedio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lst_cola;
    private javax.swing.JTextField tf_nota;
    // End of variables declaration//GEN-END:variables
}