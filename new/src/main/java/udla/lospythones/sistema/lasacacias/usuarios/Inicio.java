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
    BaseDeDatos db = new BaseDeDatos(); // se inicia una conexión con la base de datos
    Connection acacias = db.connectToDataBase();
    public Inicio() throws SQLException {
    }

    public void paginadeInicio(String id, String pass, String rol) throws IOException, SQLException {
        ImageIcon logoAcacias = new ImageIcon("C:\\Users\\saril\\Desktop\\OneDrive - Universidad de Las Américas\\3\\PROGRAMACION II\\Proyecto Final\\logoacacias_S.jpg");
        
        int ans = 0;
        String roles = rol;
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
                inicioDeSesion("administrador", id, pass);
                usuario = new Administrador();
                break;
            case 2:
                inicioDeSesion("veterinaria", id, pass);
                usuario = new Veterinario();
                break;
            case 3:
                inicioDeSesion("trabajador", id, pass);
                usuario = new Trabajador();
                break;
        }
        int ans1=0;
        while (ans1==0){
        login.dispose();
        ans1 = usuario.opcionesUsuario();//Anteriormente se instanció de acuerdo a la clase escogida, se llama al metodo que hereda de la clase abstracta Usuario
            if (ans1==1){
                break;
            }
            String[] option = {"Continuar","Salir"};
            ans1= JOptionPane.showOptionDialog(null, "¿Desea continuar en el sistema?", " ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        }
        JOptionPane.showMessageDialog(null, "Gracias por usar nuestro sistema!", "", JOptionPane.INFORMATION_MESSAGE, logoAcacias);
    }

    private void inicioDeSesion(String tipoUser, String user, String cont) {
    BaseDeDatos db = new BaseDeDatos(); // se inicia una conexión con la base de datos
    Connection acacias = db.connectToDataBase();
    boolean ingreso = false;

    while (!ingreso) { // Reitera hasta que `ingreso` sea true
        String nombreUSer = verificacionUser(acacias, user, cont, tipoUser);
        if (nombreUSer != null) {
            JOptionPane.showMessageDialog(null, "Bienvenid@ " + nombreUSer);
            // se cierra el JFrame de login si la autenticación es exitosa
            login.setVisible(false);
            ingreso = true; // Detiene la reiteración
        } else {
            // Muestra un mensaje de error en un JOptionPane
            JOptionPane.showMessageDialog(null, "¡Datos incorrectos!", "Error", JOptionPane.ERROR_MESSAGE);

            // Permite que el usuario vuelva a intentar ingresando datos
            login.setVisible(true); // Reabre el JFrame para permitir reingresar datos
            String[] options = {"Reintentar", "Salir"};
            int response = JOptionPane.showOptionDialog(null, "¿Desea intentar de nuevo?", "Error de Ingreso",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (response == 1) { // Si el usuario elige salir
                System.exit(0); // Finaliza el programa
            }
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
