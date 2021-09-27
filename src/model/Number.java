package model;

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
        Log.logWrite("new number has been generated");
    }
    public int getChance() {
    	return chanceUsed;
    }
    public String isCorrect(String number1){
        String frase = "";
        if(!isNumber(number1)){
            frase = " ?????????  numberi !!!!!!!!!!! ?????????";
        }
        else{

        int number = Integer.parseInt(number1);
        if(number > guessNumber) {
            chanceUsed++;
            frase =  "il numero e piu piccolo" + " <br>Tentativi = " + chanceUsed;
        }
        if(number < guessNumber) {
        	chanceUsed++;
            frase =  "il numero e piu grande" + " <br>Tentativi = " + chanceUsed;
        }
        else
        	{
        	frase = "Hai indovinato dopo " + chanceUsed + " Tentativi ! ! ! !" + "<br>Nuovo numero e stato generato";
            genNewNumber();
        	}
        if(chanceUsed == 5) {
        	genNewNumber();
        	frase = "---- non sei riuscito a indovinare il number num = " + guessNumber + " ---- <br>un nuovo numero si e generato" ;
        }
        }
        Log.logWrite(frase.replaceAll("(<html>|</html>|<br>)",""));
        return "<html>" + frase +  " ,input = " +number1 +"</html>";
    }
}
