package Objects;


public class User {
    private int idUser;
    private String firstName;
    private char gender;

    public User(int idUser, String firstName, char gender) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.gender = gender;
    }

    public int getID() {
        return idUser;
    }

    public void setID(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    
    
           
}
