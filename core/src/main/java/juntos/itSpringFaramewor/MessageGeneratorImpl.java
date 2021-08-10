package juntos.itSpringFaramewor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * @author Jisha Maniamma
 * @version 1.0
 * @date 2021/08/10 8:32
 */
@Component
public class MessageGeneratorImpl implements  MessageGenerator{

    public static final Logger log=LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;
   // private int guessCount=10;


    @PostConstruct
    public void init(){
        log.info("game={}",game);
    }


    @Override
    public String getMainMessage() {

        return "Number is between "+game.getSmallest()+" and "+game.getBiggest()+". can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "you guessed it! You won!...the number is "+game.getNumber();
        }
        else if(game.isGameLost()){
            return "you lost. th number was "+game.getNumber();
        }
        else if(!game.isValidNumberRange()){
            return "Invalid number range";
        }else if(game.getRemaining()==game.getGuessCount()){
            return "what s your first guss";
        }else{
            String direction="Lower";

            if(game.getGuess()<game.getNumber()){
                direction="Higher";
            }
            return direction+"! you have "+game.getRemaining()+" guesses left ";

        }
    }


}
