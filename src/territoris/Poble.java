/*
* Classe que defineix un poble d’una comarca. Es defineixen pel seu codi, nom, 
* nombre d’habitants i densitat de població per Km2.
 */
package territoris;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Poble {

       
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
    public Poble(String codi, String nom, int habitants, double densitat) {
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
     - Demanar a l'usuari les dades per consola per crear un nou poble. Les dades a demanar 
       són les que necessita el constructor.
     - També heu de tenir en compte que el nom del poble pot ser una frase, per exemple, 
       "Sant Feliu de Codines".
     - En el cas del nombre d'habitants i densitat, s'ha de complir que un poble
       ha de tenir un mínim de 5000 habitants i la densitat mai pot ser més gran 
       que el nombre d'habitants, ni un valor negatiu. Si no es compleixen aquests requisits,
       se li demanarà a l'usuari que torni a introduir les dades fins que siguin correctes.
     - També heu de pensar que amb un mínim de 50.000 habitants, ja no és un poble, és una ciutat.
     
     Retorn: El nou poble creat.
     */
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

    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades del poble actual i
       modificar els atributs corresponents d'aquest poblel.
     - També heu de tenir en compte que el nom del poble pot ser una frase, per exemple, 
       "Sant Feliu de Codines".
     - En el cas del nombre d'habitants i densitat, s'ha de complir que un poble
       ha de tenir un mínim de 5000 habitants i la densitat mai pot ser més gran 
       que el nombre d'habitants, ni un valor negatiu. Si no es compleixen aquests requisits,
       se li demanarà a l'usuari que torni a introduir les dades fins que siguin correctes.
     - També heu de pensar que amb un mínim de 50.000 habitants, ja no és un poble, és una ciutat.
     
     Retorn: cap
     */
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
