package oving6_oppgave2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tekstanalyse {
    private int antall[] = new int[30];
    private String tekst;
    private char[] bokstaver = {'a', 'b', 'c', 'd', 'e', 'f',
                           'g', 'h', 'i', 'j', 'k', 'l',
                           'm', 'n', 'o', 'p', 'q', 'r',
                           's', 't', 'u', 'v', 'w', 'x',
                           'y', 'z', 'æ', 'ø', 'å'};
    private int antallBokstaver = 0; 
    private int antallAvSpesifikBokstav = 0; 
    private int antallForskjelligeBokstaver = 0;
    String regex = "\\W";

    Pattern pat = Pattern.compile(regex);
    Matcher match;

    public Tekstanalyse(String tekst){
        this.tekst = tekst.toLowerCase();
    }

    public void tellBokstaver(){
        for(int i = 0; i < tekst.length(); i++){
            for(int t = 0; t < bokstaver.length; t++){
                if(tekst.charAt(i) == bokstaver[t]){
                    antall[t] += 1;
                }
            }
            match = pat.matcher(Character.toString(tekst.charAt(i)));
            if(match.matches()){
                antall[29]++;
            }
        } 
    }

    public void forskjelligeBokstaver(){
        for (int v = 0; v < bokstaver.length; v++){
            if(antall[v] != 0){
                antallForskjelligeBokstaver += 1;
            }
        }
    }

    public void antallBokstaver(){
        for(int i = 0; i < tekst.length(); i++){
            for(int t = 0; t < bokstaver.length; t++){
                if(tekst.charAt(i) == bokstaver[t]){
                    antallBokstaver += 1;
                }
            }
        } 
    }

    public void bokstavCheck(char bokstav){
        for(int i = 0; i < tekst.length(); i++){
                if(tekst.charAt(i) == bokstav){
                    antallAvSpesifikBokstav += 1;
                }
        } 
    }

    public void forekommer(){
        int max = antall[0];  
        //Loop through the array  
        for (int i = 0; i < antall.length; i++) {  
            //Compare elements of array with max  
           if(antall[i] > max)  
               max = antall[i];  
        }  
        System.out.println("Bokstaver som forekommer flest ganger: ");
        for (int v = 0; v < bokstaver.length; v++){
            if(antall[v] == max){
                System.out.println(bokstaver[v]);
            }
        }
    }

    public int[] getAntall(){
        return this.antall;
    }
    public int getBokstaver(){
        return this.antallBokstaver;
    }
    public double getProsent(){
        double prosent = (antall[29]*100.0) / tekst.length();
        return prosent;
    }
    public int getAntallAvSpesifkBokstav(){
        return this.antallAvSpesifikBokstav;
    }
    public int getAntallForksjelligeBokstaver(){
        return this.antallForskjelligeBokstaver;
    }

}
