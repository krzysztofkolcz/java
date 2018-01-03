package patterns.state.exercise01;

public class TvContext implements State {
    private State state;

    public TvContext(State state) {
        this.state = state;
    }

    public void setState(State state){
        this.state = state;
    }

    @Override
    public void doAction() {
        this.state.doAction();
    }
}
