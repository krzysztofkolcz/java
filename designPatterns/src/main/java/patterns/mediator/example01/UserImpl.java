package patterns.mediator.example01;

public class UserImpl implements User{

    private String name;
    private Mediator mediator;

    public UserImpl(String name,Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
//        mediator.addUser(this);
    }

    @Override
    public void send(String msg) {
        System.out.println(name + " sent:"+msg);
        mediator.sendMessage(msg,this);
    }

    @Override
    public void recive(String msg) {
        System.out.println(name + " recive:"+msg);
    }
}
