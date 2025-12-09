import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle5 {
    /*
    * Highest Joltage Puzzle: Have a String of numbers like 89569, without changing the order of the numbers from left to right: What is the highest combination of 2 numbers we can create.
    * */


    public static void puzzle5(){
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
            System.out.println(entry);
            //two "pointers" iterating through the string
            // int pointerDecimal = 0;
            int decimal = Character.getNumericValue(entry.charAt(0));
            int positionDecimal = 0;
            int number = -1;
            // int pointer = 1;
            for(int pointerDecimal = 1; pointerDecimal<entry.length() - 1; pointerDecimal++){
                if(Character.getNumericValue(entry.charAt(pointerDecimal)) > decimal) {
                    decimal = Character.getNumericValue(entry.charAt(pointerDecimal));
                    positionDecimal = pointerDecimal;
                }
            }
            for(int numberPointer = positionDecimal+1; numberPointer<entry.length(); numberPointer++){
                if(Character.getNumericValue(entry.charAt(numberPointer)) > number) {
                    number = Character.getNumericValue(entry.charAt(numberPointer));
                }
            }
            if(number == -1){
                System.out.println("Something went wrong, number is still -1!");
            }
            solution += (decimal*10) + number;
            System.out.println((decimal*10) + number);

        }
        System.out.println(solution);
    }
}
