/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_okienkowy;

import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author user
 */
public class Pass {
    String path;
    String passWord;
    String alfa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public Pass() throws IOException{
        path = "pass.txt";
        
        if(!new File(path).exists()){
            try (FileWriter fileWriter = new FileWriter(path)) {
                String t = "TRABANT";
                for(int i = 0; i<t.length();i++){
                    int pos = (alfa.indexOf(t.charAt(i))+1);
                    if(pos>=alfa.length()){
                        pos = pos-alfa.length();
                    }
                    fileWriter.write(alfa.charAt(pos));
                } 
            }
        }
    }
    private boolean Transcript(String text) throws FileNotFoundException{
        String userPass = "";
        for(int i = 0; i<text.length();i++){
            int pos = (alfa.indexOf(text.charAt(i))+1);
            if(pos>=alfa.length()){
                pos = pos-alfa.length();
            }
            userPass += alfa.charAt(pos);
        } 
        Scanner scan = new Scanner(new File(path));
        String pass=scan.next();
        return (userPass.equals(pass));
    }
    
    public boolean GetPass() throws FileNotFoundException{
        JPanel panel = new JPanel();
        JLabel l = new JLabel();
        l.setText("Drogi użytkowniku, bardzo proszę podaj hasło");
        JPasswordField t = new JPasswordField();
        t.setEchoChar('*');
        GridLayout GL = new GridLayout(2,1);
        panel.add(l);
        panel.add(t);
        panel.setLayout(GL);
        JOptionPane.showMessageDialog(null, panel);
        boolean result = Transcript(t.getText());
        if(!result)
        {
            JOptionPane.showMessageDialog(null, "Złe Hasło zły człowieku ", "InfoBox: " + "Err", JOptionPane.INFORMATION_MESSAGE);
        }
        return result;
    }
}

