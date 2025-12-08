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
        int rotationDirection;
        int lastPosition = position;

        for (int i = 0; i < length; i++) {
            rotationDirection = words[i].contains("L") ? -1 : 1;
            String word = words[i].substring(1);
            Integer rotation = Integer.valueOf(word, 10);
            while(rotation > 100) {
                rotation -= 100;
                combinationCounter++;
            }
            while(rotation < -100){
                rotation += 100;
                combinationCounter++;
            }

            System.out.println("Position: " + position);
            System.out.println("LR: " + words[i]);
            position = position + (rotation * rotationDirection);


            if(position == 0){
                combinationCounter++;

            }

            while(position < 0){
                position += 100;
                if(lastPosition != 0){
                    combinationCounter++;
                }
                //Edgecase fix for rotations over L100 when on position 0:
                lastPosition = position;


            }

            while(position >= 100) {
                position -= 100;
                combinationCounter++;

            }
            lastPosition = position;

            System.out.println("position after: " + position);
            System.out.println("counter: " + combinationCounter);
            System.out.println("---------");


        }

        // System.out.println(actualInput);
        System.out.println(combinationCounter);
    }
}
