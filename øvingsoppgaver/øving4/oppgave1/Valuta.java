package oving4_oppgave1;

public class Valuta {
    double kurs;

    Valuta(double kurs){
        this.kurs = kurs;
    }

    double kalkulerNok(double antall){
        double nok = antall * kurs;
        return nok;
    }

    double kalkulerUtland(double antall){
        double utland = antall / kurs;
        return utland;
    }
}
