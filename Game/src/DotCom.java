import java.util.*;
public class DotCom {
    /*
     * This class using for creating playing sites and setting their locations,
     * also checking for users guess.
     */

    private ArrayList<String> locationCells;    // Locations for each of site
    private String name;    // Variable of sites name

    public void setLocationCells (ArrayList<String> loc, String n) {
        /*
         * This method implements setter for ArrayList,
         * which set locations of sites and their names
         */

        locationCells = loc;
        name = n;
    }

    public String getName() {
        /*
         * Getter to get sites names when they will sink.
         */

        return name;
    }

    public ArrayList<String> getLocationCells() {
        /*
         *  This getter return site location, it needed in testing code to see,
         * if it properly work.
         */

        return locationCells;
    }

    public String checkYourself(String userInput) {
        /*
         * This method return String variable "result":
         * 1. "Missed" - if user didnt guess right;
         * 2. "Hitted" - if user guessed right;
         * 3. "Sank" - if all sites terminated.
         */

        String result = "Missed!";  // Variable of result
        int index = locationCells.indexOf(userInput);   // Variable of index users guess

        /*
         * Next condition check if index greater than zero,
         * thats mean that users guess is right,
         * than we should remove that that element from ArrayList.
         * Change String variable "result" to needed and return it.
         */

        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Sank!";
            } else {
                result = "Hitted!";
            }
        }
        return result;
    }
}
