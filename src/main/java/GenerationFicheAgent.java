    import htmlflow.*;
    import org.xmlet.htmlapifaster.EnumRelType;

    import java.io.*;
    import java.util.ArrayList;
    import java.util.Scanner;

    public class GenerationFicheAgent {
    public static void main(String[] args)  {
        Agent agent = new Agent();
        Equipement equipement = new Equipement();
        agent.getInfoAgent("data/cberthier.txt","nom");
        agent.getInfoAgent("data/cberthier.txt","prenom");
        agent.getInfoAgent("data/cberthier.txt","mission");
        ArrayList<Equipement> listeEquipement = getListEquipement();
        String[] listeEquipementAffecte=getEquipementAffecte("data/cberthier.txt");


    HtmlView html=StaticHtml.view(v -> v
            .html()
            .head()
            .link().attrRel(EnumRelType.STYLESHEET).attrHref("styles.css")
            .__()
            .title().text("Fiche Agent")
            .__()
            .__()
            .body()
            .div().attrClass("conteneur")
            .div().attrClass("nom")
            .p().text(agent.getNom())
            .__()
            .__()
            .div().attrClass("CNI")
            .img().attrSrc("data/cberthier.jpg").attrAlt("CNI")
            .__()
            .__()
            .div().attrClass("listeEquipement")
            .__()
            .__()
            .__()
    );
        try {
            html
                    .setPrintStream(new PrintStream(new FileOutputStream("./FicheAgent.html")))
                            .write();                       // 3) write to details.html file                     // 2) print to the standard output
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*private static String[] getListEquipement(){
        InputStream inslist = null;
        try {
            inslist = new FileInputStream("data/liste.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] liste=new String[10];
        Scanner list = new Scanner(inslist);
        int cpt=0;
        while (list.hasNextLine()){
            liste[cpt]=list.nextLine();
            cpt++;
        }
        return liste;
    }*/
        private static ArrayList<Equipement> getListEquipement(){
            InputStream inslist = null;
            try {
                inslist = new FileInputStream("data/liste.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            ArrayList<Equipement> liste=new ArrayList<>();

            Scanner list = new Scanner(inslist);
            int cpt=0;
            while (list.hasNextLine()){
                Equipement equipement = new Equipement();
                equipement.setNom(list.nextLine());
                liste.add(equipement);
                cpt++;
            }
            return liste;
        }
    private static String[] getEquipementAffecte(String fichier){

            InputStream ins = null;
            try {
                ins = new FileInputStream("data/cberthier.txt");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            Scanner obj = new Scanner(ins);

        String[] affectation=new String[10];
        while (obj.hasNextLine()){
            if (obj.nextLine()==""){
                int compteur=0;
                while (obj.hasNextLine()){
                    affectation[compteur]= obj.nextLine();
                    compteur++;
                }
            }
        }
        return affectation;
    }

    }
