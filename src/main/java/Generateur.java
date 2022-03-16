import j2html.tags.DomContent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;


public class Generateur {
    public static void main(String[] args) throws IOException {
        Agent agent=new Agent();
        ArrayList<Agent> agentList = Agent.getAllAgent();
        agent.getInfoAgent("data/cberthier.txt");
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
       // String url_open ="/home/guicheri/IdeaProjects/GoSecuri/FicheAgent.html";
        BufferedWriter b1 = new BufferedWriter(f2);
        b1.write(Generateur.genererAccueil(agentList));
        b1.close();
       // java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
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

    public static String genererAccueil(ArrayList<Agent> agentList){
        String  render = html(
                (DomContent) head(
                title("Fiche Accueil"),
                link().withRel("stylesheet").withHref("styles.css")
        ),
                body(
                j2html.TagCreator.main(attrs(".content")
                        , div(attrs(".CNI")
                        , div(attrs(".ListeAgent"),
                                each(agentList, agent ->
                                        div(attrs(".agent"),
                                                a(String.valueOf(agent.getNom())).withHref("https://www.google.com/"))
                                )
                        )
                )
        )
            )
        ).renderFormatted();
        return render;
    }
}
