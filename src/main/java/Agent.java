import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Agent {
    private String nom;
    private String prenom;
    private String mission;
    private ArrayList<Equipement> equipement=new ArrayList<Equipement>();

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
    public boolean possedeEquipement(String nom){
        boolean resultat = false;
        for (Equipement e:equipement
             ) {
            if (e.getNom().equals(nom)){
                return true;
            }else{
                resultat=false;
            }
        }
        return resultat;
    }

    public ArrayList<Equipement> getEquipement(String fichier) {
        if (!equipement.isEmpty()) {
            equipement.clear();
        }
        InputStream ins = null;
        try {
            ins = new FileInputStream(fichier);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Scanner obj = new Scanner(ins);
        obj.nextLine();
        obj.nextLine();
        obj.nextLine();
        obj.nextLine();
        obj.nextLine();
        while (obj.hasNextLine()){
            Equipement e=new Equipement();
            e.setNom(obj.nextLine());
            equipement.add(e);
        }
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

    public static ArrayList<Agent> getAllAgent() {
        ArrayList<Agent> listAgents = new ArrayList<>();
        InputStream ins = null;
        try {
            ins = new FileInputStream("data/staff.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Scanner obj = new Scanner(ins);
        while (obj.hasNextLine()){
            Agent agent = new Agent();
            agent.setNom(obj.nextLine());
            listAgents.add(agent);
        }


        return listAgents;
    }
}