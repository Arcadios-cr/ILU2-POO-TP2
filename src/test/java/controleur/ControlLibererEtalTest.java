package controleur;


import org.junit.jupiter.api.*;
import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ControlLibererEtalTest {

	private Village village;
    private Chef abraracourcix;
    private ControlLibererEtal controlLibererEtal;

    @BeforeEach
    void init() {
        System.out.println("Debut du test...");
        village = new Village("le village des irréductibles", 10, 5);
        abraracourcix = new Chef("abraracourcix",10, village);
        village.setChef(abraracourcix);
        village.installerVendeur(abraracourcix,"fleurs",12);
        ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
        controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur,village);

    }

    @AfterEach
    void Stop() {
        System.out.println("...Fin du test");
    }

    @Test
    void isSeller() {
        assertFalse(controlLibererEtal.isSeller("Inconnu"));
        assertFalse(controlLibererEtal.isSeller("bonemine"));
        Gaulois bonemine = new Gaulois("bonemine",3);
        village.ajouterHabitant(bonemine);
        village.installerVendeur(bonemine,"fleurs",12);
        assertTrue(controlLibererEtal.isSeller("bonemine"));
        assertTrue(controlLibererEtal.isSeller("abraracourcix"));
    }

    @Test
    void libererEtal() {
        assertNull(controlLibererEtal.libererEtal("Inconnu"));
        assertNotNull(controlLibererEtal.libererEtal("abraracourcix"));
    }

}
