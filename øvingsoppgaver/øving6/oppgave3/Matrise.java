package oving6_oppgave3;
public class Matrise {
    private int matrix[][];
    private int svarMatrix[][];

    public Matrise(int[][] matrix){
        this.matrix = matrix;
    }

    public void addisjonMatrise(int[][] matrix2){
        int lengde1 = matrix.length;
        int lengde2 = matrix2.length;
        int bredde1 = matrix[0].length;
        int bredde2 = matrix2[0].length;
        int[][] zeros = new int[lengde1][bredde2];
        if(bredde1 == bredde2 && lengde1 == lengde2){
            for(int i = 0; i < lengde1; i++){
                for(int j = 0; j < bredde1; j++){
                    zeros[i][j] = (matrix[i][j] + matrix2[i][j]);
                }
            }
            this.svarMatrix = zeros;
        }
        else{
            throw new IllegalArgumentException("Denne matrisen er ikke mulig å addere");
        }
    }

    public void multipliserMatrise(int[][] matrix2){
        int lengde1 = matrix.length;
        int lengde2 = matrix2.length;
        int bredde1 = matrix[0].length;
        int bredde2 = matrix2[0].length;
        int[][] zeros = new int[lengde1][bredde2];
        int zerosLengde = zeros.length;
        int zerosBredde = zeros[0].length;
        if (bredde1 == lengde2){
            for(int i = 0; i < zerosLengde; i++){
                 for(int v = 0; v < zerosBredde; v++){
                        for(int j = 0; j < bredde1; j++){
                            zeros[i][v] += matrix[i][j] * matrix2[j][v];
                        }
                }
            }
            this.svarMatrix = zeros;
         }
         else{
             throw new IllegalArgumentException("Denne matrisen er ikke mulig å addere");
         }
    }

    public void transponerMatrise(){
        int lengde = matrix.length;
        int bredde = matrix[0].length;
        int[][] zeros = new int[bredde][lengde];
        for(int i = 0; i < bredde; i++){
            for(int j = 0; j < lengde; j++){
                zeros[i][j] = matrix[j][i];
            }
        }
        this.svarMatrix = zeros;
    }

    public int[][] getSvarMatrise(){
        return svarMatrix;
    }
    
}
