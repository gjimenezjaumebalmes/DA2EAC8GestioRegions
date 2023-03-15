/*
 * Classe que defineix una comarca. Una comarca es defineix pel seu nom, el nom de
 * la seva capital, un array de ciutats, un array de pobles i un array de zones rurals.
 */
package territoris;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Comarca {

    private final static Scanner DADES = new Scanner(System.in);

    private String codi;
    private String nom;
    private String capital;
    private Poble[] pobles = new Poble[100];
    private int pPobles = 0; //Priemra posició buida de l'array de pobles
    private Ciutat[] ciutats = new Ciutat[100];
    private int pCiutats = 0; //Priemra posició buida de l'array de ciutats
    private ZonaRural[] zonesRurals = new ZonaRural[100];
    private int pZonesRurals = 0; //Priemra posició buida de l'array de zones rurals

    /*
     TODO CONSTRUCTOR
    
     Paràmetres: valors per tots els atributs de la classe, menys els arrays
    
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.    
     */
    public Comarca(String codi, String nom, String capital) {
        this.codi = codi;
        this.nom = nom;
        this.capital = capital;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Poble[] getPobles() {
        return pobles;
    }

    public void setPobles(Poble[] pobles) {
        this.pobles = pobles;
    }

    public int getpPobles() {
        return pPobles;
    }

    public void setpPobles(int pPobles) {
        this.pPobles = pPobles;
    }

    public Ciutat[] getCiutats() {
        return ciutats;
    }

    public void setCiutats(Ciutat[] ciutats) {
        this.ciutats = ciutats;
    }

    public int getpCiutats() {
        return pCiutats;
    }

    public void setpCiutats(int pCiutats) {
        this.pCiutats = pCiutats;
    }

    public ZonaRural[] getZonesRurals() {
        return zonesRurals;
    }

    public void setZonesRurals(ZonaRural[] zonesRurals) {
        this.zonesRurals = zonesRurals;
    }

    public int getpZonesRurals() {
        return pZonesRurals;
    }

    public void setpZonesRurals(int pZonesRurals) {
        this.pZonesRurals = pZonesRurals;
    }


    /*
    TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari les dades per consola per crear una nova comarca. Les dades a demanar 
       són les que necessita el constructor.
     - També heu de tenir en compte que el nom de la comarca o la seva capital poden ser frase, per exemple, 
       la comarca de l'"Alt Camp".
     
     Retorn: La nova comarca creada.
     */
    public static Comarca addComarca() {
        String codi, nom, capital;

        System.out.println("\nCodi de la comarca:");
        codi = DADES.next();
        DADES.nextLine(); //Netejem buffer
        System.out.println("\nNom de la comarca:");
        nom = DADES.nextLine();
        System.out.println("\nCapital de la comarca:");
        capital = DADES.nextLine();

        return new Comarca(codi, nom, capital);
    }

    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de la comarca i
       modificar els atributs corresponents d'aquesta comarca. Els únics atributs que modificarem
       són els que hem inicialitzat en el constructor amb els paràmetres passats.
     - També heu de tenir en compte que el nom de la comarca o la seva capital poden ser frase, per exemple, 
       la comarca de l'"Alt Camp".
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     
    Retorn: cap
     */
    public void updateComarca() {
        System.out.println("\nCodi de la comarca:" + codi);
        System.out.println("\nEntra el nou codi:");
        codi = DADES.next();
        DADES.nextLine(); //Netejem buffer
        System.out.println("\nNom de la comarca: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nCapital de la comarca: " + capital);
        System.out.println("\nEntra la nova capital:");
        capital = DADES.nextLine();
    }

    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Calcular el total d'habitants de la comarca a partir dels habitants de les seves
       ciutats, pobles i zones rurals.
     
     Retorn: nombre total d'habitants
     */
    public int calcularTotalHabitants() {

        int totalHabitants = 0;

        for (int i = 0; i < pPobles; i++) {
            totalHabitants += pobles[i].getHabitants();
        }

        for (int i = 0; i < pCiutats; i++) {
            totalHabitants += ciutats[i].getHabitants();
        }

        for (int i = 0; i < pZonesRurals; i++) {
            totalHabitants += zonesRurals[i].getHabitants();
        }

        return totalHabitants;
    }
    
    
    public void showComarca() {
        System.out.println("\nLes dades de la comarca amb codi" + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nCapital: " + capital);
        System.out.println("\nTotal habitants: " + calcularTotalHabitants());
    }
    
    
    /*
     CIUTAT
     */
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Afegeix una nova ciutat a l'array de ciutats de la comarca actual si aquesta no existeix. 
       Per afegir-la heu de fer servir el mètode de la classe Ciutat escaient i per comprovar la seva 
       existència el mètode d'aquesta classe que ens ajuda en aquesta tasca.
     - Actualitza la posició de l'array de ciutats si s'afegeix la ciutat.
     - Mostra el missatge "La ciutat ja existeix" si no s'ha afegit la ciutat.
    
     Retorn: cap
     */
    public void addCiutat() {

        Ciutat novaCiutat = Ciutat.addCiutat();

        if (selectCiutat(novaCiutat.getCodi()) == -1) {
            ciutats[pCiutats] = novaCiutat;
            pCiutats++;
        } else {
            System.out.println("\nLa ciutat ja existeix");
        }
    }

    public int selectCiutat(String codi) {

        if (codi == null) {
            System.out.println("\nCodi de la ciutat?:");
            codi = DADES.next();
        }

        for (int i = 0; i < pCiutats; i++) {
            if (ciutats[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }
    

    /*
     POBLE
     */
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Afegeix un nou poble a l'array de pobles de la comarca actual si aquest no existeix. 
       Per afegir-lo heu de fer servir el mètode de la classe Poble escaient i per comprovar la seva 
       existència el mètode d'aquesta classe que ens ajuda en aquesta tasca.
     - Actualitza la posició de l'array de pobles si s'afegeix el poble.
     - Mostra el missatge "El poble ja existeix" si no s'ha afegit el poble.
    
     Retorn: cap
     */
    public void addPoble() {

        Poble nouPoble = Poble.addPoble();

        if (selectPoble(nouPoble.getCodi()) == -1) {
            pobles[pPobles] = nouPoble;
            pPobles++;
        } else {
            System.out.println("\nEl poble ja existeix");
        }
    }

    public int selectPoble(String codi) {

        if (codi == null) {
            System.out.println("\nCodi del poble?:");
            codi = DADES.next();
        }

        for (int i = 0; i < pPobles; i++) {
            if (pobles[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }
    
    
     /*
     ZONA RURAL
     */
    /*
     TODO
    
     Paràmetres: cap
    
     Accions:
     - Afegeix una nova zona rural a l'array de zones rurals de la comarca actual si aquesta no existeix. 
       Per afegir-la heu de fer servir el mètode de la classe ZonaRural escaient i per comprovar la seva 
       existència el mètode d'aquesta classe que ens ajuda en aquesta tasca.
     - Actualitza la posició de l'array de zones rurals si s'afegeix la zona rural.
     - Mostra el missatge "La zona rural ja existeix" si no s'ha afegit la zona rural.
    
     Retorn: cap
     */
    public void addZonaRural() {

        ZonaRural novaZonaRural = ZonaRural.addZonaRural();

        if (selectZonaRural(novaZonaRural.getCodi()) == -1) {
            zonesRurals[pZonesRurals] = novaZonaRural;
            pZonesRurals++;
        } else {
            System.out.println("\nLa zona rural ja existeix");
        }
    }

    public int selectZonaRural(String codi) {

        if (codi == null) {
            System.out.println("\nCodi de la zona rural?:");
            codi = DADES.next();
        }

        for (int i = 0; i < pZonesRurals; i++) {
            if (zonesRurals[i].getCodi().equals(codi)) {
                return i;
            }
        }

        return -1;
    }

}
