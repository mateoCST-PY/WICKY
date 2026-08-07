import connection.connection;
import java.sql.Connection;

public class main {
    public static void main(String[] args) {

        try {
        
            Connection conexion = connection.connect();

            System.out.println("Conexion Exitosa");
        }catch (Exception e){
            
            System.out.println("Error de conexion" + e.getMessage());   
        }   
    }
}
