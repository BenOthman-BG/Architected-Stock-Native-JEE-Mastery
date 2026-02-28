package dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import metier.entities.Produit;

public class DaoTest {

    @Test
    void testSaveEtRecherche() {
        ProduitDaoImpl dao = new ProduitDaoImpl();
        
        // Test de l'insertion
        Produit p1 = dao.saveProduit(new Produit("HP", 4500.0, 10));
        Produit p2 = dao.saveProduit(new Produit("LENOVO", 6444.9, 20));
        
        // Vérifications (Assertions)
        assertNotNull(p1.getId(), "L'ID ne doit pas être nul après l'insertion");
        assertNotNull(p2.getId());
        
        // Test de la recherche
        List<Produit> prods = dao.ProduitsParMC("%HP%");
        
        assertFalse(prods.isEmpty(), "La liste ne doit pas être vide pour le mot-clé HP");
        assertEquals("HP", prods.get(0).getDesignation());
        
        System.out.println("Test JUnit réussi : Produits insérés et récupérés avec succès.");
    }
}