/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Check.DataBase;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author yat
 */
public class RegisterGUI extends JFrame implements ActionListener{
    
    public RegisterGUI(){
        
    }
    JPanel principale = new JPanel(new GridLayout(6, 2));
    JPanel secondo = new JPanel(new BorderLayout());
    JTextField user = new JTextField(20);
    JTextField nome = new JTextField(20);
    JTextField cognome = new JTextField(20);
    JTextField email = new JTextField(40);
    JPasswordField pass = new JPasswordField(20);
    JPasswordField ri_pass = new JPasswordField(20);
    JButton registra = new JButton("Registra");
    JLabel usr = new JLabel("Username:");
    JLabel name = new JLabel("Nome:");
    JLabel surname = new JLabel("Cognome:");
    JLabel mail = new JLabel("E-mail:");
    JLabel psw= new JLabel("Password:");
    JLabel ri_psw = new JLabel("Ripeti Pass:");
    
    public void Registra() {
        this.add(principale);
        this.add(secondo, BorderLayout.SOUTH);
        
        principale.add(usr);
        principale.add(user);
        principale.add(name);
        principale.add(nome);
        principale.add(surname);
        principale.add(cognome);
        principale.add(mail);
        principale.add(email);
        principale.add(psw);
        principale.add(pass);
        principale.add(ri_psw);
        principale.add(ri_pass);
        secondo.add(registra, BorderLayout.CENTER);
        
        registra.addActionListener(this);
        
        
        
        setTitle("Register");
        setVisible(true);
        setSize(300, 200);
       // setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String p = String.valueOf(pass.getPassword());
        String rp = String.valueOf(pass.getPassword());
        if(user.getText().equals("") || nome.getText().equals("") || cognome.getText().equals("") ||
                email.getText().equals("") || p.equals("") || rp.equals("")) {
            System.out.println("Completare tutti i campi e riprovare.");    
        } else{
            String qry;
            qry = "INSERT INTO Utenti(Username,Nome,Cognome,Email,Password)" + "VALUES(" + 
                   "'"+ user.getText() +"',"+ "'" + nome.getText() + "'," + "'"+ cognome.getText() + "'," +
                    "'"+email.getText() + "'," +"'"+ p + "')";
            DataBase db = new DataBase();
            if(p.equals(rp)){
            try {
                db.Inserisci(qry);
                System.out.println("Benvento!!! Registrazone avvenuta con successo.");
            } catch (SQLException ex) {
                Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else System.out.println("Password non coincidono.");
        }
        
    }
}
