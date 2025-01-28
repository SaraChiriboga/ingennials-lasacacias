package udla.lospythones.sistema.lasacacias;


import java.io.IOException;
import java.sql.SQLException;
import udla.lospythones.sistema.lasacacias.usuarios.Inicio;
import udla.lospythones.sistema.lasacacias.usuarios.Login1;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
      Login1 lasacacias = new Login1();
      lasacacias.setVisible(true);
    }
}
