/*  Oppgave 2
Skriv et program som finner ut om et tall er et primtall. Et primtall er et tall som kun kan deles
med 1 og med seg selv uten å få rest. Les inn tallet fra brukeren og la programmet repetere
slik at flere tall kan analyseres.
*/
import java.util.Scanner;
public class oving3_oppgave2 {
    public static void main(String args[]) {
        try (Scanner input = new Scanner(System.in)){
            while (true){
                int tall = 0;
                System.out.printf("Sjekk om et tall er et primtall---> ");
                tall = input.nextInt();
                if (tall <= 1){
                    System.out.println(tall + " er ikke et primtall eller et vanlig tall \n");
                }
                else{
                    boolean sjekk = false;
                    for (int i = 2; i <= tall/2; i++) {
                        if (tall % i == 0) {
                            sjekk = true;
                            break;
                        }
                    }
                    if (sjekk){
                        System.out.println(tall + " er ikke et primtall \n");
                    }
                    else{
                        System.out.println(tall + " er et primtall \n");
                    }
                }
            }
        }
    }
}