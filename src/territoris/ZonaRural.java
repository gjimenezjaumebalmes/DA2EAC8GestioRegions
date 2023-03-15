
package territoris;

    public class ZonaRural extends Territori{

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
            System.out.println("\nQuants habitants té la zona rural? (>= 5000):");
            habitants = DADES.nextInt();
        } while (habitants < 0 || habitants >= 5000);

        do {
            System.out.println("\nQuina és la densitat de la zona rural?:");
            densitat = DADES.nextDouble();
        } while (densitat < 0 || densitat > habitants);

        return new ZonaRural(codi, nom, habitants, densitat);
    }


    public void updateZonaRural() {

    }
    

    public void showZonaRural() {

    }
}
