package ch02.sub11_poli_virt;

public class ZwierzApp {

        public static void main(String[] arg) {
            Zwierz z1 = new Zwierz();
            Zwierz z2 = new Zwierz();
            Pies pies = new Pies();
            Pies kuba = new Pies("Kuba");
            Pies reksio = new Pies("Reksio");
            Kot kot = new Kot();
            animalDialog(z1, z2);
            animalDialog(kuba, reksio);
            animalDialog(kuba, kot);
            animalDialog(reksio, pies);
        }
        static void animalDialog(Zwierz z1, Zwierz z2) {
            z1.speak();
            z2.speak();
            System.out.println("----------------------------------------");
        }
}
