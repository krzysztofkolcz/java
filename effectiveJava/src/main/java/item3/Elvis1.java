package item3;

// Singleton with public final field
public class Elvis1 {
    public static final Elvis1 INSTANCE = new Elvis1();
    private Elvis1() {}
    public void leaveTheBuilding() {}
}
