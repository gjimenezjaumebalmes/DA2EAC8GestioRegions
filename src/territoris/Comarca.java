
package territoris;

import java.util.Scanner;

public class Comarca{

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

        public Comarca(String codi, String nom, String capital) {
            this.codi = codi;
            this.nom = nom;
            this.capital = capital;
        }

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
