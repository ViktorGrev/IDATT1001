package oving6_oppgave2;
import java.util.Arrays;
public class Oppgave {
    public static void main(String[] args){
        Tekstanalyse analyse = new Tekstanalyse("Jeg elsker Javaaa");

        analyse.tellBokstaver();
        analyse.antallBokstaver();
        analyse.bokstavCheck('j');
        analyse.forskjelligeBokstaver();
        System.out.println(Arrays.toString(analyse.getAntall()));
        System.out.println("Antall forksjellige bokstaver: " + analyse.getAntallForksjelligeBokstaver());
        System.out.println("Antall bokstaver i teksten: " + analyse.getBokstaver());
        System.out.println("Prosent: " + analyse.getProsent() + "%");
        System.out.println("Så mange er det av den spesifike bokstaven: " + analyse.getAntallAvSpesifkBokstav());
        analyse.forekommer();
    }
}
