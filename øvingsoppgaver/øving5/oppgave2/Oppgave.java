package oving5_oppgave2;
import java.util.Scanner;
public class Oppgave {
    public static void main(String[] args) {
        MinRandom random = new MinRandom();
        Scanner input = new Scanner(System.in);
        System.out.printf("Starten på intervallet: ");
        int nedre = input.nextInt();
        System.out.printf("Slutten på intervallet: ");
        int ovre = input.nextInt();
        input.close();

        for(int i = 0; i < 10; i++){
            System.out.println(random.nesteHeltall(nedre, ovre));
        }
        for(int i = 0; i < 10; i++){
            System.out.println(random.nesteDesimal(nedre, ovre));
        }
    }
}
