package Bussiness;

import Data.DBManager;
import Objects.User;
import java.util.ArrayList;


public class UserManager {
    
    DBManager dbManager = new DBManager();
    
    public int isNumeric(String string){
	try {
            return Integer.parseInt(string);
	} catch (NumberFormatException nfe){
            return -1;
	}
    }
    
    public boolean insertUser(User user) {
        if (dbManager.doesUserExist( user.getID() ) == false) {
            dbManager.insertUser(user);
            return true;
        }
            return false;
    }
    
    public ArrayList getUserList() {
        return dbManager.getUserIDs();
    }
}
