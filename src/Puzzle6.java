import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle6 {


    public static void puzzle6(){
         //Turn on the highest number that 12 digits can produce in the input strings.
        //

        //Exact same reader from previous puzzle, could be an extra class tbh.
        String puzzleInput = "";
        int solution = 0;

        try(Scanner sc = new Scanner(new File("./src/puzzle5.txt"))){
            while(sc.hasNextLine()){
                puzzleInput += sc.nextLine();
                puzzleInput += "\n";

            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        String[] puzzle = puzzleInput.split("\n");
        for(String entry : puzzle){
            System.out.println(entry.length());
        }


    }
}
