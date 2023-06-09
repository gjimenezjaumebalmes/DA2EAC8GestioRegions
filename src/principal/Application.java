package principal;

import java.util.Scanner;


public class Application {

    private final static Scanner DADES = new Scanner(System.in);

    private static Regio[] regions = new Regio[10];
    private static int pRegions = 0; //Priemra posició buida del vector regions
    private static Regio regioActual = null;

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;

        do {
            System.out.println("\nSelecciona una opcio");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestio de regions");
            System.out.println("\n2. Gestio de comarques");
            System.out.println("\n3. Gestio de ciutats");
            System.out.println("\n4. Gestio de pobles");
            System.out.println("\n5. Gestio de zones rurals");
            opcio = DADES.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuRegions();
                    break;
                case 2:
                    if (regioActual != null) {
                        menuComarques();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la regio al menu Gestio de regions");
                    }
                    break;
                case 3:
                    if (regioActual != null) {
                        menuCiutats();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la regio al menu Gestio de regions");
                    }
                    break;
                case 4:
                    if (regioActual != null) {
                        menuPobles();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la regio al menu Gestio de regions");
                    }
                    break;
                case 5:
                    if (regioActual != null) {
                        menuZonesRurals();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la regio al menu Gestio de regions");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opcio correcta del menu.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuRegions() {
        int opcio;

        do {
            int indexSel;
            System.out.println("\nSelecciona una opcio de Regions");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta Regio");
            System.out.println("\n2. Seleccionar Regio");
            System.out.println("\n3. Modificar Regio");
            System.out.println("\n4. Llista de regions");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    Regio novaRegio = Regio.addRegio();

                    indexSel = selectRegio(novaRegio);

                    if (indexSel == -1) {
                        regions[pRegions] = novaRegio;
                        pRegions++;
                    } else {
                        System.out.println("\nLa regió ja existeix");
                    }

                    break;
                case 2:
                    indexSel = selectRegio(null);
                    if (indexSel >= 0) {
                        regioActual = regions[indexSel];
                    } else {
                        System.out.println("\nNo existeix aquesta regio");
                    }
                    break;
                case 3:
                    indexSel = selectRegio(null);
                    if (indexSel >= 0) {
                        regions[indexSel].updateRegio();
                    } else {
                        System.out.println("\nNo existeix aquesta regio");
                    }
                    break;
                case 4:
                    for (int i = 0; i < pRegions; i++) {
                        regions[i].showRegio();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opcio correcta del menu.");
                    break;
            }
        } while (opcio != 0);
    }


    public static void menuComarques() {
        int opcio;

        do {
            System.out.println("\nSelecciona una opcio de Comarques");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta Comarca");
            System.out.println("\n2. Modificar Comarca");
            System.out.println("\n3. Llista de comarques");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    regioActual.addComarca();
                    break;
                case 2:
                    int indexSel = regioActual.selectComarca(null);
                    if (indexSel >= 0) {
                        regioActual.getComarques()[indexSel].updateComarca();
                    } else {
                        System.out.println("\nNo existeix aquesta comarca");
                    }
                    break;
                case 3:
                    for (int i = 0; i < regioActual.getpComarques(); i++) {
                        regioActual.getComarques()[i].showComarca();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opcio correcta del menu.");
                    break;
            }
        } while (opcio != 0);
    }


    public static void menuCiutats() {
        int opcio;

        do {
            System.out.println("\nSelecciona una opcio de Ciutats");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta Ciutat");
            System.out.println("\n2. Modificar Ciutat");
            System.out.println("\n3. Llista de ciutats");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    regioActual.addCiutatComarca();
                    break;
                case 2:
                    regioActual.updateCiutatComarca();
                    break;
                case 3:
                    for (int i = 0; i < regioActual.getpComarques(); i++) {

                        for (int j = 0; j < regioActual.getComarques()[i].getpCiutats(); j++) {

                            regioActual.getComarques()[i].getCiutats()[j].showCiutat();

                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opcio correcta del menu.");
                    break;
            }
        } while (opcio != 0);
    }



    public static void menuPobles() {
        int opcio;

        do {
            System.out.println("\nSelecciona una opcio de Pobles");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta Poble");
            System.out.println("\n2. Modificar Poble");
            System.out.println("\n3. Llista de pobles");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    regioActual.addPobleComarca();
                    break;
                case 2:
                    regioActual.updatePobleComarca();
                    break;
                case 3:
                    for (int i = 0; i < regioActual.getpComarques(); i++) {

                        for (int j = 0; j < regioActual.getComarques()[i].getpPobles(); j++) {

                            regioActual.getComarques()[i].getPobles()[j].showPoble();

                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opcio correcta del menu.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuZonesRurals() {
        int opcio;

        do {
            System.out.println("\nSelecciona una opcio de Zona Rural");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta Zona Rural");
            System.out.println("\n2. Modificar Zona Rural");
            System.out.println("\n3. Llista de zones rurals");
            opcio = DADES.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    regioActual.addZonaRuralComarca();
                    break;
                case 2:
                    regioActual.updateZonaRuralComarca();
                    break;
                case 3:
                    for (int i = 0; i < regioActual.getpComarques(); i++) {

                        for (int j = 0; j < regioActual.getComarques()[i].getpZonesRurals(); j++) {

                            regioActual.getComarques()[i].getZonesRurals()[j].showZonaRural();

                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opcio correcta del menu.");
                    break;
            }
        } while (opcio != 0);
    }

   public static Integer selectRegio(Regio regio) {

        String nom;

        if (regio == null) {
            System.out.println("\nNom de la regio?:");
            DADES.nextLine(); //Neteja buffer
            nom = DADES.nextLine();
        } else {

            nom = regio.getNom();
        }

        for (int i = 0; i < pRegions; i++) {
            if (regions[i].getNom().equals(nom)) {
                return i;
            }
        }

        return -1;
    }
}
