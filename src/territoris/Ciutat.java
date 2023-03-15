
package territoris;

import java.util.Scanner;


public class Ciutat { 
    
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private String nom;
    private int habitants;
    private double densitat;

    public Ciutat(String codi, String nom, int habitants, double densitat) {
        this.codi = codi;
        this.nom = nom;
        this.habitants = habitants;
        this.densitat = densitat;
    }

    /*
     TODO Heu d'implementar tots els mètodes accessors possibles.  
     */
    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHabitants() {
        return habitants;
    }

    public void setHabitants(int habitants) {
        this.habitants = habitants;
    }

    public double getDensitat() {
        return densitat;
    }

    public void setDensitat(double densitat) {
        this.densitat = densitat;
    }


    public static Ciutat addCiutat() {
        String codi, nom;
        int habitants;
        double densitat;

        System.out.println("\nCodi de la ciutat:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la ciutat:");
        nom = DADES.nextLine();

        do {
            System.out.println("\nQuants habitants té la ciutat?:");
            habitants = DADES.nextInt();
        } while (habitants < 50000);

        do {
            System.out.println("\nQuina és la densitat de la ciutat?:");
            densitat = DADES.nextDouble();
        } while (densitat < 0 || densitat > habitants);

        return new Ciutat(codi, nom, habitants, densitat);
    }


    public void updateCiutat() {
        System.out.println("\nCodi de la ciutat: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        DADES.nextLine(); //Neteja buffer
        System.out.println("\nNom de la ciutat: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();

        System.out.println("\nNombre d'habitants de la ciutat: " + habitants);
        do {
            System.out.println("\nEntra el nou nombre d'habitants:");
            habitants = DADES.nextInt();
        } while (habitants < 50000);

        System.out.println("\nDensitat de la ciutatl: " + densitat);
        do {
            System.out.println("\nEntra la nova densitat:");
            densitat = DADES.nextDouble();
        } while (densitat < 0 || densitat > habitants);
    }
    

    public void showCiutat() {
        System.out.println("\nLes dades de la ciutat amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nHabitants: " + habitants);
        System.out.print("\nDensitat: " + densitat);
    }
}
