import java.util.ArrayList;

import static j2html.TagCreator.*;


public class Generateur {
    public static String genererHtml(){
        Equipement e1=new Equipement();
        Equipement e2=new Equipement();
        ArrayList<Equipement> listeEquipement=new ArrayList<>(2);
        listeEquipement.add(e1);
        listeEquipement.add(e2);
        return html(
                head(
                        title("Fiche Agent"),
                        link().withRel("stylesheet").withHref("styles.css")
                ),
                body(
                        main(attrs(".content"),
                                p("nom")
                                ,div(attrs(".CNI"),
                                        img().withSrc("data/cberthier.jpg").withAlt("CNI"))
                                ,div(attrs(".ListeEquipement"),
                                each(listeEquipement, equipement ->
                                        div(attrs(".equipement"),
                                                p(String.valueOf(equipement)))

                                )
                        )
                )
                )
        ).render();

    }

    public static String genererAccueil(){
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
