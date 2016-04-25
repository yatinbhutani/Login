/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author yat
 */
public class StartGUI extends JFrame implements ActionListener {
    JPanel left = new JPanel(new BorderLayout());
    JPanel right = new JPanel(new BorderLayout());
    JButton login = new JButton("Sign in");
    JButton register = new JButton("Sign up");
    
    public StartGUI(){
        this.add(left);
        this.add(right);
        
        left.add(login, BorderLayout.CENTER);
        right.add(register, BorderLayout.CENTER);
        
        login.addActionListener(this);
        register.addActionListener(this);
        
        
        
        setTitle("Benvenuti!");
        setLayout(new GridLayout(1,2));
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            LoginGUI login = new  LoginGUI();
            this.setVisible(false);
        } else {
            RegisterGUI register = new RegisterGUI();
            register.Registra();
            this.setVisible(false);
        }
    }
    
}
