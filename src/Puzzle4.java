import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Puzzle4 {
    /*
    * Day 2 Puzzle 2: Same as before but any repeating sequence >= 2 times is invalid.
    * */


    public static void puzzle4() {
        final File INPUTFILE = new File("Puzzle3.txt");
        String puzzle = "";


        try (Scanner scanner = new Scanner(INPUTFILE)) {
            while (scanner.hasNextLine()) {
                String line  = scanner.nextLine();
                puzzle += line;

            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        String[] IDs = puzzle.split(",");

        for(String ID : IDs) {
            String[] both = ID.split("-");
            String first = both[0];
            String second = both[1];
            int modulochecker = 2;
            //using ArrayList for dynamic changes of size:
            ArrayList<String> inputStringValue = new ArrayList<>();

            for(long i = Long.parseLong(first); i <= Long.parseLong(second); i++) {
                while(modulochecker <= 10){


                    break;
                }
                modulochecker = 2;
            }



        }

    }
}
