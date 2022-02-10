import htmlflow.*;
import org.xmlet.htmlapifaster.EnumRelType;

import java.io.*;

public class GenerationFicheAgent {
    public static void main(String[] args) {
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
