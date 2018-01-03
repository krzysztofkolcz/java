package patterns.state.exercise01;

public class TvTurnOffState implements State {
    @Override
    public void doAction() {
        System.out.println("Tv is turned off");
    }
}
