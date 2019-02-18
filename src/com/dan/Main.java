package com.dan;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ListaPersoane listaPersoane = new ListaPersoane();

    public static void main(String[] args) {

        boolean quit = false;
        int choice;

        printInstructions();

        while (!quit) {
            System.out.println("Indrodu optiunea: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Nu este o optiune valida!");
                break;
            }
            switch (choice) {
                case 1:
                    listaPersoane.printPersoane();
                    break;
                case 2:
                    addPersoana();
                    break;
                case 3:
                    modifyPersoana();
                    break;
                case 4:
                    deletePersoana();
                    break;
                case 5:
                    searchPersoana();
                    break;
                case 6:
                    export();
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Nu este o optiune valida!");
                    break;
            }

        }
    }

    private static void deletePersoana() {
        System.out.println("Introdu numele persoanei pe care vrei s-o stergi: ");
        String nume = scanner.nextLine();
        listaPersoane.removePersoana(nume);
    }

    private static void searchPersoana() {
        System.out.println("Introdu numele persoanei pe care vrei s-o cauti:");
        String nume = scanner.nextLine();
        System.out.println(listaPersoane.findPersoana(nume).toString());

    }

    private static void modifyPersoana() {
        System.out.println("Introdu numele persoanei pe care vrei s-o modifici:");
        String nume = scanner.nextLine();
        Persoana persoana1 = listaPersoane.findPersoana(nume);
        System.out.println("Nume");
        String numeModificat = scanner.nextLine();
        System.out.println("Prenume:");
        String prenume = scanner.nextLine();
        System.out.println("Varsta: ");
        int varsta = scanner.nextInt();
        listaPersoane.modifyPersoane(persoana1, numeModificat, prenume, varsta);
    }

    public static void printInstructions() {
        System.out.println("\nOptiuni:");
        System.out.println("\t 1 - Listeaza persoanele.");
        System.out.println("\t 2 - Introduce persoana.");
        System.out.println("\t 3 - Modifica persoana");
        System.out.println("\t 4 - Sterge persoana");
        System.out.println("\t 5 - Cauta persoana");
        System.out.println("\t 6 - Exporta in format text");
        System.out.println("\t 7 - Inchide Aplicatia");
    }

    public static void addPersoana() {
        System.out.println("Nume:");
        String nume = scanner.nextLine();
        System.out.println("Prenume:");
        String prenume = scanner.nextLine();
        System.out.println("Varsta: ");
        int varsta = scanner.nextInt();
        listaPersoane.addPersoana(nume, prenume, varsta);
    }

    public static void export() {
        try {
            listaPersoane.exportTxt();
        }catch (IOException e){
            System.out.println("can't");
        }
    }


}
