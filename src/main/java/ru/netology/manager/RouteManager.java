package ru.netology.manager;

import ru.netology.domain.Route;
import ru.netology.repository.RouteRepository;

public class RouteManager {
    private RouteRepository repository;

    public RouteManager(RouteRepository repository) {
        this.repository = repository;
    }

    public void add(Route ticket) {
        repository.save(ticket);

    }

    public Route[] searchTicket(String from, String to) {
        Route[] result = new Route[0];
        for (Route route : repository.findAll()) {
            if (route.getDepartureAirport().contains(from)) {
                if (route.getArrivalAirport().contains(to)) {
                    Route[] tmp = new Route[result.length + 1];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = route;
                    result = tmp;
                }
            }

        }
        return result;
    }
}


