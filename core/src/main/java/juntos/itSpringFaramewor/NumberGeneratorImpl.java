package juntos.itSpringFaramewor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Jisha Maniamma
 * @version 1.0
 * @date 2021/08/06 9:46
 */
//
@Component
public class NumberGeneratorImpl implements NumberGenerator{

    // == fields section ==
    private final Random random=new Random();
//    @Autowired
    @MaxNumber
    private int maxNumber;

//    @Autowired
    @MinNumber
    private int minNumber;


//      private final int maxNumber;
//
//    private  final int minNumber;
//
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int MaxNumber,@MinNumber int minNumber){
        this.minNumber=minNumber;
        this.maxNumber=MaxNumber;
    }

    // == public methods ==
    @Override
    public int next() {

        return random.nextInt((maxNumber-minNumber)+minNumber);
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    public int getMinNumber() {
        return minNumber;
    }
}
