/**
* Message class for encoding and decoding messages between the server and client
*
* @author  Lufuno Tshishivhiri
* @version 1.0
* @since   02/04/2021 
*/

public class Message {
    
    private User user;
    public boolean command;
    private String text;

    public Message(User user, boolean command, String text){
        this.user = user;
        this.command = command;
        this.text = text;
    }

    public Message(String encoded){
        parseString(encoded);
    }

    public String getString(){
        return user.getId() +"++"+ user.getUsername() + "++"+ command +"++" + text;
    }

    public void parseString(String message){
        String [] data = message.split("++");
        user = new User(Integer.parseInt(data[0]),data[1]);
        command = Boolean.parseBoolean(data[2]);
        text = data[3];
    }

    public User getUser(){
        return user;
    }

    public String getText(){
        return text;
    }
}
