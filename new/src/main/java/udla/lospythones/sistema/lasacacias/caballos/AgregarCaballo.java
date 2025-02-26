/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package udla.lospythones.sistema.lasacacias.caballos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import udla.lospythones.sistema.lasacacias.BaseDeDatos;

/**
 *
 * @author SARILOLA
 */
public class AgregarCaballo extends javax.swing.JFrame {
    BaseDeDatos db = new BaseDeDatos(); //se inicia una conexión con la base de datos para emplearla en esta clase, se hace el mismo procedimiento en las demás
    Connection acacias = db.connectToDataBase();

    /**
     * Creates new form AgregarCaballo
     */
    public AgregarCaballo() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        edad = new javax.swing.JTextField();
        sexo = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        raza = new javax.swing.JTextField();
        peso = new javax.swing.JTextField();
        campo = new javax.swing.JTextField();
        valor = new javax.swing.JTextField();
        estadoEntrenamiento = new javax.swing.JTextField();
        estadoSalud = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        descripcion1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Datos");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Raza:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Ingrese los datos del caballo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 230, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Campo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Edad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Nombre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Identificación:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Sexo:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Descripción:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Estado de Salud:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Estado de entrenamiento:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Peso:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Valor:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, -1));

        id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 220, -1));

        edad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 220, -1));

        sexo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 220, -1));

        nombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 220, -1));

        raza.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(raza, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 220, -1));

        peso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 220, -1));

        campo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(campo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 220, -1));

        valor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 220, -1));

        estadoEntrenamiento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(estadoEntrenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 220, -1));

        estadoSalud.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(estadoSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 220, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 220, 50));

        descripcion1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(descripcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Caballo caballo = new Caballo();
        try{
            //se debe verificar que exista el campo en el que se lo posiciona
            Statement a = acacias.createStatement();
            String camp = "SELECT * FROM criadero WHERE nombre = '"+campo.getText()+"'";
            ResultSet campos = a.executeQuery(camp);
            while (!campos.next()){
                if (!campos.next()){
                    throw new CamposDisponiblesException("No hay ningun campo con ese nombre. Ingrese de nuevo...");
                }
            }

            //el sistema calcula automaticamente la alimentacion adecuada
            double alimentacion = caballo.alimentacion(Integer.parseInt(edad.getText()), Double.parseDouble(peso.getText()), sexo.getText());
            
            //el id es unico, se debe verificar que no se repita
            try(Statement verificar = acacias.createStatement()){
                String similar = "SELECT * FROM caballo WHERE idcaballo = '" + id.getText() + "'";
                ResultSet rs = verificar.executeQuery(similar);
                if (rs.next()) {
                    throw new UniqueValueException("El ID de cada caballo es único! Por favor, ingrese un valor diferente...");
                } else {
                    // ingreso de datos a la base de datos
                    String datos = "INSERT INTO caballo (idcaballo, edad, nombre, raza, sexo, descripcion, estadoSalud, estadoEntrenamiento, peso, valorComercial, campo, alimentacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement insertar = acacias.prepareStatement(datos)) {
                        insertar.setInt(1, Integer.parseInt(id.getText())); //obteniendo informacion por columna
                        insertar.setInt(2, Integer.parseInt(edad.getText()));
                        insertar.setString(3, nombre.getText());
                        insertar.setString(4, raza.getText());
                        insertar.setString(5, sexo.getText());
                        insertar.setString(6, descripcion1.getText());
                        insertar.setString(7, estadoSalud.getText());
                        insertar.setString(8, estadoEntrenamiento.getText());
                        insertar.setDouble(9, Double.parseDouble(peso.getText()));
                        insertar.setDouble(10, Double.parseDouble(valor.getText()));
                        insertar.setString(11, campo.getText());
                        insertar.setDouble(12, alimentacion);

                        // se actualiza la tabla con los nuevos datos
                        insertar.executeUpdate();
                        setVisible(false);
                    }
                }
            }catch (SQLException e){
                throw new RuntimeException(e);
            }catch (UniqueValueException un){
                JOptionPane.showMessageDialog(null, un.getMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Ingrese un valor valido!");
        }catch (SxException | CamposDisponiblesException sx){
            JOptionPane.showMessageDialog(null,sx.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarCaballo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCaballo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCaballo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCaballo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCaballo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campo;
    private javax.swing.JTextField descripcion1;
    private javax.swing.JTextField edad;
    private javax.swing.JTextField estadoEntrenamiento;
    private javax.swing.JTextField estadoSalud;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField peso;
    private javax.swing.JTextField raza;
    private javax.swing.JTextField sexo;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}