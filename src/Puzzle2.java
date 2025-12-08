import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Puzzle2 {
    /*
    * It is not the times the dial lands on 0, it is everytime the dial passes 0.
    * */


    public static void puzzle2() {
        String actualInput = "";
        int position = 50;
        int combinationCounter = 0;

        try (Scanner myReader = new Scanner(new File("./src/input.txt"))) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                actualInput += data;
                actualInput += "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] words = actualInput.split("\n");
        int length = words.length;
        int rotationDirection = 0;

        for (int i = 0; i < length; i++) {
            rotationDirection = words[i].contains("L") ? -1 : 1;
            String word = words[i].substring(1);
            Integer rotation = Integer.valueOf(word, 10);
            position = position + (rotation * rotationDirection);

            while(position < 0){
                position += 100;
                combinationCounter++;
            }

            while(position >= 100) {
                position -= 100;
                combinationCounter++;
            }

        }

        //System.out.println(actualInput);
        System.out.println(combinationCounter);
    }
}
