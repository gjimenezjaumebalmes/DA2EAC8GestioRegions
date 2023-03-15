
package territoris;

import java.util.Scanner;


    public class ZonaRural extends Poblacio{

        private final static Scanner DADES = new Scanner(System.in);

    public ZonaRural(String codi, String nom, int habitants, double densitat) {
        super(codi, nom, habitants, densitat);
    }

    public static ZonaRural addZonaRural() {
        String codi, nom;
        int habitants;
        double densitat;

        System.out.println("\nCodi de la zona rural:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la zona rural:");
        nom = DADES.nextLine();

        do {
            System.out.println("\nQuants habitants té la zona rural?:");
            habitants = DADES.nextInt();
        } while (habitants < 0 || habitants >= 5000);

        do {
            System.out.println("\nQuina és la densitat de la zona rural?:");
            densitat = DADES.nextDouble();
        } while (densitat < 0 || densitat > habitants);

        return new ZonaRural(codi, nom, habitants, densitat);
    }


    public void updateZonaRural() {
        System.out.println("\nCodi de la zona rural: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la zona rural: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();

        System.out.println("\nNombre d'habitants de la zona rural: " + habitants);
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
    

    public void showZonaRural() {
        System.out.println("\nLes dades de la zona rural amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nHabitants: " + habitants);
        System.out.print("\nDensitat: " + densitat);
    }
}
