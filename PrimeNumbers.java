
/**
 * Check if a number is prime and prompt the user
 *
 * @author Ari Hayete
 * @version v1.0
 * @since Nov 5, 2026
 */

import java.util.Scanner;
public class PrimeNumbers
{
    public static void main (String[] args) {
        boolean isPrime;
        int number;
        String playAgain;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("Enter a number to check if it is prime:");
            number = scan.nextInt();
            //fix trailing \n bug
            scan.nextLine();
            
            isPrime = testForPrime(number);
            System.out.print("Your number, " + number + ", is ");
            if(!isPrime)
                System.out.print("not ");
            System.out.print("prime");
            System.out.print("\nWould you like to test another number? Y/N");
            playAgain = scan.nextLine();
        } while (playAgain.equalsIgnoreCase("y"));
    }
    /**
     * Check if a number is prime
     * 
     * @param number is a whole number greater than 2
     * @return boolean whether it is prime or not
     */
    public static boolean testForPrime(int num){
        int inNumberSqRt = (int)Math.sqrt(num);
        boolean isPrimeMeth = true;
        
        for (int i = 2; isPrimeMeth && i <= inNumberSqRt; i++) {
            if ((double) num / i - num / i == 0)
                isPrimeMeth = false;
        }
        
        return isPrimeMeth;
    }
}