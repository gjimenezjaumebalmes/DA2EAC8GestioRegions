package territoris;

import java.util.Scanner;

public class Territori extends Poblacio{


    public Territori(String codi, String nom, int habitants, double densitat) {
        super(codi, nom, habitants, densitat);
    }

    public void updateTerritori() {

        System.out.println("\nCodi de la poblacio: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la poblacio: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();

        System.out.println("\nNombre d'habitants de la poblacio: " + habitants);

        if(habitants < 50000) {
            do {
                System.out.println("\nEntra el nou nombre d'habitants de la Ciutat:");
                habitants = DADES.nextInt();
            } while (habitants < 50000);

        System.out.println("\nDensitat de la poblacio: " + densitat);
        do {
            System.out.println("\nEntra la nova densitat:");
            densitat = DADES.nextDouble();
        } while (densitat < 0 || densitat > habitants);
    }
        if(habitants < 5000 || habitants >= 50000 ){

            do {
                System.out.println("\nEntra el nou nombre d'habitants:");
                habitants = DADES.nextInt();
            } while (habitants < 5000 || habitants >= 50000);

            System.out.println("\nDensitat del poble: " + densitat);
            do {
                System.out.println("\nEntra la nova densitat:");
                densitat = DADES.nextDouble();
            } while (densitat < 0 || densitat > habitants);

        }

        if(densitat < 0 || densitat > habitants){

            do {
                System.out.println("\nEntra el nou nombre d'habitants:");
                habitants = DADES.nextInt();
            } while (habitants < 0 || habitants >= 5000);

            System.out.println("\nDensitat de la zona rural: " + densitat);
            do {
                System.out.println("\nEntra la nova densitat:");
                densitat = DADES.nextDouble();
            } while (densitat < 0 || densitat > habitants);

        }

    }


    public void showTerritori() {

        System.out.println("\nLes dades amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nHabitants: " + habitants);
        System.out.print("\nDensitat: " + densitat);


    }


}
