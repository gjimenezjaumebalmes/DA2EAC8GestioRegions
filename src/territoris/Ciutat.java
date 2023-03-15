
package territoris;


    public class Ciutat extends Territori{

    public Ciutat(String codi, String nom, int habitants, double densitat) {
            super(codi, nom, habitants, densitat);
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
            System.out.println("\nQuants habitants té la ciutat? ( < 50000 ) :");
            habitants = DADES.nextInt();
        } while (habitants < 50000);

        do {
            System.out.println("\nQuina és la densitat de la ciutat?:");
            densitat = DADES.nextDouble();
        } while (densitat < 0 || densitat > habitants);

        return new Ciutat(codi, nom, habitants, densitat);
    }


    public void updateCiutat () {
        updateTerritori();
    }

    public void showCiutat(){
        showTerritori();
    }

}
