package Bussiness;

import Data.DBManager;
import Objects.Invoice;
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
        if (getTicketID(sponsor, location) == -1) {
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
    
    public int getTicketPrice(int id) {
        Ticket ticket = dbManager.getTicket(id);
        return ticket.getPrice();
    }
    
    public int getTicketAmount(int id) {
        Ticket ticket = dbManager.getTicket(id);
        return ticket.getAmountStock();
    }
    
    public int getTicketID(String sponsor, String location){
        return dbManager.getTicketID(sponsor, location);
    }
    
    public void purchaseTicket(int id, int amount, int userID, int total) {
        dbManager.updateStockTickets(amount, id);
        dbManager.insertInvoice(new Invoice(id, userID, amount, total));
    }
    
    
}
