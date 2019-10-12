package item3;

public class Elvis2Protected {

    public static final Elvis2Protected INSTANCE = new Elvis2Protected();
    private Elvis2Protected() {
        if(INSTANCE!=null){
            throw new IllegalAccessError();
        }

    }
    public void leaveTheBuilding() {}
}
