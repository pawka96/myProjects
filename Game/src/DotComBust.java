import java.util.*;
public class DotComBust {
    /*
     * This class by references manage supporting class and class which contain ArrayList of sites objects.
     */

    GameHelper helper = new GameHelper();       // Supporting object
    ArrayList<DotCom> dotComList = new ArrayList<>();   // ArrayList of "DotCom" which include sites.
    int numOfGuesses = 0;   // Number of guesses
    int numOfHits = 0;      // Number of hits

    public void setUpGame() {
        /*
         * This method creat 3 objects of DotCom (sites), add them to ArrayList,
         * get locations and names for each of them by supporting method.
         */

        DotCom site1 = new DotCom();
        DotCom site2 = new DotCom();
        DotCom site3 = new DotCom();
        dotComList.add(site1);
        dotComList.add(site2);
        dotComList.add(site3);
        site1.setLocationCells(helper.placeDotCom(), "Go2.com");
        site2.setLocationCells(helper.placeDotCom(), "Pets.com");
        site3.setLocationCells(helper.placeDotCom(), "AskMe.com");
    }

    public void startPlaying() {
        /*
         * This method launch the game, then until at least 1 site is alive,
         * offer to user input cell.
         */

        String userGuess;
        while (!dotComList.isEmpty()) {
            userGuess = helper.getUserInput("Please input cell:");
            numOfGuesses++;
            checkUserGuess(userGuess);
        }
    }

    public void checkUserGuess(String guess) {
        /*
         * This method using in method above, which get users input,
         * change result of outputting message depending on the situation,
         * increment number of hits if needed. If site sank, we removed it from ArrayList.
         * After that method output result and current number of hits.
         */

        String resultOfGuess = null;

        for (DotCom site : dotComList) {
            resultOfGuess = site.checkYourself(guess);
            if (resultOfGuess.equals("Hitted!")) {
                numOfHits++;
                break;
            } else if (resultOfGuess.equals("Sank!")) {
                numOfHits++;
                dotComList.remove(site);
                System.out.print(site.getName());
                break;
            }
        }
        System.out.printf(" %s Number of hits: %d. \n", resultOfGuess, numOfHits);
    }

    public void finishGame() {
        /*
         * This method finished the game by ouputting users result:
         * numuber of attempts and congratulations if it lower than 30.
         */

        System.out.printf("The game is ended! ");
        if (numOfGuesses > 30) {
            System.out.printf("Your number of guesses - %d, looser!", numOfGuesses);
        } else {
            System.out.printf("Your number of guesses - %d, congratulations!", numOfGuesses);
        }
    }
}


