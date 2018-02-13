package ch04.sub07_mixin;

public class Bintorung implements Bear,Cat{
    private String name;
    public Bintorung(String name) {
        this.name = name;
    }
    public String toString() {
        return "Nazywam się " + name + "\ni jestem Bintorung," + "\nczyli " + bear() + cat();
    }

    @Override
    public String x() {
        return "XBintorung";
    }

    public static void main(String[] args) {
        Bintorung wayan = new Bintorung("Wayan");
        System.out.println(wayan);
    }
}
