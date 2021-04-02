/**
* User class for storing user information for the server and client
*
* @author  Lufuno Tshishivhiri
* @version 1.0
* @since   02/04/2021 
*/
public class User {
    private int id;
    private String username;

    public User(int id, String username){
        this.id = id;
        this.username = username;
    }
    
    public String getUsername(){
        return username;
    }

    public int getId(){
        return id;
    }
}
