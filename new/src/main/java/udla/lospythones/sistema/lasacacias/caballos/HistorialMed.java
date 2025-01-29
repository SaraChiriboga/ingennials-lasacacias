package udla.lospythones.sistema.lasacacias.caballos;

import udla.lospythones.sistema.lasacacias.BaseDeDatos;

import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import javax.swing.JOptionPane;

public class HistorialMed {
    //atributos
    private int id;
    private String vacuna;
    private String desparacitacion;
    private String enfermedad;

    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in)); //lector
    BaseDeDatos db = new BaseDeDatos(); //conexión con la base de datos
    Connection acacias = db.connectToDataBase();

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public String getDesparacitacion() {
        return desparacitacion;
    }

    public void setDesparacitacion(String desparacitacion) {
        this.desparacitacion = desparacitacion;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    //metodo para obtener el modelo de tabla con los historiales medicos (modelo de tabla)
    public DefaultTableModel transferHistoriales(){
        String l = "SELECT * FROM historialmed";
        DefaultTableModel historial = new DefaultTableModel();
        historial.addColumn("ID"); //CONSIDERACION: se puede repetir el id, ya que cada visita al veterinario se genera información del mismo caballo
        historial.addColumn("Vacuna");
        historial.addColumn("Desparacitacion");
        historial.addColumn("Enfermedad");

        try (Statement st = acacias.createStatement();
             ResultSet rs = st.executeQuery(l)) { //se crea una lista que contiene información sobre la tabla
            while (rs.next()) { //recorre la lista recuperando detalles y los almacena en un arreglo
                Object[] fila = { //un arreglo Object almacena datos de diversos tipos (int, double, String, etc)
                        rs.getInt("idCaballo"),
                        rs.getString("vacuna"),
                        rs.getString("desparacitacion"),
                        rs.getString("enfermedad")

                };
                historial.addRow(fila); //una vez que se llena el arreglo con los datos, se agrega una fila y se repite el proceso
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return historial;
    }

    //metodo para mostrar los historiales medicos
    public void mostrarHistoriales(){
        TablaMed historiales = new TablaMed();

        historiales.setVisible(true);
    }

    //metodo para eliminar un historial en base al id
    public void eliminarHistorial(int id) throws SQLException { //PRECAUCION!!! este metodo borra todos los historiales del caballo
        String verificacion = "SELECT * FROM historialmed WHERE idCaballo = '"+ id+"'";
        String instruccion = "DELETE FROM historialmed WHERE idCaballo = '"+id+"'"; //esta solicita que se elimine de la tabla caballo aquella fila que contenga la id ingresada como parametro

        //verificar si hay historiales con la id ingresada
        Statement st = acacias.createStatement();
        ResultSet verificarID =  st.executeQuery(verificacion);

        if (verificarID.next()){
            try(PreparedStatement borrar = acacias.prepareStatement(instruccion)) {
                JOptionPane.showMessageDialog(null,"Historiales del caballo" + id + "eliminados exitosamente!");
                borrar.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            JOptionPane.showMessageDialog(null,"No se encontraron historiales con tal id...");
        }
    }

    //metodo para obtener el historial medico de un caballo basado en su id (modelo de tabla)
    public DefaultTableModel buscarHistorial() throws IOException {
        //se debe diseñar un nuevo modelo de tabla donde solo se encuentre información del caballo solicitado
        DefaultTableModel m = new DefaultTableModel();
        try {
            int buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "ID del caballo: "));
            String sql = "SELECT * FROM historialmed WHERE idCaballo ='" + buscar + "'";
            m.addColumn("ID"); //se agregan y se definen los nombres de las columnas
            m.addColumn("Vacuna");
            m.addColumn("Desparacitacion");
            m.addColumn("Enfermedad");

            try (Statement st = acacias.createStatement();
                 ResultSet rs = st.executeQuery(sql)) { //se crea una lista que contiene información sobre la tabla
                while (rs.next()) { //recorre la lista recuperando detalles y los almacena en un arreglo
                    Object[] fila = { //un arreglo Object almacena datos de diversos tipos (int, double, String, etc)
                            rs.getInt("idCaballo"),
                            rs.getString("vacuna"),
                            rs.getString("desparacitacion"),
                            rs.getString("enfermedad")
                    };
                    m.addRow(fila); //una vez que se llena el arreglo con los datos, se agrega una fila y se repite el proceso
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Ingrese un valor válido!");
        }
        return m;
    }

}
