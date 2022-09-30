/*Oppgave 1:
Lag et program som skriver ut en del av multiplikasjonstabellen, for eksempel fra 13-15. Da
skal utskriften se omtrent slik ut (prikkene skal erstattes med regnestykker).
13-gangen:
13 x 1 = 13
13 x 2 = 26
…
13 x 10 = 130
14-gangen:
14 x 1 = 14
14 x 2 = 28
…
14 x 10 = 140
15-gangen:
15 x 1 = 15
15 x 2 = 30
…
15 x 10 = 150
Brukeren skal velge hvilken del av tabellen som skal skrives ut. */
import java.util.Scanner;
public class oving3_oppgave1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Gangetabell 1: ");
        int tall1 = input.nextInt();
        System.out.printf("Gangetabell 2: ");
        int tall2 = input.nextInt();
        input.close();

        int minsteTall = Math.min(tall1, tall2);
        int størsteTall = Math.max(tall1, tall2);

        for(; minsteTall <= størsteTall; minsteTall++){
            System.out.println("Gangetabellen for " + minsteTall );
            for (int i = 1; i < 11; i++) {
                System.out.println(minsteTall + " x " + i + " = " + (minsteTall*i));
            }
        }
    }
}

