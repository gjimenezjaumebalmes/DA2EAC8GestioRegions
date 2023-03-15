package territoris;

import java.util.Scanner;

public class Poblacio {

    // Atributs
    public final static Scanner DADES = new Scanner(System.in);
    public String codi;
    public String nom;
    public int habitants;
    public double densitat;
    // Constructor

    public Poblacio(String codi, String nom, int habitants, double densitat) {
        this.codi = codi;
        this.nom = nom;
        this.habitants = habitants;
        this.densitat = densitat;
    }

    //Metodes getters i setters

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



}
