package oving4_oppgave2;

public class krig {
    public static void main(String[] args) {
        spiller playerA = new spiller(0);
        spiller playerB = new spiller(0);

        int runde = 0;
        int index = 0;
        
        while (playerA.getSumPoeng() < 100 || playerB.getSumPoeng() < 100){
            if (index == 0){
                runde++;
                System.out.println("Runde: " + runde);
                spillRunde(playerA);
                System.out.println("A: " + playerA.getSumPoeng());
                index = 1;
            }
            else{
                spillRunde(playerB);
                System.out.println("B: " + playerB.getSumPoeng());
                index = 0;
            }
        }

        if (playerA.getSumPoeng() > playerB.getSumPoeng()){
            erFerdig("A", playerA.getSumPoeng());
        }
        else{
            erFerdig("B", playerB.getSumPoeng());
        }
    }

    public static void erFerdig(String spiller, int vinnerPoeng){
        System.out.println("Spiller: " + spiller + " har vunnet med: " + vinnerPoeng);
    }

    
    public static void spillRunde(spiller spiller){
        int tall = spiller.kastTerning();
        if (tall == 1){
            spiller.setSumPoeng(0);
        }
        else{
            spiller.setSumPoeng(tall + spiller.getSumPoeng());
        }
    }
}
