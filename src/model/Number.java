package model;

import java.util.Random;

/**
 * @author Oniichan
 * @data 14/09/2021
 * @project GuessNumber
 */
public class Number {
    private int number;
    private int guessNumber;
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
    	guessNumber = (new Random()).nextInt(50);
    }
    public int getChance() {
    	return chanceUsed;
    }
    public String isCorrect(String number1){
        String frase = "";
        if(!isNumber(number1)){
            return "????????????  numberi !!!!!!!!!!!!!!!! ???????????";
        }

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
        	frase = "<html>Hai indovinato dopo " + chanceUsed + " Tentativi" + "Nuovo numero e stato generato</html>";
            genNewNumber();
        	}
        if(chanceUsed == 5) {
        	genNewNumber();
        	frase = "<html>non sei riuscito a indovinare il number num = " + guessNumber + "</html>";
        }
        return frase;
    }
}
