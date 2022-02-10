import htmlflow.*;
import org.xmlet.htmlapifaster.EnumRelType;

import java.io.*;
import java.util.Scanner;

public class GenerationFicheAgent {
    public static void main(String[] args)  {
        InputStream ins = null;
        try {
            ins = new FileInputStream("data/cberthier.txt");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        Scanner obj = new Scanner(ins);;
    StringBuilder affectation=new StringBuilder();

       String nom= obj.nextLine();
       String prenom=obj.nextLine();
        while (obj.hasNextLine()){
            if (obj.nextLine()==""){
                while (obj.hasNextLine()){
                    affectation.append(obj.nextLine()+";");
                }
            }
        }
        String affect=affectation.toString();
        System.out.println(affect);

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
            .p().text(nom)
            .__()
            .__()

            .div().attrClass("CNI")
            .img().attrSrc("C:\\Users\\killi\\IdeaProjects\\GoSecuri\\data\\cberthier.jpg").attrAlt("CNI")
            .__()
            .__()
            .__()
    );

        try {
            html
                    .setPrintStream(new PrintStream(new FileOutputStream("C:\\wamp\\www\\GoSecuri\\FicheAgent.html")))
                            .write();                       // 3) write to details.html file                     // 2) print to the standard output
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
