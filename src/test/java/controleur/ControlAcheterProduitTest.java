package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

class ControlAcheterProduitTest {
	
	private Chef abraracourcix;
    private Village village;
    private Gaulois asterix;
    private Gaulois panoramix;
    private ControlAcheterProduit controlAcheterProduit;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private ControlVerifierIdentite controlVerifierIdentite;
    private ControlPrendreEtal controlPrendreEtal;


    @BeforeEach
    void setUp() {
        village = new Village("le village des irréductibles", 10, 5);
        abraracourcix = new Chef("abraracourcix",10, village);
        village.setChef(abraracourcix);
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
        controlVerifierIdentite = new ControlVerifierIdentite(village);
        controlAcheterProduit = new ControlAcheterProduit(
            controlVerifierIdentite,
            controlTrouverEtalVendeur,
            village
        );
        asterix = new Gaulois("asterix",3);
        village.ajouterHabitant(asterix);
        panoramix = new Gaulois("panoramix",3);
        village.ajouterHabitant(panoramix);
        controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
        controlPrendreEtal.prendreEtal("asterix","Poisson",10);
        controlPrendreEtal.prendreEtal("panoramix","Poisson",10);
    }

    @Test
    void testObtenirMarchand() {
        String[] marchands = controlAcheterProduit.obtenirMarchand("Poisson");
        assertNotNull(marchands);
        assertEquals(2, marchands.length);
        assertArrayEquals(new String[]{"asterix", "panoramix"}, marchands);
    }

    @Test
    void testAcheterProduit() {
        int quantiteAchetee = controlAcheterProduit.acheterProduit("asterix", 3);
        assertEquals(3, quantiteAchetee);
    }
}
