package patterns.singleton.exercises01;

public class Single02EagerInit {

    private static Single02EagerInit instance = new Single02EagerInit();

    private Single02EagerInit(){

    }

    public static Single02EagerInit getInstance(){
        return instance;
    }
}
