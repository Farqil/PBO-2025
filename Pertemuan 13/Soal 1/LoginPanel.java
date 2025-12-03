/**
 * @author Farrel Aqilla Novianto
 */
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  

public class LoginPanel{  
  private UserDatabase userDatabase;
  private JTextField txtUsername;
  private JTextField txtPassword;
  
  public LoginPanel(){
    userDatabase = new UserDatabase();
    createAndShowGUI();
  }
  
  public void createAndShowGUI(){  
    JFrame frame = new JFrame("Login System");  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    
    JPanel panel = new JPanel();  
    panel.setLayout(new GridLayout(3, 2, 10, 10));
    
    JLabel lblUsername = new JLabel("Username:");    
    JLabel lblPassword = new JLabel("Password:");  
    txtUsername = new JTextField(20);  
    txtPassword = new JPasswordField(20);  
    JButton btnLogin = new JButton("Login");  
    btnLogin.addActionListener(new LoginListener());  
    JButton btnCancel = new JButton("Cancel");  
    btnCancel.addActionListener(new CancelListener());  
    
    panel.add(lblUsername);  
    panel.add(txtUsername);  
    panel.add(lblPassword);  
    panel.add(txtPassword);
    panel.add(btnLogin);
    panel.add(btnCancel);
    frame.getContentPane().add(BorderLayout.CENTER, panel);  
    frame.setSize(400, 200);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);  
  }  
  
  private class LoginListener implements ActionListener{  
    public void actionPerformed(ActionEvent event){
      String msg;
      String inputUsername = txtUsername.getText();
      String inputPassword = txtPassword.getText();
      
      if(userDatabase.validateUser(inputUsername, inputPassword)){  
        msg = "Login Granted!";  
      }
      else{  
        msg = "Login Denied";  
      }    
      JOptionPane.showMessageDialog(null, msg);            
    }  
  }  
  
  private class CancelListener implements ActionListener{  
    public void actionPerformed(ActionEvent event){  
      txtUsername.setText("");  
      txtPassword.setText("");  
      txtUsername.requestFocus();  
    }  
  }  
}