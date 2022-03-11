import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Agent {
    private String nom;
    private String prenom;
    private String mission;
    private ArrayList<Equipement> equipement;

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public ArrayList<Equipement> getEquipement() {
        return equipement;
    }

    public void setEquipement(ArrayList<Equipement> equipement) {
        this.equipement = equipement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void getInfoAgent(String fichier) {
        InputStream ins = null;
        try {
            ins = new FileInputStream(fichier);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Scanner obj = new Scanner(ins);
        this.nom=obj.nextLine();
        this.prenom=obj.nextLine();
        this.mission=obj.nextLine();
        /*if (Objects.equals(variable, "nom")) {
            this.setNom(obj.nextLine());
        }
        if (Objects.equals(variable, "prenom")) {
            obj.nextLine();
            this.setPrenom(obj.nextLine());
        }
        if (Objects.equals(variable, "mission")) {
            obj.nextLine();
            obj.nextLine();
            this.setMission(obj.nextLine());
        }*/
    }

    public ArrayList<Agent> getAllAgent() {
        ArrayList<Agent> agents = new ArrayList<>();
        InputStream ins = null;
        try {
            ins = new FileInputStream("data/staff.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Scanner obj = new Scanner(ins);


        return agents;
    }
}