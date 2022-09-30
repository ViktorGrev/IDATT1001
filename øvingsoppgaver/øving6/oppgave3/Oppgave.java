package oving6_oppgave3;
import java.util.Arrays;
import java.util.Scanner;
public class Oppgave {
    public static void main(String[] args){
        int matrix1[][] = {{2,5,6,5,3},
                           {2,6,7,3,2},
                           {2,3,5,7,5}}; //For multiplikasjonstesting

                         /*{5,7,1},
                           {2,2,1},
                           {2,8,7},
                           {9,9,9},
                           {1,3,2} */ //For addisjonstesting

        int matrix2[][] = {{2,4,5},
                           {2,6,7},
                           {2,6,7},
                           {2,6,7},
                           {2,6,7}};
        
        Scanner input = new Scanner(System.in);
        System.out.println("1. addisjon \n2. multiplikasjon\n3. transponer ");
        System.out.println("Regneart: ");
        int regneArt = input.nextInt();
        input.close();

        Matrise matrise = new Matrise(matrix1);

        if(regneArt == 1){
            matrise.addisjonMatrise(matrix2);
        }

        else if(regneArt == 2){
            matrise.multipliserMatrise(matrix2);
        }

        else if(regneArt == 3){
            matrise.transponerMatrise();
        }
        
        for(int i = 0; i < matrise.getSvarMatrise().length; i++){
            System.out.print(Arrays.toString(matrise.getSvarMatrise()[i]) + "\n");
        }
    }
}
