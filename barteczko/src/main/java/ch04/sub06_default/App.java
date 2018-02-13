package ch04.sub06_default;

public class App {

    public static void main(String[] args) {
        Pies pies = new Pies("Azor");
        System.out.println(pies.getVoice());
        System.out.println(pies.getVoice(Speakable.LOUD));
    }

}
