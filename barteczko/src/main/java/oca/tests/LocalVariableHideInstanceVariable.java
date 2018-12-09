package oca.tests;

public class LocalVariableHideInstanceVariable {
    private int j;
    void showJ(){
        while(j<=5){//zmienna instancji - j
            for(int j=1; j <= 5;){//zmienna lokalna - j
                System.out.println("	j - loop scope:"+j+" ");
                j++;//zmienna lokalna - w scope pętli for
            }
            j++;//zmienna instancji - j
			System.out.println("j - object scope:"+j+" ");
        }
    }
    public static void main(String[] args) {
        new LocalVariableHideInstanceVariable().showJ();
    }

}
