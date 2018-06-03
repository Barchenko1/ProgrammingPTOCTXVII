package ua.org.oa.evlashdv.lectures.lecture1.p1.implemica.task2;

import java.util.HashMap;
import java.util.Map;

public class CitiesMap {
    private static Map<Integer, String> cities = new HashMap<>(); // Map contains list of cities with indexes

    public static void addCity(int cityIndex, String cityName){ // Method adds cities to cities map
        cities.put(cityIndex, cityName);
    }

    public static int getIndex(String cityName){ // Get cities index by their names
        int index = 0;
        for (Map.Entry<Integer, String> pair : cities.entrySet()){
            if (pair.getValue().equals(cityName)){
                index = pair.getKey();
            }
        }
        return index;
    }
}