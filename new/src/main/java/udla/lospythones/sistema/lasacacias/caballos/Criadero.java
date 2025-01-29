package udla.lospythones.sistema.lasacacias.caballos;

import udla.lospythones.sistema.lasacacias.BaseDeDatos;

import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import javax.swing.JOptionPane;

public class Criadero {
    //atributos
    private String nombreCampo;
    private String descripcion;

    BaseDeDatos db = new BaseDeDatos(); //se inicia una conexión con la base de datos
    Connection acacias = db.connectToDataBase();
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in)); //lector

    //GETTERS Y SETTERS
    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // metodo para agregar campo
    public void agregarCampo() throws IOException, UniqueValueException, SQLException{
        AgregarCampo campo = new AgregarCampo();
        campo.setVisible(true);
    }

    //metodo para eliminar campo
    public void eliminarCampo() throws IOException {
        String name = JOptionPane.showInputDialog(null, "Ingrese el nombre del campo: ");
        String instruccion = "DELETE FROM criadero WHERE nombre = '"+name+"'"; //esta solicita que se elimine de la tabla criadero
        try(PreparedStatement borrar = acacias.prepareStatement(instruccion)) {
            JOptionPane.showMessageDialog(null, "Campo eliminado exitosamente!");
            borrar.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //mostrar información
        mostrarCampos();
    }

    //metodo para transferir informacion de la base de datos a una ventana
    public DefaultTableModel transferCampos(){
        String sql = "SELECT * FROM criadero";
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre del campo"); //se agregan y se definen los nombres de las columnas
        model.addColumn("Descripción");

        try (Statement st = acacias.createStatement();
             ResultSet rs = st.executeQuery(sql)) { //se crea una lista que contiene información sobre la tabla
            while (rs.next()) { //recorre la lista recuperando detalles y los almacena en un arreglo
                Object[] fila = { //un arreglo Object almacena datos de diversos tipos (int, double, String, etc)
                        rs.getString("nombre"),
                        rs.getString("descripcion")};
                model.addRow(fila); //una vez que se llena el arreglo con los datos, se agrega una fila y se repite el proceso
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    //metodo para mostrar la tabla en una ventada
    public void mostrarCampos(){
        TablaCriadero tabla = new TablaCriadero();

        tabla.setVisible(true);
     }
}
