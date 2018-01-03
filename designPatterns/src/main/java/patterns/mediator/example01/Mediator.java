package patterns.mediator.example01;

public interface Mediator {
    public void addUser(User user);
    public void sendMessage(String msg,User sender);
}
