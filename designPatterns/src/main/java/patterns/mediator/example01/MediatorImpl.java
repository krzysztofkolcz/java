package patterns.mediator.example01;

import java.util.HashSet;
import java.util.Set;

public class MediatorImpl implements Mediator{

    private Set<User> users = new HashSet<>();
    private Object MUTEX = new Object();

    @Override
    public void addUser(User user) {
        synchronized (MUTEX) {
            users.add(user);
        }
    }

    @Override
    public void sendMessage(String msg, User sender) {
        Set<User> usersCopy ;
        synchronized (MUTEX){
            usersCopy = new HashSet<>(users);
        }
        usersCopy.forEach( u -> {
                if (u != sender) {
                    u.recive(msg);
                }
            }
        );
    }
}
