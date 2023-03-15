
package territoris;

   public class Poble extends Territori{

   public Poble(String codi, String nom, int habitants, double densitat) {
           super(codi, nom, habitants, densitat);
       }


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
            System.out.println("\nQuants habitants té el poble? (< 5000 >= 50000):");
            habitants = DADES.nextInt();
        } while (habitants < 5000 || habitants >= 50000);

        do {
            System.out.println("\nQuina és la densitat del poble?:");
            densitat = DADES.nextDouble();
        } while (densitat < 0 || densitat > habitants);

        return new Poble(codi, nom, habitants, densitat);
    }


    public void updatePoble() {

    }
    

    public void showPoble() {

    }
}
