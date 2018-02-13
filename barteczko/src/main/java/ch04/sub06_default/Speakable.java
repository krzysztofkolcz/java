package ch04.sub06_default;

public interface Speakable {
    int QUIET = 0;
    int LOUD = 1;

    String getVoice(int voice);

    static String getAvailableVoiceForce() {
        return "Speakable.QUIET Speakable.LOUD";
    }

    default String getVoice() {
        return getVoice(QUIET);
    }
}

