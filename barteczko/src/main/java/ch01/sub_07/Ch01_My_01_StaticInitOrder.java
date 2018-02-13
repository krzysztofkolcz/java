package ch01.sub_07;

public class Ch01_My_01_StaticInitOrder {

    private Object object;
    private static String var01 = "01";
    private static String var02;
    static {
       var02 = var01 + " 02 ";
       //nie możliwe var02 += x;
    }
    private static String x = " x ";

    private String var03;
    private String var04 = var03+" 04";
    private String var05;
    {
        var05 = var02 + var04 + " 05";
    }
    private String var06;

    public Ch01_My_01_StaticInitOrder(){
        this.var06 = var05+" 06";
    }

    @Override
    public String toString() {
        return var06;
    }

    public static void main(String[] args) {
        Ch01_My_01_StaticInitOrder initOrder = new Ch01_My_01_StaticInitOrder();
        System.out.println(initOrder);
    }
}
