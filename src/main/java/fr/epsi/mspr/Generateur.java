package fr.epsi.mspr;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import j2html.tags.DomContent;
import java.util.ArrayList;

import static j2html.TagCreator.*;


public class Generateur {
    public static void main(String[] args) throws IOException {

        ArrayList<Agent> agentList = Agent.getAllAgent();
        for (Agent a:agentList) {
            FileWriter fw = new FileWriter("FicheAgent" + a.getNom() + ".html");
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(fw);
                bw.write(Generateur.genererHtml(a));
            } finally {
                bw.close();
            }

        }
        Thread threadAccueil=new Thread() {
            @Override
            public void run() {
                FileWriter f2 = null;
                try {
                    f2 = new FileWriter("Accueil.html");
                    BufferedWriter b1 = null;
                    try {
                        b1 = new BufferedWriter(f2);
                        b1.write(Generateur.genererAccueil(agentList));
                    } finally {
                        b1.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
        threadAccueil.start();

       // java.awt.Desktop.getDesktop().browse(java.net.URI.create(url_open));
    }
        public static String genererHtml(Agent agent){
        ArrayList<Equipement> listeEquipement=Equipement.getListEquipement("equipement");
        agent.getEquipement("data/"+agent.getPrenom()+""+agent.getNom()+".txt");
            String render = html(
                    head(
                            title("Fiche fr.epsi.mspr.Agent"),
                            link().withRel("stylesheet").withHref("styles.css")
                    ),
                    body(
                            j2html.TagCreator.main(attrs(".content"),
                                    div(attrs(".user"),
                                    div(attrs(".nom"),
                                    p(agent.getNom()))
                                    , div(attrs(".CNI"),
                                            img().withSrc("data/"+agent.getPrenom()+""+agent.getNom()+".jpg").withAlt("CNI")))
                                    , div(attrs(".ListeEquipement"),
                                            h1(attrs("#pEquipement"),"Liste des ??quipements allou??"),
                                            each(listeEquipement, equipement ->
                                                            div(attrs(".equipement"),
                                                                   p(String.valueOf(equipement.getNomComplet())),
                                                                        iffElse(agent.possedeEquipement(equipement.getNom()),
                                                                                form(input().withType("checkbox").isChecked().isDisabled()),
                                                                                form(input().withType("checkbox").isDisabled())

                                                                    )
                                                            )
                                                     )
                                    )
                            )
                    )//test
            ).renderFormatted();
            return render;
//tgttgtgggtgtg
    }

    public static String genererAccueil(ArrayList<Agent> agentList){
        String  render = html(
                 head(
                title("Fiche Accueil"),
                link().withRel("stylesheet").withHref("styles.css")
        ),
                body(
                j2html.TagCreator.main(attrs(".content"),
                        h1(attrs(".titre"),"Liste des employ??s")
                        , div(attrs(".ListeAgent"),
                                each(agentList, agent ->
                                        div(attrs(".agent"),
                                                a(String.valueOf(agent.getNom())).withHref("./FicheAgent"
                                                        +agent.getNom()+".html"))
                                )
                        )
                )
        )

        ).renderFormatted();
        return render;
    }
}
