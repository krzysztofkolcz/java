package ch04.sub06_default;

public abstract class Zwierz {

    public abstract String getTyp();
    public abstract String getName();

    public void speak(int... v) {
        int vol = Speakable.QUIET;
        if (v.length == 1) vol = v[0];
        String voice;
        if (this instanceof Speakable) voice = ((Speakable) this).getVoice(vol);
        else voice = "... (cisza) ...";
        System.out.println(getTyp() + " " + getName() + " mówi " + voice);
    }
}

