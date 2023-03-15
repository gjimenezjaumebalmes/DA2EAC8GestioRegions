/*
* Classe que defineix una ciutat d’una comarca. Es defineixen pel seu codi, nom, 
* nombre d’habitants i densitat de població per Km2
 */
package territoris;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Ciutat { 
    
    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private String nom;
    private int habitants;
    private double densitat;

    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe.
    
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres.
     */
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

    /*
    TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova ciutat. Les dades a demanar 
       són les que necessita el constructor.
     - També heu de tenir en compte que el nom de la ciutat pot ser una frase, per exemple, 
       "Santa Coloma de Gramanet".
     - En el cas del nombre d'habitants i densitat, s'ha de complir que una ciutat
       ha de tenir un mínim de 50.000 habitants i la densitat mai pot ser més gran 
       que el nombre d'habitants, ni un valor negatiu. Si no es compleixen aquests requisits,
       se li demanarà a l'usuari que torni a introduir les dades fins que siguin correctes.
     
     Retorn: La nova ciutat creada.
     */
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

    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de la ciutat actual i
       modificar els atributs corresponents d'aquesta ciutat.
     - També heu de tenir en compte que el nom de la ciutat pot ser una frase, per exemple, 
       "Santa Coloma de Gramanet".
     - En el cas del nombre d'habitants i densitat, s'ha de complir que una ciutat
       ha de tenir un mínim de 50.000 habitants i la densitat mai pot ser més gran 
       que el nombre d'habitants, ni un valor negatiu. Si no es compleixen aquests requisits,
       se li demanarà a l'usuari que torni a introduir les dades fins que siguin correctes.
     
     Retorn: cap
     */
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
