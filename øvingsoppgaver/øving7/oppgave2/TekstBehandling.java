package oving7_oppgave2;

public class TekstBehandling {
    String setning;
    double antallBokstaver = 0.0;
    int finnAntallOrdIPeriode = 0;

    public TekstBehandling(String setning){
        this.setning = setning;
    }

    public int finnAntallOrd(){
        String regex = "([^a-zA-ZÆæØøÅå']+)'*\\1*";
        String[] ord = setning.split(regex);
        int antallOrd = ord.length;
        return antallOrd;
    }

    public double finnGjennomsnittLengdeOrd(){
        String regex = "([^a-zA-ZÆæØøÅå']+)'*\\1*";
        String[] ord = setning.split(regex);
        for (int i = 0; i < ord.length; i++){
            antallBokstaver += ord[i].length();
        }
        int antallOrd = ord.length;
        double gjennomsnittLengdeOrd = antallBokstaver / antallOrd;
        return gjennomsnittLengdeOrd;
    }

    public double finnAntallOrdIPeriode(){
        String regex1 = "[.!;?:]+";
        String[] ord1 = setning.split(regex1);
        double antallPerioder = ord1.length;
        String regex2 = "([^a-zA-ZÆæØøÅå']+)'*\\1*";
        String[] ord2 = setning.split(regex2);
        double antallOrd = ord2.length;
        return antallOrd / antallPerioder;
    }

    public String endre(String fra, String til){
        String setning1 = setning.replace(fra, til);
        return setning1;
    }

    public String getSetning(){
        return setning;
    }

    public String getSetningStor(){
        return setning.toUpperCase();
    }
}