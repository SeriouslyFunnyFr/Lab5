
/**
 * Write a description of class FallingDistance here.
 *
 * @author Ari Hayete
 * @version v1.0
 * @since Nov 5, 2026
 */

import java.util.Scanner;
public class FallingDistance
{
    //public constant for acceleration
    public static final double ACCELERATION = 9.8;
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        double distance;
        int numOfSecs;
        
        System.out.println("Please enter how many seconds you would like to compute:");
        numOfSecs = scan.nextInt();
        
        System.out.println("Time\tDistance\n============");
        for(int i = 1; i <= numOfSecs; i++){
            System.out.printf(i + "\t%.1f\n", getDistance(i));
        }
    }
    /**
     * Find distance as a function of time
     * 
     * @param time in seconds from release
     * @return distance as a double in meters
     */
    public static double getDistance (int time) {
        return 0.5 * ACCELERATION * Math.pow(time, 2);
    }
}