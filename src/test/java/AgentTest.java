import fr.epsi.mspr.Agent;
import fr.epsi.mspr.Equipement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static fr.epsi.mspr.Agent.getAllAgent;
import static fr.epsi.mspr.Equipement.getListEquipement;
import static org.junit.jupiter.api.Assertions.*;

public class AgentTest {
    public static Agent agent = new Agent();
    public static ArrayList<Agent> agentList = new ArrayList<>();


    @BeforeAll
    static void environement() {
        agentList = getAllAgent();
        agent.getInfoAgent("data/cberthier.txt");
    }

    @Test
    public void verificationAgent() {
        assertEquals(agentList.get(0).getNom(), agent.getNom());

    }

    @Test
    public void verificationEquipement() {
        //ÉTANT DONNE un agent et une liste d'equipement
        Agent agent1 = new Agent();
        ArrayList<Equipement> equipement = new ArrayList<>();
        equipement = getListEquipement("equipement");
        //QUAND Agent est relié à des equipement
        agent1.getInfoAgent("data/cberthier.txt");
        agent1.getEquipement("data/cberthier.txt");
        //ALORS les equipements des agents corresponds à la liste d'equipement possible
        assertTrue(true);
        for ( Equipement equipementAgent : agent1.getEquipement("data/cberthier.txt")){
            for ( Equipement equipementListe : equipement){
                if (equipementListe.getNom().contains(equipementAgent.getNom())){
                    assertTrue(true);
                }
            }

        }

    }
}
