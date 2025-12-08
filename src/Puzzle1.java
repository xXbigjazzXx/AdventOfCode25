import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle1 {
    /**
     * Safe puzzle, everytime the dial is on 0, count one up; the total number is the password to the door.
     */

    public static void puzzle1() {

        String actualinput = "";
        int position = 50;
        int combinationCounter = 0;


        try (Scanner myReader = new Scanner(new File("./src/input.txt"))) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                actualinput += data;
                actualinput += "\n";
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        String[] words = actualinput.split("\n");
        int length = words.length -1; //-1 because we start counting at 0;
        int rotationDirection = 0;

        for(int i = 0; i <= length; i++) {
            // if there is an L we want to subtract, if there is an R we want to add.
            rotationDirection = words[i].contains("L") ? -1 : 1;
            String word = words[i].substring(1);
            Integer rotation = Integer.valueOf(word, 10);
            position = position + (rotation * rotationDirection);
            if(position < 0){
                position = 100 + position;
            }
            // Do not know how I got the correct answer, I never actually reset it here, only check.
            combinationCounter = (position % 100 == 0) ? combinationCounter + 1 : combinationCounter;

        }
        System.out.println(combinationCounter);


        //Advent Of Code puzzle one:
        //starting position = 50 on the safe
        //if number < 0 ? number += 100 : number;



    }
}

