import java.io.*;
import java.util.*;
public class GameHelper {
    /*
     * This is supporting class, which implements inputting users guess in console for the further game.
     */

    ArrayList<ArrayList<String>> allSitesLocation = new ArrayList<ArrayList<String>>();     // ArrayList which include 3 ArrayLists for sites locations

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
         * This method return ArrayList of String which include locations for site.
         * There we creat two-dimensional matrix for 7x7 desk where sites will be located.
         * By random generation we get direction and cells for site,
         * also we check that there shouldnt be coincedences of cells.
         */

        ArrayList<String> siteLocation = new ArrayList<String>();

        int[][] numbMatrix = new int[7][7];     // Two-dimensional matrix for numbers (at first)
        String[][] letterMatrix = new String[7][7];     // Two-dimensional matrix for letters (which we add ti numbers after)

        // Loops of filling matrix with numbers and futher translation of them to String
        for (int i = 0; i < numbMatrix.length; i++) {
            for (int j = 0; j < numbMatrix[i].length; j++) {
                numbMatrix[i][j] = j + 1;
                letterMatrix[i][j] = Integer.toString(numbMatrix[i][j]);
            }
        }

        //These loops below implement adding letters for each of row
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

        /*
         * These loops and if-conditions check ArrayList which contain ArrayLists of locations fo each of site,
         * if the cell used, we assign to it "space" and by if-operators we check all conditions to block cells
         * around used by rules of the Sea Battle.
         */
        if (!allSitesLocation.isEmpty()) {
            for (ArrayList<String> list : allSitesLocation) {
                for (String listLoc : list) {
                    for (int i = 0; i < letterMatrix.length; i++) {
                        for (int j = 0; j < letterMatrix[i].length; j++) {
                            if (letterMatrix[i][j].equals(listLoc)) {
                                letterMatrix[i][j] = " ";
                                if (i == letterMatrix.length - 1) {
                                    if (j == letterMatrix[i].length - 1) {
                                        letterMatrix[i - 1][j] = " ";
                                        letterMatrix[i][j - 1] = " ";
                                        letterMatrix[i - 1][j - 1] = " ";
                                    } else if (j == 0) {
                                        letterMatrix[i][j + 1] = " ";
                                        letterMatrix[i - 1][j - 1] = " ";
                                        letterMatrix[i - 1][j] = " ";
                                    } else {
                                        letterMatrix[i][j - 1] = " ";
                                        letterMatrix[i][j + 1] = " ";
                                        letterMatrix[i - 1][j - 1] = " ";
                                        letterMatrix[i - 1][j + 1] = " ";
                                        letterMatrix[i - 1][j] = " ";
                                    }
                                } else if (i == 0) {
                                    if (j == letterMatrix[i].length - 1) {
                                        letterMatrix[i][j - 1] = " ";
                                        letterMatrix[i + 1][j - 1] = " ";
                                        letterMatrix[i + 1][j] = " ";
                                    } else if (j == 0) {
                                        letterMatrix[i][j + 1] = " ";
                                        letterMatrix[i + 1][j] = " ";
                                        letterMatrix[i + 1][j + 1] = " ";
                                    } else {
                                        letterMatrix[i + 1][j] = " ";
                                        letterMatrix[i + 1][j - 1] = " ";
                                        letterMatrix[i][j - 1] = " ";
                                        letterMatrix[i + 1][j + 1] = " ";
                                        letterMatrix[i][j + 1] = " ";
                                    }
                                } else if (i > 0 && i < letterMatrix.length - 1 && j == 0) {
                                    letterMatrix[i - 1][j] = " ";
                                    letterMatrix[i - 1][j + 1] = " ";
                                    letterMatrix[i][j + 1] = " ";
                                    letterMatrix[i + 1][j + 1] = " ";
                                    letterMatrix[i + 1][j] = " ";
                                } else if (i > 0 && i < letterMatrix.length - 1 && j == letterMatrix[i].length - 1) {
                                    letterMatrix[i - 1][j] = " ";
                                    letterMatrix[i - 1][j - 1] = " ";
                                    letterMatrix[i][j - 1] = " ";
                                    letterMatrix[i + 1][j - 1] = " ";
                                    letterMatrix[i + 1][j] = " ";
                                } else {
                                    letterMatrix[i + 1][j] = " ";
                                    letterMatrix[i - 1][j] = " ";
                                    letterMatrix[i][j + 1] = " ";
                                    letterMatrix[i][j - 1] = " ";
                                    letterMatrix[i - 1][j - 1] = " ";
                                    letterMatrix[i - 1][j + 1] = " ";
                                    letterMatrix[i + 1][j + 1] = " ";
                                    letterMatrix[i + 1][j - 1] = " ";
                                }
                            }
                        }
                    }
                }
            }
        }

        int randDirection = (int) (Math.random() * 2);      // Variable of the direction
        int randRow = (int) (Math.random() * 7);        // Variable of row
        int randColumn = (int) (Math.random() * 7);     // Variable of column
        String cell = letterMatrix[randRow][randColumn];
        siteLocation.add(cell);

        /*
         * if-conditions with Exceptions for horizontal and vertical directions.
         * Exceptions are using if we trying to get cell out of array, so if it have to go,
         * we are starting to move to another side.
         */
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
        for (String loc : siteLocation) {
            if (loc.equals(" ")) {
                return placeDotCom();
            }
        }
        allSitesLocation.add(siteLocation);
        return siteLocation;
    }
}



