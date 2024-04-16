package exo2;

import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Test
    public void testCreateOrder() {
        // Créer des mocks pour OrderService et OrderDao
        OrderService mockOrderService = mock(OrderService.class);
        OrderDao mockOrderDao = mock(OrderDao.class);
        // Créer une instance de OrderController avec les mocks
        OrderController orderController = new OrderController(mockOrderService);


        // Créer une commande pour le test
        Order order = new Order(1,"PlayStation");

        // Appeler la méthode à tester
        orderController.createOrder(order);

        // Vérifier que OrderService.createOrder est appelé avec le bon argument
        verify(mockOrderService).createOrder(order);

        OrderService orderService = new OrderService(mockOrderDao);
        orderService.createOrder(order);
        verify(mockOrderDao).saveOrder(order);


        // Vérifier que OrderDao.saveOrder est appelé avec l'objet de commande créé
        verify(mockOrderDao).saveOrder(order);
    }
    @Test
    public void testEchoeéOrderService() {

        OrderService mockOrderService = mock(OrderService.class);
        OrderDao mockOrderDao = mock(OrderDao.class);
        // Créer une instance de OrderController avec les mocks
        Order order = new Order(1,"PlayStation");

        doThrow(new RuntimeException("Unable to save order")).when(mockOrderService).createOrder(order);

        OrderController orderController = new OrderController(mockOrderService);

        // Créer une commande pour le test

        assertThrows(RuntimeException.class, () -> {
            orderController.createOrder(order);
        });

    }

    @Test
    public void testEchoeéOrderDao() {

        OrderService mockOrderService = mock(OrderService.class);
        OrderDao mockOrderDao = mock(OrderDao.class);
        // Créer une instance de OrderController avec les mocks
        OrderController orderController = new OrderController(mockOrderService);

        Order order = new Order(1,"PlayStation");
        OrderService orderService = new OrderService(mockOrderDao);
        orderService.createOrder(order);

        doThrow(new RuntimeException("Unable to save order")).when(mockOrderDao).saveOrder(order);
        // Créer une commande pour le test

        assertThrows(RuntimeException.class, () -> {
            orderService.createOrder(order);
        });


    }
}