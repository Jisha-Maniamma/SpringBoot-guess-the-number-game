package juntos.itSpringFaramewor;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Jisha Maniamma
 * @version 1.0
 * @date 2021/08/06 11:01
 */
@Slf4j
@Getter
@Component
public class GameImpl implements Game{

    // == constants ==

//    public static final Logger log= LoggerFactory.getLogger(GameImpl.class);

    // == fields ==

  //  @Autowired
    private NumberGenerator numberGenerator;

    public GameImpl(NumberGenerator numberGenerator,@GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    //  @Autowired
    @GuessCount
    private int guessCount;
    private int guess;
    private boolean validNumberRange=true;
    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;


    // == init ==
    @PostConstruct
    @Override
    public void rest() {
        //log.trace("the number is {}", number);

        smallest=numberGenerator.getMinNumber();
        guess=numberGenerator.getMinNumber();
        remainingGuesses=guessCount;
        biggest=numberGenerator.getMaxNumber();
        number=numberGenerator.next();
        log.debug("the number is {}", number);
    }


    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy()");
    }
///////////////////////////////////////////
    // == constructor ==
    // constructor based dependency injection
//
//    public GameImpl(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }
    /////////////////////////////////////////////////


    // == public methos ==


//    public void setNuumberGenerator(NumberGenerator numberGenerator){
//        this.numberGenerator=numberGenerator;
//    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess=guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemaining() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }


    @Override
    public void check() {
        checkValidNumberRange();
        if(validNumberRange){
            if(guess>number){
                biggest=guess-1;
            }
            if(guess<number){
                smallest=guess+1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess ==number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses<=0;
    }


    // == private method ==
    private void checkValidNumberRange(){
        validNumberRange= (guess>=smallest) && (guess<=biggest);

    }
}
