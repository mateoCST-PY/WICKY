import java.sql.SQLException;
import java.sql.Connection;
import model.userDAO;
import model.connection;


public class main {
    public static void main(String[] args) throws SQLException{

        userDAO usuarioDAO = new userDAO();
        
        usuarioDAO.deleteUser(3);

        usuarioDAO.listUser();

        try {

            Connection conexion = connection.connect();

            System.out.println("Conexion Exitosa");

        }catch (Exception e){
            
            System.out.println("Error de conexion" + e.getMessage());   
            
        }   
    }
}
