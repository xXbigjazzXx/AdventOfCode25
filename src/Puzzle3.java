import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle3 {
    /*
    * Okay so a String of ID-Ranges, invalid IDs are repeating numbers eg 11, 22, 333333 or 4242 136136
    * adding up all invalid IDs gives the answer: Above example 11+22+333333+4242+136136
    * Vergleich mathematisch als Nummer oder durch character im String?
    * */

    public static void puzzle3() {

        String puzzleInput = "";
        long solution = 0;

        try(Scanner input = new Scanner(new File("./src/Puzzle3.txt"))) {
            while(input.hasNextLine()) {
                String data = input.nextLine();
                puzzleInput = puzzleInput + data;

            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }

        String[] Ids = puzzleInput.split(",");
        for(String Id : Ids){
            String[] splitID = Id.split("-");
            Long startingID = Long.valueOf(splitID[0]);
            Long endingID = Long.valueOf(splitID[1]);
            for(long i = startingID; i <= endingID; i++){
                String numberToCheck = String.valueOf(i);
                if(numberToCheck.length() % 2 == 0){
                    String first = numberToCheck.substring(0, numberToCheck.length()/2);
                    String second = numberToCheck.substring(numberToCheck.length()/2);
                    if(first.equals(second)){
                        solution += Long.parseLong(numberToCheck);
                    }
                }
            }
        }
        System.out.println(solution);


    }

}
