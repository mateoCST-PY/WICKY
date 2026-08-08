package model;

import model.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class userDAO {

    //metod used for create new user in the data base
    public void createUser(String documento, String nombre_usuario, String telefono, String email, String direccion) throws SQLException {
         
        Connection conexion = connection.connect();

        String sql = "INSERT INTO usuarios (documento, nombre_usuario, telefono, email, direccion) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, documento);
        ps.setString(2, nombre_usuario);
        ps.setString(3, telefono);
        ps.setString(4, email);
        ps.setString(5, direccion);

        ps.executeUpdate();

        ps.close();
        conexion.close();

    }

    //here we come consult dates from database
    public void listUser(){

        String sql = "SELECT * FROM usuarios";

        try {

            Connection conexion = connection.connect();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                int id_usuario = rs.getInt("id_usuario");
                String documento = rs.getString("documento");
                String nombre_usuario = rs.getString("nombre_usuario");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");

                System.out.println("id usuario: " + id_usuario);
                System.out.println("documento: " + documento);
                System.out.println("nombre usuario: " + nombre_usuario);
                System.out.println("telefono " + telefono);
                System.out.println("email: " + email);
                System.out.println("direccion: " + direccion);

            }

            rs.close();
            ps.close();
            conexion.close();

        } catch (Exception e){
            
            System.out.println("ocurrio un error" + e.getMessage());

        }
    }
    
}
