package juntos.itSpringFaramewor;

/**
 * @author Jisha Maniamma
 * @version 1.0
 * @date 2021/08/06 10:58
 */

public interface Game {
    int getNumber();
    int getGuess();
    void setGuess(int guess);
    int getSmallest();
    int getBiggest();
    int getRemaining();
    int getGuessCount();
    void rest();
    void check();
    boolean isValidNumberRange();
    boolean isGameWon();
    boolean isGameLost();
}
