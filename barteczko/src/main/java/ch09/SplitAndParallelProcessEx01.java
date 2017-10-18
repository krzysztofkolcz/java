package ch09;

import java.util.Spliterator;

/**
 * Created by kkolcz on 11/10/17.
 */
public class SplitAndParallelProcessEx01 {

    public void doubleLetters(StringBuilder stringBuilder){
        for(int i = 0; i< stringBuilder.length(); i = i+2){
            stringBuilder.insert(i + 1, stringBuilder.charAt(i));
        }
    }

    public void doubleLettersForEveryWordInSpliterator(Spliterator<StringBuilder> spliterator){
        spliterator.forEachRemaining( e -> doubleLetters(e));
    }
}
