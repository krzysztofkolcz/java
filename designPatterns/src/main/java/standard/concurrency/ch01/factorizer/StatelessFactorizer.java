package standard.concurrency.ch01.factorizer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StatelessFactorizer {

    public List<Long> countFactors(long argument){
        System.out.println(argument);
        List<Long> fac = new ArrayList<>();
        for(long i = 2; i <= argument && argument != 1; i++){
            long mod = argument % i;
            System.out.println("argument:"+argument+", i:"+i+", argument % i = "+mod+" ");
            if(mod == 0){
                argument = argument / i;
                System.out.println(", argument / i ="+argument);
                fac.add(i);
            }
        }
        return fac;
    }
}
