package patterns.singleton.exercises01;

public class Single01 {

    private static Single01 instance;

    private Single01(){
    }

    public static Single01 createInstance(){
        if(instance == null){
            instance = new Single01();
        }
        return instance;
    }
}
