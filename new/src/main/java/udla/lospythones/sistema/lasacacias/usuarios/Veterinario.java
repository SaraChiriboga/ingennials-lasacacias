package udla.lospythones.sistema.lasacacias.usuarios;

import udla.lospythones.sistema.lasacacias.BaseDeDatos;
import udla.lospythones.sistema.lasacacias.caballos.Caballo;
import udla.lospythones.sistema.lasacacias.caballos.HistorialMed;
import udla.lospythones.sistema.lasacacias.caballos.TablaMed;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import udla.lospythones.sistema.lasacacias.caballos.AgregarHistorial;

public class Veterinario extends Usuario {

    // Atributos específicos de la clase Veterinario
    private String registroSenecyt;
   private String especializacion;
   private int telefono;

   //instancias de clases que contienen los métodos a los que puede acceder el vet
    Caballo caballito = new Caballo();
    HistorialMed historiales = new HistorialMed();
    TablaMed hist = new TablaMed();

    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in)); //lector

    // Constructor por defecto
    public Veterinario() {
        super(0, "", "", "");
    }

    // Constructor con parámetros, incluyendo atributos heredados y específicos
    public Veterinario(int idUser, String nombre, String contrasena, String CI, String registroSenecyt, String especializacion, String experiencia, int telefono) {
        super(idUser, nombre, contrasena, CI);
        this.registroSenecyt = registroSenecyt;
        this.especializacion = especializacion;
        this.telefono = telefono;
    }

    // Métodos getter y setter para los atributos específicos
    public String getRegistroSenecyt() {
        return registroSenecyt;
    }

    public void setRegistroSenecyt(String registroSenecyt) {
        this.registroSenecyt = registroSenecyt;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public int opcionesUsuario() throws SQLException, IOException {
        // Opciones disponibles para el veterinario
        String[] object={"", "Agregar historial médico","Eliminar todos los historiales de un caballo", "Buscar historial","Mostrar historiales","Mostrar caballos", "Salir"};
        Object option= null;
        option= JOptionPane.showInputDialog(null, "Elegir..", "Opciones a realizar", JOptionPane.QUESTION_MESSAGE,null, object,object[0]);
        if (option==null){
            JOptionPane.showMessageDialog(null, "Por favor, escoja una opción");
            opcionesUsuario();//Bucle para que el usuario escoja una opción a realizar
        }

        // Switch donde se ejecutará acciones según la opción seleccionada
        switch (option.toString()){
            case "Agregar historial médico":
                AgregarHistorial hist = new AgregarHistorial();
                hist.setVisible(true);
                break;
            case "Eliminar todos los historiales de un caballo":
                try{
                    int deletehist = Integer.parseInt(JOptionPane.showInputDialog(null, "ID del caballo:"));
                    historiales.eliminarHistorial(deletehist);
                }catch (NumberFormatException e){
                    System.out.println("Es necesario que coloque el id del caballo...");}
                break;
            case "Buscar historial":
                TablaMed histmed = new TablaMed();
                histmed.mostrarHistorialEncontrado();
                break;
            case "Mostrar historiales":
                historiales.mostrarHistoriales();
                break;
            case "Mostrar caballos":
                caballito.impresionCaballos();
                break;
            case "Salir":
                return 1;//Se retorna para culminar el sistema
        }
        return 0;
    }

    @Override
    public void nuevoUsuario() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

