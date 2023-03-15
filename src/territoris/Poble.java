
package territoris;

import java.util.Scanner;

   public class Poble extends Poblacio{

       
   private final static Scanner DADES = new Scanner(System.in);


   public Poble(String codi, String nom, int habitants, double densitat) {
           super(codi, nom, habitants, densitat);
       }


    public static Poble addPoble() {
        String codi, nom;
        int habitants;
        double densitat;

        System.out.println("\nCodi del poble:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom del poble:");
        nom = DADES.nextLine();

        do {
            System.out.println("\nQuants habitants té el poble?:");
            habitants = DADES.nextInt();
        } while (habitants < 5000 || habitants >= 50000);

        do {
            System.out.println("\nQuina és la densitat del poble?:");
            densitat = DADES.nextDouble();
        } while (densitat < 0 || densitat > habitants);

        return new Poble(codi, nom, habitants, densitat);
    }


    public void updatePoble() {
        System.out.println("\nCodi del poblel: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom del poblel: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();

        System.out.println("\nNombre d'habitants del poble: " + habitants);
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
    

    public void showPoble() {
        System.out.println("\nLes dades del poble amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nHabitants: " + habitants);
        System.out.print("\nDensitat: " + densitat);
    }
}
