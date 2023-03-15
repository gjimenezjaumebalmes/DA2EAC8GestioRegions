/*
 * Classe que defineix una regió. Una regió es defineix pel seu nom, el nom de 
 * la seva capital i un array de comarques.
 */
package principal;

import java.util.Scanner;
import territoris.Comarca;

/**
 *
 * @author fta
 */
public class Regio {

    private final static Scanner DADES = new Scanner(System.in);

    private String nom;
    private String capital;
    private Comarca[] comarques = new Comarca[5];
    private int pComarques = 0; //Priemra posició buida de l'array de comarques

    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe menys els arrays.
    
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres..
     */
    public Regio(String nom, String capital) {
        this.nom = nom;
        this.capital = capital;
    }


    /*
     TODO Heu d'implementar tots els mètodes accessors possibles.
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Comarca[] getComarques() {
        return comarques;
    }

    public void setComarques(Comarca[] comarques) {
        this.comarques = comarques;
    }

    public int getpComarques() {
        return pComarques;
    }

    public void setpComarques(int pComarques) {
        this.pComarques = pComarques;
    }

    /*
    TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova regió. Les dades a demanar 
       són les que necessita el constructor.
     - També heu de tenir en compte que el nom de la regió o la seva capital poden ser frase, per exemple, 
       "Regió IV".
     
     Retorn: La nova regió creada.
     */
    public static Regio addRegio() {
        String nom, capital;

        System.out.println("\nNom de la regio:");
        nom = DADES.nextLine();
        System.out.println("\nCapital de la regio:");
        capital = DADES.nextLine();

        return new Regio(nom, capital);
    }

    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de la regió i
       modificar els atributs corresponents d'aquesta regió. Els únics atributs que modificarem
       són els que hem inicialitzat en el constructor amb els paràmetres passats.
     - També heu de tenir en compte que el nom de la regió o la seva capital poden ser frase, per exemple, 
       "Regió IV".
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     
    Retorn: cap
     */
    public void updateRegio() {
        System.out.println("\nNom de la regio: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nCapital de la regio: " + capital);
        System.out.println("\nEntra la nova capital:");
        capital = DADES.nextLine();
    }

    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Calcular el total d'habitants de la regió a partir dels habitants de les comarques.
     
     Retorn: nombre total d'habitants
     */
    public int calcularTotalHabitants() {

        int totalHabitants = 0;

        for (int i = 0; i < pComarques; i++) {
            totalHabitants += comarques[i].calcularTotalHabitants();
        }

        return totalHabitants;
    }

    public void showRegio() {
        System.out.println("\nLes dades de la regio " + nom + " són:");
        System.out.println("\nCapital: " + capital);
        System.out.println("\nTotal habitants: " + calcularTotalHabitants());
    }

    /*
     COMARCA
     */
 /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Afegeix una nova comarca a l'array de comarques de la regió actual si aquesta no existeix. 
       Per afegir-la heu de fer servir el mètode de la classe Comarca escaient i per comprovar la seva 
       existència el mètode d'aquesta classe que ens ajuda en aquesta tasca.
     - Actualitza la posició de l'array de comarques si s'afegeix la comarca.
     - Mostra el missatge "La comarca ja existeix" si no s'ha afegit la comarca.
    
     Retorn: cap
     */
    public void addComarca() {

        Comarca novaComarca = Comarca.addComarca();

        if (selectComarca(novaComarca.getCodi()) == -1) {
            comarques[pComarques] = novaComarca;
            pComarques++;
        } else {
            System.out.println("\nLa comarca ja existeix");
        }
    }

    public int selectComarca(String codi) {

        if (codi == null) {
            System.out.println("\nCodi de la comarca?:");
            codi = DADES.next();
        }

        for (int i = 0; i < pComarques; i++) {
            if (comarques[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }
    
    

    public void addCiutatComarca() {

        int index = selectComarca(null);

        if (index != -1) {

            comarques[index].addCiutat();

        } else {

            System.out.println("\nLa comarca no existeix");

        }

    }

    public void updateCiutatComarca() {

        int indexComarca = selectComarca(null);

        if (indexComarca != -1) {

            int indexCiutat = comarques[indexComarca].selectCiutat(null);

            if (indexCiutat != -1) {

                comarques[indexComarca].getCiutats()[indexCiutat].updateCiutat();

            } else {

                System.out.println("\nLa ciutat no existeix");

            }

        } else {

            System.out.println("\nLa comarca no existeix");

        }

    }

    public void addPobleComarca() {

        int index = selectComarca(null);

        if (index != -1) {

            comarques[index].addPoble();

        } else {

            System.out.println("\nLa comarca no existeix");

        }

    }

    public void updatePobleComarca() {

        int indexComarca = selectComarca(null);

        if (indexComarca != -1) {

            int indexPoble = comarques[indexComarca].selectPoble(null);

            if (indexPoble != -1) {

                comarques[indexComarca].getPobles()[indexPoble].updatePoble();

            } else {

                System.out.println("\nEl poble no existeix");

            }

        } else {

            System.out.println("\nLa comarca no existeix");

        }

    }

    public void addZonaRuralComarca() {

        int index = selectComarca(null);

        if (index != -1) {

            comarques[index].addZonaRural();

        } else {

            System.out.println("\nLa comarca no existeix");

        }

    }

    public void updateZonaRuralComarca() {

        int indexComarca = selectComarca(null);

        if (indexComarca != -1) {

            int indexZonaRural = comarques[indexComarca].selectZonaRural(null);

            if (indexZonaRural != -1) {

                comarques[indexComarca].getZonesRurals()[indexZonaRural].updateZonaRural();

            } else {

                System.out.println("\nLa zona rural no existeix");

            }

        } else {

            System.out.println("\nLa comarca no existeix");

        }

    }

}
