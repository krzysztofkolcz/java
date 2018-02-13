package ch02.sub11_poli_virt;

public class App {
    public static void main(String[] args) {
        Car c = new Car();
        Vehicle v = c;
        String msg = v.start();
        System.out.println(msg);
    }
}
