package udla.lospythones.sistema.lasacacias.usuarios;

import udla.lospythones.sistema.lasacacias.BaseDeDatos;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Inicio {
    Login1 login = new Login1();
    public Inicio() throws SQLException {
    }

    public void paginadeInicio() throws IOException, SQLException {
        login.setVisible(true);
        ImageIcon logoAcacias = new ImageIcon("C:\\Users\\saril\\Desktop\\OneDrive - Universidad de Las Américas\\3\\PROGRAMACION II\\Proyecto Final\\logoacacias_S.jpg");
        /*String[] object={"Administrador","Veterinario","Trabajador"};//Opciones de los roles que intervienen en el sistema
        int ans = 0;
        ans=JOptionPane.showOptionDialog(null, "Escoger rol...", "Seleccion del rol",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, logoAcacias, object, null)+1;//Se suma uno debido a que este retorna un valor basado en cero y para el switch se necesita desde 1
        if (ans==0){
            JOptionPane.showMessageDialog(null, "Por favor, escoja una opción");
            paginadeInicio();//Bucle para que el usuario deba colocar que rol ocupa al iniciar sesión
        }*/
        int ans = 0;
        String rol = login.getRol();
        switch (rol) {
            case "Administrador" -> ans = 1;
            case "Veterinario" -> ans = 2;
            case "Trabajador" -> ans = 3;
            default -> {
            }
        }
       
       

        Usuario usuario = null;//Uso de la clase abstracta
        switch (ans){//El switch nos permitirá ingresar a la base de datos correcta de acuerdo al rol
            case 1:
                inicioDeSesion("administrador");
                usuario = new Administrador();
                break;
            case 2:
                inicioDeSesion("veterinaria");
                usuario = new Veterinario();
                break;
            case 3:
                inicioDeSesion("trabajador");
                usuario = new Trabajador();
                break;
        }
        int ans1=0;
        while (ans1==0){
        ans1 = usuario.opcionesUsuario();//Anteriormente se instanció de acuerdo a la clase escogida, se llama al metodo que hereda de la clase abstracta Usuario
            if (ans1==1){
                break;
            }
            String[] option = {"Continuar","Salir"};
            ans1= JOptionPane.showOptionDialog(null, "¿Desea continuar en el sistema?", " ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        }
        JOptionPane.showMessageDialog(null, "Gracias por usar nuestro sistema!", "", JOptionPane.INFORMATION_MESSAGE, logoAcacias);
    }

    private void inicioDeSesion(String tipoUser){
        BaseDeDatos db = new BaseDeDatos();
        Connection acacias = db.connectToDataBase();
        boolean ingreso = true;
        while (ingreso) {
            String us = login.getId();
            String ps = login.getPsw().getText();
            String nombreUSer = verificacionUser(acacias, us, ps, tipoUser);
            
            if (nombreUSer != null) {
                login.setVisible(false);
                JOptionPane.showMessageDialog(null, "Bienvenid@ " + nombreUSer);
                ingreso = false;
            }
        }
    }




    private String verificacionUser(Connection acacias, String us, String ps, String tipoUSer){
        String usuarioInfo = "SELECT * FROM " + tipoUSer + " WHERE  idUser = ? AND contrasena = ?"; //Dentro de la base de datos se busca la informacion, el tipoUser permite definir la tabla en la que se buscará
        try {
            PreparedStatement statement= acacias.prepareStatement(usuarioInfo);
            // Sustitución de los placeholders con los valores proporcionados (usuario y contraseña)
            statement.setString(1, us); // Primer parámetro: ID del usuario
            statement.setString(2, ps); // Segundo parámetro: Contraseña del usuario

            ResultSet resultSet = statement.executeQuery();//Se consulta en el MYSQL

            //Verificacion del resultado
            if (resultSet.next()) {
                //En caso de que haya resultado, se extrae el nombre del usuario
                return resultSet.getString("nombre");
            }
        } catch (SQLException e) {
            //Manejo de errores con excepciones en caso de problemas en la base de datos.
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return null;// Si no entró al condicional if, retornará null
    }
    
    public String verificacionUserSinPs(Connection acacias, String us, String tipoUSer){
        String usuarioInfo = "SELECT * FROM " + tipoUSer + " WHERE  idUser = ?"; //Dentro de la base de datos se busca la informacion, el tipoUser permite definir la tabla en la que se buscará
        try {
            PreparedStatement statement= acacias.prepareStatement(usuarioInfo);
            statement.setString(1, us); // Parámetro: ID del usuario
            ResultSet resultSet = statement.executeQuery();//Se consulta en el MYSQL

            //Verificacion del resultado
            if (resultSet.next()) {
                //En caso de que haya resultado, se extrae el nombre del usuario
                return resultSet.getString("nombre");
            }
        } catch (SQLException e) {
            //Manejo de errores con excepciones en caso de problemas en la base de datos.
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
            e.printStackTrace();
        }
        return null;// Si no entró al condicional if, retornará null
    }
}
