package udla.lospythones.sistema.lasacacias.caballos;

import udla.lospythones.sistema.lasacacias.BaseDeDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Caballo {
    //atributos
    private int id;
    private int edad;
    private String nombre;
    private String raza;
    private String sexo; //Hembra(H) ; Macho(M)
    private String descripcion;
    private String estadoSalud;
    private String estadoEntrenamiento;
    private double peso;
    private double valorComercial;
    private double alimentacion; //este atributo se calcula mediante un metodo y es medida en kg
    private String campo;
        
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in)); //lector
    BaseDeDatos db = new BaseDeDatos(); //se inicia una conexión con la base de datos para emplearla en esta clase, se hace el mismo procedimiento en las demás
    Connection acacias = db.connectToDataBase();

    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public String getEstadoEntrenamiento() {
        return estadoEntrenamiento;
    }

    public void setEstadoEntrenamiento(String estadoEntrenamiento) {
        this.estadoEntrenamiento = estadoEntrenamiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValorComercial() {
        return valorComercial;
    }

    public void setValorComercial(double valorComercial) {
        this.valorComercial = valorComercial;
    }

    public double getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(double alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    //metodo para calcular la cantidad apropiada de alimento para el caballo
    public double alimentacion(int edad, double peso, String sexo){
        double ali = 0;
        //ESTOS VALORES SON FICTICIOS
        /*si el caballo es menor de 4 años y es macho, debe comer el 2.5% de su peso, si
         * es hembra, el 1.5% de su peso*/
        /*si el caballo es mayor de 4 años y es macho, debe comer el 3% de su peso, si
         * es hembra, el 2.5% de su peso*/
        if (edad < 4 && sexo.equals("M")){
            ali = peso * 0.025;
        }else if (edad < 4 && sexo.equals("H")){
            ali = peso * 0.015;
        }else if (edad >= 4 && sexo.equals("M")){
            ali = peso * 0.03;
        }else if (edad >= 4 && sexo.equals("H")){
            ali = peso * 0.025;
        }
        return ali;
    }

    //metodo de obtencion de detalles del caballo
    public void obtencionDetalles() throws IOException, UniqueValueException, SxException {
        AgregarCaballo add = new AgregarCaballo();
        add.setVisible(true);
    }

    //metodo para editar caballo
    public void editarCaballo() throws IOException, SQLException {
        EditarCaballo editar = new EditarCaballo();
        editar.setVisible(true);
    }

    //metodo para eliminar un caballo de los registros del criadero en base a su id
    public void eliminarCaballo(int id){
        String instruccion = "DELETE FROM caballo WHERE idcaballo = ?";
        try (PreparedStatement borrar = acacias.prepareStatement(instruccion)) {
            borrar.setInt(1, id);
            int filasAfectadas = borrar.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún caballo con tal id");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente!");
        }
    }

    public DefaultTableModel buscarCaballo(){
    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID del caballo: "));
  
    DefaultTableModel modeloEncontrado = new DefaultTableModel();
    modeloEncontrado.addColumn("ID");
    modeloEncontrado.addColumn("Edad");
    modeloEncontrado.addColumn("Nombre");
    modeloEncontrado.addColumn("Raza");
    modeloEncontrado.addColumn("Sexo");
    modeloEncontrado.addColumn("Descripción");
    modeloEncontrado.addColumn("Estado de Salud");
    modeloEncontrado.addColumn("Estado de Entrenamiento");
    modeloEncontrado.addColumn("Peso");
    modeloEncontrado.addColumn("Valor");
    modeloEncontrado.addColumn("Campo");
    modeloEncontrado.addColumn("Alimentación");

    try{
        String sql = "SELECT * FROM caballo WHERE idcaballo ='"+ id +"'";
        Statement st = acacias.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        if(rs.next()){
            // Aquí se procesa el primer registro
            Object[] fila = {
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
            modeloEncontrado.addRow(fila); 
        
            // Y ahora procesamos cualquier registro adicional
            while (rs.next()) { 
                Object[] filaAdicional = {
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
                modeloEncontrado.addRow(filaAdicional); 
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se encontró ningún caballo con tal id");
            buscarCaballo();
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"No se encontró ningún caballo con tal id");
    }
    return modeloEncontrado;
}


    //metodo para imprimir la lista de caballos en el criadero
    public void impresionCaballos(){
        Tabla tabla = new Tabla();
        tabla.setVisible(true);
    }

}
