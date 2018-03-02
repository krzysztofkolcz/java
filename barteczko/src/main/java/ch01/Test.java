package ch01;

public class Test {

    public static void main(String[] args) {
        for(int i =0 ;i < 100; i++){
            System.out.println(i);
        }
        Test t = new Test();
        String result = t.bla(4);
        System.out.println(result);
    }

    public String bla(int i){
        String s = "";
        for(int j = 0; j < i; j++){
            s += "bla";

        }
        return s;
    }

}
