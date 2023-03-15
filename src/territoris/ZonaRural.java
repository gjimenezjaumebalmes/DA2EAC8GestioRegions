/*
* Classe que defineix una zona rural d’una comarca. Es defineixen pel seu codi, 
* nom, nombre d’habitants, densitat de població per Km2
 */
package territoris;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class ZonaRural {

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
    public ZonaRural(String codi, String nom, int habitants, double densitat) {
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
     - Demanar a l'usuari les dades per consola per crear una nova zona rural. Les dades a demanar 
       són les que necessita el constructor.
     - També heu de tenir en compte que el nom de la zona rural pot ser una frase, per exemple, 
       "La Pobla de Lillet".
     - En el cas del nombre d'habitants i densitat, s'ha de complir que una zona rural
       ha de tenir menys de 5000 habitants i la densitat mai pot ser més gran 
       que el nombre d'habitants. Si no es compleixen aquests requisits, se li demanarà 
       a l'usuari que torni a introduir les dades fins que siguin correctes.
     - També heu de pensar que el nombre d'habitants i la densitat no poden ser nombres negatius
     
     Retorn: La nova zona rural creada.
     */
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

    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de la zona rural actual i
       modificar els atributs corresponents d'aquesta zona rural.
     - També heu de tenir en compte que el nom de la zona rural pot ser una frase, per exemple, 
       "La Pobla de Lillet".
     - En el cas del nombre d'habitants i densitat, s'ha de complir que una zona rural
       ha de tenir menys de 5000 habitants i la densitat mai pot ser més gran 
       que el nombre d'habitants. Si no es compleixen aquests requisits, se li demanarà 
       a l'usuari que torni a introduir les dades fins que siguin correctes.
     - També heu de pensar que el nombre d'habitants i la densitat no poden ser nombres negatius
     
     Retorn: cap
     */
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
