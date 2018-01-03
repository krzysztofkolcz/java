package standard.streams;

public class Boss {

    private String fullName;

    public Boss(Employee e){
        this.fullName = e.getFirstName() + " " + e.getLastName();
    }

    @Override
    public String toString() {
        return this.fullName;
    }
}
