package Data;

import Objects.User;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUsers {
    
    DBConexion conexion = new DBConexion();
    private Statement s = null;
    private ResultSet rs = null;
    private Connection connection = null;
    
    public void insertUser(User user) {
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            int userInserted = s.executeUpdate("INSERT INTO usuarios VALUES ('" + user.getID() + "','" 
                    + user.getFirstName() + "','" 
                    + user.getGender() + "' )");
            
            if (userInserted == 0) {
                System.out.println("Error al insertar jugador");
            } else {
                System.out.println("Jugador insertado exitosamente");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String[] getSponsor() {
        String[] sponsorList = new String[5];
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre AS sponsor FROM patrocinadores");
            int index = 0;
            while (rs.next()) {
                sponsorList[index] = rs.getString("sponsor");
                index++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return sponsorList;
    }
    
    public String[] getLocations() {
        String[] locationList = new String[5];
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombre AS location FROM localidades");
            int index = 0;
            while (rs.next()) {
                locationList[index] = rs.getString("location");
                index++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return locationList;
    }
    
    public HashMap getReport1 (char gender) {
        HashMap count = new HashMap();
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT u.genero, sum(f.cantidad) cantidad FROM usuarios u inner join facturas f on f.id_usuario = u.id_usuario group by u.genero;");
            while (rs.next()) {
                count.put(rs.getString("genero"), rs.getInt("cantidad"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return count;
    }
    
    public HashMap<Integer, HashMap> getReport2 (char gender) {
        HashMap<Integer, HashMap> mainHash = new HashMap();
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT u.id_usuario AS id_usuario, u.primer_nombre AS nombre, l.nombre AS localidad, pa.nombre AS patrocinador, f.cantidad AS cantidad, f.total total FROM usuarios u"
                                + "INNER JOIN facturas f on f.id_usuario = u.id_usuario "
                                + "LEFT JOIN boletos b on b.id_tipo_boleto = f.id_boleto "
                                + "LEFT JOIN localidades l on b.id_localidad = l.id_localidad "
                                + "LEFT JOIN patrocinadores pa on b.id_patrocinador = pa.id_patrocinador "
                                + "WHERE u.id_usuario = '" + gender + "' "
                                + "GROUP BY u.id_usuario, u.primer_nombre, l.nombre, pa.nombre, f.cantidad, f.total;");
            while (rs.next()) {
                HashMap subHash = new HashMap();
                subHash.put("userName", rs.getString("nombre"));
                subHash.put("location", rs.getString("localidad"));
                subHash.put("sponsor", rs.getString("patrocinador"));
                subHash.put("numberTickets", rs.getInt("cantidad"));
                subHash.put("numberTickets", rs.getInt("total"));
                
                mainHash.put( rs.getInt("id_usuario"), subHash);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return mainHash;
    }
}