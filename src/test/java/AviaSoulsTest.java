import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    @Test
    public void compareTicketsPrice() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2000, 5, 6);
        Ticket ticket2 = new Ticket("MSK", "SPB", 1900, 6, 7);
        Ticket ticket3 = new Ticket("MSK", "SPB", 3000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "KZN", 2500, 9, 11);
        Ticket ticket5 = new Ticket("UFA", "MSK", 5000, 7, 10);
        Ticket ticket6 = new Ticket("MSK", "SPB", 5400, 15, 17);
        Ticket ticket7 = new Ticket("MSK", "SPB", 3800, 21, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Ticket[] expected = { ticket2, ticket1, ticket3, ticket7, ticket6 };
        Ticket[] actual = manager.search("MSK", "SPB");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareTicketsPriceNotFound() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2000, 5, 6);
        Ticket ticket2 = new Ticket("MSK", "SPB", 1900, 6, 7);
        Ticket ticket3 = new Ticket("MSK", "SPB", 3000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "KZN", 2500, 9, 11);
        Ticket ticket5 = new Ticket("UFA", "MSK", 5000, 7, 10);
        Ticket ticket6 = new Ticket("MSK", "SPB", 5400, 15, 17);
        Ticket ticket7 = new Ticket("MSK", "SPB", 3800, 21, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Ticket[] expected = { };
        Ticket[] actual = manager.search("SPB", "MSK");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareTicketsPriceBoundary() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2000, 5, 6);
        Ticket ticket2 = new Ticket("MSK", "SPB", 1900, 6, 7);
        Ticket ticket3 = new Ticket("MSK", "SPB", 3000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "KZN", 2500, 9, 11);
        Ticket ticket5 = new Ticket("UFA", "MSK", 5000, 7, 10);
        Ticket ticket6 = new Ticket("MSK", "SPB", 5400, 15, 17);
        Ticket ticket7 = new Ticket("MSK", "SPB", 3800, 21, 23);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Ticket[] expected = { ticket5 };
        Ticket[] actual = manager.search("UFA", "MSK");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparatorTicketsFlightsTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2000, 5, 9); // 4
        Ticket ticket2 = new Ticket("MSK", "SPB", 1900, 6, 11); // 5
        Ticket ticket3 = new Ticket("MSK", "SPB", 3000, 10, 13); // 3
        Ticket ticket4 = new Ticket("SPB", "KZN", 2500, 9, 11);
        Ticket ticket5 = new Ticket("UFA", "MSK", 5000, 7, 10);
        Ticket ticket6 = new Ticket("MSK", "SPB", 5400, 15, 16); // 1
        Ticket ticket7 = new Ticket("MSK", "SPB", 3800, 21, 23); // 2
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = { ticket6, ticket7, ticket3, ticket1, ticket2 };
        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparatorTicketsFlightsTimeOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 2000, 5, 9); // 4
        Ticket ticket2 = new Ticket("MSK", "SPB", 1900, 6, 11); // 5
        Ticket ticket3 = new Ticket("MSK", "SPB", 3000, 10, 13); // 3
        Ticket ticket4 = new Ticket("SPB", "KZN", 2500, 9, 11);
        Ticket ticket5 = new Ticket("UFA", "MSK", 5000, 7, 10);
        Ticket ticket6 = new Ticket("MSK", "SPB", 5400, 15, 16); // 1
        Ticket ticket7 = new Ticket("MSK", "SPB", 3800, 21, 23); // 2
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = { ticket5 };
        Ticket[] actual = manager.search("UFA", "MSK", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }


}