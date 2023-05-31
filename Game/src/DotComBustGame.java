public class DotComBustGame {
    /*
     * Class of the game with object, which launches needed methods.
     */
    public static void main(String[] args) {

        DotComBust dotComGame = new DotComBust();
        dotComGame.setUpGame();
        dotComGame.startPlaying();
        dotComGame.finishGame();
    }
}
