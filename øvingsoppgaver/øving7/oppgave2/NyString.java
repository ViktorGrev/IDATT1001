package oving7_oppgave1;
public class NyString {
    private String setning;
    private String forkortSetning = "";
    private String fjernSetning = "";
    public NyString(String setning){
        this.setning = setning;
    }

    public String forkort(){
        String[] words = setning.split(" ");

        for (int i = 0; i < words.length; i++){
            char bokstav = words[i].charAt(0);
            forkortSetning += bokstav;
        }
        return forkortSetning;
    }

    public String fjern(String bokstav){
        fjernSetning = setning.replace(bokstav, "");
        return fjernSetning;
    }
}
