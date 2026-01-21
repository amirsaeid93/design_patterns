package org.example.app;

import org.example.maps.CityMap;
import org.example.maps.Map;
import org.example.maps.WildernessMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("City Map:");
        Map city = createMap("city", 10, 5);
        city.display();

        System.out.println("\nWilderness Map:");
        Map wild = createMap("wilderness", 10, 5);
        wild.display();
    }

    public static Map createMap(String type, int width, int height) {
        return switch (type.toLowerCase()) {
            case "city" -> new CityMap(width, height);
            case "wilderness" -> new WildernessMap(width, height);
            default -> throw new IllegalArgumentException("Unknown map type: " + type);
        };
    }
}