package fr.epsi.mspr;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Equipement {
    private String nom;
    private String nomComplet;

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static ArrayList<Equipement> getListEquipement(String parametre){
        InputStream inslist = null;
        try {
            if (parametre.equals("equipement")){
                inslist = new FileInputStream("data/liste.txt");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Equipement> liste=new ArrayList<>();

        Scanner list = new Scanner(inslist);
        if (parametre.equals("equipement")){
        }
        int cpt=0;
        while (list.hasNextLine()){
            Equipement equipement = new Equipement();
            String ligne=list.nextLine();
            String[] ligneSepare=ligne.split(";");
            equipement.setNomComplet(ligneSepare[1]);
            equipement.setNom(ligneSepare[0]);
            liste.add(equipement);
            cpt++;
        }
        list.close();
        return liste;
    }

}
