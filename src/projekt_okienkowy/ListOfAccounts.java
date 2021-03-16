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
class ListOfAccounts{
    public LinkedList<Account> ListOfData; 
    final private String SEPARATOR = ",";
    private String fileName;
    
    ListOfAccounts() {
        this.ListOfData = new LinkedList<>();
    }
    ListOfAccounts(LinkedList<Account> list ) {
        this.ListOfData = list;
    }
    
    
    public void SaveFile() throws IOException{
       try (FileWriter fileWriter = new FileWriter(fileName)) {
           fileWriter.write("A"+System.lineSeparator());
           for(int i = 0; i<ListOfData.size(); i++){
               fileWriter.write(ListOfData.get(i).getData()+System.lineSeparator());
           }
           fileWriter.write("EOF");
       }catch(Exception e){
           SaveFileAs();
       }
    
}

    public void SaveFileAs() throws IOException {
       String FilePathBox = JOptionPane.showInputDialog("Podaj nazwę pliku");
        try (FileWriter fileWriter = new FileWriter(FilePathBox)) {
           fileWriter.write("A"+System.lineSeparator());
           for(int i = 0; i<ListOfData.size(); i++){
               fileWriter.write(ListOfData.get(i).getData()+System.lineSeparator());
           }
           fileWriter.write("EOF");
        }
    }
    public void SetFileName(String fileName){
        this.fileName = fileName;
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
            String[] tab;
            tab = (line.split(SEPARATOR));
            add(tab);            
        }
    }

   public void add(String[] tab) {
        ListOfData.add(new Account(tab));       
    }    
}
    
