package Data;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUsers {
    
    DBConexion conexion = new DBConexion();
    private Statement s = null;
    private ResultSet rs = null;
    private Connection connection = null;
    
//    public void insertPlayer(Player player) {
//        try {
//            connection = conexion.conexion();
//            s = connection.createStatement();
//            int playerInserted = s.executeUpdate("INSERT INTO JUGADORES VALUES ('" + player.getId() + "','" 
//                    + player.getName() + "','" 
//                    + player.getAge() + "','" 
//                    + player.isState() + "','" 
//                    + player.getTeam() + "','" 
//                    + player.getSkill() + "','" 
//                    + player.getDebutDate() + "' )");
//            if (playerInserted == 0) {
//                System.out.println("Error al insertar jugador");
//            } else {
//                System.out.println("Jugador insertado exitosamente");
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    
//    public int getSkill(String profile, String fortitude) {
//        int skill = -1;
//        try {
//            connection = conexion.conexion();
//            s = connection.createStatement();
//            rs = s.executeQuery("SELECT ID_DESTREZA FROM DESTREZAS WHERE UPPER(PERFIL) = '" + profile.toUpperCase() + "' AND UPPER(FORTALEZA) = '" + fortitude.toUpperCase() + "'");
//            while (rs.next()) {
//                skill = rs.getInt("id_destreza");
//            }
//
//        } catch (Exception e) {
//            Logger.getLogger(DBPlayers.class.getName()).log(Level.SEVERE, null, e);
//        }
//        
//        return skill;
//    }
}