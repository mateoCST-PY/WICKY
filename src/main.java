import java.sql.Connection;
import java.sql.SQLException;

import model.connection;
import model.userDAO;


public class main {
    public static void main(String[] args) throws SQLException{

        userDAO usuarioDAO = new userDAO();

        //usuarioDAO.createUser("1036252466", "Mateo Hurtado", "3135953670", "mateo.hurtado@example.com", "Cra 12 # 34-56");
        
        // usuarioDAO.deleteUser(3);

        usuarioDAO.listUser();

        try {

            Connection conexion = connection.connect();

            System.out.println("Conexion Exitosa");

        }catch (Exception e){
            
            System.out.println("Error de conexion" + e.getMessage());   
            
        }   
    }
}
