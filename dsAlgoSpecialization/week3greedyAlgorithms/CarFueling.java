package dsAlgoSpecialization.week3greedyAlgorithms;

import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        // The minimum number of refills to get from one city to another if a car can travel at most "tank" miles on a full tank.
        // The distance between the cities is "dist" miles and there are gas stations at distances stop1, stop2,..., stopn along the way. 
        // We assume that a car starts with a full tank.
        int currentStop = 0;
        int lastStop = 0;
        int count = 0;
        int totalStops = stops.length;
        for(int i = 0; i < totalStops; i++){
            if(dist <= tank){
                return count;
            } else if((stops[i] - currentStop) > tank && (i - 1) >= 0 && (stops[i - 1] - currentStop) <= tank){
                lastStop = currentStop;
                currentStop = stops[i - 1];
                dist -= (currentStop - lastStop);
                count++;
            } else if(i == totalStops - 1){
                currentStop = stops[i];
                dist -= currentStop;
                count++;
            }
        }
        if(dist > tank) return -1;
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        // int dist = 950;
        // int tank = 400;
        // int n = 4;
        // int[] stops = {200, 375, 550, 750};
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}