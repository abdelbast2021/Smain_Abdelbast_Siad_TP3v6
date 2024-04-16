package exo1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        // Créer un mock pour UserRepository
        UserRepository mockUserRepository = mock(UserRepository.class);

        // Créer une instance de UserService avec le mock
        UserService userService = new UserService(mockUserRepository);

        // Définir le comportement attendu du mock
        long userId = 1L;
        User expectedUser = new User(userId, "John Doe"); // Supposons que User a un constructeur prenant un id et un nom
        when(mockUserRepository.findUserById(userId)).thenReturn(expectedUser);

        // Appeler la méthode à tester
        User actualUser = userService.getUserById(userId);

        // Vérifier que la méthode findUserById a été appelée avec le bon argument
        verify(mockUserRepository).findUserById(userId);

        // Vérifier que le résultat retourné est celui attendu
        assertEquals(expectedUser, actualUser);
    }
}