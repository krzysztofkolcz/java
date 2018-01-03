package patterns.state.exercise01;

public class Main {
    public static void main(String[] args) {
        TvTurnOffState tvTurnOffState = new TvTurnOffState();
        TvTurnOnState tvTurnOnState = new TvTurnOnState();
        TvContext tvContext = new TvContext(tvTurnOnState);
        tvContext.doAction();

        tvContext.setState(tvTurnOffState);
        tvContext.doAction();
    }
}
