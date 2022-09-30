package oving5_oppgave2;
import java.util.Random;
public class MinRandom {
    Random random = new Random();
    
    public int nesteHeltall(int nedre, int ovre){
        int randomHeltall = (random.nextInt((ovre - nedre))) + nedre;
        return randomHeltall;
    }

    public double nesteDesimal(double nedre, double ovre){
        Double randomDesimal = (random.nextDouble((ovre - nedre))) + nedre;
        return randomDesimal;
    }
}
