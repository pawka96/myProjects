import java.io.*;
import java.util.*;
public class GameHelper {
    /*
     * This is supporting class, which implements inputting users guess in console for the further game.
     */

    public String getUserInput(String outputMessage) {
        /*
         * This method get users String type input by using BufferedReader and InputStreamReader,
         *  also catch IO Exception if it should be and return String.
         */

        String inputLine = null;
        System.out.print(outputMessage + " ");
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            inputLine = input.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }

    public ArrayList<String> placeDotCom() {
        /*
         *
         */

        ArrayList<String> siteLocation = new ArrayList<>();
        int[][] numbMatrix = new int[7][7];
        String[][] letterMatrix = new String[7][7];

        for (int i = 0; i < numbMatrix.length; i++) {
            for (int j = 0; j < numbMatrix[i].length; j++) {
                numbMatrix[i][j] = j + 1;
                letterMatrix[i][j] = Integer.toString(numbMatrix[i][j]);
            }
        }

        for (int j = 0; j < letterMatrix[0].length; j++) {
            letterMatrix[0][j] = "A".concat(letterMatrix[0][j]);
        }
        for (int j = 0; j < letterMatrix[1].length; j++) {
            letterMatrix[1][j] = "B".concat(letterMatrix[1][j]);
        }
        for (int j = 0; j < letterMatrix[2].length; j++) {
            letterMatrix[2][j] = "C".concat(letterMatrix[2][j]);
        }
        for (int j = 0; j < letterMatrix[3].length; j++) {
            letterMatrix[3][j] = "D".concat(letterMatrix[3][j]);
        }
        for (int j = 0; j < letterMatrix[4].length; j++) {
            letterMatrix[4][j] = "E".concat(letterMatrix[4][j]);
        }
        for (int j = 0; j < letterMatrix[5].length; j++) {
            letterMatrix[5][j] = "F".concat(letterMatrix[5][j]);
        }
        for (int j = 0; j < letterMatrix[6].length; j++) {
            letterMatrix[6][j] = "G".concat(letterMatrix[6][j]);
        }

        int randDirection = (int) (Math.random() * 2);
        int randRow = (int) (Math.random() * 7);
        int randColumn = (int) (Math.random() * 7);
        String cell = letterMatrix[randRow][randColumn];
        siteLocation.add(cell);

        if (randDirection == 0) {   // Horizontal direction
            try {
                for (int i = 1; i <= 2; i++) {
                    cell = letterMatrix[randRow + i][randColumn];
                    siteLocation.add(cell);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                for (int i = 1; i <= 2; i++) {
                    cell = letterMatrix[randRow - i][randColumn];
                    siteLocation.add(cell);
                    if (siteLocation.size() == 3) {
                        break;
                    }
                }
            }
        } else {    // Vertical direction
            try {
                for (int j = 1; j <= 2; j++) {
                    cell = letterMatrix[randRow][randColumn + j];
                    siteLocation.add(cell);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                for (int j = 1; j <= 2; j++) {
                    cell = letterMatrix[randRow][randColumn - j];
                    siteLocation.add(cell);
                    if (siteLocation.size() == 3) {
                        break;
                    }
                }
            }
        }
        return siteLocation;
    }
}
