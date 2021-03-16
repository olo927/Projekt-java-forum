/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_okienkowy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ListOfUsers {
   public LinkedList<User> ListOfData; 
   final private String SEPARATOR = ",";
   private String fileName;
    
    ListOfUsers() {
        this.ListOfData = new LinkedList<>();
    }

    ListOfUsers(LinkedList<User> found) {
        this.ListOfData = found;
    }
    
    public void SaveFile() throws IOException{
       try (FileWriter fileWriter = new FileWriter(fileName)) {
           fileWriter.write("U"+System.lineSeparator()); //nadanie identyfikatora pliku
           for(int i = 0; i<ListOfData.size(); i++){
               fileWriter.write(ListOfData.get(i).getData()+System.lineSeparator()); //zapisanie danych do pliku
           }
           fileWriter.write("EOF");
       }catch(Exception e){
           SaveFileAs();
       }
    
}

    public void SaveFileAs() throws IOException {
       String FilePathBox = JOptionPane.showInputDialog("Podaj nazwę pliku");
        try (FileWriter fileWriter = new FileWriter(FilePathBox)) {
           fileWriter.write("U"+System.lineSeparator()); //napisz identyfikator i przejdz do nowej linii
           for(int i = 0; i<ListOfData.size(); i++){
               fileWriter.write(ListOfData.get(i).getData()+System.lineSeparator());
           }
           fileWriter.write("EOF");
        }
    }

    public void SetFile(File file) throws FileNotFoundException {
        this.fileName = file.getName();
        Scanner scan = new Scanner(file);
        String line = scan.nextLine();
        boolean endOfFile = false;
        while(!endOfFile){
            line = scan.nextLine();
            if("EOF".equals(line))
            {
                endOfFile = true;
                break;
            }
            String[] tab = null;
            tab = line.split(SEPARATOR); //umiesc w tab cala linie podzielona separatorem
            ListOfData.add(new User(tab));     //do list of data dodaj 1 linijke z nowym uzytkoiwnikiem       
        }
        
    }

    void SetFileName(String name) {
        this.fileName = name;
    }

    void add(String[] tab) {
        ListOfData.add(new User(tab));
    }

}