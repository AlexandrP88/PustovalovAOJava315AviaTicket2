package ru.netology.repository;

import ru.netology.domain.Route;
import ru.netology.manager.RouteManager;

import java.util.Arrays;

public class RouteRepository {
    private Route[] route = new Route[0];

    public void save(Route ticket) {
        int length = route.length + 1;
        Route[] tmp = new Route[length];
        System.arraycopy(route, 0, tmp, 0, route.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        route = tmp;
        Arrays.sort(route);
    }

    public Route[] findAll() {
        Arrays.sort(route);
        return route;
    }

}
