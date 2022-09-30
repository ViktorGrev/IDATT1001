/* Oppgave 3
Skriv et program som leser inn et antall sekunder og beregner hvor mange timer, minutter og
sekunder dette er. (Hint: Bruk heltallsdivisjon.) Sett opp testdatasett og prøv ut programmet. */
import java.util.Scanner;
public class oving1_oppgave3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Antall sekunder: ");

        int totalSekunder = input.nextInt();
        //int totalSekunder = 5671;

        int timer = totalSekunder/3600;
        int minutter = (totalSekunder % 3600) / 60;
        int sekunder = totalSekunder % 60;
        System.out.println("Timer: " + timer + " Minutter: " + minutter + " Sekunder: " + sekunder ); 
        input.close();
    }
}

