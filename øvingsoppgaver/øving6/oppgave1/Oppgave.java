package oving6_oppgave1;
import java.util.Random;
import java.util.Arrays;
import java.lang.Math;
public class Oppgave {

    public static void main(String[] args) {
        int antall[] = new int[10];

        int tall;
        double stjerner;
        for(int i = 0; i <= 1000; i++){
            tall = random();
            antall[tall] += 1;
        }
        for(int i = 0; i < 10; i++){
            System.out.printf("\n" + i + ": " + antall[i]);
            stjerner = (Math.round(antall[i] / (1000/100.0)));
            for(int t = 0; t < stjerner; t++){
                System.out.printf("*"); 
            }
        }
        System.out.println("\n" + Arrays.toString(antall));  
    }

    public static int random(){
        Random random = new Random();
        int tall = (random.nextInt(10));
        return tall;
    }
}
