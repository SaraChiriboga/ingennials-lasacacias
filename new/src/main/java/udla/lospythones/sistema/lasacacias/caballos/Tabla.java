/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package udla.lospythones.sistema.lasacacias.caballos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import udla.lospythones.sistema.lasacacias.BaseDeDatos;

/**
 *
 * @author SARILOLA
 */
public class Tabla extends javax.swing.JFrame {
    Caballo callabo = new Caballo();    
    BaseDeDatos db = new BaseDeDatos(); //se inicia una conexión con la base de datos para emplearla en esta clase, se hace el mismo procedimiento en las demás
    Connection acacias = db.connectToDataBase();

    /**
     * Creates new form Tabla
     */
    public Tabla() {
        initComponents();
        this.setLocationRelativeTo(null);
        ListadoCaballos.setModel(transferDetalles());
    }
    
    //metodo obtener un modelo de tabla basado en el listado de caballos de la base de datos
    public DefaultTableModel transferDetalles(){
        String sql = "SELECT * FROM caballo";
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID"); //se agregan y se definen los nombres de las columnas
        model.addColumn("Edad");
        model.addColumn("Nombre");
        model.addColumn("Raza");
        model.addColumn("Sexo");
        model.addColumn("Descripción");
        model.addColumn("Estado de Salud");
        model.addColumn("Estado de Entrenamiento");
        model.addColumn("Peso");
        model.addColumn("Valor");
        model.addColumn("Campo");
        model.addColumn("Alimentación");
        
        try (Statement st = acacias.createStatement();
             ResultSet rs = st.executeQuery(sql)) { //se crea una lista que contiene información sobre la tabla
            while (rs.next()) { //recorre la lista recuperando detalles y los almacena en un arreglo
                Object[] fila = { //un arreglo Object almacena datos de diversos tipos (int, double, String, etc)
                        rs.getInt("idcaballo"),
                        rs.getInt("edad"),
                        rs.getString("nombre"),
                        rs.getString("raza"),
                        rs.getString("sexo"),
                        rs.getString("descripcion"),
                        rs.getString("estadoSalud"),
                        rs.getString("estadoEntrenamiento"),
                        rs.getDouble("peso"),
                        rs.getDouble("valorComercial"),
                        rs.getString("campo"),
                        rs.getDouble("alimentacion")
                };
                model.addRow(fila); //una vez que se llena el arreglo con los datos, se agrega una fila y se repite el proceso
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }
    
    public void resultadoBusqueda() throws IOException{
        ListadoCaballos.setModel(callabo.buscarCaballo());
        setVisible(true);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListadoCaballos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listado de Caballos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Listado de caballos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoacacias_S.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 20, -1, -1));

        ListadoCaballos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ListadoCaballos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1192, 560));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Tabla().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListadoCaballos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
