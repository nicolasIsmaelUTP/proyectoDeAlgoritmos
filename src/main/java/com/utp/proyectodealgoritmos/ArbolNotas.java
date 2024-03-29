
package com.utp.proyectodealgoritmos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ArbolNotas extends javax.swing.JInternalFrame {
    NodoArbol raiz = null;
    ArrayList<Integer> notas = new ArrayList<>();

    /**
     * Creates new form ArbolNotas
     */
    public ArbolNotas() {
        initComponents();
        this.setSize(356, 360);
        this.setTitle("Arbol binario");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_nota = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_promedio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_min = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_max = new javax.swing.JTextField();
        btn_dibujar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_recorrer = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(tf_nota, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 120, 30));

        btn_agregar.setText("Agregar nota");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("UTP - ARBOL DE NOTAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel2.setText("Promedio:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        tf_promedio.setEditable(false);
        getContentPane().add(tf_promedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 120, 30));

        jLabel3.setText("Mínimo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        tf_min.setEditable(false);
        getContentPane().add(tf_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 110, -1));

        jLabel4.setText("Maximo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        tf_max.setEditable(false);
        getContentPane().add(tf_max, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 110, -1));

        btn_dibujar.setText("Dibujar arbol");
        btn_dibujar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dibujarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_dibujar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        btn_recorrer.setText("Recorrer arbol");
        btn_recorrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_recorrerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_recorrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_agregarActionPerformed
        // Agregar nota
        try {
            int nota = Integer.parseInt(tf_nota.getText());
            tf_nota.setText("");
            if (nota < 0 || nota > 20) {
                JOptionPane.showMessageDialog(this, "Ingrese una nota valida");
                return;
            }

            if (NodoArbol.buscar(raiz, nota)) {
                JOptionPane.showMessageDialog(this, "La nota ya existe");
                return;
            }

            raiz = NodoArbol.agregar(raiz, nota);
            notas.add(nota);
            tf_nota.setText("");
            tf_nota.requestFocus();

            // Llenando el promedio
            tf_promedio.setText(String.valueOf(promedio()));

            // Llenando el minimo
            tf_min.setText(String.valueOf(minimo()));

            // Llenando el maximo
            tf_max.setText(String.valueOf(maximo()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese una nota valida");
        }
    }// GEN-LAST:event_btn_agregarActionPerformed

    private double promedio() {
        double suma = 0, promedio;
        for (int nota : notas) {
            suma += nota;
        }
        promedio = suma / notas.size();
        return Math.round(promedio * 100.0) / 100.0;
    }

    private int minimo() {
        int min = notas.get(0);
        for (int nota : notas) {
            if (nota < min) {
                min = nota;
            }
        }
        return min;
    }

    private int maximo() {
        int max = notas.get(0);
        for (int nota : notas) {
            if (nota > max) {
                max = nota;
            }
        }
        return max;
    }

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_buscarActionPerformed
        // Buscar nota
        try {
            int nota = Integer.parseInt(tf_nota.getText());
            tf_nota.setText("");
            if (nota < 0 || nota > 20) {
                JOptionPane.showMessageDialog(this, "No es una nota valida");
                return;
            }

            if (NodoArbol.buscar(raiz, nota)) {
                JOptionPane.showMessageDialog(this, "La nota existe");
            } else {
                JOptionPane.showMessageDialog(this, "La nota no existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ingrese una nota valida");
        }
    }// GEN-LAST:event_btn_buscarActionPerformed

    private void btn_dibujarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_dibujarActionPerformed
        // Dibujar
        new BinaryTreeViewer("valor", "izq", "der")
                .setDataMethod("getValor()")
                .setLeftChildMethod("getIzq()")
                .display(raiz, 500, 500);
    }// GEN-LAST:event_btn_dibujarActionPerformed

    private void btn_recorrerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_recorrerActionPerformed
        // Recorrer arbol
        // Elegir el tipo de recorrido
        String[] opciones = { "Preorden", "Inorden", "Postorden" };
        String opcion = (String) JOptionPane.showInputDialog(this, "Seleccione el tipo de recorrido", "Recorrido",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        // Recorrer el arbol
        ArrayList<Integer> recorrido = new ArrayList<>();
        switch (opcion) {
            case "Preorden":
                recorrido = raiz.preorden();
                break;
            case "Inorden":
                recorrido = raiz.inorden();
                break;
            case "Postorden":
                recorrido = raiz.postorden();
                break;
        }

        // Mostrar el recorrido
        String recorridoString = "";
        for (int nota : recorrido) {
            recorridoString += nota + " ";
        }
        JOptionPane.showMessageDialog(this, recorridoString);

    }// GEN-LAST:event_btn_recorrerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_dibujar;
    private javax.swing.JButton btn_recorrer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tf_max;
    private javax.swing.JTextField tf_min;
    private javax.swing.JTextField tf_nota;
    private javax.swing.JTextField tf_promedio;
    // End of variables declaration//GEN-END:variables
}
