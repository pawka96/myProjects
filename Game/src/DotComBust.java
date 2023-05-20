import java.util.*;
public class DotComBust {
    /*
     *
     */

    GameHelper helper = new GameHelper();
    ArrayList<DotCom> dotComList = new ArrayList<>();
    int numOfGuesses = 0;

    public void setUpGame() {
        /*
         *
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
         *
         */

        String userGuess;
        while (!dotComList.isEmpty()) {
            userGuess = helper.getUserInput("Please input cell: ");
            checkUserGuess(userGuess);
        }
    }

    public void checkUserGuess(String guess) {
        /*
         *
         */

        String resultOfGuess = null;
        int numOfHits = 0;

        for (DotCom site : dotComList) {
            resultOfGuess = site.checkYourself(guess);
            numOfGuesses++;
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
        System.out.printf(" %s Number of hits: %d", resultOfGuess, numOfHits);
    }

    public void finishGame() {
        /*
         *
         */

        System.out.printf("The game is ended! ");
        if (numOfGuesses > 25) {
            System.out.printf("Your number of guesses - %d, looser!", numOfGuesses);
        } else {
            System.out.printf("Your number of guesses - %d, congratulations!", numOfGuesses);
        }
    }
}


