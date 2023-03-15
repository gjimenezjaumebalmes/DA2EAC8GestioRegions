
package principal;

import java.util.Scanner;
import territoris.Comarca;

public class Regio {

    private final static Scanner DADES = new Scanner(System.in);

    private String nom;
    private String capital;
    private Comarca[] comarques = new Comarca[5];
    private int pComarques = 0; //Primera posició buida de l'array de comarques


    public Regio(String nom, String capital) {
        this.nom = nom;
        this.capital = capital;
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


    public static Regio addRegio() {
        String nom, capital;

        System.out.println("\nNom de la regio:");
        nom = DADES.nextLine();
        System.out.println("\nCapital de la regio:");
        capital = DADES.nextLine();

        return new Regio(nom, capital);
    }


    public void updateRegio() {
        System.out.println("\nNom de la regio: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = DADES.nextLine();
        System.out.println("\nCapital de la regio: " + capital);
        System.out.println("\nEntra la nova capital:");
        capital = DADES.nextLine();
    }


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
