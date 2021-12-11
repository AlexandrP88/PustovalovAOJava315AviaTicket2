package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Route;
import ru.netology.repository.RouteRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RouteManagerTest {
    Route ticket1 = new Route(15, 150, "DME", "LED", 1500);
    Route ticket2 = new Route(16, 100, "DME", "LED", 1000);
    Route ticket3 = new Route(17, 200, "DME", "LED", 1400);
    Route ticket4 = new Route(18, 500, "DME", "AJJ", 2500);
    Route ticket5 = new Route(19, 220, "DME", "NAB", 3500);
    Route ticket6 = new Route(20, 300, "DME", "WAB", 100);
    Route ticket7 = new Route(21, 10, "DME", "TJM", 200);


    @Test
    public void showdAllTicket() {
        RouteRepository repo = new RouteRepository();

        RouteManager manager = new RouteManager(repo);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Route[] expected = {ticket7, ticket2, ticket1, ticket3, ticket5, ticket6, ticket4};
        Route[] actual = repo.findAll();

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

    @Test
    public void showdTicketFromTo() {
        RouteRepository repo = new RouteRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);

        RouteManager manager = new RouteManager(repo);


        Route[] expected = {ticket2, ticket1, ticket3,};
        Route[] actual = manager.searchTicket("DME", "LED");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

    @Test
    public void showdNoTicket() {
        RouteRepository repo = new RouteRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);

        RouteManager manager = new RouteManager(repo);


        Route[] expected = {};
        Route[] actual = manager.searchTicket("LED", "DME");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

}