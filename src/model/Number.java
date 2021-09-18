package model;

import java.util.Random;

/**
 * @author Oniichan
 * @data 14/09/2021
 * @project GuessNumber
 */
public class Number {
    private int guessNumber;
    private int chanceUsed = 0;
    private int maxChance;
    public Number(int number,int maxChance){
        guessNumber = number;
        this.maxChance = maxChance;
    }





    
    public void genNewNumber() {
    	chanceUsed = 0;
    	guessNumber = (new Random()).nextInt(50);
    }
    public int getChance() {
    	return chanceUsed;
    }
    public String isCorrect(int number){
    	
    	String frase = "";
        if(number > guessNumber) {
            chanceUsed++;
            frase =  "<html>il numero e piu piccolo" + " Tentativi = " + chanceUsed + "</html>";
        }
        if(number < guessNumber) {
        	chanceUsed++;
            frase =  "<html>il numero e piu grande" + " Tentativi = " + chanceUsed + "</html>";
        }
        else 
        	{
        	frase = "Hai indovinato dopo " + chanceUsed + " Tentativi";
            genNewNumber();
        	}
        if(chanceUsed == 5) {
        	genNewNumber();
        	frase = "<html>non sei riuscito a indovinare il number num = " + guessNumber + "</html>";
        }
        return frase;
    }
}
