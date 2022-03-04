import java.util.ArrayList;

import static j2html.TagCreator.*;
import static j2html.TagCreator.h1;

public class Generateur {
    public static String genererHtml(){
        ArrayList<String> listeEquipement=new ArrayList<>(2);
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
                                ,div(attrs("ListeEquipement")),
                                each(listeEquipement, equipement ->
                                        div(attrs("equipement"),
                                                p(equipement))


                        )
                )
                )
        ).render();

    }
}
