package Objects;


public class Bill {
    private int billID;
    private int ticketID;
    private int userID;
    private int quantity;
    private int total;

    public Bill(int billID, int ticketID, int userID, int quantity, int total) {
        this.billID = billID;
        this.ticketID = ticketID;
        this.userID = userID;
        this.quantity = quantity;
        this.total = total;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
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
