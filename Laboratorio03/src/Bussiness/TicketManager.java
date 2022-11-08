package Bussiness;

import Data.DBManager;
import Objects.Ticket;
import java.util.ArrayList;

public class TicketManager {
    
    DBManager dbManager = new DBManager();
    
    public boolean makeNewTicket(String sponsor, String location, int amount, int price) {
        int locationID = dbManager.getLocationID(location);
        int sponsorID = dbManager.getSponsorID(sponsor);
        Ticket newTicket = new Ticket(locationID, sponsorID, price, amount);
        
        boolean success = insertTicket(newTicket, sponsor, location);
        return success;
    }
    
    public boolean insertTicket(Ticket ticket, String sponsor, String location) {
        boolean success = false;
        if (dbManager.getTicketID(sponsor, location) == -1) {
            dbManager.insertTicket(ticket);
            success = true;
        }
        return success;

    }
    
    public String[] getLocations() {
        return dbManager.getLocations();
    }
    
    public String[] getSponsors() {
        return dbManager.getSponsors();
    }
    
    public int getTicketAmount(String location) {
        return dbManager.getTicketAmount(location);
    }
    
    
}
