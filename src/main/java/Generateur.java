import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static j2html.TagCreator.*;


public class Generateur {
    static class Equipement {
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
    static class Agent {
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
    public static void main(String[] args) throws IOException {
        Agent agent=new Agent();
        agent.getInfoAgent("data/cberthier.txt");
        ArrayList<Agent> agents = agent.getAllAgent();
        /*String nom = getNomAgent("data/cberthier.txt");
        String prenom = getPrenomAgent("data/cberthier.txt");
        String[] listeEquipement = getListEquipement();
        String[] listeEquipementAffecte = getEquipementAffecte("data/cberthier.txt");
        */
        System.out.println(Generateur.genererHtml(agent));

        FileWriter fw = new FileWriter("FicheAgent.html");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(Generateur.genererHtml(agent));
        bw.close();
        FileWriter f2 = new FileWriter("Accueil.html");
        String url_open ="http://localhost/GoSecuri/FicheAgent.html";
        BufferedWriter b1 = new BufferedWriter(f2);
        b1.write(Generateur.genererAccueil(agents));
        b1.close();
        java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
    }
        public static String genererHtml(Agent agent){
        Equipement e1=new Equipement();
        Equipement e2=new Equipement();
        ArrayList<Equipement> listeEquipement=new ArrayList<>(2);
        listeEquipement.add(e1);
        listeEquipement.add(e2);

            String render = html(
                    head(
                            title("Fiche Agent"),
                            link().withRel("stylesheet").withHref("styles.css")
                    ),
                    body(
                            j2html.TagCreator.main(attrs(".content"),
                                    p(agent.getNom())
                                    , div(attrs(".CNI"),
                                            img().withSrc("data/cberthier.jpg").withAlt("CNI"))
                                    , div(attrs(".ListeEquipement"),
                                            each(listeEquipement, equipement ->
                                                    div(attrs(".equipement"),
                                                            p(String.valueOf(equipement)))

                                            )
                                    )
                            )
                    )
            ).render();
            return render;
    }

    public static String genererAccueil(ArrayList<Agent> agents){
        return head(
                title("Fiche Accueil"),
                link().withRel("stylesheet").withHref("styles.css")
        )/*
        body(
                main(attrs("content")

        )*/
                .render();
    }
}
