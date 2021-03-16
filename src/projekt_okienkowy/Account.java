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
class Account {
    final private String SEPARATOR = ",";
    private String eMail, nickname, typeOfAccount;
    private int point,yearOfCreateAcc;
    private String isPremium;

    public Account(String[] tab) {   //konstruktor o parametrze tab, wypełniający pola klasy na podstawie tabeli
        nickname = tab[0];
        eMail = tab[1];
        point = Integer.valueOf(tab[2]); //String to int
        yearOfCreateAcc = Integer.parseInt(tab[3]);
        isPremium = tab[4];
        typeOfAccount = tab[5];
    }

    public String getData() {                 //geter zwracający String z wartościami wszystkich pól klasy przchowujących dane o obiekcie
        String pointss = Integer.toString(point);
               while(pointss.length()<5){
                   pointss = "0" + pointss;
               }
        return nickname + SEPARATOR + eMail + SEPARATOR + pointss + SEPARATOR + String.valueOf(yearOfCreateAcc) + SEPARATOR + isPremium + SEPARATOR + typeOfAccount;
    }

    public String get(int index) {
        switch(index){
           case 0: 
               return nickname;
           case 1:
               return eMail;
           case 2:
               String pointss = Integer.toString(point);
               while(pointss.length()<5){
                   pointss = "0" + pointss;
               }
               return pointss;
           case 3:
               return String.valueOf(yearOfCreateAcc);
           case 4:
               return isPremium;
           case 5:
               return typeOfAccount;
       }
       return null;
    }

    int getNum(int index) {
        switch(index){
           case 2:
               return point;
           case 3:
               return yearOfCreateAcc;
           default:
               return -1;
       }
    }
}
