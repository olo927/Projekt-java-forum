/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_okienkowy;


/**
 *
 * @author user
 */
public class User{
    final private String SEPARATOR = ",";
    private String name, surname, eMail,city;
    private Size sizeOfShirt;
    private int yearOfBirth;
    
    

   public User(String[] tab) {
        name = tab[0];
        surname = tab[1];
        eMail = tab[2];
        sizeOfShirt = Size.valueOf(tab[3]);
        yearOfBirth = Integer.parseInt(tab[4]);
        city = tab[5];
    }


   public String getData() {
        return name + SEPARATOR + surname + SEPARATOR + eMail + SEPARATOR + String.valueOf(sizeOfShirt) + SEPARATOR + String.valueOf(yearOfBirth)+ SEPARATOR + city;
    }
   public String get(int index){
       switch(index){
           case 0: 
               return name;
           case 1:
               return surname;
           case 2:
               return eMail;
           case 3:
               return sizeOfShirt.toString();
           case 4:
               return String.valueOf(yearOfBirth);
           case 5:
               return city;
       }
       return null;
   }

    int getNum(int index) {
        switch(index){
           case 4:
               return yearOfBirth;
           default:
               return -1;
       }
    }

}
