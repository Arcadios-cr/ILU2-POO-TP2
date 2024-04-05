package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	
	private Chef abraracourcix;
    private Village village;
    private ControlAfficherVillage controlAfficherVillage;


    @BeforeEach
    public void init() {
        System.out.println("Début du test...");
        village = new Village("le village des irréductibles", 10, 5);
        abraracourcix = new Chef("abraracourcix",10, village);
        village.setChef(abraracourcix);
        controlAfficherVillage = new ControlAfficherVillage(village);
    }

    @Test
    void donnerNomsVillageois() {
    	Gaulois asterix = new Gaulois("asterix",3);
    	Gaulois panoramix = new Gaulois("panoramix",5);
        village.ajouterHabitant(asterix);
        village.ajouterHabitant(panoramix);
        String[] nomsVillageois = controlAfficherVillage.donnerNomsVillageois();
        assertEquals(3, nomsVillageois.length);
        assertArrayEquals(new String[]{"abraracourcix","asterix", "panoramix"}, nomsVillageois);
    }

    @Test
    void donnerNomVillage() {
        String nomVillage = controlAfficherVillage.donnerNomVillage();
        assertEquals("le village des irréductibles", nomVillage);
    }

    @Test
    void donnerNbEtals() {
        int nbEtals = controlAfficherVillage.donnerNbEtals();
        assertEquals(5, nbEtals);
    }

    @AfterEach
    void tearDown() {
        System.out.println("... Fin du test");
    }
}
