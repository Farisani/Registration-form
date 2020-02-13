import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RegistrationForm extends ActionListener {
JFrame frame;

String[] gender={"Male", "Female"};
JLabel nameLabel = new JLabel("Name");
JLabel surnameLabel = new JLabel("Surname");
JLabel genderLabel = new JLabel("Gender");
JLabel idNumberLabel = new JLabel("Identity Number");
JLabel dobLabel = new JLabel("Date Of Birth");
JLabel emailLabel = new JLabel("Email");
JLabel passwordLabel = new JLabel("Password");
JLabel confirmPasswordLabel = new JLabel("Confirm Password");
JTextField nameTextField = new JTextField();
JTextField surnameTextField = new JTextField();
JComboBox genderComboBox = new JComboBox(gender);
JTextField idNumberTextField = new JTextField();
JTextField dobTextField = new JTextField();
JTextField emailTextField = new JTextField();
JPasswordField passwordField = new JPasswordField();
JPasswordField confirmPasswordField = new JPasswordField();
JButton registerButton = new JButton("Register");
JButton signInButton = new JButton("Sign In");


RegistrationForm(){
  createWindow()
  setLocationAndSize();
  addComponentsToFrame();
  actionEvent();
}
public void createWindow(){
  frame= new JFrame();
  frame.setTitle("Registration Form");
  frame.setBounds(40,40,380,600);
  frame.getContentPane().setBackground(Color.blue);
  frame.getContentPane().setLayout(null);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setResizable(false);
}

public void setLocationAndSize(){
  nameLabel.setBounds(20,20,40,70);
  surnameLabel.setBounds(20,120,100,70);
  genderLabel.setBounds(20,70,80,70);
  idNumberLabel.setBounds(20,120,100,70);
  dobLabel.setBounds(20,20,40,70);
  emailLabel.setBounds(20,130,100,70);
  passwordLabel.setBounds(20,220,140,70);
  confirmPasswordLabel.setBounds(20,220,140,70);
  nameTextField.setBounds(180,43,165,23);
  surnameTextField.setBounds(180,143,165,23);
  genderComboBox.setBounds(180,93,165,23);
  idNumberTextField.setBounds(18-,143,165,23);
  dobTextField.setBounds(180,43,165,23);
  emailTextField.setBounds(180,343,165,23);
  passwordField.setBounds(180,193,165,23);
  confirmPasswordField.setBounds(180,193,165,23);
}


public void addComponentsToFrame(){
  frame.add(nameLabel);
  frame.add(surnameLabel);
  frame.add(genderLabel);
  frame.add(idNumberLabel);
  frame.add(dobLabel);
  frame.add(emailLabel);
  frame.add(passwordLabel);
  frame.add(confirmPasswordLabel);
  frame.add(nameTextField);
  frame.add(surnameTextField);
  frame.add(genderComboBox);
  frame.add(idNumberTextField);
  frame.add(dobTextField);
  frame.add(emailTextField);
  frame.add(passwordField);
  frame.add(confirmPasswordField);
}

public void ActionEvent(){
  registerButton.addActionListener(this);
  signInButton.addActionListener(this);
}

  @Override
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==registerButton){
      try{
        Connection connection = DriverManager.getConnection(jdbc:mysql://localhost:3306/myDatabase","root","root");
        PreparedStatement Pstatement = connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
        Pstatement.setString(1,nameTextField.getText());
        Pstatement.setString(2,surnameTextField.getText());
        Pstatement.setString(3,genderComboBox.getSelectedItem().toString());
        Pstatement.setString(4,idNumberTextField.getText());
        Pstatement.setString(5,dobTextField.getText());
        Pstatement.setString(6,emailTextField.getText());
        Pstatement.setString(7,passwordField.getText());
        Pstatement.setString(8,confirmPasswordField.getText());

        if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText())){
          Pstatement.executeUpdate();
          JOptionPane.showMessageDialog(null , "Successfully Registered");
        }
        else{
          JOptionPane.showMessageDialog(null, "Password did not match");
        }
        catch(SQLException e1){
          e1.printStackTrace();
        }
      }

if(e.getSource()==signInButton){
  nameTextField.setText("");
  surnameTextField.setText("");
  genderComboBox.setSelectedItem("Male");
  idNumberTextField.setText("");
  dobTextField.setText("");
  emailTextField.setText("");
  passwordField.setText("");
  confirmPasswordField.setText("");
}
  }
  }

  public static void main(String[] args) {
    new RegistrationForm();
  }
}
