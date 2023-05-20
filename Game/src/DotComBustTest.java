import java.util.*;
public class DotComBustTest {
    /*
     * Testing class of full program
     */
    public static void main(String[] args) {

        DotComBust dotComTest = new DotComBust();
        dotComTest.setUpGame();     // Launching the game

        // Checking by loop correct names and cells locations for each of site
        for (DotCom site : dotComTest.dotComList) {
            System.out.printf("%s: %s \n", site.getName(), site.getLocationCells());
        }
    }
}
