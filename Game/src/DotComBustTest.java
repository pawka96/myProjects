import java.util.*;
public class DotComBustTest {
    /*
     * Testing class of full program.
     */
    public static void main(String[] args) {
        /*
         * In this case we creat new object of DotComBust class,
         * launch installation method and check by loop if names and locations for each of site are correсt
         */

        DotComBust dotComTest = new DotComBust();
        dotComTest.setUpGame();     // Installation basic components of the game

        // Checking by loop correct names and cells locations for each of site
        for (DotCom site : dotComTest.dotComList) {
            System.out.printf("%s: %s \n", site.getName(), site.getLocationCells());
        }

        /*
         * In this case we check correctness of method "checkYourself" by DotCom class,
         * which get String variable of user input and output messages.
         * These method using in other method "checkUserGuess" which belong DotComBust class
         * and using in playing method which testing below.
         */

        String testResult = "Something wrong during testing.";

        /*
         * Below we creat new ArrayList which will contain of the 1st site locations,
         * beacuse of ConcurrentModificationException which was when we tried to use
         * ArrayList from "allSitesLocation" directly.
         * Also we check each of the 1st sites cell by outputting message.
         */

        ArrayList<String> copyOfSiteLoc = new ArrayList<>(dotComTest.helper.allSitesLocation.get(0));
        for (String loc : copyOfSiteLoc) {
            String methodRes = dotComTest.dotComList.get(0).checkYourself(loc);     // Variable of method result
            dotComTest.helper.allSitesLocation.get(0).add(loc);     // Return deleted cell to ArrayList
            dotComTest.checkUserGuess(loc);

            // These loop using for checking correctness of output messages
            if (methodRes.equals("Hitted!")) {
                testResult = "Intermediate test is right.";
                System.out.println(testResult);
            } else if (methodRes.equals("Sank!")) {
                testResult = "Full testing is right.";
                System.out.println(testResult);
            } else {
                System.out.println(testResult);
            }
        }

        // Return cells for the 1st site for futher right counting (not an object).
        dotComTest.helper.allSitesLocation.add(0, copyOfSiteLoc);

        /*
         * In this case we sink all sites and check total number of hits by loop,
         * also we check outputting message in the different situations
         * (if missed, hitted, sank).
         */

        int totalNumOfHits = 0;     // Total number of hits (should be 9)
        for (ArrayList siteLocation : dotComTest.helper.allSitesLocation) {
            totalNumOfHits += siteLocation.size();
        }

        dotComTest.startPlaying();      // Launching playing method

        if (totalNumOfHits == dotComTest.numOfHits) {
            System.out.println("Counting of hits is right.");
        } else {
            System.out.println("Wrong counting of hits.");
        }

        /*
         * This case testing final method of finishing game.
         * Considering that we tested another method above and spend 3 attempts,
         * so the counting of total number of guesses should be without these attempts,
         * only count inputting in console.
         */

        dotComTest.finishGame();
    }
}
