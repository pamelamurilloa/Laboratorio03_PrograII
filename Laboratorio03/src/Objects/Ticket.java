package Objects;


public class Ticket {
    private int locationID;
    private int sponsorID;
    private int price;
    private int amountStock;

    public Ticket(int locationID, int sponsorID, int price, int amountStock) {
        this.locationID = locationID;
        this.sponsorID = sponsorID;
        this.price = price;
        this.amountStock = amountStock;
    }
    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getSponsorID() {
        return sponsorID;
    }

    public void setSponsorID(int sponsorID) {
        this.sponsorID = sponsorID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmountStock() {
        return amountStock;
    }

    public void setAmountStock(int amountStock) {
        this.amountStock = amountStock;
    }
    
    
}
