package patterns.memento.exercises03;

public class Client {

    public static void main(String[] args) {
        Originator org = new Originator("test.txt");
        Caretaker caretaker = new Caretaker();
        org.write("bla");
        System.out.println("write bla");
        System.out.println(org);
        caretaker.save(org);
        System.out.println("save");
        System.out.println(org);
        org.write("blabla");
        System.out.println("write blabla:");
        System.out.println(org);
        caretaker.undo(org);
        System.out.println("undo:");
        System.out.println(org);


    }

}
