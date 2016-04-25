/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Check.DataBase;

import java.awt.*;
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
public class LoginGUI extends JFrame implements ActionListener {

    JPanel top = new JPanel(new BorderLayout());
    JPanel middle = new JPanel(new BorderLayout());
    JPanel bottom = new JPanel(new BorderLayout());

    JLabel username = new JLabel("Username: ");
    JLabel password = new JLabel("Password: ");

    JTextField user = new JTextField(20);
    JPasswordField pass = new JPasswordField(20);
    JButton submit = new JButton("Submit");

    public LoginGUI() {
        initGUI();
    }

    private void initGUI() {
        this.add(top);
        this.add(middle);
        this.add(bottom);

        top.add(user, BorderLayout.CENTER);
        top.add(username, BorderLayout.WEST);
        middle.add(pass, BorderLayout.CENTER);
        middle.add(password, BorderLayout.WEST);
        bottom.add(submit, BorderLayout.CENTER);

        user.setEditable(true);
        submit.addActionListener(this);

        setTitle("Login");
        setVisible(true);
        setLayout(new GridLayout(3, 1));
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String p = String.valueOf(pass.getPassword());
        if (user.getText().equals("") || p.equals("")) {
            System.out.println("Inserire correttamente tutti i campi!");
        } else {
            String query;
            query = "SELECT Nome"
                    + " FROM Utenti"
                    + " WHERE Username = " + "'" + user.getText() + "'"
                    + "AND Password = '" + p + "'";
            DataBase db = new DataBase();
            try {
                String result = db.Query(query);
                System.out.println(result);
            } catch (SQLException ex) {
                Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
