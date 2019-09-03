package StatePattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/23 15:59
 * @Description :
 */
public class Context {

    private State state;

    public Context() {
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
