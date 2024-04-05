package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
	private Chef abraracourcix;
	private Village village;
    private ControlAfficherMarche controlAfficherMarche;

    @BeforeEach
    public void init() {
        System.out.println("Début du test...");
        village = new Village("le village des irréductibles", 10, 5);
        abraracourcix = new Chef("abraracourcix",10, village);
        village.setChef(abraracourcix);
        Gaulois asterix = new Gaulois("Asterix", 3);
        Gaulois obelix = new Gaulois("Obelix", 5);
        village.ajouterHabitant(asterix);
        village.ajouterHabitant(obelix);
        ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(
            new ControlVerifierIdentite(village),
            village
        );
        controlPrendreEtal.prendreEtal("Asterix", "Poisson", 10);
        controlPrendreEtal.prendreEtal("Obelix", "Menhir", 15);
        controlAfficherMarche = new ControlAfficherMarche(village);
    }

    @Test
    void testDonnerInfosMarche() {
        String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
        assertNotNull(infosMarche);
        assertTrue(infosMarche.length > 0);
    }

    @AfterEach
    void tearDown() {
        System.out.println("... Fin du test");
    }
}
