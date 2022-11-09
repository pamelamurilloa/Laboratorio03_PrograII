package Objects;


public class Invoice {
    private int ticketID;
    private int userID;
    private int quantity;
    private int total;

    public Invoice( int ticketID, int userID, int quantity, int total) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.quantity = quantity;
        this.total = total;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
