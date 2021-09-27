package model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Oniichan
 * @data 14/09/2021
 * @project GuessNumber
 */
public class Number {
    private int number;
    private int guessNumber = 0;
    private int chanceUsed = 0;
    private int maxChance;
    public Number(int maxChance){
        genNewNumber();
        this.maxChance = maxChance;
    }




    public boolean isNumber(String text){
        for(char i : text.toCharArray() ){
            if(i > 57 || i < 48) return false;
        }
        return true;
    }
    
    public void genNewNumber() {
    	chanceUsed = 0;
    	guessNumber = ThreadLocalRandom.current().nextInt(50);
    }
    public int getChance() {
    	return chanceUsed;
    }
    public String isCorrect(String number1){
        String frase = "";
        if(!isNumber(number1)){
            frase = "????????????  numberi !!!!!!!!!!!!!!!! ???????????";
        }
        else{

        int number = Integer.parseInt(number1);
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
        	frase = "<html>Hai indovinato dopo " + chanceUsed + " Tentativi ! ! ! !" + "\n\n\n\nNuovo numero e stato generato</html>";
            genNewNumber();
        	}
        if(chanceUsed == 5) {
        	genNewNumber();
        	frase = "<html>non sei riuscito a indovinare il number num = " + guessNumber + "</html>";
        }
        }
        return frase +  " ,input = " +number1;
    }
}
