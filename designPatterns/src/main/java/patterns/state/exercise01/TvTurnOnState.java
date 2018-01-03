package patterns.state.exercise01;

public class TvTurnOnState implements State {
    @Override
    public void doAction() {
        System.out.println("Tv is turned on");
    }
}
