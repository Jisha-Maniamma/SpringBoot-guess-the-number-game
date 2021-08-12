package Juntos.itSpringFaramewor.console;


import juntos.itSpringFaramewor.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Jisha Maniamma
 * @version 1.0
 * @date 2021/08/05 11:37
 */
@Slf4j
public class Main {
//    public static final Logger log= LoggerFactory.getLogger(Main.class);
//    private static  final String CONFIG_LOCATION="beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // create context (container)

//        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(GameConfig.class);
        //get number generator bean from context (container)
//        NumberGenerator numberGenerator=context.getBean("numberGenerator",NumberGenerator.class);
//        NumberGenerator numberGenerator=context.getBean(NumberGenerator.class);

        //call method next() to get random number
//
//        int number=numberGenerator.next();
//        log.info("number={}",number);
//
//
////        //get game bean from context (container)
////        Game game=context.getBean(Game.class);
//
//        //get message generator bean from context (container)
//        MessageGenerator messageGenerator=context.getBean(MessageGenerator.class);
//
//
//        log.info("getMainMeassage={}",messageGenerator.getMainMessage());
//        log.info("getResultMessage={}",messageGenerator.getResultMessage());
//
////        game.rest();

        context.close();
    }
}
