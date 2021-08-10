package juntos.itSpringFaramewor.config;

import juntos.itSpringFaramewor.GuessCount;
import juntos.itSpringFaramewor.MaxNumber;
import juntos.itSpringFaramewor.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Jisha Maniamma
 * @version 1.0
 * @date 2021/08/10 11:47
 */
@Configuration
@ComponentScan(basePackages = "juntos.itSpringFaramewor")
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    @Value("${game.maxNumber:20}")
    private int maxNumber;
    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:5}")
    private int minNumber;
    @Bean
    @MaxNumber
    public int maxNumber(){
        return  maxNumber;
    }
    @Bean
    @GuessCount
    public int guessCount(){
        return  guessCount;
    }
    @Bean
    @MinNumber
    public  int minNumber(){
        return minNumber;
    }


}
