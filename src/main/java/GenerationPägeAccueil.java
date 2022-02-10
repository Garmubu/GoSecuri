import htmlflow.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class GenerationPägeAccueil {
    public static void main(String[] args){
        HtmlView view = StaticHtml.view(v -> v
                .html()
                .body()
                .p().text("Ca va marcher? :-)").__()
                .__() //body
                .__()); // html
        String html = view.render();        // 1) get a string with the HTML
        try {
            view
                    .setPrintStream(new PrintStream(new FileOutputStream("C:\\wamp\\www\\GoSecuri\\index.html")))
                    .write();                       // 3) write to details.html file                     // 2) print to the standard output
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
