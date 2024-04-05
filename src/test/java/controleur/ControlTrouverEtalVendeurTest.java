package controleur;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

	 private Village village;
	    private Chef abraracourcix;
	    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	    @BeforeEach
	    void setUp() {
	        System.out.println("Initialisation...");
	        village = new Village("le village des irréductibles", 10, 5);
	        abraracourcix = new Chef("abraracourcix",10, village);
	        village.setChef(abraracourcix);
	        village.installerVendeur(abraracourcix,"fleurs",12);
	        Gaulois bonemine = new Gaulois("bonemine",3);
	        village.ajouterHabitant(bonemine);
	        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);

	    }

	    @Test
	    void trouverEtalVendeur() {
	        assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Inconnu"));
	        assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("abraracourcix"));
	        assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("bonemine"));
	    }

	    @AfterEach
	    void tearDown() {
	        System.out.println("...Fin du test");
	    }

}
