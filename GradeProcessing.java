/**
 * Process grades from an input file
 *
 * @author Ari Hayete
 * @version v1.1
 * @since Nov 3
 */
import java.util.Scanner;
import java.io.*;

public class GradeProcessing
{
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);   // one Scanner for System.in
        String inFile = getInFile(keyboard);
        String outFile = getOutFile(keyboard);
        processFile(inFile, outFile);
        keyboard.close();
    }

    /**
     * Prompts until the user enters the name of a file that exists
     *
     * @param scan Scanner reading from System.in
     * @return name of an existing input file
     */
    public static String getInFile(Scanner scan) {
        System.out.println("Enter the name of the file you would like to process:");
        String fileName = scan.nextLine();
        File file = new File(fileName);
        while (!file.exists()) {
            System.out.println("File not found. Enter the name of the file you would like to process:");
            fileName = scan.nextLine();
            file = new File(fileName);
        }
        return fileName;
    }

    /**
     * Prompts for the output file name
     *
     * @param scan Scanner reading from System.in
     * @return name of the output file
     */
    public static String getOutFile(Scanner scan) {
        System.out.println("Enter the name of the output file:");
        return scan.nextLine();
    }

    /**
     * Reads each set of grades (terminated by -1) from the input file
     * and writes a summary of each set to the output file
     *
     * @param inFileName  valid path of the input file
     * @param outFileName filename to write to
     */
    public static void processFile(String inFileName, String outFileName) throws IOException {
        int number;
        int a, b, c, d, f, min, max;
        int total, count;
        int set = 1;

        Scanner scan = new Scanner(new File(inFileName));
        PrintWriter write = new PrintWriter(new File(outFileName));

        while (scan.hasNextInt()) {          // was hasNextLine(): crashed on trailing newline
            a = b = c = d = f = 0;
            total = 0;
            count = 0;

            number = scan.nextInt();
            min = number;
            max = number;

            while (number != -1) {
                if (number < min)
                    min = number;
                if (number > max)
                    max = number;
                count++;
                total += number;
                if (number >= 90)            // was > : a 90 counted as a B
                    a++;
                else if (number >= 80)
                    b++;
                else if (number >= 70)
                    c++;
                else if (number >= 60)
                    d++;
                else
                    f++;

                if (!scan.hasNextInt())      // set missing its -1 terminator
                    break;
                number = scan.nextInt();
            }

            write.println("Set " + set + " of grades collected.");
            set++;
            if (count == 0)
                write.println("No grades to average.");   // was System.out
            else {
                write.println("Number of As: " + a);
                write.println("Number of Bs: " + b);
                write.println("Number of Cs: " + c);
                write.println("Number of Ds: " + d);
                write.println("Number of Fs: " + f);
                write.println("The high score was: " + max);
                write.println("The low score was: " + min);
                write.printf("The average is: %.1f%n", (double) total / count);
            }
        }

        scan.close();
        write.close();                       // without this the output file stays empty
        System.out.println("Grade processing completed.");
        System.out.println("Retrieve output at " + outFileName);
    }
}