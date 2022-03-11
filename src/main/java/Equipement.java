import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Equipement {
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Equipement> getListEquipement(String parametre){
        InputStream inslist = null;
        try {
            if (parametre == "equipement"){
                inslist = new FileInputStream("data/liste.txt");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Equipement> liste=new ArrayList<>();

        Scanner list = new Scanner(inslist);
        if (parametre == "equipement"){

        }
        int cpt=0;
        while (list.hasNextLine()){
            Equipement equipement = new Equipement();
            equipement.setNom(list.nextLine());
            liste.add(equipement);
            cpt++;
        }
        return liste;
    }

}
