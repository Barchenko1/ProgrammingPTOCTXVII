package ua.org.oa.evlashdv.lectures.lecture1.practice.implemica.task2;

public class TravelPrice {
    private static int[][] Price; // Array of transportation costs between cities
    private static int[][] tripCost; //Array of costs paths between two cities
    private static int Value; // Value of cities quantity
    private static final int MAX_COST = 200000;
    public TravelPrice(int numberOfCities){ // Creates array of transportation costs between cities
        Price = new int[numberOfCities][numberOfCities];
        Value = numberOfCities;
        for (int i = 0; i < numberOfCities; i++){
            for(int y = 0; y < numberOfCities; y++){
                Price[i][y] = MAX_COST;
            }
        }
        tripCost = Price;
    }

    public static void setPrice(int departureCityIndex, int arrivalCityIndex, int transportationCost ){ // Fills array of transportation costs by data from file
        if (departureCityIndex < 0 || arrivalCityIndex < 0) {
            System.out.println("Incorrect values of city index.");
            return;
        } else if(transportationCost < 0) {
            System.out.println("Incorrect value of transportation costs.");
            return;
        }

        Price[departureCityIndex][arrivalCityIndex - 1] = transportationCost;

    }

    private static int getInteger(String var){ // Gets Integer value from String
        int value = 0;
        try{
            value = Integer.parseInt(var);
        } catch (ClassCastException e){
            System.out.println(e);
            return -1;
        }
        return value;
    }

    public static void countCostsPaths(){ // Counts transportation costs and fills the array of costs paths between pairs of cities
        for (int k = 0; k < Value; k++)
            for (int i = 0; i < Value; i++)
                for (int j = 0; j < Value; j++)
                    tripCost[i][j] = Math.min(tripCost[i][j], tripCost[i][k] + tripCost[k][j]);
    }

    public static String getCostsPath(String departureCity, String arrivalCity){ // Returns minimum  cost of path between two cities
        String pathCosts = "No paths between - " + departureCity.toUpperCase() + " and " + arrivalCity.toUpperCase();
        if (tripCost[CitiesMap.getIndex(departureCity)][CitiesMap.getIndex(arrivalCity)] < MAX_COST){
            pathCosts = "Minimum cost of path - " + departureCity+" " + arrivalCity +" "+
                    tripCost[CitiesMap.getIndex(departureCity)][CitiesMap.getIndex(arrivalCity)];
        }
        return pathCosts;
    }
}