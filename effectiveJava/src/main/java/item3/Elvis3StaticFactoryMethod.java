package item3;

public class Elvis3StaticFactoryMethod {

    private static final Elvis3StaticFactoryMethod INSTANCE = new Elvis3StaticFactoryMethod();
    private Elvis3StaticFactoryMethod() {
        if(INSTANCE!=null){
            throw new IllegalAccessError();
        }
    }
    public static Elvis3StaticFactoryMethod getInstance(){return INSTANCE;}
    public void leaveTheBuilding() {}
}
