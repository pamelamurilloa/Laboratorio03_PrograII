package Data;

import Objects.Invoice;
import Objects.Ticket;
import Objects.User;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBManager {
    
    DBConexion conexion = new DBConexion();
    private Statement s = null;
    private ResultSet rs = null;
    private Connection connection = null;
    
    // USERS //
    public boolean doesUserExist(int userID) {
        boolean exist = false;
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT Count(1) cantidad from usuarios u where u.id_usuario = '" + userID + "';");
            while (rs.next()) {
                exist = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return exist;
    }
    
    public void insertUser(User user) {
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            int userInserted = s.executeUpdate("INSERT INTO usuarios VALUES ('" + user.getID() + "','" 
                    + user.getFirstName() + "','" 
                    + user.getGender() + "' )");
            
            if (userInserted == 0) {
                System.out.println("Error al insertar jugador");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList getUserIDs() {
        ArrayList<String> userList = new ArrayList();
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_usuario AS id FROM usuarios;");
            while (rs.next()) {
                userList.add(rs.getString("id"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return userList;
    }
    
    // SPONSOR //
    public String[] getSponsors() {
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
    
    public int getSponsorID(String sponsorName) {
        int sponsor = -1;
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_patrocinador AS id FROM patrocinadores WHERE nombre = '" + sponsorName + "'");
            while (rs.next()) {
                sponsor = rs.getInt("id");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return sponsor;
    }
    
    
    // LOCATION //
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
    
        public int getLocationID(String locationName) {
        int location = -1;
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_localidad AS id FROM localidades WHERE nombre = '" + locationName + "'");
            while (rs.next()) {
                location = rs.getInt("id");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return location;
    }
    
     // REPORTS //
    public HashMap getReport1 () {
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
    
    public HashMap<Integer, HashMap> getReport2 (int userID) {
        HashMap<Integer, HashMap> mainHash = new HashMap();
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT u.id_usuario AS id_usuario, u.primer_nombre AS nombre, l.nombre AS localidad, pa.nombre AS patrocinador, f.cantidad AS cantidad, f.total total FROM usuarios u "
                                + "INNER JOIN facturas f on f.id_usuario = u.id_usuario "
                                + "LEFT JOIN boletos b on b.id_tipo_boleto = f.id_boleto "
                                + "LEFT JOIN localidades l on b.id_localidad = l.id_localidad "
                                + "LEFT JOIN patrocinadores pa on b.id_patrocinador = pa.id_patrocinador "
                                + "WHERE u.id_usuario = '" + userID + "' "
                                + "GROUP BY u.id_usuario, u.primer_nombre, l.nombre, pa.nombre, f.cantidad, f.total;");
            int count = 0;
            while (rs.next()) {
                HashMap subHash = new HashMap();
                subHash.put("userID", userID);
                subHash.put("userName", rs.getString("nombre"));
                subHash.put("location", rs.getString("localidad"));
                subHash.put("sponsor", rs.getString("patrocinador"));
                subHash.put("numberTickets", rs.getInt("cantidad"));
                subHash.put("total", rs.getInt("total"));
                
                mainHash.put( count, subHash);
                count++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
        return mainHash;
    }
    
     // TICKETS //
    public void insertTicket (Ticket ticket) {
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            int userInserted = s.executeUpdate("INSERT INTO boletos (id_localidad, id_patrocinador, precio, cantidad_stock) VALUES ('" + ticket.getLocationID() + "', "
                                                + "'" + ticket.getSponsorID() + "', "
                                                + "'" + ticket.getPrice() + "', "
                                                + "'" + ticket.getAmountStock() + "');");
            
            if (userInserted == 0) {
                System.out.println("Error al actualizar cantidad de boletos");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateStockTickets(int ticketsBought, int id_ticket) {
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            int userInserted = s.executeUpdate("UPDATE boletos "
                                            + "SET cantidad_stock = cantidad_stock - '" + ticketsBought + "' "
                                            + "WHERE id_tipo_boleto = '" + id_ticket + "';");
            
            if (userInserted == 0) {
                System.out.println("Error al actualizar cantidad de boletos");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Ticket getTicket(int idTicket) {
        Ticket newTicket = null;
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT id_localidad as local, id_patrocinador as patro, precio as precio, cantidad_stock as cantidad from boletos "
                    + "where id_tipo_boleto = '" + idTicket + "'");
            
            while (rs.next()) {
                newTicket = new Ticket(rs.getInt("local"), rs.getInt("patro"), rs.getInt("precio"), rs.getInt("cantidad"));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return newTicket;
    }
    
    public int getTicketID(String sponsor, String location) {
        int ticketID = -1;
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT b.id_tipo_boleto AS id FROM boletos b " +
                                    "left join localidades l " +
                                    "on l.id_localidad = b.id_localidad " +
                                    "left join patrocinadores pa " +
                                    "on pa.id_patrocinador = b.id_patrocinador " +
                                    "WHERE UPPER(l.nombre) = '" + location.toUpperCase() + "' " +
                                    "AND UPPER(pa.nombre) = '" + sponsor.toUpperCase() + "';");
            
            while (rs.next()) {
                ticketID = rs.getInt("id");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return ticketID;
    }
    
    // BILLS //
    
    public void insertInvoice(Invoice invoice) {
        try {
            connection = conexion.conexion();
            s = connection.createStatement();
            int userInserted = s.executeUpdate("INSERT INTO facturas (id_boleto, id_usuario, cantidad, total) VALUES "
                    + "('" + invoice.getTicketID() + "', "
                    + "'" + invoice.getUserID() + "', "
                    + "'" + invoice.getQuantity() + "', "
                    + "'" + invoice.getTotal() + "';");
            
            if (userInserted == 0) {
                System.out.println("Error al insertar factura");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public static void main(String[] args) {
        DBManager db = new DBManager();
        String[] a = db.getLocations();
        for (String i : a) {
            System.out.println(i);
        }
    }
}