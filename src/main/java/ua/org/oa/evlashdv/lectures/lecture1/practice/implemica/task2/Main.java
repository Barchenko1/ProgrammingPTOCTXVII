package ua.org.oa.evlashdv.lectures.lecture1.practice.implemica.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dataFileName = reader.readLine(); // Read file name
        reader = new BufferedReader(new FileReader(dataFileName)); // Create a BufferedReader to read from file
        int numberOfTest = Integer.parseInt(reader.readLine().replace("\uFEFF", "")); //Read the number of tests
        if (numberOfTest > 10){
            System.out.println("Please check values from file. The number of tests must be <= 10");
            return;
        }
        int numberOfCities = Integer.parseInt(reader.readLine().replace("\uFEFF", ""));; // Read number of cities
        if (numberOfCities > 10000){
            System.out.println("Please check data.The number of cities must be <= 10000");
            return;
        }

        TravelPrice travelRate = new TravelPrice(numberOfCities); // Create a new class with path costs data

        for (int cityIndex = 0; cityIndex < numberOfCities; cityIndex++){ // Create new cities with ways cost
            CitiesMap.addCity(cityIndex, reader.readLine()); // Add new city
            int neighbours = Integer.parseInt(reader.readLine());//Set neighbours of city
            for (int y = 0; y < neighbours; y++){
                String[] nrCost = reader.readLine().split(" ");
                TravelPrice.setPrice(cityIndex, Integer.parseInt(nrCost[0]), Integer.parseInt(nrCost[1]));//Set cost or the paths from city to neighbour
            }
        }
        ArrayList<String> routes = new ArrayList<>(); // Created new array. Array contains pairs of cities to find the paths of minimum cost between pairs of cities.
        int routeRequests = Integer.parseInt(reader.readLine()); // Reading number of city pairs to find the paths of minimum cost
        for (int z = 0; z < routeRequests; z++){ // Add city pairs to Array of cities fot future requests.
            routes.add(reader.readLine());
        }

        reader.close();

        travelRate.countCostsPaths();   // Count the paths of minimum cost between pairs of cities

        for (String route : routes) {   // Print minimum cost between pairs of cities
            String[] pair = route.split(" ");
            System.out.println(travelRate.getCostsPath(pair[0], pair[1]));
        }
    }
}