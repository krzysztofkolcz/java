package ch12.synchronization;

public class Balance  {

    int b = 0;

    public int balance(){
        b++;
        b--;
        return b;
    }


}
