package patterns.mediator.example01;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new MediatorImpl();
        User user1 = new UserImpl("John",mediator);
        User user2 = new UserImpl("Frank",mediator);
        User user3 = new UserImpl("Michael",mediator);

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user1.send("Hi all");
    }
}
