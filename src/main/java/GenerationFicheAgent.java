

    import java.io.*;
    import java.nio.charset.Charset;
    import java.nio.charset.StandardCharsets;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.util.Scanner;

    import static j2html.TagCreator.*;

    public class GenerationFicheAgent {
    public static void main(String[] args) throws IOException {
        String nom=getNomAgent("data/cberthier.txt");
        String prenom=getPrenomAgent("data/cberthier.txt");
        String[] listeEquipement=getListEquipement();
        String[] listeEquipementAffecte=getEquipementAffecte("data/cberthier.txt");
        Generateur g1=new Generateur();
        System.out.println(Generateur.genererHtml());
        File file = new File("FicheAgent.html");
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(Generateur.genererHtml());
        bw.close();








    /*HtmlView html=StaticHtml.view(v -> v
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
            .p().text(nom)
            .__()
            .__()
            .div().attrClass("CNI")
            .img().attrSrc("data/cberthier.jpg").attrAlt("CNI")
            .__()
            .__()
            .div().attrClass("listeEquipement")
            .p().text(listeEquipement[0])
            .__()
            .p().text(listeEquipement[1])
            .__()
            .p().text(listeEquipement[2])
            .__()
            .p().text(listeEquipement[3])
            .__()
            .p().text(listeEquipement[4])
            .__()
            .p().text(listeEquipement[5])
            .__()
            .p().text(listeEquipement[6])
            .__()
            .p().text(listeEquipement[7])
            .__()
            .p().text(listeEquipement[8])
            .__()
            .p().text(listeEquipement[9])
            .__()
            .p().text(listeEquipement[9])
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
        }*/
    }

    private static String getNomAgent(String name){
        InputStream ins = null;
        try {
            ins = new FileInputStream(name);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Scanner obj = new Scanner(ins);
        return obj.nextLine();
    }

    private static String getPrenomAgent(String fichier){
        InputStream ins = null;
        try {
            ins = new FileInputStream(fichier);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Scanner obj = new Scanner(ins);
        obj.nextLine();
        return obj.nextLine();
    }

    private static String[] getListEquipement(){
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
