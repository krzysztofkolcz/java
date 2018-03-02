package ch07.sub02_lambdas_scope;

import java.util.Arrays;

public class ScopeLambda {

    void doWork(Worker w) {
        w.work();
    }

    void defineAndDoWork(String[] s) {
        String pref = "( ";
        String suff = " )";
//         int i = 7;// spowoduje błąd w kompilacji, bo w lambda przesłonięte
//        suff = "*";// spowoduje błąd w kompilacji, bo nie efektywnie finalne
        doWork ( () -> { // lambda bez parametrów
            System.out.println(this.getClass());
            for (int i = 0; i < s.length; i++) {
                s[i] = pref + s[i] + suff;
            }
        });
    }

    public static void main(String[] args) {
        String[] s = { "A", "B", "C" };
        new ScopeLambda().defineAndDoWork(s);
        System.out.println(Arrays.toString(s));
        int i = 7, k = 10;
//         k = 11;// spowoduje błąd w kompilacji, bo nie efektywnie finalne
        Worker w = new Worker() {
            int i = 8; // nie ma błędów w kompilacji
            public void work() {
                System.out.println(k);
                int i = 9; // nie ma błędów w kompilacji
                System.out.println(this.getClass());
            }
        };
        w.work();
    }
}

