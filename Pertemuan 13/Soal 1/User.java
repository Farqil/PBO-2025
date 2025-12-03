/**
 * @author Farrel Aqilla Novianto
 */
import java.util.ArrayList;
import java.util.List;

public class User{
  private String username;
  private String password;
  
  public User(String username, String password){
    this.username = username;
    this.password = password;
  }
  
  public String getUsername(){
    return username;
  }
  
  public void setUsername(String username){
    this.username = username;
  }
  
  public String getPassword(){
    return password;
  }
  
  public void setPassword(String password){
    this.password = password;
  }
  
  public boolean authenticate(String inputUsername, String inputPassword){
    return this.username.equals(inputUsername) && this.password.equals(inputPassword);
  }
}

class UserDatabase{
  private List<User> users;
  
  public UserDatabase(){
    users = new ArrayList<>();
    users.add(new User("james3302", "pass"));
    users.add(new User("admin", "admin123"));
    users.add(new User("user1", "password1"));
  }
  
  public void addUser(User user){
    users.add(user);
  }
  
  public boolean validateUser(String username, String password){
    for(User user : users){
      if(user.authenticate(username, password)){
        return true;
      }
    }
    return false;
  }
  
  public User findUser(String username){
    for(User user : users){
      if(user.getUsername().equals(username)){
        return user;
      }
    }
    return null;
  }
}