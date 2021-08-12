package Juntos.itSpringFaramewor.console;

import juntos.itSpringFaramewor.Game;
import juntos.itSpringFaramewor.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;


/**
 * @author Jisha Maniamma
 * @version 1.0
 * @date 2021/08/10 11:10
 */
@Slf4j
@Component
public class ConsoleNumberGuess {
//    public static final Logger log= LoggerFactory.getLogger(ConsoleNumberGuess.class);


  //  @Autowired
    private Game game;

    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //@Autowired
    private MessageGenerator messageGenerator;

    @EventListener(ContextRefreshedEvent.class)
    public void start(){
        log.info("start()---> container is called");

        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int gues= scanner.nextInt();
            scanner.nextLine();
            game.setGuess(gues);
            game.check();


            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("play agin y/n?");
                String playagain=scanner.nextLine().trim();
                if(!playagain.equalsIgnoreCase("y")){
                    break;
                }
                game.rest();
            }
        }
    }

}
