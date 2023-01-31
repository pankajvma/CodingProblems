package dsAlgoSpecialization.week3greedyAlgorithms;

import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int currentStop = 0;
        int count = 0;
        int totalStops = stops.length;

        for (int i = 0; i < totalStops; i++) {
            if (dist - currentStop <= tank) {
                return count;
            } else if (((i + 1) <= (totalStops - 1) && (stops[i + 1] - currentStop) > tank
                    && (stops[i] - currentStop) <= tank)
                    ||
                    ((i == totalStops - 1) && (stops[i] - currentStop) <= tank)) {
                currentStop = stops[i];
                count++;
            }
        }

        if(dist - currentStop > tank) return -1;
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int[] stops = new int[n];
        for(int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
        System.out.println(computeMinRefills(dist, tank, stops));
    }
}