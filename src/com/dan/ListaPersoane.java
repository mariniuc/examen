package com.dan;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListaPersoane {

    private ArrayList<Persoana> persoane = new ArrayList<>();

    public void addPersoana(String nume, String prenume, int varsta) {

        persoane.add(new Persoana(nume, prenume, varsta));
    }

    public ArrayList<Persoana> getPersoane() {
        return persoane;
    }

    public void printPersoane() {
        for (Persoana persoana : persoane) {
            System.out.println(persoana.toString());
        }
    }

    public void modifyPersoane(Persoana persoana, String nume, String prenume, int varsta) {
        int position = persoane.indexOf(persoana);

        Persoana newPersoana = new Persoana();
        newPersoana.setNume(nume);
        newPersoana.setPrenume(prenume);
        newPersoana.setVarsta(varsta);

        persoane.set(position, newPersoana);
    }

    public Persoana findPersoana(String nume) {
        for (Persoana persoana : persoane) {
            if (persoana.getNume().equals(nume)) {
                return persoana;
            }
        }
        return null;
    }

    public void removePersoana(String nume) {
        Persoana tempPersoana = findPersoana(nume);
        persoane.remove(tempPersoana);
    }

    public void exportTxt() throws IOException {
        FileReader in = null;
        FileWriter out = null;

        try {
            out = new FileWriter("persoane.txt");
            for (Persoana persoana : persoane) {
                out.write(persoana.toString() + "\n");
            }
        } finally {
            out.close();
        }
    }
}
