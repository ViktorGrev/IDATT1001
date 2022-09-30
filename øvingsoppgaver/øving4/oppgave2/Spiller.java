package oving4_oppgave2;
import java.util.Random;
public class spiller {
    private int sumPoeng;

    public spiller(int sumPoeng){
        this.sumPoeng = sumPoeng;
    }

    public int kastTerning() {
        Random terning = new Random();
        int terningkast = terning.nextInt(6)+1;
        return terningkast;
    }

    public int getSumPoeng(){
        return this.sumPoeng;
    }

    public void setSumPoeng(int nySum){
        this.sumPoeng = nySum;
    }



}
