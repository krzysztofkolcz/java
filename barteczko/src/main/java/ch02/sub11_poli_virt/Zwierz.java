package ch02.sub11_poli_virt;

public class Zwierz {
    String name = "bez imienia";
    Zwierz() { }
    Zwierz(String s) { name = s; }
    String getTyp() { return "Jakis zwierz"; }
    String getName() { return name; }
    String getVoice() { return "?"; }
    // Metoda speak symuluje wydanie głosu przez wypisanie odpowiedniego komunikatu
    void speak() {
        System.out.println(getTyp()+" "+getName()+" mówi "+getVoice());
    }
}
