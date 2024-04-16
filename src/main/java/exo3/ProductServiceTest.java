package exo3;

// ProductServiceTest.java

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Test
    public void testGetProduct_Successful() {
        // Créer un mock pour ProductApiClient
        ProductApiClient mockProductApiClient = mock(ProductApiClient.class);

        // Créer une instance de ProductService avec le mock
        ProductService productService = new ProductService(mockProductApiClient);

        // Créer un produit pour le test
        Product expectedProduct = new Product("1", "Product Name", 10.0); // Supposons que Product a un constructeur prenant un id, un nom et un prix

        // Configurer le comportement du mock pour la récupération réussie
        when(mockProductApiClient.getProduct("1")).thenReturn(expectedProduct);

        // Appeler la méthode à tester
        Product actualProduct = productService.getProduct("1");

        // Vérifier que ProductApiClient.getProduct est appelé avec le bon argument
        verify(mockProductApiClient).getProduct("1");

        // Vérifier que le résultat retourné est celui attendu
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testGetProduct_IncompatibleDataFormat() {
        // Créer un mock pour ProductApiClient
        ProductApiClient mockProductApiClient = mock(ProductApiClient.class);

        // Créer une instance de ProductService avec le mock
        ProductService productService = new ProductService(mockProductApiClient);

        // Configurer le comportement du mock pour simuler un format de donnée incompatible (lancer une exception)
        when(mockProductApiClient.getProduct("1")).thenThrow(new RuntimeException("Incompatible data format"));

        // Appeler la méthode à tester et vérifier qu'une RuntimeException est levée
        assertThrows(RuntimeException.class, () -> {
            productService.getProduct("1");
        });
    }

    @Test
    public void testGetProduct_APIFailure() {
        // Créer un mock pour ProductApiClient
        ProductApiClient mockProductApiClient = mock(ProductApiClient.class);

        // Créer une instance de ProductService avec le mock
        ProductService productService = new ProductService(mockProductApiClient);

        // Configurer le comportement du mock pour simuler un échec d'appel d'API (lancer une exception)
        when(mockProductApiClient.getProduct("1")).thenThrow(new RuntimeException("API failure"));

        // Appeler la méthode à tester et vérifier qu'une RuntimeException est levée
        assertThrows(RuntimeException.class, () -> {
            productService.getProduct("1");
        });
    }
}