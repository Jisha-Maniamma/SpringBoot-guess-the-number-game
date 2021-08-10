package juntos.itSpringFaramewor.config;

import juntos.itSpringFaramewor.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Jisha Maniamma
 * @version 1.0
 * @date 2021/08/10 8:19
 */
@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "juntos.itSpringFaramewor")
public class AppConfig {

// ==bean methods ==

    @Bean
    public NumberGenerator numberGenerator(){
        return new NumberGeneratorImpl();
    }
    @Bean
    public Game game(){
        return new GameImpl();
    }
    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }

}
