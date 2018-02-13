package ch04.sub06_default;

import org.mockito.Spy;

public class Pies extends Zwierz implements Speakable{
    private String name;

    public Pies(String name) {
        this.name = name;
    }

    @Override
    public String getVoice(int voice) {
        if(voice == Speakable.LOUD){
            return "HAU! HAU!";
        }else{
            return "hau hau";
        }
    }

    @Override
    public String getTyp() {
        return "Pies";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
